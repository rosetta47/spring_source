package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.Board;
import pack.model.BoardDao;

@Controller
public class DetailController {
	@Autowired
	private BoardDao dao;
	
	@GetMapping("detail")
	public String detail(@RequestParam("num") int num, Model model) {
		Board board = dao.detail(num); 
		model.addAttribute("board",board);
		return "detail";
		
	}
}
