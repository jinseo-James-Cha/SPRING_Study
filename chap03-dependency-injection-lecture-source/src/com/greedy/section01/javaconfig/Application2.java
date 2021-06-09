package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration2;


public class Application2 {

	public static void main(String[] args) {

		/* setter를 통한 DI  */
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration2.class);
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("bean Name : " + beanName);
		}
		
		/* .class를 통하여 리턴 타입이 MemberDTOdls @Bean을 찾아 실행한다. */
		MemberDTO member = context.getBean(MemberDTO.class);
		
		System.out.println(member);
	}

}
