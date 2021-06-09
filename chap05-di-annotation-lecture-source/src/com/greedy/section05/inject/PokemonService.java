package com.greedy.section05.inject;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

@Component
public class PokemonService {
	
	/* @Inject는 @Autowired와 유사하게 타입을 이용해서 bean을 자동 연결한다.
	 * 마찬가지로 bean이 여러개면 모호성으로 인해 의존성을 주입할 수 없다.
	 * Collection 형태로 변경하면 가능하다.
	 *  */

	/* 1. 필드 주입 */
//	@Inject
//	@Named("pikachu") // 여러개의 bean이 있어도 이름으로 찾기 가능 
//	@Qualifier("pikachu") // 여러개의 bean이 있어도 이름으로 찾기 가능.
//	private Pokemon pokemon;
//	
//	public void pokemonAttack() {
//		pokemon.attack();
//	}
	
	/* 2. 생성자 주입 */
	private Pokemon pokemon;
	
	/* 2-1 생성자 
	@Inject
	@Named("pikachu")
	public PokemonService(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	*/
	
	/*	2-2 생성자의 파라미터 레벨 사용 */
//	@Inject
//	public PokemonService(@Named("pikachu")Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
//	
//	public void pokemonAttack() {
//		pokemon.attack();
//	}
	
	/* 3. 세터주입 */
	
	/* 3-1 setter */
//	@Inject
//	@Named("pikachu")
//	public void setPokemon(Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
	
	/* 3-2 setter의 파라미터 레벨 */
	@Inject
	public void setPokemon(@Named("pikachu")Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void pokemonAttack() {
		pokemon.attack();
	}
	
}
