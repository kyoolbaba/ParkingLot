package com.park;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
     int sizeOfParkingLot;
    ParkingLotOwner parkingLotOwner;
     int[] slotCapacity;
    List<Vehicle> listOfParkingLots ;
    private int[] slots;
    ParkingLotRepository parkingLotRepository;

    public ParkingLot(List<ParkingLot> parkingSlots) {
        parkingLotOwner=new ParkingLotOwner();
        parkingLotRepository=new ParkingLotRepository(parkingSlots);
    }

    public ParkingLot(int sizeOfParkingLot,int...slotCapacities) throws ParkingLotException {
        this.sizeOfParkingLot = sizeOfParkingLot;
        listOfParkingLots= new ArrayList();
        slots =new int[sizeOfParkingLot];
        slotCapacity =slotCapacities;
        if(sizeOfParkingLot!=slotCapacities.length)
            throw new ParkingLotException("Invalid ParkingLot Input"
                    ,ParkingLotException.ExceptionType.INVALID_PARKINGLOT_INPUT);
    }

    public void parkTheVehicle(Vehicle vehicle) throws ParkingLotException {
        if(vehicle==null||vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(parkingLotRepository.checkVehiclePresent(vehicle))
            throw new ParkingLotException("Vehicle Already Pressent"
                    ,ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN);
        if(this.isFull())
            throw new ParkingLotException("Parking Full",ParkingLotException.ExceptionType.PARKING_IS_FULL);
        ParkingLot vehicleToBeParkedInThisLot=parkingLotRepository.selectLot();
        parkingLotOwner.assignLotNumber(vehicleToBeParkedInThisLot.slots,vehicle,vehicleToBeParkedInThisLot.slotCapacity);
        vehicle.setLotNumber(parkingLotRepository.getLotNumber()+1);
        vehicleToBeParkedInThisLot.listOfParkingLots.add(vehicle);
        if(this.isFull()) {
            this.sendStatusToParkingOwner();
            this.redirectStaff();
        }
    }

    public Vehicle unparkTheVehicle(Vehicle vehicle) throws ParkingLotException {
        if(vehicle==null|| vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(!(parkingLotRepository.checkVehiclePresent(vehicle)))
            throw new ParkingLotException("Vehicle Not Present"
                    ,ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
        if(this.isFull()) {
            this.sendStatusToParkingOwner();
            this.redirectStaff();
        }
        ParkingLot vehiclesParkedLot=parkingLotRepository.getLotOfVehicle(vehicle);
        int lotNumber=0;
        Vehicle vehicleTobeUnparked=null;
        for(Vehicle vehicles:vehiclesParkedLot.listOfParkingLots){
            if(vehicles.equals(vehicle)){
                vehiclesParkedLot.slots[vehicles.getSlotNumber()-1]-= vehiclesParkedLot.slots[vehicles.getSlotNumber()-1]-1;
                vehicleTobeUnparked=vehicles;
                vehiclesParkedLot.listOfParkingLots.remove(vehicles);
                break;
            }
        }
        return vehicleTobeUnparked;
    }

    public int getOccupiedLots(){
        return listOfParkingLots.size();
    }

    public boolean isFull(){
        return parkingLotRepository.checkParkingFullOrNot();
    }

    public ParkingLotOwner sendStatusToParkingOwner(){
          return new ParkingLotOwner(this.isFull());
    }

    public AirportSecurity redirectStaff(){
        return new AirportSecurity(!isFull());
    }

}
