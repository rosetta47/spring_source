package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.MemberDto;
import pack.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService mservice;
	
	
	@GetMapping("/member/mlist")
	public String memlist(Model model) {
		mservice.getList(model); // getList는 void인데 받았음 어떻게?(Model 이라서 가능)
		//Model 객체는 스프링이 제공하는 모델을 사용하는 것이므로 따로 반환을 해주지 않아도 된다.
	
		return "member/mlist";
	}
	
	// insert 추가
	@GetMapping("/member/insertform")
	public String insertform() {
		return "member/insertform";
	}
	
	@PostMapping("/member/insert")
	public String insert(MemberDto fbean) {
		mservice.insert(fbean);
		
		return "member/insert";
	}
	
	// 회원 수정 update 
	@GetMapping("/member/updateform")
	public String updateform(@RequestParam("num") Long num,Model model) {
		mservice.getData(num, model); // 먼저 자료를 읽는다.
		return "member/updateform";
	}
	
	@PostMapping("/member/update")
	public String update(MemberDto fbean) {
		mservice.update(fbean);
		
		return "member/update";
	}
	
	// 회원 삭제 delete 
		@GetMapping("/member/delete")
		public String delete(@RequestParam("num") Long num) {
			mservice.delete(num);
			
			return "redirect:/member/mlist";
		}
}
