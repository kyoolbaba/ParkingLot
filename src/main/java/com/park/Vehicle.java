package com.park;

import java.util.Objects;

public class Vehicle {
    private String vehicleNumber;

    public Vehicle(  String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getVehicleNumber(), vehicle.getVehicleNumber());
    }

}
