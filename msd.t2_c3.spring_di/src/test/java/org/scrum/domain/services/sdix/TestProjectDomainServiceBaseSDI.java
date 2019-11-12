package org.scrum.domain.services.sdix;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.scrum.domain.services.IProjectDomainService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// JUnit.4
@Configuration
@ComponentScan(value="org.scrum.domain.services")
public class TestProjectDomainServiceBaseSDI {
	private static Logger logger = Logger.getLogger(TestProjectDomainServiceBaseSDI.class.getName());
	private AnnotationConfigApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(TestProjectDomainServiceBaseSDI.class);
		// Dependency resolution
		service = context.getBean(IProjectDomainService.class);
	}

	// Service dependency
	IProjectDomainService service;
	
	@Test
	public void test() {
		//
		logger.info("Service implementation object:: " + service);
		logger.info("Service implementation class:: " + service.getClass().getName());
		Integer featureCount = service.getProjectFeaturesCount(1);
		assertTrue("Features not counting...", featureCount > 0);
		logger.info("Feature count:: " + featureCount);
	}
	
	
	@After
	public void tearDown() throws Exception {
		context.close();
	}	

}
/*
sudo -i
VBoxManage startvm "Oracle DB Developer VM" --type headless
###
VBoxManage controlvm "Oracle DB Developer VM" savestate
###
*/