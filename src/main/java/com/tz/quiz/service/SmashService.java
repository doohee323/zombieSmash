package com.tz.quiz.service;

import java.util.ArrayList;
import java.util.List;

import com.tz.quiz.domain.Me;
import com.tz.quiz.domain.TestCase;
import com.tz.quiz.domain.Zombie;
import com.tz.quiz.support.Constants;
import com.tz.quiz.support.ExampleFactory;
import com.tz.quiz.support.ExampleNode;
import com.tz.quiz.support.Map;

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
		
		List<TestCase> testCases = new ArrayList<TestCase>();
		
		TestCase testCase1 = new TestCase();
		testCase1.addZombie(new Zombie(1, 0 , 0));
		testCase1.addZombie(new Zombie(-1, 0, 0));
		testCase1.addZombie(new Zombie(10, 10, 1000));
		testCase1.addZombie(new Zombie(10, -10, 1000));
		testCases.add(testCase1);
		
		TestCase testCase2 = new TestCase();
		testCase2.addZombie(new Zombie(1, 1 , 0));
		testCase2.addZombie(new Zombie(2, 2, 0));
		testCase2.addZombie(new Zombie(3, 3, 0));
		testCases.add(testCase2);
		
		TestCase testCase3 = new TestCase();
		testCase3.addZombie(new Zombie(10, 10, 1000));
		testCase3.addZombie(new Zombie(-10, 10, 1000));
		testCase3.addZombie(new Zombie(10, -10, 1000));
		testCase3.addZombie(new Zombie(-10, -10, 1000));
		testCase3.addZombie(new Zombie(20, 20, 2000));
		testCases.add(testCase3);
		
		for(int j=0;j<testCases.size();j++) {
			TestCase testCase = testCases.get(j);
			int closeIndex = 0;
			int closeGap = 0;
			for (int i = 0; i < Constants.maxTime; i++) {
				if(Me.smasherEnergy <= Constants.)
				// 1) 현재 존재하는 좀비 확인
				for (int k = 0; k < testCase.getZ(); k++) {
					// 현 시간에 존재하는 좀비
					if(i == testCase.getZombie(k).getM()) {
						testCase.getZombie(k).setShowYn(true);
					}
					testCase.getZombie(k).setShowTime();
				}
				// 2) 가장 가까이 있는 좀비 찾기
				if(closeIndex == 0) {
					for (int k = 0; k < testCase.getZ(); k++) {
						if(testCase.getZombie(k).isShowYn()) {
							// 좀비와의 거리
							int xk = testCase.getZombie(k).getX();
							int yk = testCase.getZombie(k).getY();
							
					        Map<ExampleNode> myMap = new Map<ExampleNode>(50, 50, new ExampleFactory());
					        List<ExampleNode> path = myMap.findPath(Me.X, Me.Y, xk, yk);
					        int gap = path.size();
					        if(closeGap == 0 || gap < closeGap) {
					        	closeGap = gap;
					        	closeIndex = k;
					        }
						}
					}
				}
				
				// 3) 좀비 쪽으로 이동 후 smash
				if(i == closeGap) {
					Me.X = testCase.getZombie(closeIndex).getX();
					Me.Y = testCase.getZombie(closeIndex).getY();
					Me.smashCnt++;
					Me.smasherEnergy = 0;
				}
				
			}
			
			
		}

	}

}
