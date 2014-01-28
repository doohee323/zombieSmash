package com.tz.quiz.service;

import java.util.ArrayList;
import java.util.List;

import com.tz.quiz.domain.Me;
import com.tz.quiz.domain.Output;
import com.tz.quiz.domain.TestCase;
import com.tz.quiz.support.Constants;
import com.tz.quiz.support.ExampleFactory;
import com.tz.quiz.support.ExampleNode;
import com.tz.quiz.support.Map;

public class SmashService {

	public List<Output> smashZombie(List<TestCase> testCases) {

		List<Output> outputs = new ArrayList<Output>();

		for (int j = 0; j < testCases.size(); j++) {
			TestCase testCase = testCases.get(j);
			int closeIndex = -1;
			int closeGap = 0;
			for (int i = 0; i < Constants.maxTime; i++) {
				// recharge smash
				if (Me.smasherEnergy < Constants.smash)
					Me.smasherEnergy++;
				// 1) find the zombie showed
				int finshedCnt = 0;
				for (int k = 0; k < testCase.getZ(); k++) {
					if (i == testCase.getZombie(k).getM()) {
						testCase.getZombie(k).setShowYn(true);
					}
					testCase.getZombie(k).setShowTime();
					if (testCase.getZombie(k).isFinished())
						finshedCnt++;
				}
				if (finshedCnt == testCase.getZ())
					break;

				// 2) find the closest zombie
				if (closeIndex == -1) {
					for (int k = 0; k < testCase.getZ(); k++) {
						if (!testCase.getZombie(k).isFinished()) {
							// get the gap from zombie location
							int xk = testCase.getZombie(k).getX();
							int yk = testCase.getZombie(k).getY();

							Map<ExampleNode> myMap = new Map<ExampleNode>(
									Constants.maxLocation * 2,
									Constants.maxLocation * 2,
									new ExampleFactory());
							int mex = Me.X + Constants.maxLocation;
							int mey = Me.Y + Constants.maxLocation;
							int mxk = xk + Constants.maxLocation;
							int myk = yk + Constants.maxLocation;
							List<ExampleNode> path = myMap.findPath(mex, mey,
									mxk, myk);
							int gap = path.size();
							if (closeGap == 0 || gap < closeGap) {
								closeGap = gap;
								closeIndex = k;
								Me.time2Move = closeGap * Constants.move;
							}
						}
					}
				}

				// 3) move to zombie and smash
				Me.time2Move--;
				if (closeIndex > -1 && Me.time2Move <= 0
						&& Me.smasherEnergy == Constants.smash) {
					Me.X = testCase.getZombie(closeIndex).getX();
					Me.Y = testCase.getZombie(closeIndex).getY();
					Me.smashCnt++;
					Me.smasherEnergy = 0;
					testCase.getZombie(closeIndex).setSmashedYn(true);
					closeGap = 0;
					closeIndex = -1;
					Me.time2Move = -1;
				}
			}
			outputs.add(new Output(j + 1, Me.smashCnt));
			Me.reset();
		}

		// 4) print output
		return outputs;
	}

}
