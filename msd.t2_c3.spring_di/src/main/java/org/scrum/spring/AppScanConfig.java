package org.scrum.spring;

import java.util.Date;
import java.util.logging.Logger;

import org.scrum.domain.services.IProjectEntityFactory;
import org.scrum.domain.services.ProjectEntityFactoryBaseCDI;
import org.scrum.domain.services.ProjectEntityRepositoryBaseCDI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="org.scrum.domain.services")
public class AppScanConfig {
	private static Logger logger = Logger.getLogger(AppScanConfig.class.getName());
	
	// @Bean("projectFactory")
	public IProjectEntityFactory projectEntityfactory() {
		ProjectEntityRepositoryBaseCDI entityRepositoryBaseCDI = new ProjectEntityRepositoryBaseCDI(); 
		ProjectEntityFactoryBaseCDI projectEntityFactoryBaseCDI = new ProjectEntityFactoryBaseCDI(entityRepositoryBaseCDI);
		
		initDomainServiceEntities(entityRepositoryBaseCDI, projectEntityFactoryBaseCDI);
		
		return projectEntityFactoryBaseCDI;
	}
	
	private void initDomainServiceEntities(ProjectEntityRepositoryBaseCDI entityRepository,
			ProjectEntityFactoryBaseCDI projectEntityFactory) {
		logger.info(">> AppContextConfig :: initDomainServiceEntities");
		for(int i=1; i<=3; i++) {
			entityRepository.add(
					projectEntityFactory.buildProjectWith2R("Project_" + i, new Date(), 1)
			);
		}
		logger.info(">> AppContextConfig.EntityRepository project.count :: " + entityRepository.size());
	}
}
