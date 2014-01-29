package com.tz.quiz;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tz.quiz.domain.Output;
import com.tz.quiz.domain.TestCase;
import com.tz.quiz.domain.Zombie;
import com.tz.quiz.service.SmashService;
import com.tz.test.TestSupport;

/**
 * 
 * @author
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
// @Ignore
public class ZombieTest extends TestSupport {

	@Test
	public void runtTest() {
		SmashService service = new SmashService();

		List<TestCase> testCases = new ArrayList<TestCase>();
		List<Output> outputs = null;

		given("with @ testcases,", "3");
		{

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
		}

		when("run service.smashZombie");
		{
			outputs = service.smashZombie(testCases);
		}

		for (int j = 0; j < outputs.size(); j++) {

			Output output = outputs.get(j);
			System.out.println(output.getlog());

			if (j == 0) {
				then(j + " is 3.", j + "'s result == 3");
				{
					assertThat(output.getSmashCnt(), is(3));
				}
			} else if (j == 1) {
				then(j + " is 2.", j + "'s result == 2");
				{
					assertThat(output.getSmashCnt(), is(2));
				}
			} else if (j == 2) {
				then(j + " is 2.", j + "'s result == 2");
				{
					assertThat(output.getSmashCnt(), is(2));
				}
			}
		}
	}

}