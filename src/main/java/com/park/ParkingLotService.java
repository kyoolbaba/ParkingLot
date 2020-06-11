package com.park;

public class ParkingLotService {

    ParkingLot parkingLot;

    public ParkingLotService(int sizeOfParkingLot) {
        parkingLot=new ParkingLot(sizeOfParkingLot);
    }

    public boolean entry(Vehicle vehicle ) throws ParkingLotException {
        return parkingLot.parkTheVehicle(vehicle);
    }

    public boolean exit(Vehicle vehicle) throws ParkingLotException {
    return parkingLot.unparkTheVehicle(vehicle);
    }

    public boolean checkAvailability(){
        return (!(parkingLot.isFull()));
    }

    public boolean checkStaffRedirection(){
        return parkingLot.redirectStaff();
    }

}
