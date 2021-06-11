package com.greedy.section01.advice.xmlconfig;

public class AchievementResult {

	private int understandingScore; // 이해도
	private int satisfactionScore; // 성취도
	private double employeementRate; // 취업
	public AchievementResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AchievementResult(int understandingScore, int satisfactionScore, double employeementRate) {
		super();
		this.understandingScore = understandingScore;
		this.satisfactionScore = satisfactionScore;
		this.employeementRate = employeementRate;
	}
	public int getUnderstandingScore() {
		return understandingScore;
	}
	public void setUnderstandingScore(int understandingScore) {
		this.understandingScore = understandingScore;
	}
	public int getSatisfactionScore() {
		return satisfactionScore;
	}
	public void setSatisfactionScore(int satisfactionScore) {
		this.satisfactionScore = satisfactionScore;
	}
	public double getEmployeementRate() {
		return employeementRate;
	}
	public void setEmployeementRate(double employeementRate) {
		this.employeementRate = employeementRate;
	}
	@Override
	public String toString() {
		return "ArchievementResult [understandingScore=" + understandingScore + ", satisfactionScore="
				+ satisfactionScore + ", employeementRate=" + employeementRate + "]";
	}
	
	
	
}
