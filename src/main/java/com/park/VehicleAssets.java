package com.park;

public enum VehicleAssets {
    SMALL(1),MEDIUM(2),LARGE(3);

    private final int vehicleSize;

    VehicleAssets(int vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public int getSize() {
        return vehicleSize;
    }
}
