package com.greedy.section02.locale.xmlconfig;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.greedy.section02.locale.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section02/locale/xmlconfig/config/spring-context.xml");
		
		/* Locale.KOREA = basename_ko_KR여기에서 "ko_KR"을 매칭 시킨다. */
		String error404Message = context.getMessage("error.404", null, Locale.KOREA);
		String error500Message = context.getMessage("error.500", new Object[] {"차진서", new Date()}, Locale.KOREA);
		
		System.out.println("The I18N message for error.404 : " + error404Message);
		System.out.println("The I18N message for error.500 : " + error500Message);
		
	}

}
