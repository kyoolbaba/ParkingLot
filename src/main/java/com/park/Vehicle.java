package com.park;

import java.util.Objects;

public class Vehicle {
    private String vehicleNumber;
    private int slotNumber;
    private double charges;
    private int vehicleSize;
    private String color;

    public String getColor() {
        return color;
    }

    public Vehicle setColor(String color) {
        this.color = color;
        return this;
    }

    public int getVehicleSize() {
        return vehicleSize;
    }

    private Driver handicapped;
    private int lotNumber;
    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Driver getDriver() {
        return handicapped;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public double getCharges() {
        return charges;
    }

    public Vehicle(String vehicleNumber, Driver handicapped,int vehicleSize) {
        this.vehicleNumber = vehicleNumber;
        this.handicapped = handicapped;
        this.vehicleSize = vehicleSize;
    }

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getVehicleNumber(), vehicle.getVehicleNumber());
    }

}
