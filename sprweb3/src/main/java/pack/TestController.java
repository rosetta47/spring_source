package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

/*
@RestController // @Controller + @ResponseBody
public class TestController {
	@RequestMapping("test1")
	public String abc() {
		return " 요청에 대한 반응 보이기";
	}
}
*/

@Controller //사용자의 요청을 받아가지고 처리한 후 지정된 뷰(템플릿 엔진:jsp ...)에 모델 객체를 넘겨주는 역할
public class TestController {
	@RequestMapping("test1") // @RequestMapping은 get과 post 모두 처리한다
	public ModelAndView abc() {
		//System.out.println("abc 처리");
		//return null;
		
		//return new ModelAndView("list", "msg", "안녕? jsp");

		//위에 return을 풀어서 쓰면 아래문장이 됨
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		// request.setAttribute("msg", "안녕? jsp")
		// HttpServletRequest를 사용해 키, 값으로 jsp에 전송
		modelAndView.addObject("msg", "안녕? jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="test2", method=RequestMethod.GET) // get만 요청 받고 싶을 떄
	public ModelAndView abc2() {
		return new ModelAndView("list", "msg", "성공2");
	}
	
	
	@GetMapping("test3") // get 요청 처리
	public ModelAndView abc3() {
		return new ModelAndView("list", "msg", "성공3");
	}
	
	@GetMapping("test4") // get 요청 처리
	public String abc4(Model model) {
		model.addAttribute("msg", "성공4");
		return "list";
	}
	
	@RequestMapping(value="test5", method=RequestMethod.POST) //POST 요청 처리
	public ModelAndView abc5() {
		return new ModelAndView("list", "msg", "성공5");
	}
	
	@PostMapping("test6") //POST 요청 처리
	public ModelAndView abc6() {
		return new ModelAndView("list", "msg", "성공6");
	}
	
	@PostMapping("test7") //POST 요청 처리
	public String abc7(Model model) {
		model.addAttribute("msg", "성공7");
		return "list"; // ModelAndView가 있을 때 뷰 파일이름이 list이니까 String 으로 받아
	}
	
	@GetMapping("test8") // get 요청 처리
	@ResponseBody 
	public String abc8() {
		String value = "일반 데이터-String, Map, JSON 등을 전달 가능";
		return value;
	}
	
	@GetMapping("test8_1") // get 요청 처리
	@ResponseBody //{"code":10,"name":"톰아저씨"} JSON타입으로 리턴됨
	public DataDto abc8_1() {
		DataDto dto = new DataDto();
		dto.setCode(10);
		dto.setName("톰아저씨");
		return dto; // JSON 형태로 반환 (jackson 라이브러리가 지원되고 있는 거임)
	}
}