package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.Jikwon;
import pack.model.JikwonDao;

@Controller
public class ListController {
	@Autowired
	private JikwonDao dao;
	
	@RequestMapping("list")
	public String list(Model model) {
		ArrayList<Jikwon> list = (ArrayList<Jikwon>)dao.list();
		model.addAttribute("list", list);
		
		return "list";
	}
}
