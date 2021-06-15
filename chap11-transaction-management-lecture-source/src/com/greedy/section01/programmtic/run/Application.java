package com.greedy.section01.programmtic.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		/*
		 * 프로그래밍 레벨에서 트랜잭션 처리하는 방법
		 * 
		 * 기존에 마이바티스를 이용할 때는 sqlSession의 commit(), rollback() 메소드를 이용했었다.
		 * 하지만, 스프링과 연동한 환경에서는 위 메소드를 사용하면 UnsupportOperationException 예외가 발생하게된다. 
		 * 
		 * 스프링과 연동한 환경에서 수동으로 트랜잭션을 제어하고자 한다면
		 * PlatformTransactionManager를 사용해야한다.
		 * 
		 * 참고 : https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html#transaction-programmatic
		 * 
		 * */
		
		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section01/programmatic/config/spring-context.xml");
		
	}

}
