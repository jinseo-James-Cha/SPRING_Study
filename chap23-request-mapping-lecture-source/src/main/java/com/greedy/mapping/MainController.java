package com.greedy.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	// 주소만 써야한다면 value="/"로 안해도 된다.
	@RequestMapping("/")
	public String main() {
		return "main";
	}
}
