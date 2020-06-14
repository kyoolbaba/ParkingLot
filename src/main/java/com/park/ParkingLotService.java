package com.park;

import java.util.List;

public class ParkingLotService {

    ParkingLot parkingLot;

    public ParkingLotService(List<ParkingLot> sizeOfParkingLot) {
        parkingLot=new ParkingLot(sizeOfParkingLot);
    }

    public void parkTheVehicle(Vehicle vehicle ) throws ParkingLotException {
         parkingLot.parkTheVehicle(vehicle);

    }

    public Vehicle unParkTheVehicle(Vehicle vehicle) throws ParkingLotException {
        return parkingLot.unparkTheVehicle(vehicle);
    }

    public int getNumberOfOccupiedLots(){
        return parkingLot.getOccupiedLots();
    }

    public boolean checkAvailability(){
        return (!(parkingLot.isFull()));
    }

    public List getDetailsByColor(String matches){
       return parkingLot.getDetailsByColor(matches);
    }

}
