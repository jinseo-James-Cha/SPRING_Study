package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.greedy.section01.advice.annotation.AchievementResult;

/*
 * ASPECT = Advice + PointCut
 * 
 * Advice : 지금 이 클래스와 같은 것을 말한다.
 * PointCut : 실행될 시점을 잡는 것
 * */

@Aspect
@Component
public class AfterReturningAttendingAdvice {

	/* 1. 속성이 포인트컷만 있었을 때는 명시적으로 안써도 됐지만
	 * 		여기에서는 두개이상의 속성이 들어가므로 명시적으로 속성을 써줘야한다. */
	/* 2. joinPoint는 반드시 첫번째 매개변수로 선언해야한다. */
	/* 3. returning="이름" 과 두번째 매개변수 명을 동일하게 맞춰줘야한다 ex)result */
	@AfterReturning(pointcut = "execution(* com.greedy.section01.advice.annotation..*(..))", returning = "result")
	public void  afterReturningAttending(JoinPoint joinPoint, Object result) {
		System.out.println("===============after returning attending ====================");
		System.out.println("보람찬 !!! 하루일을! 끝마치고서~~~ 두 다리 쭉 펴면 고향의 안방으로~~~");
		System.out.println("오늘의 이해도 : " + (((AchievementResult) result).getUnderstandingScore()));
		System.out.println("오늘의 만족도 : " + (((AchievementResult) result).getSatisfactionScore()));
		System.out.println("오늘의 취업률 : " + (((AchievementResult) result).getEmployeementRate()));
		
		/* 취업률 수치를 백분율로 환산해서 퍼센트로 변환해보자 */
		double employeementRate = ((AchievementResult) result).getEmployeementRate();
		double percent = employeementRate / 1000.0 * 100;
		System.out.println("증가된 취업률 : " + percent + "%");
		
		/* 리턴할 결과값을 변경해 줄 수 있다 */
		((AchievementResult)result).setEmployeementRate(percent);
		System.out.println("=========================================================");
	}
}
