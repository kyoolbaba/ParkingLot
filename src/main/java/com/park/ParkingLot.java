package com.park;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int sizeOfParkingLot;
    ParkingLotOwner parkingLotOwner;
    List<Vehicle> listOfParkingLots = new ArrayList();
    int[] lots;

    public ParkingLot(int sizeOfParkingLot) {
        this.sizeOfParkingLot = sizeOfParkingLot;
        parkingLotOwner=new ParkingLotOwner();
        lots=new int[sizeOfParkingLot];
    }

    public int parkTheVehicle( Vehicle vehicle) throws ParkingLotException {
        if(vehicle==null||vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(listOfParkingLots.contains(vehicle))
            throw new ParkingLotException("Vehicle Already Pressent"
                    ,ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN);
        if(this.isFull())
            throw new ParkingLotException("Parking Full",ParkingLotException.ExceptionType.PARKING_IS_FULL);
        if(listOfParkingLots.size()+1==sizeOfParkingLot) {
            this.sendStatusToParkingOwner();
            this.redirectStaff();
        }
        parkingLotOwner.assignLotNumber(lots,vehicle);
        listOfParkingLots.add(vehicle);
        return vehicle.getLotNumber();
    }

    public boolean unparkTheVehicle(Vehicle vehicle) throws ParkingLotException {
        if(vehicle==null|| vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(!(listOfParkingLots.contains(vehicle)))
            throw new ParkingLotException("Vehicle Not Present"
                    ,ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
        if(listOfParkingLots.size()==sizeOfParkingLot) {
            this.sendStatusToParkingOwner();
            this.redirectStaff();
        }
        for(Vehicle vehicles:listOfParkingLots){
            if(vehicles.equals(vehicle)){
                lots[vehicles.getLotNumber()-1]=0;
                listOfParkingLots.remove(vehicles);
                break;
            }
        }

        return (!(listOfParkingLots.contains(vehicle)));
    }

    public int getOccupiedLots(){
        return listOfParkingLots.size();
    }

    public boolean isFull(){
        return listOfParkingLots.size()==sizeOfParkingLot;
    }

    public ParkingLotOwner sendStatusToParkingOwner(){
          return new ParkingLotOwner(this.isFull());
    }

    public AirportSecurity redirectStaff(){
        return new AirportSecurity(!isFull());
    }

}
