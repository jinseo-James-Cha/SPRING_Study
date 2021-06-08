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
		
		/* 패키지이지만 물리적으로는 폴더이기때문에 위치를 찾을때는 하위폴더를 구분하는 /로 해야한다.
		 * (혹은 \\로도 가능하지만 .으로는 구분 못한다) */
		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section01/xmlconfig/spring-context.xml");
		
		System.out.println(context);
	}

}
