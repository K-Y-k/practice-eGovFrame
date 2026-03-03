package main.member.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import main.member.service.MemberService;
import main.member.vo.MemberVO;

@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	

	/**
	 * 회원 등록 화면
	 */
	@RequestMapping("/memberWrite.do")
	public String memberWrite() {
		return "member/memberWrite";
	}
	
	/**
	 * 회원 등록 기능
	 */
	@ResponseBody
	@RequestMapping("/memberWriteSave.do")
	public String memberSave(MemberVO vo) throws Exception {
	    System.out.println("컨트롤러 호출됨");
	    System.out.println("vo: " + vo);
	    
	    String result = memberService.insertMember(vo);
	    String message = "";
	    message = Objects.isNull(result) ? "ok" : "fail";
	    
	    System.out.println("message: " + message);
	    
	    return message; 
	}
	
	/**
	 * 아이디 중복 체크
	 */
	@ResponseBody
	@RequestMapping("/idcheck.do")
	public String selectMemberIdCheck(String userid) throws Exception {
		String message = "fail";
		
		int count = memberService.selectMemberIdCheck(userid);
		if (count == 0) {
			message = "ok";
		}
		
		return message;
	}
	
	/**
	 * 우편번호 찾기 폼
	 */
	@RequestMapping("/post1.do")
	public String post1() {
		return "member/post1";
	}
	
	/**
	 * 우편번호 찾기 기능
	 */
	@RequestMapping("/post2.do")
	public String post2(String dong, ModelMap model) throws Exception {
		
		List<?> result = memberService.selectPostList(dong);
		model.addAttribute("resultList", result);
		
		return "member/post2";
	}
	
	/**
	 * 로그인 폼
	 */
	@RequestMapping("/loginWrite.do")
	public String loginWrite() {
		return "member/loginWrite";
	}
	
	/**
	 * 로그인 기능
	 */
	@ResponseBody
	@RequestMapping("/loginWriteSub.do")
	public String loginProcessing(MemberVO vo, HttpSession session) throws Exception {
		
		String message = "fail";
		
		int count = memberService.selectMemberCount(vo);
		if (count == 1) {
			// 세션 생성
			session.setAttribute("SessionUserID", vo.getUserid());
			
			// 메시지  처리
			message = "ok";
		}
		
		return message;
	}
	
	/**
	 * 로그아웃 기능
	 */
	@RequestMapping("/logoutWrite.do")
	public String logoutProcessing(HttpSession session) {
		session.removeAttribute("SessionUserID");
		return "redirect:/loginWrite.do";
	}
	
}
