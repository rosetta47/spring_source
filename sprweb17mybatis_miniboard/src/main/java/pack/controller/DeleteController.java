package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class DeleteController {
	@Autowired
	private BoardDao dao;
		
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteSummit(BoardBean bean) {
		boolean b = dao.deleteData(bean); //bean 통째로 들고 감
		
		if(b) {
			return "redirect:/list"; //수정후 목록보기
		}else {
			return "error";
		}
	}
}
