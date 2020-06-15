package com.park;

import java.util.ArrayList;
import java.util.List;

public class ParkingSlot {
     Vehicle vehicle;
     List<Vehicle> listOfVehiclesInSlot;
    int slotFilled;
    int slotCapacity;
    int slotAvailable=slotCapacity-slotFilled;

    public ParkingSlot() {
        listOfVehiclesInSlot=new ArrayList();
    }

    public void parkTheVehicle(ParkingSlot parkingSlot, Integer vehicleSize, Vehicle vehicle) {
        parkingSlot.slotFilled +=vehicleSize;
        parkingSlot.listOfVehiclesInSlot.add(vehicle);
    }
}
