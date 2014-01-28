package com.tz.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

	private static final Logger logger = LoggerFactory
			.getLogger(ZombieTest.class);

	@Test
	public void mongoTest() {
		SmashService service = new SmashService();
		service.smashZombie();
	}

}