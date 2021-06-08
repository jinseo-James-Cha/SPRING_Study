package com.greedy.section02.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application2 {

	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section02/xmlconfig/config/spring-context2.xml");
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
