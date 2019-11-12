package org.scrum.spring;

import org.scrum.domain.services.IProjectDomainService;
import org.scrum.domain.services.IProjectEntityFactory;
import org.scrum.domain.services.IProjectEntityRepository;
import org.scrum.domain.services.ProjectDomainServiceCDI;
import org.scrum.domain.services.ProjectEntityFactoryBaseCDI;
import org.scrum.domain.services.ProjectEntityRepositoryBaseCDI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanConfig {
	@Bean
	public IProjectEntityRepository getProjectEntityRepositoryBaseCDI() {
		return new ProjectEntityRepositoryBaseCDI();
	}
	
	@Bean
	public IProjectDomainService getIProjectDomainService() {
		return new ProjectDomainServiceCDI(getProjectEntityRepositoryBaseCDI());
	}
	
	
	@Bean
	public IProjectEntityFactory getIProjectEntityFactory() {
		return new ProjectEntityFactoryBaseCDI();
	}
}