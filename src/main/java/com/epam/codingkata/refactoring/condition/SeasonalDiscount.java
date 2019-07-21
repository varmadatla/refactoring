package com.epam.codingkata.refactoring.condition;

import java.util.Date;

public class SeasonalDiscount {
    private static Date SUMMER_START = new Date();
    private static Date SUMMER_END = new Date();
    private double winterRate = 20;

    public double getDiscount(Date date, int quantity){
        double discount = 0;

        if (date.before(SUMMER_START) && date.after(SUMMER_END)) {
            discount = winterRate * quantity;
        } else {
            discount = 20 * quantity;
        }

        return  discount;
    }
}
