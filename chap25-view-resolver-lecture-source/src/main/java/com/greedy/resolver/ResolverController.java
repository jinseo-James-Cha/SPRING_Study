package com.greedy.resolver;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class ResolverController {

	@GetMapping("string")
	public String stringReturning(Model model) {
		
		model.addAttribute("message", "문자열로 뷰 이름 반환한다..");
		
		return "result";
	}
	
	@GetMapping("string-redirect")
	public String stringRedirect(Model model) throws UnsupportedEncodingException {
		
		model.addAttribute("message", URLEncoder.encode("문자열로 뷰 이름 반환하며 리다이렉트", "UTF-8"));

		
		/* 접두사로 redirect:을 하면
		 * forward가 아닌 redirect시킨다 */
		return "redirect:main";  
	}
	
	
}
