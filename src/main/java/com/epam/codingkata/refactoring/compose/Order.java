package com.epam.codingkata.refactoring.compose;

public class Order {

    private double orderCost = 1000.25;
    private boolean orderedWithinTime = true;

    public double calculatePrice(){
        int festiveDiscount = 10;
        int memberDiscount = 5;

        double firstDiscountedPrice = orderCost * festiveDiscount/100;

        if (orderedWithinTime) {
            firstDiscountedPrice += firstDiscountedPrice + 10;
        }

        double memberDiscountedPrice = orderCost * memberDiscount/100;

        double totalDiscount = firstDiscountedPrice + memberDiscountedPrice;

        double price = orderCost - totalDiscount;

        return price;
    }
}
