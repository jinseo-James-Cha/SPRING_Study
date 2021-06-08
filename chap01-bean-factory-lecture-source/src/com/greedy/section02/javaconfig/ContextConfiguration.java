package com.greedy.section02.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 이 클래스는 환경설정을 위한 클래스로 사용할 것 이다.
 * section01의 spring-context.xml과 같은 역할 */
@Configuration
public class ContextConfiguration {
	
	/* Bean을 등록하기 위해서는 @Bean annotation을 사용한다. */
	/*
	 * @Bean(name="myName") -> name외에 여러 속성들이 포함되어야 할때 
	 * @Bean("myName") -> 오직 name속성만 사용하려고 할 때 생략가능
	 * @Bean -> 메소드명을 자동으로 id로 인식한다
	 * */
	@Bean(name="member")
	public MemberDTO getMember() {
		return new MemberDTO(1,"user01", "pass01", "홍길동");
	}
	
}
