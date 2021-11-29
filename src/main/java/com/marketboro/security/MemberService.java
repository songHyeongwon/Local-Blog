package com.marketboro.security;

import com.sun.security.auth.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.usertype.UserType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		//로그인 성공 했을때
		System.out.println("loadUserByUsername = " +username);
		Member member = memberRepository.findByName(username).orElseThrow(RuntimeException::new);
		System.out.println("loadUserByUsername = " +member.toString());
		return new MyUserPrincipal(member);
	}
}
