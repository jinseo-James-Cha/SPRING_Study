package com.greedy.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class MainController {

	/* return type이 void일때,
	 * RequestMapping의 main이라는 key값을 가지고 
	 * view에 있는 key값.jsp로 viewResolver 자동으로 리턴 시켜준다.
	 *  */
	@RequestMapping("/main")
	public void showMain() {}
	
}
