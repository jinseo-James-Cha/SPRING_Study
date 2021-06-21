package com.greedy.gson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class MainController {

	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("main")
	public void showMain() {}
	
}
