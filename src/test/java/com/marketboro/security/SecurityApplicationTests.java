package com.marketboro.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@SpringBootTest
class SecurityApplicationTests {
	@Autowired
	private MemberRepository memberRepository;

	@Test
	void contextLoads() {
		for(int i = 0; i < 100; i++) {
			Member member = new Member();
			member.setId(				memberRepository.count()+1);
			member.setName(				"song" + i);
			member.setPassword(			("{noop}")+"test");
			member.setContractNumber(	"010-9999-9999");
			if(i < 50) {
				member.setAuth(				"ROLE_ADMIN"); //사용자
			} else {
				member.setAuth(				"ROLE_MEMBER"); //사용자
			}
			member.setCreateDatetime(LocalDateTime.now());
			member.setUpdateDatetime(LocalDateTime.now());
			System.out.println(member.toString());
			memberRepository.save(member);
		}


	}
	public boolean isNumeric(String str) {
		return Pattern.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", str);
	}
}
