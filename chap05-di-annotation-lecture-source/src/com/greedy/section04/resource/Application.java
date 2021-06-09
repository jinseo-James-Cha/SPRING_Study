package com.greedy.section04.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

	public static void main(String[] args) {
		
		/* 세 개의 Bean을 모두 사용해야 하는 경우
		 * 이 때는 의존성 주입을 받을 필드의 타입을 변경해야한다. */
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.greedy.section04.resource");
		
		PokemonService pokemonService = context.getBean("pokemonService", PokemonService.class);
		
		pokemonService.pokemonAttack();
	}

}
