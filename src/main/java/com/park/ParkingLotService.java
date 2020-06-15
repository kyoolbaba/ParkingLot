package com.park;

import java.util.List;

public class ParkingLotService {

    ParkingSlot parkingSlot;

    public ParkingLotService(List<ParkingSlot> sizeOfParkingSlot) {
        parkingSlot =new ParkingSlot(sizeOfParkingSlot);
    }

    public void parkTheVehicle(Vehicle vehicle ) throws ParkingLotException {
         parkingSlot.parkTheVehicle(vehicle);

    }

    public Vehicle unParkTheVehicle(Vehicle vehicle) throws ParkingLotException {
        return parkingSlot.unparkTheVehicle(vehicle);
    }

    public int getNumberOfOccupiedLots(){
        return parkingSlot.getOccupiedLots();
    }

    public boolean checkAvailability(){
        return (!(parkingSlot.isFull()));
    }

}
