package com.park;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int sizeOfParkingLot;
    Vehicle vehicle;
    List listOfLots = new ArrayList();

    public ParkingLot(int sizeOfParkingLot) {
        this.sizeOfParkingLot = sizeOfParkingLot;
    }

    public boolean addVehicle(String vehicleNumber) throws ParkingLotException {
        if(listOfLots.contains(new Vehicle(vehicleNumber)))
            throw new ParkingLotException("Vehicle Already Pressent"
                    ,ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN);
        if(vehicleNumber==null||vehicleNumber=="")
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(listOfLots.size()==sizeOfParkingLot)
            throw new ParkingLotException("Parking Full",ParkingLotException.ExceptionType.PARKING_IS_FULL);
        vehicle=new Vehicle(vehicleNumber);
        listOfLots.add(vehicle);
        return listOfLots.contains(new Vehicle(vehicleNumber));
    }




}
