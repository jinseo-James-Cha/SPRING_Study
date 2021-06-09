package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.greedy.section01.javaconfig.Account;
import com.greedy.section01.javaconfig.MemberDTO;
import com.greedy.section01.javaconfig.PersonalAccount;

@Configuration
public class ContextConfiguration2 {

	@Bean
	public Account accountGenerator() {
		return new PersonalAccount(20, "110-234-56789", "1234");
	}
	
	@Bean
	public MemberDTO memberGenerator() {

		/* 기본 생성자 + setter를 통한 의존성 주입 */
		
		MemberDTO member = new MemberDTO();
		Account account = accountGenerator();
		
		member.setSequence(1);
		member.setName("JAMES");
		member.setPhone("010-1234-4567");
		member.setEmail("up1912@gmail.com");
		member.setPersonalAccount(account);
		
		return member;
	
	}
}
