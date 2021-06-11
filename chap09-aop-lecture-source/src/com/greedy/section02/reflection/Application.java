package com.greedy.section02.reflection;

public class Application {

	public static void main(String[] args) {

		/*
		 * 리플렉션이란?
		 * 
		 * 컴파일된 자바 코드에서 역으로 클래스를 불러 메소드 및 필드 정보를 구해오는 방법으로,
		 * 반사, 투영이라는 의미를 가진다.
		 * 
		 * 리플렉션은 JVM에서 실행되는 애플리케이션의 런타임 동작을
		 * 검사하거나 수정할 수 있는 기능의 필요한 경우 사용한다.
		 * 
		 * 스프링프레임워크, 마이바티스, 하이버네이트, jackson 등의 라이브러리에서 사용한다.
		 * 
		 * Reflection을 사용해서 스프링에서는 런타임 시에 
		 * 개발자가 등록한 Bean을 애플리케이션 내에서 사용할 수 있게 하는 것이다.
		 * 
		 * Reflection은 강력한 도구이지만 무분별하게 사용해서는 안된다.
		 * 주의사항
		 * 1. 오버헤드 발생 : 성능저하를 발생할 수 있기 때문에 성능에 민감한 애플리케이션에는 사용하지 않는다.
		 * 2. 캡슐화 삭제 : private로 설정한 member에 접근 가능하기 때문에
		 * 				코드 기능이 저하되며 여러가지 문제를 발생시킬 수 있다.
		 * 
		 * Reflection이 사용되는 경우
		 * 1. IoC Container
		 * 2. AOP
		 * 3. Mybatis Mapper
		 * 4. log4jdbc
		 * */
	}

}
