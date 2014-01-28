package com.tz.log;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.tz.test.TestSupport;

/**
 * 
 * @author
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
// @Ignore
public class MongoTest extends TestSupport {

	private static final Logger logger = LoggerFactory
			.getLogger(MongoTest.class);

	@Autowired
	@Qualifier("appProperties")
	private Properties appProperties;

	@Test
	public void mongoTest() {
		mongoTest(appProperties.getProperty("com.tz.mongodb.host"),
				appProperties.getProperty("com.tz.mongodb.port"),
				appProperties.getProperty("com.tz.mongodb.dbname"));
	}

	public void mongoTest(String ip, String port, String dbname) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}