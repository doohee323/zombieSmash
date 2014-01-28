package com.tz.quiz.domain;

import com.tz.quiz.support.Constants;

public class Me {

	public static int X = 0; // location X
	public static int Y = 0; // location Y
	public static int smashCnt = 0; // count which I smached
	public static int time2Move = -1; // time to move for next zombie
	public static int smasherEnergy = Constants.smash; // Energy to smash

	public static void reset() {
		X = 0;
		Y = 0;
		smashCnt = 0;
		time2Move = -1;
		smasherEnergy = Constants.smash;
	}
}
