package org.scrum.domain.services.sdix;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.scrum.domain.services.IProjectDomainService;
import org.scrum.spring.AppXMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * https://www.logicbig.com/tutorials/spring-framework/spring-core/integration-testing.html
 */

// JUnit.4
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppXMLConfig.class)
public class TestProjectDomainServiceXMLDefSDI {
	private static Logger logger = Logger.getLogger(TestProjectDomainServiceXMLDefSDI.class.getName());

	@Autowired
	private IProjectDomainService service;

	@Test
	public void test() {
		logger.info("Service implementation autowired:: " + service);
		logger.info("Service implementation autowired:: " + service.getClass().getName());
		Integer featureCount = service.getProjectFeaturesCount(1);
		assertTrue("Features not counting...", featureCount > 0);
		logger.info("Feature count autowired:: " + featureCount);
	}

}
/*
sudo -i
VBoxManage startvm "Oracle DB Developer VM" --type headless
###
VBoxManage controlvm "Oracle DB Developer VM" savestate
###
*/