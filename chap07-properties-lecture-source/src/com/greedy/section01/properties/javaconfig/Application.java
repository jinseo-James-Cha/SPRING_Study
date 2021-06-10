package com.greedy.section01.properties.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.properties.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("bean Name : " + beanName);
		}
		
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
