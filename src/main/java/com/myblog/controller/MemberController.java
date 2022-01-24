package com.myblog.controller;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.myblog.repository.MemberRepository;
import com.myblog.been.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/member**")
public class MemberController {

	/*private final MemberRepository memberRepository;

	@GetMapping("/user/list")
	public String users(Map<String, Object> model, @RequestParam Map<String, String> param , @PageableDefault(size = 5) Pageable pageable) {
		String findName = (String)param.get("name");
		Page<Member> page = null;
		if(findName == null) {
			page = memberRepository.findAll(pageable);
		} else {
			page = memberRepository.findByNameLike(findName + "%" , pageable);
		}
		//페이징 처리
		model.put("startPage" 	, Math.max(0,page.getPageable().getPageNumber() -4));
		model.put("endPage" 	, Math.min(page.getTotalPages()-1 , page.getPageable().getPageNumber() +4));
		model.put("findName" , findName);
		model.put("members", page);

		return "user";
	}

	@GetMapping("/save")
	public String save(Map<String, Object> model , @RequestParam Map<String, String> param) {
		Member member = new Member();
		member.setId(				memberRepository.maxById()+1);
		member.setName(				(String)param.get("name"));
		member.setPassword(			("{noop}")+(String)param.get("password"));
		member.setContractNumber(	(String)param.get("contractNumber"));
		member.setAuth(				"ROLE_MEMBER"); //사용자
		member.setCreateDatetime(LocalDateTime.now());
		member.setUpdateDatetime(LocalDateTime.now());

		String memberCheckResult = memberCheck(member); //객체의 회원가입을 체크한다
		if(memberCheckResult != null) { //메세지가 있다면 회원가입 할수없는 메세지내용을 담고있다.
			model.put("message" , memberCheckResult);
			return "join";
		}

		//System.out.println(member.toString());
		memberRepository.save(member);
		return "index";
	}

	@GetMapping("/admin/saveAdmin")
	public String saveAdmin(Map<String, Object> model , @RequestParam Map<String, String> param) {
		Member member = new Member();
		member.setId(				memberRepository.maxById()+1);
		member.setName(				(String)param.get("name"));
		member.setPassword(			("{noop}")+(String)param.get("password"));
		member.setContractNumber(	(String)param.get("contractNumber"));
		member.setAuth(				"ROLE_ADMIN"); //사용자
		member.setCreateDatetime(LocalDateTime.now());
		member.setUpdateDatetime(LocalDateTime.now());

		String memberCheckResult = memberCheck(member); //객체의 회원가입을 체크한다
		if(memberCheckResult != null) { //메세지가 있다면 회원가입 할수없는 메세지내용을 담고있다.
			model.put("message" , memberCheckResult);
			return "createMember";
		}

		//System.out.println(member.toString());
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

	//세션에 이전페이지 넣기
	@GetMapping("/login")
	public String loginForm(HttpServletRequest req) {
		String referer = req.getHeader("Referer");
		req.getSession().setAttribute("prevPage", referer);
		return "login";
	}*/

	/********************************************************************************************************************************************
	 * 여기서부터 유틸리티 함수모음
	 * 유틸리티는 길어지면 별도 클래스로 빼려 했지만 크게 2가지밖에 없어 컨트롤러 안에 작성하였습니다.
	 ********************************************************************************************************************************************/
	//회원가입할 객체를 검사합니다.
	/*public String memberCheck(Member member) {
		//1. 동일ID여부 검사
		if(memberRepository.countByName(member.getName()) > 0) {
			return "동일한 ID가 존재합니다.";
		}

		//2. 정규표현식 영문 대문자, 영문 소문자, 숫자, 특수문자 모두 1개 이상 포함 하도록 체크 해주세요.
		if(!isNumeric(member.getPassword().replace("{noop}", ""))) {
			return "영문 대문자, 영문 소문자, 숫자, 특수문자 모두 1개 이상 포함 필수입니다.";
		}
		return null;//최종통과
	}
	//비밀번호 정규표현식
	public boolean isNumeric(String psw) {
		Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z0-9$@$!%*?&]{4,}");
		Matcher m = p.matcher(psw);
		return m.matches();
	}*/
}
