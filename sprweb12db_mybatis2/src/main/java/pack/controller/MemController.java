package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemController {

	@GetMapping("/")// 받는값이 없으면 "/"
	public String chulbal() {
		return "chulbal";
	}
}
