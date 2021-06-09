package com.greedy.section04.resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class PokemonService {
	
	/* 기본적으로 이름으로 주입을 받는다.
	 * 그리고, bean의 이름이 일치하지 않으면 타입으로 주입받는다.
	 * 
	 * 하지만, 동일한 타입의 bean이 있는 경우에는 주입받지 못한다.
	 * */
	
	/* 1. 같은 타입의 bean이 여러개 */
	@Resource(name="charmander")
	private Pokemon pokemon;
	
	public void pokemonAttack() {
		pokemon.attack();
	}
	
///////////////////////////////////////////////////////	
	/* 여러개 중에 원하는 bean만 가져오기 
	 * @Resource에도 @Qualifier 붙이기 가능.
	 * */
//	@Resource
//	@Qualifier("squirtle")
//	private List<Pokemon> pokemonList;
//	
//	public void pokemonAttack() {
//		for(Pokemon pokemon : pokemonList) {
//			pokemon.attack();
//		}
//	}
///////////////////////////////////////////////////////	
	/* 2. 같은 타입의 bean 한 개 일때(Charmander와 Squirtle 두개의 @Component 주석하고 테스트) */
//	private Pokemon pokemon;
	
	/* 2-1 @Resource 는 생성자 주입을 하지 못한다.(애초에 에로발생) */
//	@Resource
//	public PokemonService(Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
	
	/* 2-2 @Resource 는 setter 주입을 할 수 있다.*/
//	private Pokemon pokemon;
//	
//	@Resource
//	public void setPokemon(Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
//	
//	public void pokemonAttack() {
//		pokemon.attack();
//	}
	
}
