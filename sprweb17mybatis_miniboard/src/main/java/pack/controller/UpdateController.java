package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class UpdateController {
	@Autowired
	private BoardDao dao;
		
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateSummit(BoardBean bean) {
		boolean b = dao.updateData(bean);
		
		if(b) {
			return "redirect:/list"; //수정후 목록보기
		}else {
			return "error";
		}
	}
}
