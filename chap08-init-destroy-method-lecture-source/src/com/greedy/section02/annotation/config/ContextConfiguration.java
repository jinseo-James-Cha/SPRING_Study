package com.greedy.section02.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.greedy.section02.annotation.Beverage;
import com.greedy.section02.annotation.Bread;
import com.greedy.section02.annotation.Product;
import com.greedy.section02.annotation.ShoppingCart;



@Configuration
/* 아래 ComponentScan을 통해 Bean으로 등록하지않은 Component를 찾아 실행한다. */
@ComponentScan("com.greedy.section02.annotation")
public class ContextConfiguration {

	@Bean
	public Product carpBrad() {
		return new Bread("붕어빵", 1000, new java.util.Date());
	}
	
	@Bean
	public Product milk() {
		return new Beverage("딸기우유", 1500, 500);
	}
	
	@Bean
	public Product water() {
		return new Beverage("지리산암반수", 3000, 1000);
	}
	
	@Bean
	@Scope("prototype")
	public ShoppingCart cart() {
		return new ShoppingCart();
	}
	
	/* initMethod는 동작하지만
	 * destroyMethod는 현시점에서는 동작하지 않는다.
	 * 
	 * Why? 가비지컬렉터가 해당 Bean을 메모리에서 지울 때 동작하게 되는데
	 * 메모리에서 지우기 전에 프로세스는 종료되기 때문에 호출 될 수 없다.
	 * -> 여기에서는 설정하는 방법만 알아두기.
	 * */
	
}
