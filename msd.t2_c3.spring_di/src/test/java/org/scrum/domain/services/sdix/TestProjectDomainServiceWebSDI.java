package org.scrum.domain.services.sdix;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.scrum.domain.services.IProjectDomainService;
//import org.scrum.spring.AppConfig;
import org.scrum.spring.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/*
 * https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/spring-mvc-unit-testing.html
 */

// JUnit.4
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppConfig.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class TestProjectDomainServiceWebSDI {
	private static Logger logger = Logger.getLogger(TestProjectDomainServiceWebSDI.class.getName());

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp() throws Exception {
		//
	}
	
	@After
	public void tearDown() throws Exception {
		//
	}

	@Test
	public void test() throws Exception{
		IProjectDomainService service = context.getBean(IProjectDomainService.class);
		//
		logger.info("Service implementation object-web:: " + service);
		logger.info("Service implementation class-web:: " + service.getClass().getName());
		Integer featureCount = service.getProjectFeaturesCount(1);
		assertTrue("Features not counting...", featureCount > 0);
		logger.info("Feature count web:: " + featureCount);
		
		System.in.read();
	}

}
/*
sudo -i
VBoxManage startvm "Oracle DB Developer VM" --type headless
###
VBoxManage controlvm "Oracle DB Developer VM" savestate
###
*/