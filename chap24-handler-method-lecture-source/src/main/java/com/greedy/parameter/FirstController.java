package com.greedy.parameter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id") // model.addAttribute("id", XX) -> key에 해당하는 것을 어노테이션으로 넣어준다.
public class FirstController {

	/* GET방식의 /first/regist요청이 들어오면 /first/regist 뷰로 위임한다.*/
	/* 요청하는 jsp의 경로와 views 하위 경로를 일치시켜야한다.
	 * 그러므로, views/first/regist.jsp로 만들어져 있어야 한다.
	 *   */
	@GetMapping("regist")
	public void regist() {}
	
	/*
	 * 핸들러 메소드에 파라미터로 특정 몇가지 타입을 선언하게 되면 핸들러 메소드 호출 시 인자로 값을 전달해준다.
	 * 1. HttpServletRequest를 매개변수로 선언하여 파라미터로 전달받은 값 꺼내기
	 * 	  (핸들러 메소드 매개변수로 HttpServletResponse도 사용 가능하며,
	 * 	  상위 타입인 ServletRequest, ServletResponse도 사용 가능하며
	 * 	  WebRequest도 사용가능하다)
	 * 
	 * 	  HttpServletRequest의 요청 정보를 거의 대부분 그대로 가지고 있는
	 *    API로 Servlet에 종속적이지 않다.
	 * */
	@PostMapping("regist")
	public String registMenu(Model model, HttpServletRequest request) {
		/* Model은 다른 객체에 정보값을 담아서 forward해줄수 있다. */
		/* HttpServletRequest 파라미터의 정보값을 읽어올 수 있다. */
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
		
		String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 "
				        + price + "원으로 등록 하셨습니다.";
		
		System.out.println(message);
		
		model.addAttribute("message", message);
		return "first/messagePrinter";
				        
	}
	
	/*
	 * 2. @RequestParam으로 값 꺼내기
	 * 	  요청 파라미터를 매핑하여 호출 시 값을 넣어주는 어노테이션이다.
	 * 	  @PathVariable처럼 변수 앞에 작성하면 된다.
	 *    form의 name 속성값과 매개변수의 이름이 다른 경우 @RequestParam("name")을 설정하면된다.
	 *    또한, 어노테이션은 생략가능하지만 명시적으로 작성하는것이 의미 파악에 쉽다.
	 * 
	 * 	  각각의 변수에 형변환이 필요없다.
	 * 
	 * 	  @RequestParam(required ) 속성은 전달하는 form이 name속성이 일치하는 것이 없는 경우 400에러가 발생하는데
	 * 	  required 속성을 false로 하게되면 해당 name값이 존재하지 않아도 null로 처리되며 에러 발생하지 않는다.
	 * 	  기본값은 true이다.
	 * 
	 * 	  값이 넘어오지 않게되면 "" 빈문자열이 넘어오게 되는데, 이때 parsing과련 에러가 발생할 수 있다.
	 *    값이 넘어오지 않는 경우 defaultValue를 이용하게 되면 기본값으로 사용할 수 있다.
	 *    -> @RequestParam( defaultValue = "0" )
	 *       페이징 처리 시, 첫 화면의 currentPage =1일때 기본값으로 설정 할 수 있다.
	 *    
	 *      
	 * */
	@GetMapping("modify")
	public void modify() {}
	
	@PostMapping("modify") 
	public String modifyMenuPrice(Model model
			, @RequestParam String modifyName // @RequestParam("modifyName") String modifyName 가능
			                                  // String modifyName 가능
			                                  // String moName -> null값
			                                  // @RequestParam(required = true) String modifyName
			 								  // -> form 태그 안의 name속성 값이 modifyName 아닐경우,
											  //    400에러
			, @RequestParam int modifyPrice) { // @RequestParam("modifyPrice") int modifyPrice
		
		String message = modifyName + "메뉴의 가격을 " + modifyPrice + "로 가격을 변경하였습니다.";
		System.out.println(message);
		
		model.addAttribute("message", message);
		
		return "first/messagePrinter";
	}
	
	/* 
	 * 파라미터가 여러 개 인 경우, 맵으로 한번에 처리할 수도 있다.
	 * 이때 맵의 키는 form의 name 속성값이 된다.
	 * */
	@PostMapping("modifyAll")
	public String modifyAll(Model model, @RequestParam Map<String, String> parameters) {
		
		String modifyMenu =parameters.get("modifyName2");
		int modifyPrice = Integer.parseInt(parameters.get("modifyPrice2"));
		
		String message = "메뉴의 이름을 " + modifyMenu + "(으)로, 가격을 " + modifyPrice + "(으)로 변경하였습니다.";
		
		model.addAttribute("message", message);
		
		return "first/messagePrinter";
		
	}
	
	@GetMapping("search")
	public void search() {}
	
	/*
	 * 3. @ModelAttribute를 이용하는 방법
	 * DTO와 같은 모델을 커맨드 객체로 전달받는다.
	 * 
	 * @ModelAttribute의 경우 커맨드 객체를 생성하여 매개변수로 전달해준뒤 해당 인스턴스를 model에 담는다.
	 * 
	 * form 태그의 input태그 name속성과 DTO의 필드이름을 매핑시키면 된다.
	 * 
	 * 하나의 폼에서 여러 테이블의 insert가 필요할 시,
	 * @ModelAttribute를 매개변수로 더 추가해주면되고, 
	 * 해당 DTO의 필드이름만 unique하게 만들어주자.
	 * */
	
	@PostMapping("search")
	public String searchMenu(@ModelAttribute MenuDTO menu){
		System.out.println(menu);
		
		return "first/searchResult";
	}
	
	@GetMapping("login")
	public void login() {}
	
	/*3-1. HttpSession 이용하기
	 * HttpSession을 매개변수로 선언하면 핸들러메소드 호출 시 세션 객체를 넣어서 호출한다.
	 * 
	 * 매개변수로 선언하면 세션을 만들어서 session이 참조할 수 있게 해준다.
	 * */
	@PostMapping("login1")
	public String sessionTest1(HttpSession session, @RequestParam String id) {
		session.setAttribute("id", id);
		
		return "first/loginResult";
	}
	
	@GetMapping("logout1")
	public String logoutTest1(HttpSession session) {
		
		session.invalidate();
		
		return "first/loginResult";
	}
	
	/* 3-2 @SessionAttributes를 이용하여 session에 값 담기
	 * 클래스 레벨에 @SessionAttributes 어노테이션을 이용하여 세션에 값을 담을 key값을 설정해두면
	 * Model 영역에 Key로 값이 추가되는 경우 session에 자동등록을 한다.
	 * 
	 * */
	@PostMapping("login2")
	public String sessionTest2(Model model, @RequestParam String id) {
		
		// model에 담는 값을 session에 담긴것으로 사용하기 위해
		// 클래스레벨에 @SessionAttributes를 선언해 놓았다.
		model.addAttribute("id", id);
		
		return "first/loginResult";
	}
	
	/* SessionAttributes로 등록된 값은 session의 상태를 관리하는 SessionStatus의 setComplete()
	 * 메소드를 호출해야 사용이 만료된다. */
	@GetMapping("logout2")
	public String logoutTest2(SessionStatus sessionStatus) {
		
		/* 현재 컨트롤러의 세션에 저장된 모든 정보를 제거한다. 개별제거는 불가능하다. */
		sessionStatus.setComplete();
		
		return "first/loginResult";
	}
	
	@GetMapping("body")
	public void body() {}
}
