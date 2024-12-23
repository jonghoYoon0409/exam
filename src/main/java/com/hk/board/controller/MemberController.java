package com.hk.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hk.board.command.AddUserCommand;
import com.hk.board.command.LoginCommand;
import com.hk.board.service.MemberService;

import jakarta.servlet.http.HttpServletRequest; 
@Controller
@RequestMapping(value = "/user")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = "/addUser")
	public String addUserForm(Model model) {
		System.out.println("회원가입폼 이동");
		
		//회원가입폼에서 addUserCommand객체를 사용하는 코드가 작성되어 있어서 
		//null일경우 오류가 발생하기때문에 보내줘야 함
		model.addAttribute("addUserCommand", new AddUserCommand());
		
		return "member/addUserForm";
	}
	
	@PostMapping(value = "/addUser")
	public String addUser(@Validated AddUserCommand addUserCommand
			             ,BindingResult result,Model model) {
		System.out.println("회원가입하기");
		
		if(result.hasErrors()) {
			System.out.println("회원가입 유효값 오류");
			return "member/addUserForm";
		}
		
		try {
			memberService.addUser(addUserCommand);
			System.out.println("회원가입 성공");
			return "redirect:/";
		} catch (Exception e) {
			System.out.println("회원가입실패");
			e.printStackTrace();
			return "redirect:addUser";
		}

	}
	
	@ResponseBody
	@GetMapping(value = "/idChk")
	public Map<String,String> idChk(String id){
		System.out.println("ID중복체크");
		
		String resultId=memberService.idChk(id);
		// json객체로 보내기 위해 Map에 담아서 응답
		// text라면 그냥 String으로 보내도 됨
		Map<String,String>map=new HashMap<>();
		map.put("id", resultId);
		return map;
	}

	
	
		
		
	/*
	 * @GetMapping(value = "/login") public String loginForm(Model model) {
	 * model.addAttribute("loginCommand", new LoginCommand()); return
	 * "member/login"; }
	 */
		
		 
	 
	@PostMapping(value = "/login")
	public String login(@ModelAttribute("loginCommand")
						@Validated LoginCommand loginCommand,
	                    BindingResult result,
	                    Model model,
	                    HttpServletRequest request) {
	    if (result.hasErrors()) {
	        System.out.println("로그인 유효값 오류");
	        model.addAttribute("loginCommand", loginCommand); // 에러가 발생했을 경우 기존 데이터를 다시 모델에 추가
	        return "index"; // 유효성 검사 오류 시 로그인 페이지로 돌아감
	    }
	    
	    String path = memberService.login(loginCommand, request, model);

	    if (path.equals("home")) { // 로그인 성공 시 처리
	    	System.out.println("로그인 성공 후 환자리스트로이동");
	        return "redirect:/schedule/patientlist"; // 
	    }

	    return path; // 로그인 실패 시 해당 경로로 리턴
	}

	
	//나의 정보 조회
	
	//나의 정보 수정
	
}










