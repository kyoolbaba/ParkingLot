package com.park;

public enum VehicleSize {
    SMALL(1),MEDIUM(2),LARGE(3);

    private final int vehicleSize;

    VehicleSize(int vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public int getSize() {
        return vehicleSize;
    }
}
