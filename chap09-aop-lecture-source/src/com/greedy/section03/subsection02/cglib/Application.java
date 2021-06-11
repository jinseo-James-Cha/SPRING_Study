package com.greedy.section03.subsection02.cglib;

import org.springframework.cglib.proxy.Enhancer;


/* cglib로 proxy 생성, 사용 */
public class Application {

	public static void main(String[] args) {

		GreedyStudent student = new GreedyStudent();
		Handler handler = new Handler(student);
		
		/* 인터페이스 없이 proxy를 생성할 수 있다!!!! */
		GreedyStudent proxy = (GreedyStudent)Enhancer.create(GreedyStudent.class, new Handler(new GreedyStudent()));
		
		proxy.study(20);
	}

}
