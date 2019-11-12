package org.scrum.domain.services;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.scrum.domain.services.IProjectDomainService;
import org.scrum.domain.services.IProjectEntityFactory;
import org.scrum.domain.services.IProjectEntityRepository;
import org.scrum.spring.AppScanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * https://www.logicbig.com/tutorials/spring-framework/spring-core/integration-testing.html
 */

// JUnit.4
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppScanConfig.class)
public class TestProjectDomainServiceDefSDI {
	private static Logger logger = Logger.getLogger(TestProjectDomainServiceDefSDI.class.getName());

	@Autowired
	private IProjectDomainService service;
	
	@Autowired
	private IProjectEntityRepository repository;
	
	@Autowired // @Qualifier("projectFactory") 
	private IProjectEntityFactory factory;

	@Test
	public void test() {
		logger.info("Repository implementation object:: " + repository);
		logger.info("Repository implementation class:: " + repository.getClass().getName());
		//
		logger.info("Factory implementation object:: " + factory);
		logger.info("Factory implementation class:: " + factory.getClass().getName());
		// CDI -> Service -> Factory @PostConstruct :: initDomainServiceEntities -- Repository
		logger.info("Service implementation object:: " + service);
		logger.info("Service implementation class:: " + service.getClass().getName());
		//
		Integer featureCount = service.getProjectFeaturesCount(1);
		assertTrue("Features not counting...", featureCount > 0);
		logger.info("Feature count autowired xml:: " + featureCount);
	}

	@Autowired @Qualifier("ProjectEntityFactoryBaseCDI")
	private IProjectEntityFactory projectFactory;
	
	@Test
	public void testProjectEntityFactory() {
		// CDI -> AppContextConfig -> @Produces IProjectEntityFactory :: initDomainServiceEntities -- Repository
		Integer projectCounts = projectFactory.getProjectEntityRepository().size();
		assertTrue("Projects not counting...", projectCounts > 0);
		logger.info("Project count:: " + projectCounts);
	}
}
/*
sudo -i
VBoxManage startvm "Oracle DB Developer VM" --type headless
###
VBoxManage controlvm "Oracle DB Developer VM" savestate
###
*/