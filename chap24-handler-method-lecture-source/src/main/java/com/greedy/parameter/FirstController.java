package com.greedy.parameter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first/*")
public class FirstController {

	/* GET방식의 /first/regist요청이 들어오면 /first/regist 뷰로 위임한다.*/
	/* 요청하는 jsp의 경로와 views 하위 경로를 일치시켜야한다.
	 * 그러므로, views/first/regist.jsp로 만들어져 있어야 한다.
	 *   */
	@GetMapping("regist")
	public void regist() {}
}
