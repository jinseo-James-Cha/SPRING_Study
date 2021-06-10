package com.greedy.section01.properties.javaconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.greedy.section01.properties.javaconfig.Beverage;
import com.greedy.section01.properties.javaconfig.Bread;
import com.greedy.section01.properties.javaconfig.Product;
import com.greedy.section01.properties.javaconfig.ShoppingCart;



/* resources 소스폴더 안의 properties파일을 불러온다. */
@Configuration
@PropertySource("product-info.properties")
public class ContextConfiguration {

	/* placeholder(치환자) 문법을 이용하여 properties에 저장된 key를 입력하면 value에 해당하는 값을 가져옴
	 * ${bread.carpbrad.name:}에 공백을 사용하지않는다.
	 * 위의 :은 뒤의 값은, bread.carpbrad.name을 읽지 못하였을 때의 대체값.
	 *   */
	@Value("${bread.carpbrad.name:붕어빵}")
	private String carpBradName;
	
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
	
}
