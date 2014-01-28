package com.tz.quiz.service;

import com.tz.quiz.domain.TestCase;
import com.tz.quiz.domain.Zombie;
import com.tz.quiz.support.Constants;

public class SmashService {

	public void smashZombie() {
		System.out.println("");
		
//		3
//
//		4
//		1	0	0
//		-1	0	0
//		10	10	1000
//		10  -10 1000
//
//		3
//		1, 1, 0
//		2, 2, 0
//		3, 3, 0
//
//		5
//		10, 10, 1000
//		-10 10 1000
//		10  -10 1000
//		-10  -10 1000
//		20	20	2000
		
		TestCase testCase1 = new TestCase();
		testCase1.addZombie(new Zombie(1, 0 , 0));
		testCase1.addZombie(new Zombie(-1, 0, 0));
		testCase1.addZombie(new Zombie(10, 10, 1000));
		testCase1.addZombie(new Zombie(10, -10, 1000));
		
		TestCase testCase2 = new TestCase();
		testCase2.addZombie(new Zombie(1, 1 , 0));
		testCase2.addZombie(new Zombie(2, 2, 0));
		testCase2.addZombie(new Zombie(3, 3, 0));
		
		TestCase testCase3 = new TestCase();
		testCase3.addZombie(new Zombie(10, 10, 1000));
		testCase3.addZombie(new Zombie(-10, 10, 1000));
		testCase3.addZombie(new Zombie(10, -10, 1000));
		testCase3.addZombie(new Zombie(-10, -10, 1000));
		testCase3.addZombie(new Zombie(20, 20, 2000));
		
		for(int i=0;i<Constants.maxTime;i++) {
			// 현재 존재하는 좀비 확인
			
			
		}

	}

}
