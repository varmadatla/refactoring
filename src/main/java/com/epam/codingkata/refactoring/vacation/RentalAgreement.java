package com.epam.codingkata.refactoring.vacation;

public class RentalAgreement {
    Vehicle vehicle;
    double price;
    int includedKM;
    double extraKMPrice;
    boolean insured;
    int durationInDays;

    public RentalAgreement(Vehicle vehicle,
                           int durationInDays,
                           double price,
                           int includedKM,
                           double extraKMPrice,
                           boolean insured) {
        this.vehicle = vehicle;
        this.price = price;
        this.includedKM = includedKM;
        this.extraKMPrice = extraKMPrice;
        this.insured = insured;
        this.durationInDays = durationInDays;
    }

    Vehicle getVehicle() {
        return vehicle;
    }

    double getBasePrice() {
        return price;
    }

    int getCoveredKilometers() {
        return includedKM;
    }

    double getPricePerExtraKilometer() {
        return extraKMPrice;
    }

    public boolean isInsured() {
        return insured;
    }

    public int getValidDuration() {
        return durationInDays;
    }

    public double getValidityChargesPerDay() {
        return 100;
    }
}
