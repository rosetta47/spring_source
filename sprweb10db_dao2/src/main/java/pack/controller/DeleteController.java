package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class DeleteController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("delete")
	public String detailProcess(@RequestParam("id")String id, Model model) {
		MemberDto dto = memberDao.getMember(id);
		model.addAttribute("member",dto);
		return "delete";
	}
	
	@PostMapping("delete")
	public String submit(@RequestParam("id")String id, Model model) {
		memberDao.delData(id);
		return "redirect:/list";
	}
	
	/* 쌤 풀이
	 @GetMapping("delete")
	public String detailProcess(@RequestParam("id")String id) {
		MemberDto dto = memberDao.getMember(id);
		mamberDao.delData(id);
		return "redirect:/list";
	 */
	
}
