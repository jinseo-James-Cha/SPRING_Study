package com.greedy.section01.advice.xmlconfig;

import org.springframework.stereotype.Component;

@Component
public class NormalStudent implements Student{

	@Override
	public AchievementResult study(Passion passion) throws Exception {

		if(passion.getScore() <= 0) {
			throw new Exception("열정부족! 다시 가져오세요!");
		}
		
		int understandingScore = 0; // 이해도
		int satisfactionScore = 0; // 만족도
		double employeementRate = 0.0; // 취업률
		
		int passionScore = passion.getScore();
		
		int difficulty = 5;
		
		for(int i = 1; i <=8; i++) {
			System.out.println(i + "교시 수업을 열심히 듣습니다. 오~ 프로그램이 원지 알 것 같습니");
			System.out.println("이해도와 만족도가 열정에 비례하여 자꾸 올라갑니다.");
			
			understandingScore += difficulty + passionScore;
			satisfactionScore += difficulty + passionScore;
			
			System.out.println("하지만 신기하게도 취업율은 생각보다 오르지 않았습니다. 취업난이 심각한가 봅니다.");
			employeementRate += difficulty + passionScore;
			
			if(i == 3) {
				System.out.println("밥을 먹습니다.");
				System.out.println("난 당구의 신!");
				
				understandingScore /= 2;
				satisfactionScore *= 2;
				employeementRate /= 2;
			}
			
		}
		
		return new AchievementResult(understandingScore, satisfactionScore, employeementRate);
	}

}
