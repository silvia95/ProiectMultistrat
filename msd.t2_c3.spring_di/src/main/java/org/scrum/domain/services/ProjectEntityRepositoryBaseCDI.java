package org.scrum.domain.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.scrum.domain.project.Project;
import org.scrum.domain.project.Release;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//SDI Bean Component 
@Component
@Scope("singleton") 	//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProjectEntityRepositoryBaseCDI implements IProjectEntityRepository{
	private static Logger logger = Logger.getLogger(ProjectEntityRepositoryBaseCDI.class.getName());
	
	public ProjectEntityRepositoryBaseCDI() {
		logger.info(">>> BEAN: ProjectEntityRepositoryCDI instantiated!");
		/*
		// Sample projects
		for(int i=1; i<=3; i++) {
			Integer nextID = this.getNextID();
			LocalDateTime startLocalDate = LocalDateTime.now();
			Project newProject = new Project(nextID, "Project_sample_" + i, DateUtils4J8API.asDate(startLocalDate));
			// add one release
			List<Release> releasesProject = new ArrayList<>();
			Date dataPublicare = DateUtils4J8API.asDate(startLocalDate.plusMonths(1));
			Release release = new Release(1, "R: " + newProject.getProjectNo() + "." + 1, dataPublicare, newProject);
			releasesProject.add(release);
			newProject.setReleases(releasesProject);
			// make release current
			newProject.setCurrentRelease(release);
			// add 2 features
			newProject.getCurrentRelease().addFeature("Feature_sample_" + i + "_1");
			newProject.getCurrentRelease().addFeature("Feature_sample_" + i + "_2");
			entities.put(newProject.getProjectNo(), newProject);
			logger.info(">>> BEAN: ProjectEntityRepositoryCDI NEW PROJECT:" + newProject);
		}
		*/
	}
	//
	private Map<Integer, Project> entities = new HashMap<>();
	// 
	private Integer nextID = 0;
	@Override
	public Integer getNextID() {
		nextID++;
		return nextID;
	}
	
	@Override
	public Project getById(Integer id) {
		return entities.get(id);
	}

	@Override
	public Project get(Project sample) {
		return getById(sample.getProjectNo());
	}	
	
	@Override
	public Collection<Project> toCollection() {
		List<Project> projectList = new ArrayList<>();
		projectList.addAll(this.entities.values());
		return projectList;
	}

	@Override
	public Project add(Project entity) {
		if (entity.getProjectNo() == null) {
			nextID++;
			entity.setProjectNo(nextID);
		}
		entities.put(entity.getProjectNo(), entity);
		return entity;
	}

	@Override
	public Collection<Project> addAll(Collection<Project> entities) {
		for(Project entity: entities)
			this.add(entity);
		return entities;
	}

	@Override
	public boolean remove(Project entity) {
		if (this.entities.containsValue(entity)) {
			this.entities.remove(entity.getProjectNo());
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<Project> entities) {
		Boolean flag =  true;
		for(Project entity: entities) {
			if (!this.remove(entity))
				flag = false;
		}
		
		return flag;
	}

	@Override
	public int size() {
		return this.entities.values().size();
	}


}
