package com.greedy.section01.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {

	/* 필드 주입을 이용하는 경우 */
	
	/* @Qualifier 어노테이션으로 의존성 주입을 하는 경우 
	 * 타입이 아닌 클래스이름(첫들자소문자id)로 주입을 한다. 
	 * @Primary 보다 우선권을 갖는다 */
//	@Autowired
//	@Qualifier("squirtle")
	private Pokemon pokemon;
	
	@Autowired
	public PokemonService(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void pokemonAttack() {
		pokemon.attack();
	}
	
}
