package com.park;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int sizeOfParkingLot;
    List<Vehicle> listOfParkingLots = new ArrayList();

    public ParkingLot(int sizeOfParkingLot) {
        this.sizeOfParkingLot = sizeOfParkingLot;
    }

    public boolean parkTheVehicle( Vehicle vehicle) throws ParkingLotException {
        if(vehicle==null||vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(listOfParkingLots.contains(vehicle))
            throw new ParkingLotException("Vehicle Already Pressent"
                    ,ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN);
        if(this.isFull())
            throw new ParkingLotException("Parking Full",ParkingLotException.ExceptionType.PARKING_IS_FULL);
        listOfParkingLots.add(vehicle);
        this.redirectStaff();
        return listOfParkingLots.contains(vehicle);
    }

    public boolean unparkTheVehicle(Vehicle vehicle) throws ParkingLotException {
        if(vehicle==null|| vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(!(listOfParkingLots.contains(vehicle)))
            throw new ParkingLotException("Vehicle Not Present"
                    ,ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
        listOfParkingLots.remove(vehicle);
        return (!(listOfParkingLots.contains(vehicle)));
            }

    public boolean isFull(){
        return listOfParkingLots.size()==sizeOfParkingLot;
    }

    public boolean redirectStaff(){
        return listOfParkingLots.size()==sizeOfParkingLot;
    }

}
