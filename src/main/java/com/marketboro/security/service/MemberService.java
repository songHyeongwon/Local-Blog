package com.marketboro.security.service;

import com.marketboro.security.security.MyUserPrincipal;
import com.marketboro.security.been.Member;
import com.marketboro.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		//로그인 내부
		//System.out.println("loadUserByUsername = " +username);
		Member member = memberRepository.findByName(username).orElseThrow(RuntimeException::new);
		//System.out.println("loadUserByUsername = " +member.toString());

		//카운트와 시간을 검사해 미만이면 null 반환
		String failCheck = failCntCheck(member);
		if(failCheck != null) {
			throw new LockedException(failCheck);
		}
		return new MyUserPrincipal(member);
	}
	private String failCntCheck(Member member) {
		LocalDateTime localDateTime = member.getLastFailtime();
		//날짜가 없다면 실패한적이 없는것
		if(localDateTime == null) return null;

		localDateTime = localDateTime.plusMinutes(10); //10분 후

		if(member.getFailCnt() >= 3 && localDateTime.isAfter(LocalDateTime.now())) { //더 이후인11분 이상일때는 false
			//DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
			return "3회 이상 로그인에 실패하여 ID가 잠겼습니다. " + ChronoUnit.MINUTES.between(LocalDateTime.now(), localDateTime) + "분 이후에 다시 시도해주세요.";
		} else {
			return null;
		}
	}
}
