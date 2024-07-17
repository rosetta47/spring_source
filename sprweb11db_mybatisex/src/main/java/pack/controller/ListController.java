package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	

	@GetMapping("jikwon")
	public String searchProcess(FormBean bean, Model model) {
        ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)dataDao.getDataSearch(bean);
        model.addAttribute("datas", list);
        return "list";
    }
	
}
