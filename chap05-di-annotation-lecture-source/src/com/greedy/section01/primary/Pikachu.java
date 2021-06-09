package com.greedy.section01.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
/* @Primary 어노테이션은 
 * @Autowired로 동일한 타입의 여러 Bean을 찾게되는 경우
 * 자동연결을 우선 시 할 타입으로 설정하는 것이다.
 * 동일한 타입(Pokemon 인터페이스를 상속받은 3개의 클래스) 중 하나만 @Primary를 붙일 수 있다.
 *  */
public class Pikachu implements Pokemon{

	@Override
	public void attack() {
		System.out.println("피카츄가 공격을 합니다!! 백만볼트~~찌찌찌찌찌~~");
	}

}
