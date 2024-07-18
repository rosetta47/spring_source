package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;
import pack.model.MemDto;

@Controller
public class MemController {
	
	@Autowired
	private DataProcess dataProcess;

	@GetMapping("/")// 받는값이 없으면 "/"
	public String chulbal() {
		return "chulbal";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		// 자료를 읽어서 넘겨야되 arraylist
		ArrayList<MemDto> list = (ArrayList<MemDto>)dataProcess.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insertProcess(MemBean bean) {
		boolean b = dataProcess.insert(bean);
		if(b) //b 이면 성공
			return "redirect:/list";
		else
			return "redirect:error";
	}
	
	@GetMapping("error")
	public String error() {
		return "error";
	}
	
	// update 요청
	@GetMapping("update") // num을 받아줌 @RequestParam("num")
	public String update(@RequestParam("num") String num, Model model) {
		MemDto dto = dataProcess.getData(num);
		model.addAttribute("data", dto); // requestsetAttribute 느낌을 가지고 있어야되
		return "update";
	}
	
	@PostMapping("update")
	public String updateProcess(MemBean bean) {
		boolean b = dataProcess.update(bean);
		if(b) //b 이면 성공 list
			return "redirect:/list";
		else
			return "redirect:error";
	}
	
	// 삭제 요청
	@GetMapping("delete") // num을 받아줌 @RequestParam("num")
	public String delete(@RequestParam("num") String num) {
		boolean b = dataProcess.delete(num);
		if(b) //b 이면 성공 list
			return "redirect:/list";
		else
			return "redirect:error";
	
	}
	
}
