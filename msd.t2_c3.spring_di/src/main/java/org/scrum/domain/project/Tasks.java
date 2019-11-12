package org.scrum.domain.project;

import java.util.Date;

public class Tasks {
    private String taskName;
    private String taskDescription;
    private String Activity;
    private Date dueDate;
    private Date dateCreated;
    private String Status;
    // aici astea 2 ar trebui sa fie reprezentate de niste
    // id-uri ale angajatilor cu rolul de project manageri
    private String assignedBy;
    private String assignedTo;
}
