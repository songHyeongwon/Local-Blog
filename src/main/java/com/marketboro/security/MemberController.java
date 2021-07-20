package com.marketboro.security;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberRepository memberRepository;

	@GetMapping({"/", "index"})
	public String mainPage(Map<String, Object> model) {
		return "index";
	}

	@GetMapping("/user/list")
	public String users(Map<String, Object> model) {
		List<Member> members = memberRepository.findAll();
		model.put("members", members);
		return "user";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

}
