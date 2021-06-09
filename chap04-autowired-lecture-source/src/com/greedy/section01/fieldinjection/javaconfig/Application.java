package com.greedy.section01.fieldinjection.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {

		/* DI 3번째 - 필드에 의존성 주입 */
		
		/*
		 * @Autowired를 이용한 의존성 주입
		 * 스프링 3.1이후 버전부터 어노테이션을 이용한 bean 생성 및 의존성 주입을 위한 어노테이션을 제공한다.
		 * 어노테이션 방식을 이용하면,
		 * chap03에서 공부한 생성자 주입과 setter주입 외에 필드 주입을 추가적으로 할 수 있다.
		 * */
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.greedy.section01.fieldinjection.javaconfig");
		
		/* @Service어노테이션에 id를 붙여주지않으면 클래스명의 소문자로 바꿔 자동 생성된다. */
		/*                      = new BookService()와 같은 구문  */
		BookService bookService = context.getBean("bookService", BookService.class);
		
		/* 전체 목록 조회 */
		for(BookDTO book : bookService.selectAllBooks()) {
			System.out.println(book);
		}
		
		
	}
}
