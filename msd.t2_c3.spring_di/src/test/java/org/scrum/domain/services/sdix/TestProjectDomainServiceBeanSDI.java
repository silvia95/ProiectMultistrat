package org.scrum.domain.services.sdix;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.scrum.domain.services.IProjectDomainService;
import org.scrum.domain.services.IProjectEntityFactory;
import org.scrum.spring.AppBeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// JUnit.4
public class TestProjectDomainServiceBeanSDI {
	private static Logger logger = Logger.getLogger(TestProjectDomainServiceBeanSDI.class.getName());
	private AnnotationConfigApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(AppBeanConfig.class);
	}
	
	@After
	public void tearDown() throws Exception {
		context.close();
	}

	@Test
	public void test() {
		IProjectDomainService service = context.getBean(IProjectDomainService.class);
		IProjectEntityFactory factory = context.getBean(IProjectEntityFactory.class);
		//
		logger.info("Service implementation :: " + service);
		logger.info("Service implementation class:: " + service.getClass().getName());
		logger.info("Factory implementation :: " + factory);
		logger.info("Factory implementation class:: " + factory.getClass().getName());
		//
		Integer featureCount = service.getProjectFeaturesCount(1);
		assertTrue("Features not counting...", featureCount > 0);
		logger.info("Feature count:: " + featureCount);
	}

}
/*
sudo -i
VBoxManage startvm "Oracle DB Developer VM" --type headless
###
VBoxManage controlvm "Oracle DB Developer VM" savestate
###
*/