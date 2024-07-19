package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.Jikwon;

@Controller
public class TestController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("/")//모든 요청이 들어오고 있다
	public String main() {
		return "main";
	}
	
	@GetMapping("testjpa")
	public String list(Model model) {
		ArrayList<Jikwon> slist = (ArrayList<Jikwon>)dataDao.getDataAll();
		model.addAttribute("datas",slist);
		return "list";
	}
	
	// 검색을 받으려고 함(list.html에서 보낸 form태그)
	@GetMapping("search")
	public String searchList(FormBean bean,Model model) {
		ArrayList<Jikwon> slist = (ArrayList<Jikwon>)dataDao.getDataSearch(bean.getSearchValue());
		model.addAttribute("datas",slist);
		return "list";
	}
	
}
