
package com.project.comit.entities.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.project.comit.entities.account.personaldata.PersonalData;
import com.project.comit.entities.event.challenge.solution.Solution;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usr_generator")
    @SequenceGenerator(name = "usr_generator", sequenceName = "usr_sequence", initialValue = 1, allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;


    /* ----- CONSTRUCTORS ----- */
    protected User() {
        super();
    }

    protected User(String name, String surname) {
        super();
        this.personalData = new PersonalData(name, surname);
    }

    /* ----- GETTERS & SETTERS ----- */
    public Long getId() {
        return id;
    }

    public String getName() {
        return this.personalData.getName();
    }

    public void setName(String name) {
        this.personalData.setName(name);
    }

    public String getSurname() {
        return this.personalData.getSurname();
    }

    public void setSurname(String surname) {
        this.personalData.setSurname(surname);
    }

}