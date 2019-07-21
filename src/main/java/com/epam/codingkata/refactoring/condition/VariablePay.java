package com.epam.codingkata.refactoring.condition;

public class VariablePay {

    private enum  EmployeeType {
        CEO,
        DIRECTOR,
        ARCHITECT
    }

    public double getPay(EmployeeType employeeType){
        switch (employeeType) {
            case CEO: return 50 + (131.23);
            case DIRECTOR: return 40 + (42.89);
            case ARCHITECT: return 30 + (2.45);
            default: return 0;
        }
    }
}
