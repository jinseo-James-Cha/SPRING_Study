package com.greedy.jackson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class JacksonController {

	private final List<MemberDTO> memberList;

	public JacksonController() {
		memberList = new ArrayList<>();
		memberList.add(new MemberDTO(1, "차진서", 20, new Date()));
		memberList.add(new MemberDTO(2, "James", 10, new Date(System.currentTimeMillis())));
		memberList.add(new MemberDTO(3, "자메스", 24, new Date()));
		memberList.add(new MemberDTO(4, "제임스", 19, new Date()));
		memberList.add(new MemberDTO(5, "메스차", 29, new Date()));
	}

	/* 1. Stream을 이용한 반환 */
	@GetMapping("jackson1")
	public void getMemberList(HttpServletResponse response) throws IOException {
		
		response.setContentType("application/json; charset=UTF-8");
		
		/* jackson lib의 ObjectMapper를 이용해서 json 문자열을 반환 */
		ObjectMapper mapper = new ObjectMapper();
		
		/* dateFormat을 아래와 같이 선언하면 안된다
		 * DTO에 어노테이션으로 날짜 포멧을 설정해야한다.
		 *  */
//		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS"));
		
		PrintWriter out = response.getWriter();
		out.print(mapper.writeValueAsString(memberList));
		
		out.flush();
		out.close();
	}
	
	/* 2. @ResponseBody를 이용한 반환 */
	@GetMapping(value = "jackson2", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getMemberListOnResponseBody() throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(memberList);
		
	}
	
	/* 3. @ResponseBody를 이용하여 MessageConverter 설정 후 자동 json 문자열 반환*/
	@GetMapping(value = "jackson3", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<MemberDTO> getConvertedMemberList() {
		
		/* 메세지 컨버터 설정을 하면 리턴하는 인스턴스를 자동으로 json으로 변환 후 응답
		 * --> 설정을 위해 servlet-context.xml 추가
		 *  */
		return memberList;
	}
	
	/* 4. jsonView를 이용한 응답 
	 *    jsonView를 적용시키려면 servlet-context.xml에서 jsonView를 bean으로 등록하고
	 *    BeanNameViewResolver도 빈으로 등록시켜줘야한다.
	 * */
	@GetMapping("jackson4")
	public ModelAndView getMemberListInModelAndView(ModelAndView mv, HttpServletResponse response) throws JsonProcessingException {
		
		response.setContentType("application/json; charset=UTF-8");
		
		ObjectMapper mapper = new ObjectMapper();
		
		mv.addObject("memberList", mapper.writeValueAsString(memberList));
		mv.setViewName("jsonView");
		
		return mv;
	}
	
	
}
