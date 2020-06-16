package com.park;

import java.util.Objects;

public class Vehicle {
    private String vehicleNumber;
    private int slotNumber;
    private VehicleColor vehicleColor;
    private int duration;
    private String vehicleLocation ="";
    private Driver handicapped;
    private int lotNumber;
    private VehicleName vehicleName;
    private String attendentName;
    private VehicleSize vehicleSize;

    public Vehicle(String vehicleNumber, Driver handicapped,VehicleSize vehicleSize
            ,VehicleColor vehicleColor,VehicleName vehicleName) {
        this.vehicleNumber = vehicleNumber;
        this.handicapped = handicapped;
        this.vehicleSize = vehicleSize;
        this.vehicleColor = vehicleColor;
        this.vehicleName = vehicleName;
    }

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    enum VehicleColor{
        GREEN,RED,WHITE,BLUE,BLACK;
    }

    enum VehicleName{
        MARUTI,BMW,TOYOTA,HYUNDAI,TATA
    }

    public int getDuration() {
        return duration;
    }

    public Vehicle setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public VehicleColor getVehicleColor() {
        return vehicleColor;
    }

    public VehicleName getVehicleName() {
        return vehicleName;
    }

    public String getVehicleLocation(){
        return Integer.toString(this.lotNumber)+"_"+Integer.toString(this.slotNumber);
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Driver getDriver() {
        return handicapped;
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
