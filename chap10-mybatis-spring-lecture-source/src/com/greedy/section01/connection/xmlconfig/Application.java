package com.greedy.section01.connection.xmlconfig;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = 
				new GenericXmlApplicationContext("com/greedy/section01/connection/xmlconfig/config/spring-context.xml");
		
		System.out.println("전체 메뉴 조회하기");
		
		//                                        Bean등록에 쓰인 ID, 클래스타입(보통 상속한 인터페이스)
		MenuService menuService = context.getBean("menuService", MenuService.class);
	
		List<MenuDTO> menuList = menuService.selectMenuList();
		for(MenuDTO menu : menuList) {
			System.out.println(menu);
		}
		
	}

}
