package com.greedy.section02.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {

		/* annotation으로 설정되어있는 설정값들을 읽어 오려면 AnnotationConfigApplicationContext 사용하여 읽는다. */
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

		System.out.println(context);
		
		// @Bean옆에 name="member"를 했을 시,
		MemberDTO member = context.getBean("member", MemberDTO.class);
		// @Bean옆에 아무것도 없을 시,
//		MemberDTO member = context.getBean(getMember(), MemberDTO.class);
		
		System.out.println(member);
		
	}

}
