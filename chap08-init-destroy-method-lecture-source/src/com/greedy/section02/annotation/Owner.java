package com.greedy.section02.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Owner {

	/* init-method와 같은 설정 annotation */
	@PostConstruct
	public void openShop() {
		System.out.println("사장님이 가게 문을 열었습니다. 이제 쇼핑을 하실 수 있습니다.");
	}
	
	/* destroy-method와 같은 설정 annotation */
	@PreDestroy
	public void closeShop() {
		System.out.println("사장님이 가게 문을 닫았습니다. 더이상 쇼핑을 할 수 없습니다.");
	}
}
