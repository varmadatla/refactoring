package com.epam.codingkata.refactoring.vacation;

public class Vehicle {
    private int odomoterReading;
    private int fuel;
    private int damage;

    public Vehicle(int reading, int fuel, int damage) {
        this.odomoterReading = reading;
        this.fuel = fuel;
        this.damage = damage;
    }

    int getCurrentReading() {
        return odomoterReading;
    }

    int getCurrentFuelLevel() {
        return fuel;
    }

    int getDamageLevel() {
        return damage;
    }

    public void setOdomoterReading(int odomoterReading) {
        this.odomoterReading = odomoterReading;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
