package com.greedy.section01.advice.xmlconfig;

import org.springframework.stereotype.Component;

@Component
public class GreedyStudent implements Student {

	@Override
	public AchievementResult study(Passion passion) throws Exception {

		if(passion.getScore() != 10) {
			throw new Exception("GreedyStuden는 열정이 언제나 MAX여야합니다! 다시 열정가져오세요!!");
		}
		
		int understandingScore = 0;
		int satisfactionScore = 0;
		double employeementRate = 0.0;
		
		int passionScore = passion.getScore();

		int difficulty = 10;
		
		for(int i = 1; i <= 8; i++) {
			System.out.println(i + "교시 수업을 열심히 듣습니다. 하지만 너무 어렵습니다.");
			System.out.println("이해도와 만족도가 열정에 비례하여 자꾸 떨어집니다.");
			
			understandingScore -= difficulty * passionScore;
			satisfactionScore -= difficulty * passionScore;
			
			System.out.println("하지만 신기하게 취업률은 올라가고 있습니다.");
			employeementRate += difficulty * passionScore;
			
			if(i == 3) {
				System.out.println("잠시 밥을 먹으며 오전에 수업들은 내용으로 토론을 해요.");
				employeementRate += difficulty * passionScore;
			}
		}
		
		return new AchievementResult(understandingScore, satisfactionScore, employeementRate);
	}

}
