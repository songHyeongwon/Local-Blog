package com.myblog;

import com.myblog.been.Member;
import com.myblog.mapper.MemberMapper;
import com.myblog.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

@SpringBootTest
class SecurityApplicationTests {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberMapper memberMapper;
	@Test
	void contextLoads() {
		/*for(int i = 0; i < 100; i++) {
			Member member = new Member();
			member.setId(i + 3L);
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
		}*/
		Member member = new Member();
		member.setName("admin%");
		List<Member> list= memberMapper.findMapperMember(member);
		System.out.println("나오나?");
		for(Member vo : list) {
			System.out.println("매퍼 출력 = "+vo.toString());
		}
	}
}
