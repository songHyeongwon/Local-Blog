package com.marketboro.security;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginFailHandler")
@Component
@RequiredArgsConstructor
@Transactional
public class MemberLoginFailHandler implements AuthenticationFailureHandler {

    private final MemberRepository memberRepository;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws ServletException, IOException {
        String username = request.getParameter("username");
        //System.out.println("onAuthenticationFailure " + username);

        String loginFailMsg = "로그인에 실패하였습니다.";

        if (exception instanceof LockedException) {
            //로그인프로세스에서 3회이상일경우 던져준다.
            loginFailMsg = exception.getMessage();
        } else if(exception instanceof BadCredentialsException) {
            //사용자가 있는 지점에서 처리해준다.
            loginFailMsg = failProcess(username);
        } else if(exception instanceof InternalAuthenticationServiceException) {
            loginFailMsg = exception.getMessage();
        }
        HttpSession session = (HttpSession)request.getSession();
        session.setAttribute("loginFailMsg", loginFailMsg);
        response.sendRedirect("/login");
    }

    public String failProcess (String username) {
        try{
            Optional<Member> member = memberRepository.findByName(username);
            //System.out.println("failProcess = "+member.get().toString());
            if(member.get().getFailCnt() >= 3) {
                LocalDateTime localDateTime = member.get().getLastFailtime();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
                return "3회 이상 로그인에 실패하여 ID가 잠겼습니다. " + localDateTime.plusMinutes(10).format(dateTimeFormatter).toString() + "이후에 다시 시도해주세요.";
            } else {
                member.get().setFailCnt(member.get().getFailCnt() + 1);
                member.get().setLastFailtime(LocalDateTime.now());
                memberRepository.save(member.get());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return "로그인에 실패하였습니다. 횟수가 증가합니다.";
    }
}
