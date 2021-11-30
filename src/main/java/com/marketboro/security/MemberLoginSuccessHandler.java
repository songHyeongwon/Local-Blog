package com.marketboro.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service("loginSueeessHandler")
@Component
@RequiredArgsConstructor
@Transactional
public class MemberLoginSuccessHandler implements AuthenticationSuccessHandler {

    private final MemberRepository memberRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String username = request.getParameter("username");
        //System.out.println("onAuthenticationSuccess " + username);

        Optional<Member> member = memberRepository.findByName(username);
        //System.out.println("successProcess = "+member.get().toString());
        member.get().setFailCnt(0L);
        member.get().setLastFailtime(null);
        memberRepository.save(member.get());//로그인 성공으로 프로세스 다시 원복

        // 로그인 성공 메인화면으로
        if(member.get().getAuth().equals("ROLE_ADMIN")) {
            response.sendRedirect("/admin/");//관리자 메인
        } else {
            response.sendRedirect("/main");//일반 유저 메인
        }

    }
}
