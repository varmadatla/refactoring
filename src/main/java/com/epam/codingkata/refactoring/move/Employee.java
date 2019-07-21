package com.epam.codingkata.refactoring.move;

public class Employee {
    private final String name;
    private final String email;
    private Project project;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
