package com.tz.quiz.controller;

import java.util.ArrayList;
import java.util.List;

import com.tz.quiz.domain.Output;
import com.tz.quiz.domain.TestCase;
import com.tz.quiz.domain.Zombie;
import com.tz.quiz.service.SmashService;


public class SmashController {

    /**
     * <pre>
     * main(String[] args)
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args){
    	SmashService service = new SmashService();
    	
		List<TestCase> testCases = new ArrayList<TestCase>();

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
    	
		List<Output> outputs = service.smashZombie(testCases);
		for (int j = 0; j < outputs.size(); j++) {
			outputs.get(j).print();
		}
    }
}
