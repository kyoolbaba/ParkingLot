package com.park;

import java.util.List;

public class ParkingLotService {

    ParkingLot parkingLot;

    public ParkingLotService(int s) {

    }

    public ParkingLotService(List<ParkingLot> sizeOfParkingLot) {
        parkingLot=new ParkingLot(sizeOfParkingLot);
    }

    public void entry(Vehicle vehicle ) throws ParkingLotException {
         parkingLot.parkTheVehicle(vehicle);
    }

    public Vehicle exit(Vehicle vehicle) throws ParkingLotException {
        return parkingLot.unparkTheVehicle(vehicle);
    }

    public int getNumberOfOccupiedLots(){
        return parkingLot.getOccupiedLots();
    }

    public boolean checkAvailability(){
        return (!(parkingLot.isFull()));
    }

}
