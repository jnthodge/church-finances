package com.he.giving.jpa.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.he.giving.jpa.config.PersistenceConfig;
import com.he.giving.jpa.repository.LogRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public class JavaRepositoryTest {

	@Autowired
//	@Qualifier("logRepo")
	LogRepository logRepository;
	
	public void setLogRepository(LogRepository logRepository) {
		this.logRepository = logRepository;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			com.he.giving.model.Log l = new com.he.giving.model.Log();
			l.setEventCode("TEST_LOG");
			l.setEventMessage("This is a test log");
			l.setEventType("TEST");
			logRepository.saveAndFlush(l);
		} catch(Exception e) {
			fail("Not yet implemented");
		}
	}

}
