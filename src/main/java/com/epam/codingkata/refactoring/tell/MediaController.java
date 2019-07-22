package com.epam.codingkata.refactoring.tell;

public class MediaController {

    public void isAppropriate(Person viewer) {
        int age = viewer.getAge();

        if (age >= 18) {
            viewHorror();
        }

        if (age < 18) {
            sorryNotAllowed();
        }
    }

    private void viewHorror(){}

    private void sorryNotAllowed(){}
}
