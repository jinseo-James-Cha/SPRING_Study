package com.greedy.section02.prototype.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = 
				new GenericXmlApplicationContext("com/greedy/section02/prototype/xmlconfig/config/spring-context.xml");
		
		/* 등록한 Bean 확인 */
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("bean Name : " + beanName);
		}
		
		/* 현재 Bean의 구성은 singleton으로 설정되어있다 (기본값) 
		 * singleton은 IoC 컨테이너 당 하나의 인스턴스만 생성한다.
		 * 
		 * spring의 scope
		 * 1. singleton - IoC 컨테이너 당 Bean 인스턴스를 하나를 생성한다.
		 * 2. prototype - 요청할 때마다 Bean인스턴스를 새로 만든다.
		 * 3. request - HTTP 요청당 하나의 Bean 인스턴스를 생성한다. 웹 어플리케이션 컨텍스트에만 해당된다.
		 * 4. session - HTTP 세션당 Bean 인스턴스 하나를 생성한다. 웹 어플리케이션 컨텍스트에만 해당된다.
		 * 5. globalSession - 전역 HTTP세션당 Bean 인스턴스를 하나를 생성한다. 포털 어플리케이션 컨텍스트에만 해당된다.
		 * */
		
		/* scope="prototype" */
		System.out.println("xml config 확인 ");
		
		Product carpBread = context.getBean("carpBrad", Bread.class);
		Product milk = context.getBean("milk", Beverage.class);
		Product water = context.getBean("water", Beverage.class);
		
		ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
		cart1.addItem(carpBread);
		cart1.addItem(water);
		System.out.println("cart1 담긴 내용 : " + cart1.getItem());
		
		ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
		cart2.addItem(milk);
		
		System.out.println("cart2 담긴 내용 : " + cart2.getItem());
		
		System.out.println("cart1의 hashcode " + cart1.hashCode() );
		System.out.println("cart2의 hashcode " + cart2.hashCode() );
		
	}

}
