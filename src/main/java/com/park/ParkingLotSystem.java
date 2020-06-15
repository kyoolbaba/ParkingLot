package com.park;

public class ParkingLotSystem {

    ParkingLot parkingLot;

    public ParkingLotSystem(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void parkTheVehicle(Vehicle vehicle ) throws ParkingLotException {
         parkingLot.parkVehicle(vehicle);

    }

    public Vehicle unParkTheVehicle(Vehicle vehicle) throws ParkingLotException {
      //  return parkingLot.unparkVehicle(vehicle);
        return vehicle;
    }

    public int getNumberOfOccupiedLots(){
        return parkingLot.getOccupiedLots();
    }

    public boolean checkAvailability(){
        return (!(parkingLot.isFull()));
    }

}
