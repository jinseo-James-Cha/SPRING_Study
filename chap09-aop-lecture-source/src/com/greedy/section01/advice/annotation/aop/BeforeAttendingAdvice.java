package com.greedy.section01.advice.annotation.aop;
/* pointcut과 advice를 하나의 클래스 단위로 정의하기 위한 어노테이션 
 * aspectjrt.jar를 통해 aspectj 라이브러리를 추가 해야한다.
 * */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.greedy.section01.advice.annotation.Passion;

@Aspect
@Component
public class BeforeAttendingAdvice {

	/*
	 * 포인트컷으로 패치한 실행 지점을 조인포인트라고 한다.
	 * 포인트 컷은 여러 조인포인트를 매치하기 위해 지정한 표현식이고,
	 * 이렇게 매치된 조인포인트에서 해야 할 일이 어드바이스이다.
	 * 
	 * 매개변수로 전달한 JoinPoint객체는 현재 조인포인트의 메소드명, 인수값 등의 자세한 정보를 엑세스 할 수 있다.
	 * */
	@Before("execution(* com.greedy.section01.advice.annotation..*(..))")
	public void beforeAttending(JoinPoint joinPoint) {
		System.out.println("=====before attending======");
		System.out.println("오늘도 신나게 등원해서 입실카드를 찍는다.");
		System.out.println("수강생 타입 : " + joinPoint.getTarget().getClass());
		System.out.println("수강생의 행위 : " + joinPoint.getSignature());
		System.out.println("행위 요약 : " + joinPoint.getSignature().getName());
		System.out.println("수강생의 열정 : " + ((Passion) joinPoint.getArgs()[0]).getScore());
		System.out.println("==============================");
	}
	
}
