package com.greedy.section01.advice.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.greedy.section01.advice.annotation");
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("bean name : " + beanName);
		}
		
		Student normalStudent = context.getBean("normalStudent", Student.class);
		
		System.out.println("========= Normal Student=========");
		AchievementResult normalResult = normalStudent.study(new Passion(10));
		System.out.println("NormalStudent Result : " + normalResult);
		
		Student greedyStudent = context.getBean("greedyStudent", Student.class);
		System.out.println("========= Greedy Student=========");
		AchievementResult greedyResult = greedyStudent.study(new Passion(5));
		System.out.println("GreedyStudent Result : " + greedyResult);

	}

}
