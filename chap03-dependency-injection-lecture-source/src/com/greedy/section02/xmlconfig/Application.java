package com.greedy.section02.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section02/xmlconfig/config/spring-context.xml");
		
		MemberDTO member = context.getBean(MemberDTO.class);
		
		/* xml에 bean은 Account인터페이스를 상속받은 PersonalAccount를 구현하였지만 
		 * 사용할 때는 해당 인터페이스인 Account로 불러왔다.
		 * 그러나, 애매모호함(Account를 상속한 여러 클래스가 존재 할 경우)이 있으니
		 * 해당 구현 클래스를 써도 된다.
		 * ex) Account acc = context.getBean(PersonalAccount.class);
		 *  */
		Account acc = context.getBean(Account.class);
		
		System.out.println(member);
		System.out.println(acc);
		
		System.out.println(member.getPersonalAccount().getBalance());
	}

}
