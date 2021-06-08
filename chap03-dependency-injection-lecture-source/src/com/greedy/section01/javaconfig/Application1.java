package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration1;

public class Application1 {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration1.class);
		
		/* MemberDTO의 타입으로 getBean이 되어서 ContextConfiguration1안에 MemberDTO타입으로 실행시켰다. */
		MemberDTO member = context.getBean(MemberDTO.class);
		
		System.out.println(member);
	}

}
