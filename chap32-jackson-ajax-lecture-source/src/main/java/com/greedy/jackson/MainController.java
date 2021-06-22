package com.greedy.jackson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class MainController {

	@GetMapping("/")
	public String showMain() {
		return "main";
	}
	
	@GetMapping("/main")
	public void main() {}

//  실행안됨!
//	@GetMapping("/")
//	public void main() {}
//
//	
//	@GetMapping("/main")
//	public String showMain() {
//		return "main";
//	}
	
}
