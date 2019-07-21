package com.epam.codingkata.refactoring.compose;

public class Order {

    private double itemCost = 1000.25;
    private int festiveDiscount = 10;
    private int memberDiscount = 5;
    private boolean orderedWithinTime = true;

    public double calculatePrice(){
        double firstDiscountedPrice = itemCost * festiveDiscount/100;

        if (orderedWithinTime) {
            firstDiscountedPrice += firstDiscountedPrice + 100;
        }

        double memberDiscountedPrice = itemCost * memberDiscount/100;

        double totalDiscount = firstDiscountedPrice + memberDiscountedPrice;

        double price = itemCost - totalDiscount;

        if (price > 0) {
            return price;
        } else {
            return 0;
        }
    }
}
