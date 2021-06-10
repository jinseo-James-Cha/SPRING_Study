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
	
	/* 위에서 선언된 것을 다시 재사용 가능하다. */
//	@Value("${bread.carpbrad.name:붕어빵}")
//	private String carpBradName2;
	
	@Value("${bread.carpbrad.price:0}")
	private int carpBradPrice;
	
	@Value("${beverage.milk.name:}")
	private String milkName;
	
	@Value("${beverage.milk.price:0}")
	private int milkPrice;

	@Value("${beverage.milk.capacity:0}")
	private int milkCapacity;
	
	@Bean
	public Product carpBrad() {
		return new Bread(carpBradName, carpBradPrice, new java.util.Date());
	}
	
	@Bean
	public Product milk() {
		return new Beverage(milkName, milkPrice, milkCapacity);
	}
	
	@Bean
	public Product water(@Value("${beverage.water.name:}") String waterName,
						 @Value("${beverage.water.price:0}") int waterPrice,
						 @Value("${beverage.water.capacity:0}") int waterCapacity) {
		
		return new Beverage(waterName, waterPrice, waterCapacity);
	}
	
	@Bean
	@Scope("prototype")
	public ShoppingCart cart() {
		return new ShoppingCart();
	}
	
}
