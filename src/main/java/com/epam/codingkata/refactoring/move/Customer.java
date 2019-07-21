package com.epam.codingkata.refactoring.move;

public class Customer {

    public void appreciate(Employee employee){
        Employee manager = employee.getProject().getManager();
        String appreciation = "Dear " + manager.getName() + ", A job well done by " + employee.getName() + ".";
        send(appreciation, manager);
    }

    private void send(String appreication, Employee manager) {
        String email = manager.getEmail();
        // email sent!
    }
}
