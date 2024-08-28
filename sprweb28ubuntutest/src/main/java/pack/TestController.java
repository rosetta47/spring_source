package pack;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
	@GetMapping("/")//모든 요청이 들어오고 있다
	public String main() {
		return "main";
	}
}
