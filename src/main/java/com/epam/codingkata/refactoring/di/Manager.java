package com.epam.codingkata.refactoring.di;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<Developer> developers = new ArrayList<>();
    private List<Tester> testers = new ArrayList<>();

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
    }

    public List<Tester> getTesters() {
        return testers;
    }

    public void addTester(Tester tester) {
        this.testers.add(tester);
    }
}
