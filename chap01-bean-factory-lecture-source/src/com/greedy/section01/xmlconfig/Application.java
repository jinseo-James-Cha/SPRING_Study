package com.greedy.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		/* IoC 컨테이너라 불리는 존재의 최상위 인터페이스 Bean Factory 확 */
		
		/* BeanFactoryfks?
		 * 스프링 컨테이너의 최상위 컨테이너이며, ApplicationContext와 함께 스프링 컨테이너라고 한다.
		 * Bean의 생성과 설정, 관리 등의 역할을 맡고있다.
		 *  */
		
		ApplicationContext context = new GenericXmlApplicationContext("");
		
	}

}
