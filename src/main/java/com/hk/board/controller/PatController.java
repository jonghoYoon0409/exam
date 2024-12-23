package com.hk.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.board.command.AddPatientCommand;
import com.hk.board.command.AddUserCommand;
import com.hk.board.command.DeleteCalCommand;
import com.hk.board.command.InsertCalCommand;
import com.hk.board.command.UpdateCalCommand;
import com.hk.board.dtos.CalDto;
import com.hk.board.dtos.MemberDto;
import com.hk.board.dtos.PatientDto;
import com.hk.board.service.CalServiceImp;
import com.hk.board.service.PatientService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller


//@RestController
@RequestMapping("/patient") //클라이언트에서 /patient 요청
public class PatController {
	
	
	//log를 원하는 위치에 설정해서 디버깅 하기
	Logger logger=LoggerFactory.getLogger(getClass()); //디버깅을 돕기 위한 로그 기능으로, logger.info("메시지")로 메시지를 기록할 수 있어.
	
	/*
	 * @Autowired private CalServiceImp calService;
	 */
	
	@Autowired PatientService patientService;
	
	// 환자 추가 폼
	@GetMapping(value = "/add")
	public String addUserForm(Model model) {
		System.out.println("환자추가 폼 이동");
		
		//회원가입폼에서 addUserCommand객체를 사용하는 코드가 작성되어 있어서 
		//null일경우 오류가 발생하기때문에 보내줘야 함
		model.addAttribute("AddPatientCommand", new AddPatientCommand());
		
		return "calboard/addpatient";  //환자 등록 폼 뷰로 이동
	}
	/*
	 * @GetMapping("/add") public String patientlist(Model model, HttpServletRequest
	 * request){ System.out.println("환자 추가 화면 넘어가기전");
	 * 
	 * return "calboard/addpatient"; }
	 */
	
	// 환자 추가 처리
	 @PostMapping(value = "/addpatient")         
	    public String addPatient(@Validated @ModelAttribute("AddPatientCommand") AddPatientCommand addPatientCommand,
	                             BindingResult result, Model model,HttpServletRequest request) { // validated 유효성 검사를 위한 것입니다  ModelAttribute 폼에서 입력한 데이터를 객체로 변환하    AddPatientCommand addPatientCommand:이 부분은 실제로 사용자가 폼에서 입력한 데이터를 담는 객체입니다
                                                                      //@ModelAttribute("addPatientCommand"): "이 요청의 데이터는 addPatientCommand라는 이름의 객체에 담겠다."  AddPatientCommand addPatientCommand: 이제 이 객체에 사용자가 입력한 값들이 들어간다.
		
//		 	HttpSession session=request.getSession();
//		 	MemberDto mdto=(MemberDto)session.getAttribute("mdto");
//		 	addPatientCommand.setMemberid(mdto.getMemberId());//session에서 로그인정보 중에 member_id가져오기 (fk)라서
	        System.out.println("환자 등록하기");  
	        
	        if (result.hasErrors()) {
	            System.out.println("환자 등록 유효성 오류");
	            return "calboard/addpatient"; // 오류가 있을 경우 다시 폼으로 이동
	        }

	        try {

	            // 서비스 계층으로 환자 정보 전달
	        	System.out.println(addPatientCommand); //command에 잘 담겼는지 확인하는
	            patientService.addPatient(addPatientCommand);
	            System.out.println();
	            System.out.println("환자 등록 성공");
	            return "redirect:/schedule/patientlist"; // 성공 시 메인 페이지로 리디렉
	        } catch (Exception e) {
	            System.out.println("환자 등록 실패");
	            e.printStackTrace();
	            return "redirect:addpatient"; // 실패 시 등록 폼으로 리디렉션
	        }
	    }
	 @GetMapping("/list")
	 @ResponseBody  // 
	 public Map<String,List<PatientDto>> getPatientsByMemberId(@RequestParam("memberid") String memberid) {
		 System.out.println("환자목록"+memberid);
	     // Map 형태로 전달하고 싶다면,
	     Map<String, Object> params = new HashMap<>();
	     params.put("memberid", memberid);

	     // 환자 목록 조회
	     List<PatientDto> patients = patientService.getPatientsByMemberId(memberid);
	     System.out.println("size:"+patients.get(0));
	     Map<String,List<PatientDto>> map=new HashMap<String, List<PatientDto>>();
	     map.put("plist", patients);
	     return map;  // JSON 형식으로 반환
	 }

	 
	 
	}
	
	











