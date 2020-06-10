package com.park;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int sizeOfParkingLot;
    Vehicle vehicle;
    List<Vehicle> listOfParkingLots = new ArrayList();

    public ParkingLot(int sizeOfParkingLot) {
        this.sizeOfParkingLot = sizeOfParkingLot;
    }

    public boolean addVehicle(String vehicleNumber) throws ParkingLotException {
        if(vehicleNumber==null||vehicleNumber=="")
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(listOfParkingLots.contains(new Vehicle(vehicleNumber)))
            throw new ParkingLotException("Vehicle Already Pressent"
                    ,ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN);
        if(listOfParkingLots.size()==sizeOfParkingLot)
            throw new ParkingLotException("Parking Full",ParkingLotException.ExceptionType.PARKING_IS_FULL);
        vehicle=new Vehicle(vehicleNumber);
        listOfParkingLots.add(vehicle);
        return listOfParkingLots.contains(new Vehicle(vehicleNumber));
    }

    public boolean removeVehicle(String vehicleNumber) throws ParkingLotException {
        if(vehicleNumber==null||vehicleNumber=="")
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(!(listOfParkingLots.contains(new Vehicle(vehicleNumber))))
            throw new ParkingLotException("Vehicle Not Present"
                    ,ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
        for(Vehicle vehicle: listOfParkingLots){
            if(vehicle.getVehicleNumber()==vehicleNumber){
                listOfParkingLots.remove(vehicle);
                break;
            }
        }
        return (!(listOfParkingLots.contains(new Vehicle(vehicleNumber))));
    }





}
