package com.tz.quiz.domain;

public class Output {

	private int testCaseSn = 0; 	// testCase Number
	private int smashCnt = 0; 	// smashCnt for testCase
	
	public Output (int testCaseSn, int smashCnt) {
		this.testCaseSn = testCaseSn;
		this.smashCnt = smashCnt;
	}
	
	public void print() {
		System.out.println("Case #" + this.testCaseSn + ": " + this.smashCnt);
	}
	
	public int getTestCaseSn() {
		return testCaseSn;
	}
	public void setTestCaseSn(int testCaseSn) {
		this.testCaseSn = testCaseSn;
	}
	public int getSmashCnt() {
		return smashCnt;
	}
	public void setSmashCnt(int smashCnt) {
		this.smashCnt = smashCnt;
	}
}
