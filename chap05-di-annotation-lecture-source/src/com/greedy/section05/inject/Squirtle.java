package com.greedy.section05.inject;

import org.springframework.stereotype.Component;

@Component
public class Squirtle implements Pokemon{

	@Override
	public void attack() {
		System.out.println("꼬부기가 공격을 합니다! 꼬북꼬북 물대포~~~");
	}

}
