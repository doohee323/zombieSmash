package com.tz.quiz.domain;

public class Output {

	private int testCaseSn = 0; // testCase Number
	private int smashCnt = 0; // smashCnt for testCase

	public Output(int testCaseSn, int smashCnt) {
		this.testCaseSn = testCaseSn;
		this.smashCnt = smashCnt;
	}

	public String getlog() {
		String log = "Case #" + this.testCaseSn + ": " + this.smashCnt;
		return log;
	}

	public void print() {
		String log = "Case #" + this.testCaseSn + ": " + this.smashCnt;
		System.out.println(log);
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
