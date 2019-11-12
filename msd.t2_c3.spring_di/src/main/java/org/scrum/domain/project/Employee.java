package org.scrum.domain.project;

public class Employee {
    private float rating;
    private float salariu;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getSalariu() {
        return salariu;
    }

    public void setSalariu(float salariu) {
        this.salariu = salariu;
    }

    public Employee(float rating, float salariu) {
        this.rating = rating;
        this.salariu = salariu;
    }
}
