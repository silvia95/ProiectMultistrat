package org.scrum.domain.project;

public class Users {
    private String Username;
    private String Password;
    private String Role;
    private String Name;
    private String Surname;

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getRole() {
        return Role;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setRole(String role) {
        Role = role;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Users(String username, String password, String role, String name, String surname) {
        Username = username;
        Password = password;
        Role = role;
        Name = name;
        Surname = surname;
    }
}
