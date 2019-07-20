package com.epam.codingkata.refactoring.vacation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CarRentalTest {

    private CarRental carRental;
    private RentalAgreement rentalAgreement;

    @BeforeMethod
    public void setUp() {
        carRental = new CarRental();
        Vehicle vehicle = new Vehicle(1000, 4, 1);
        rentalAgreement = new RentalAgreement(vehicle, 5,5000, 1000, 10,true);
    }

    @Test
    public void start_trip_status_should_be_started() {
        carRental.startTrip(rentalAgreement);
        assertTrue(carRental.isTripStarted());
        assertFalse(carRental.isTripEnded());
    }

    @Test
    public void end_trip_status_should_be_completed() {
        carRental.startTrip(rentalAgreement);
        carRental.endTrip();
        assertTrue(carRental.isTripEnded());
    }

    @Test
    public void no_additional_fuel_or_damage_trip_price_should_be_package_price() {
        carRental.startTrip(rentalAgreement);
        rentalAgreement.getVehicle().setOdomoterReading(1500);
        carRental.endTrip();
        assertTrue(carRental.isTripEnded());
        assertEquals(carRental.getFinalPrice(), 5000.0);
    }

    @Test
    public void more_km_trip_price_should_be_more() {
        carRental.startTrip(rentalAgreement);
        rentalAgreement.getVehicle().setOdomoterReading(2500);
        rentalAgreement.getVehicle().setFuel(4);
        carRental.endTrip();
        assertTrue(carRental.isTripEnded());
        assertEquals(carRental.getFinalPrice(), 11500.0);
    }

    @Test
    public void less_fuel_trip_price_should_be_more() {
        carRental.startTrip(rentalAgreement);
        rentalAgreement.getVehicle().setOdomoterReading(1000);
        rentalAgreement.getVehicle().setFuel(3);
        carRental.endTrip();
        assertTrue(carRental.isTripEnded());
        assertEquals(carRental.getFinalPrice(), 5080.0);
    }

    @Test
    public void damage_insured_trip__price_should_be_package_price() {
        carRental.startTrip(rentalAgreement);
        rentalAgreement.getVehicle().setOdomoterReading(1500);
        rentalAgreement.getVehicle().setDamage(2);
        carRental.endTrip();
        assertTrue(carRental.isTripEnded());
        assertEquals(carRental.getFinalPrice(), 5000.0);
    }

    @Test
    public void damage_not_insured_trip__price_should_be_more() {
        Vehicle vehicle = new Vehicle(1000, 2, 1);
        rentalAgreement = new RentalAgreement(vehicle, 5,5000, 1000, 10,false);

        carRental.startTrip(rentalAgreement);
        rentalAgreement.getVehicle().setOdomoterReading(1500);
        rentalAgreement.getVehicle().setDamage(2);
        carRental.endTrip();
        assertTrue(carRental.isTripEnded());
        assertEquals(carRental.getFinalPrice(), 5500.0);
    }
}