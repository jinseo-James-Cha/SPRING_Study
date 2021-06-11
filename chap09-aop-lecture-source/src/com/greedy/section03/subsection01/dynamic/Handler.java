package com.greedy.section03.subsection01.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler{

	// method 호출을 위해 타켓 인스턴스가 필요하다.
	private final Student student;
	
	/* GreedyStudent의 정보값 가져온다 */
	public Handler(Student student) {
		this.student = student;
	}
	
	// 생성된 proxy 인스턴스와 타겟 메소드, 전달받은 인자를 매개변수로 한다.
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		/* 매개변수 확인 */
		System.out.println("==========공부가 너무 하고 싶습니다===========");
		System.out.println("호출 대상 메소드 : " + method);
		for(Object arg : args) {
			System.out.println("전달된 인자 : " + arg);
		}
		
		method.invoke(student, args); // student의 method(=study)를 실행한다.
		System.out.println("==========공부를 마치고 수면 학습을 시작합니다===========");
		
		return proxy;
		
	}
}
