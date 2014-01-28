package com.tz.quiz.service;

import java.util.ArrayList;
import java.util.List;

import com.tz.quiz.domain.Me;
import com.tz.quiz.domain.Output;
import com.tz.quiz.domain.TestCase;
import com.tz.quiz.domain.Zombie;
import com.tz.quiz.support.Constants;
import com.tz.quiz.support.ExampleFactory;
import com.tz.quiz.support.ExampleNode;
import com.tz.quiz.support.Map;

public class SmashService {

	public void smashZombie() {

		List<TestCase> testCases = new ArrayList<TestCase>();
		List<Output> outputs = new ArrayList<Output>();

		TestCase testCase1 = new TestCase();
		testCase1.addZombie(new Zombie(1, 0, 0));
		testCase1.addZombie(new Zombie(-1, 0, 0));
		testCase1.addZombie(new Zombie(10, 10, 1000));
		testCase1.addZombie(new Zombie(10, -10, 1000));
		testCases.add(testCase1);

		TestCase testCase2 = new TestCase();
		testCase2.addZombie(new Zombie(1, 1, 0));
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

		for (int j = 0; j < testCases.size(); j++) {
			TestCase testCase = testCases.get(j);
			int closeIndex = 0;
			int closeGap = 0;
			for (int i = 0; i < Constants.maxTime; i++) {
				// recharge smash
				if (Me.smasherEnergy <= Constants.smash)
					Me.smasherEnergy++;
				// 1) find the zombie showed
				for (int k = 0; k < testCase.getZ(); k++) {
					if (i == testCase.getZombie(k).getM()) {
						testCase.getZombie(k).setShowYn(true);
					}
					testCase.getZombie(k).setShowTime();
				}
				// 2) find the closest zombie
				if (closeIndex == 0) {
					for (int k = 0; k < testCase.getZ(); k++) {
						if (!testCase.getZombie(k).isSmashedYn()
								&& testCase.getZombie(k).isShowYn()) {
							// get the gap from zombie location
							int xk = testCase.getZombie(k).getX();
							int yk = testCase.getZombie(k).getY();

							Map<ExampleNode> myMap = new Map<ExampleNode>(50,
									50, new ExampleFactory());
							List<ExampleNode> path = myMap.findPath(Me.X, Me.Y,
									xk, yk);
							int gap = path.size();
							if (closeGap == 0 || gap < closeGap) {
								closeGap = gap;
								closeIndex = k;
							}
						}
					}
				}

				// 3) move to zombie and smash
				if (i == closeGap) {
					Me.X = testCase.getZombie(closeIndex).getX();
					Me.Y = testCase.getZombie(closeIndex).getY();
					Me.smashCnt++;
					Me.smasherEnergy = 0;
					testCase.getZombie(closeIndex).setSmashedYn(true);
					closeGap = 0;
					closeIndex = 0;
				}
			}
			outputs.add(new Output(j, Me.smashCnt));
		}

		// 4) print output
		for (int j = 0; j < outputs.size(); j++) {
			outputs.get(j).print();
		}
	}

}
