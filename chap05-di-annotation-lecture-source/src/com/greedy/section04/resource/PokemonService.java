package com.greedy.section04.resource;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {
	
	/* 1. List 타입으로 주입 받기 
		 List 타입으로 하나의 타입인 번들을 한번에 주입할 수 있다. 
		 순서는 bean의 클래스명 영어 알파벳 사전순이다. */
//	private List<Pokemon> pokemonList;
//	
//	@Autowired
//	public PokemonService(List<Pokemon> pokemonList) {
//		this.pokemonList = pokemonList;
//	}
//	
//	public void pokemonAttack() {
//		for(Pokemon pokemon : pokemonList) {
//			pokemon.attack();
//		}
//	}
	
	/* 2. Map 타입으로 주입 받기 */
	private Map<String, Pokemon> pokemonMap;
	
	@Autowired
	public PokemonService(Map<String, Pokemon> pokemonMap) {
		this.pokemonMap = pokemonMap;
	}
	
	public void pokemonAttack() {
		Iterator<String> iter = pokemonMap.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println("pokemonMap의 key : " + key);
			pokemonMap.get(key).attack();
		}
	}
	
}
