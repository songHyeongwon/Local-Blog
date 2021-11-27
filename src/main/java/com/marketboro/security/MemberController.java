package com.marketboro.security;

import java.time.LocalDateTime;
import java.util.*;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberRepository memberRepository;

	@GetMapping({"/", "index"})
	public String mainPage(Map<String, Object> model) {
		return "index";
	}

	@GetMapping("/user/list")
	public String users(Map<String, Object> model, @RequestParam Map<String, String> param) {
		System.out.println("name = " + param.get("name"));
		String findName = (String)param.get("name");
		List<Member> members = null;

		if(findName == null) {
			members = memberRepository.findAll();
		} else {
			members = memberRepository.findByNameLike(findName + "%");
		}
		model.put("members", members);
		return "user";
	}

	@GetMapping("/save")
	public String save(@RequestParam Map<String, String> param) {
		Member member = new Member();
		member.setId(				memberRepository.count()+1);
		member.setName(				(String)param.get("name"));
		member.setPassword(			(String)param.get("password"));
		member.setContractNumber(	(String)param.get("contractNumber"));
		member.setAuth(				"ROLE_MEMBER"); //사용자
		member.setCreateDatetime(LocalDateTime.now());
		member.setUpdateDatetime(LocalDateTime.now());
		System.out.println(member.toString());
		memberRepository.save(member);
		return "index";
	}

	@GetMapping("/admin/saveAdmin")
	public String saveAdmin(@RequestParam Map<String, String> param) {
		Member member = new Member();
		member.setId(				memberRepository.count()+1);
		member.setName(				(String)param.get("name"));
		member.setPassword(			(String)param.get("password"));
		member.setContractNumber(	(String)param.get("contractNumber"));
		member.setAuth(				"ROLE_ADMIN"); //사용자
		member.setCreateDatetime(LocalDateTime.now());
		member.setUpdateDatetime(LocalDateTime.now());
		System.out.println(member.toString());
		memberRepository.save(member);
		return "main";
	}

	@GetMapping("/admin")
	public String admin(@RequestParam Map<String, String> param) {
		return "admin";
	}

	@GetMapping("/admin/createMember")
	public String createMember(@RequestParam Map<String, String> param) { return "createMember";}

	@GetMapping("/main")
	public String main(@RequestParam Map<String, String> param) {
		return "main";
	}

	@GetMapping("/join")
	public String join() {
		return "join";
	}
}
