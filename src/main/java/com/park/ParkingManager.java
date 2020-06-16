package com.park;

public class ParkingManager {

    public ParkingManager(boolean parkingFull) {
        new AirportSecurity(parkingFull);
        new ParkingOwner(parkingFull);
    }

    ParkingLotService parkingLotService;

    public ParkingManager(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }


    public ParkingSlot getDetails(){
        return parkingLotService.parkingSlot.getTotalVehiclesParked();
    }


}
