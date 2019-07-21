package com.epam.codingkata.refactoring.vacation;

import java.util.Date;

/**
 *
 */
public class CarRental {
    Vehicle vehicle;
    RentalAgreement rentalAgreement;
    private int curKM;
    private int curFuel;
    private int curDamage;
    private double finalPrice;
    private Date currDate;
    private boolean tripStarted;
    private boolean tripEnded;

    public void startTrip(RentalAgreement rentalAgreement) {
        currDate = new Date();
        this.rentalAgreement = rentalAgreement;
        tripStarted = true;

        // record odomoterReading, fuel level(1 to 4) and damage level( 1 to 4)
        vehicle = rentalAgreement.getVehicle();
        curKM = vehicle.getCurrentReading();
        curFuel = vehicle.getCurrentFuelLevel();
        curDamage = vehicle.getDamageLevel();
    }

    public void endTrip() {
        tripEnded = true;
        Date endDate = new Date();
        int endKM = vehicle.getCurrentReading();
        int endFuel = vehicle.getCurrentFuelLevel();
        int damage = vehicle.getDamageLevel();
        double fuelPrice = 80;


        double price = rentalAgreement.getBasePrice();

        // Add distance travelled expenses
        int total = endKM - curKM;
        int extra = total - rentalAgreement.getCoveredKilometers();

        if (extra > 0)
            price = price + total +  (extra * rentalAgreement.getPricePerExtraKilometer());


        // Add fuel expenses
        if (endFuel < curFuel) {
            price = price + (curFuel - endFuel) * fuelPrice;
        }

        // Add any damage expenses.
        price = price + getDamageExpenses(damage);

        // Add additional time expenses
        if ((endDate.getTime() - currDate.getTime())/1000/60/60/24 > rentalAgreement.getValidDuration()) {
            double charges = rentalAgreement.getValidityChargesPerDay();
            long days = (endDate.getTime() - currDate.getTime())/1000/60/60/24 - rentalAgreement.getValidDuration();
            price = price + (days * charges);
        }

        finalPrice = price;
    }

    private double getDamageExpenses(int damage) {
        double damageCost = 0.0;

        if (damage > curDamage && !rentalAgreement.isInsured()) {
            int diff = damage - curDamage;
            double pricePercent = 10.0/100;

            if (diff == 2) pricePercent = 20.0/100;
            if (diff == 3) pricePercent = 30.0/100;
            if (diff == 4) pricePercent = 40.0/100;

            damageCost = pricePercent * rentalAgreement.getBasePrice();
        }
        return damageCost;
    }

    public boolean isTripStarted() {
        return tripStarted;
    }

    public boolean isTripEnded() {
        return tripEnded;
    }

    public double getFinalPrice() {
        return finalPrice;
    }
}
