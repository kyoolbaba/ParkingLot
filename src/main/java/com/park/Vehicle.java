package com.park;

import java.util.Objects;

public class Vehicle {
    private String vehicleNumber;
    private int lotNumber;
    private double charges;
    private int noOfDays;
    private boolean handicapped;

    public boolean isHandicapped() {
        return handicapped;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public double getCharges() {
        return charges;
    }

    public Vehicle(String vehicleNumber, int noOfDays,boolean handicapped) {
        this.vehicleNumber = vehicleNumber;
        this.noOfDays = noOfDays;
        this.handicapped = handicapped;
    }

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getVehicleNumber(), vehicle.getVehicleNumber());
    }

}
