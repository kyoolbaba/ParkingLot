package com.park;

public class ParkingLotService {

    ParkingLot parkingLot;

    public ParkingLotService(int sizeOfParkingLot) {
        parkingLot=new ParkingLot(sizeOfParkingLot);
    }

    public boolean parkTheVehicle(String vehicleNumber ) throws ParkingLotException {
        return parkingLot.addVehicle(vehicleNumber);
    }

    public boolean unparkTheVehicle(String vehicleNumber) throws ParkingLotException {
    return parkingLot.removeVehicle(vehicleNumber);
    }

    public boolean checkAvailability(){
        return (!(parkingLot.isFull()));
    }

}
