package org.scrum.domain.services.sdix;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.scrum.domain.services.IProjectDomainService;
import org.springframework.context.support.GenericXmlApplicationContext;

// JUnit.4
public class TestProjectDomainServiceXMLBeanSDI {
	private static Logger logger = Logger.getLogger(TestProjectDomainServiceXMLBeanSDI.class.getName());
	private GenericXmlApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new GenericXmlApplicationContext();
		context.load("org/scrum/spring/beans.xml");
		//context.load("./beans.xml");
		context.refresh();
	}
	
	@After
	public void tearDown() throws Exception {
		context.close();
	}

	@Test
	public void test() {
		IProjectDomainService service = context.getBean(IProjectDomainService.class);
		//
		logger.info("Service implementation object-bean XML :: " + service);
		logger.info("Service implementation class-bean XML:: " + service.getClass().getName());
		Integer featureCount = service.getProjectFeaturesCount(1);
		assertTrue("Features not counting...", featureCount > 0);
		logger.info("Feature count bean XML:: " + featureCount);
	}

}
/*
sudo -i
VBoxManage startvm "Oracle DB Developer VM" --type headless
###
VBoxManage controlvm "Oracle DB Developer VM" savestate
###
*/