package com.park;

public class ParkingLotService {

    ParkingLot parkingLot;

    public ParkingLotService(int sizeOfParkingLot) {
        parkingLot=new ParkingLot(sizeOfParkingLot);
    }

    public double entry(Vehicle vehicle ) throws ParkingLotException {
        return parkingLot.parkTheVehicle(vehicle);
    }

    public int exit(Vehicle vehicle) throws ParkingLotException {
    return parkingLot.unparkTheVehicle(vehicle);
    }

    public int getNumberOfOccupiedLots(){
        return parkingLot.getOccupiedLots();
    }

    public boolean checkAvailability(){
        return (!(parkingLot.isFull()));
    }

}
