package com.epam.codingkata.refactoring.condition;

public class Pension {

    boolean alive;
    boolean retired;
    boolean poverty;

    public double pay(){
        double amount;
        if (!alive) {
            amount = 100;
        } else {
            if (retired) {
                amount = 1000;
            } else {
                if (poverty) {
                    amount = 100000;
                } else {
                    amount = 500;
                }
            }
        }

        return amount;
    }
}
