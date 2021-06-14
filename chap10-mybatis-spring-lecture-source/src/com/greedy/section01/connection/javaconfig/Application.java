package com.greedy.section01.connection.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.connection.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		
		
	}

}
