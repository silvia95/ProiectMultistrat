package org.scrum.domain.project;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List ListOfProjects = new ArrayList<Projects>();

    public List getListOfProjects() {
        return ListOfProjects;
    }

    public void setListOfProjects(List listOfProjects) {
        ListOfProjects = listOfProjects;
    }

    public Manager(List listOfProjects) {
        ListOfProjects = listOfProjects;
    }
}
