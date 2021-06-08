package com.greedy.section02.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application1 {

	public static void main(String[] args) {

		/* ComponentScan 기능을 이용한 bean등록 설정을 확인 
		 * 
		 *  ComponentScan이란?
		 *  base-package로 설정된 경로 하위에 특정 어노테이션을 가지고 있는 클래스를 이용하여 bean으로 등록한다.
		 *  @Component annotation이 작성된 클래스를 인식하여 bean으로 만들게 되면,
		 *  특수 목적에 따라 세부기능을 제공하는
		 *  @Controller, @Service, @Repository(=DAO), @Configuration(=설정값) 등을 인식한다.
		 *  */
		
		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section02/xmlconfig/config/spring-context1.xml");
		System.out.println(context);

		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("bean Name : " + beanName);
		}
		
		MemberDAO memberDAO = context.getBean(MemberDAO.class);
		
		System.out.println(memberDAO.selectMember(1));
		System.out.println(memberDAO.insertMEmber(new MemberDTO(3,"user03", "pass03", "새로운맴버")));
		System.out.println(memberDAO.selectMember(3));
	}

}
