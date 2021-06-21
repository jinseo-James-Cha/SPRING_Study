package com.greedy.gson;

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

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class GsonController {

	private final List<MemberDTO> memberList;
	
	public GsonController() {
		memberList = new ArrayList<>();
		memberList.add(new MemberDTO(1, "차진서", 20, new Date()));
		memberList.add(new MemberDTO(2, "James", 10, new Date(System.currentTimeMillis())));
		memberList.add(new MemberDTO(3, "자메스", 24, new Date()));
		memberList.add(new MemberDTO(4, "제임스", 19, new Date()));
		memberList.add(new MemberDTO(5, "메스차", 29, new Date()));
	}

	/* 1. stream을 이용한 반환 */
	@GetMapping("gson1")
	public void getMemberList(HttpServletResponse response) throws IOException {
		
		response.setContentType("application/json; charset=UTF-8"); // 내가 view로 다시 전달할 타입은 여러 문자열 타입이지만 나는 json으로 하겠다!
		
		Gson gson = new GsonBuilder() // GsonBuilder를 통해 new Date(System.currentTimeMillis()))를 포맷을 맞춰줘야한다.
					.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS") // 꺼낼때 시분초가 있으면, 데이터베이스에 삽입시에도 시분초를 넣어줘야한다.
					.setPrettyPrinting() // json 문자열을 이쁘게 출력해준다.
					.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY) // 기본값
					.serializeNulls() // 필드값이 null이여도 직렬화하겠다.
					.disableHtmlEscaping() // 직렬화 시 escape 시퀀스처리 하지 않는다. <h1>홍</h1> -> html태그 등 통으로 데이터베이스에 저장할 수도있는 경우
					.create();
		
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(memberList));
		
		out.flush();
		out.close();
	}
	
	/* @RequestBody를 이용한 방법
	 * 
	 * 스프링 3.2이후 버전 @ResponseBody 어노테이션을 이용하면 contentType 설정을 produces 속성에 명시해야한다.
	 * 
	 *  */
	@GetMapping(value = "gson2", produces = "application/json; charset=UTF-8")
	@ResponseBody // String으로 리턴한 값이 viewResolve쪽으로 넘어가지않고 콜백함수(success)로 호출했던 그 곳으로 보내진다.
	public String getMemberListOnResponseBody() {
		
		Gson gson = new GsonBuilder() // GsonBuilder를 통해 new Date(System.currentTimeMillis()))를 포맷을 맞춰줘야한다.
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS") // 꺼낼때 시분초가 있으면, 데이터베이스에 삽입시에도 시분초를 넣어줘야한다.
				.setPrettyPrinting() // json 문자열을 이쁘게 출력해준다.
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY) // 기본값
				.serializeNulls() // 필드값이 null이여도 직렬화하겠다.
				.disableHtmlEscaping() // 직렬화 시 escape 시퀀스처리 하지 않는다. <h1>홍</h1> -> html태그 등 통으로 데이터베이스에 저장할 수도있는 경우
				.create();
		
		return gson.toJson(memberList);
	}
	
	/* 3. jsonView를 이용하여 ModelAndView 반환하는 방법 
	 * 	  전송하려는 객체를 ModelAndView에 담고 view 이름을 jsonView로 설정하여 반환한다.
	 *    jsonView 라는 이름의 bean이 존재하는 경우 jsp응답이 아닌 json으로 응답할 수 있는 viewResolver를 이용하는 방식이다.
	 *    -> servlet-context에 jsp응답 이전에 json으로 응답할 수 있도록 BeanNameViewResolver를 bean에 등록하고 order를 1로 설정해야한다.
	 * */
	@GetMapping(value="gson3")
	public ModelAndView getMemberListInModelAndView(ModelAndView mv, HttpServletResponse response) {

		/* jsonViewResolver에서 response의 정보를 가져가서 view를 이용한다. 
		 * 따라서, 
		 * */
		response.setContentType("application/json; charset=UTF-8");
		
		Gson gson = new GsonBuilder() // GsonBuilder를 통해 new Date(System.currentTimeMillis()))를 포맷을 맞춰줘야한다.
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS") // 꺼낼때 시분초가 있으면, 데이터베이스에 삽입시에도 시분초를 넣어줘야한다.
				.setPrettyPrinting() // json 문자열을 이쁘게 출력해준다.
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY) // 기본값
				.serializeNulls() // 필드값이 null이여도 직렬화하겠다.
				.disableHtmlEscaping() // 직렬화 시 escape 시퀀스처리 하지 않는다. <h1>홍</h1> -> html태그 등 통으로 데이터베이스에 저장할 수도있는 경우
				.create();

		mv.addObject("memberList", gson.toJson(memberList));
		mv.setViewName("jsonView"); // mv.setViewName("bean의 이름", );
		
		return mv;
	}
	
	
	
	
	
	
	
}
