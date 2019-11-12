package org.scrum.domain.project;
import java.util.ArrayList;
import java.util.List;

public class Projects {
    private String Name;
    private List TeamMembers = new ArrayList<Employee>();
    private String Complexity;
    private List Activity = new ArrayList<Tasks>();
    private String status;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List getTeamMembers() {
        return TeamMembers;
    }

    public void setTeamMembers(List teamMembers) {
        TeamMembers = teamMembers;
    }

    public String getComplexity() {
        return Complexity;
    }

    public void setComplexity(String complexity) {
        Complexity = complexity;
    }

    public List getActivity() {
        return Activity;
    }

    public void setActivity(List activity) {
        Activity = activity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Projects(String name, List teamMembers, String complexity, List activity, String status) {
        Name = name;
        TeamMembers = teamMembers;
        Complexity = complexity;
        Activity = activity;
        this.status = status;
    }
}
