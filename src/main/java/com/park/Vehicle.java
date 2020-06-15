package com.park;

import java.util.Objects;

public class Vehicle {
    private String vehicleNumber;
    private int slotNumber;
    private int vehicleSize;
    private String color="";
    private int duration;
    private String vehicleLocation ="";
    private Driver handicapped;
    private int lotNumber;
    private String vehicleName;
    private String attendentName;

    public int getDuration() {
        return duration;
    }

    public Vehicle setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public String getAttendentName() {
        return attendentName;
    }

    public Vehicle setAttendentName(String attendentName) {
        this.attendentName = attendentName.toUpperCase();
        return this;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public Vehicle setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName.toUpperCase();
        return this;
    }

    public String getVehicleLocation(){
        return Integer.toString(this.lotNumber)+"_"+Integer.toString(this.slotNumber);
    }

    public String getColor() {
        return color;
    }

    public Vehicle setColor(String color) {
        this.color = color.toUpperCase();
        return this;
    }

    public int getVehicleSize() {
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
