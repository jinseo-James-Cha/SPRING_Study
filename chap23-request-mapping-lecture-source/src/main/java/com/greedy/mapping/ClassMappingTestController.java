package com.greedy.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/*
 * Class 레벨에 @RequestMapping annotation 사용이 가능하다
 * Class 레벨에 URL을 공통 부분을 이용해 설정하고 나면
 * 매번 핸들러 메소드에 URL의 중복되는 내용을 작성하지않아도 된다.
 * 
 * 이때 와일드 카드(*)를 이용해서 조금 더 포괄적인 URL패턴을 설정할 수 있다.
 * 
 * */
@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

	/* 와일드 카드를 통해 매핑을 하지만 아래 코드와 같이 /를 붙여도되고 안붙여도 된다. */
	@GetMapping("/regist")
	public String registOrder(Model model) {
		
		model.addAttribute("message", "Get 방식의 주문 등록용 핸들러 메소드 호출함");
		
		return "mappingResult";
	}
	
	/* 여러 개의 패턴을 매핑할 수 있다. */
	/* RequestMapping안에 RequestMapping을 써서 여러개의 패턴을 묶었다 */
	/* 주의 할 점은 value "array"안에는 /를 붙이지 않았다. */
	@RequestMapping(value= {"modify", "delete"}, method= RequestMethod.POST)
	public String modifyAndDelete(Model model) {
		
		model.addAttribute("message", "POST 방식의 주문정보 수정과 주문정보 삭제 공통 처리용 핸들러 메소드 호출");
		
		return "mappingResult";
	}
	
	/*
	 * pathVariable로 전달되는 값은 반드시 매개변수 이름이 동일해야한다.
	 * 만약 동일하지 않으면 @PathVariable("이름")을 설정해주어야 한다.
	 * 어노테이션을 생략이 가능하지만 작성해주는게 좋다.
	 * 
	 * 핸들러 메소드에서 요청 객체를 들춰서 전달된 값을 꺼내볼 필요없이 
	 * url경로에 위치한 값을 value로 인식하는 방법이다.
	 * 
	 * 특히 REST협 웹 서비스를 설계할 때 유용하다.
	 * 
	 * PathVariable은 Get방식에서의 String으로 들어와도 자동형변환이 적용되어
	 * 정의해놓은 형으로 인식한다.
	 * */
	@GetMapping("/detail/{orderNo}")
	public String selectOrderDetail(Model model, @PathVariable("orderNo") int orderNo) {
		
		model.addAttribute("message", orderNo + "번 주문 상세 내용 조회영 핸들러 메소드 호출함..");
		
		return "mappingResult";
	}
}
