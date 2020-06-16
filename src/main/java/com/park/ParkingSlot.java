package com.park;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingSlot {
     int sizeOfParkingLot;
     ParkingSpot parkingSpot;
     Integer[] slotCapacity;
     List<Vehicle> listOfParkingLots ;
     List<Vehicle> totalVehiclesPresent;
     int[] slots;
     ParkingLot parkingLot;


    public ParkingSlot(List<ParkingSlot> parkingSlots) {
        parkingSpot =new ParkingSpot();
        parkingLot =new ParkingLot(parkingSlots);
    }

    public ParkingSlot() { }

    public ParkingSlot(int sizeOfParkingLot, Integer...slotCapacities) throws ParkingLotException {
        listOfParkingLots= new ArrayList();
        slots =new int[sizeOfParkingLot];
        slotCapacity =slotCapacities;
        this.sizeOfParkingLot = Arrays.stream(slotCapacities).mapToInt(i->i).sum();
        if(sizeOfParkingLot!=slotCapacities.length)
            throw new ParkingLotException("Invalid ParkingLot Input"
                    ,ParkingLotException.ExceptionType.INVALID_PARKINGLOT_INPUT);
    }

    public void parkTheVehicle(Vehicle vehicle) throws ParkingLotException {
        if(vehicle==null||vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(parkingLot.checkVehiclePresent(vehicle))
            throw new ParkingLotException("Vehicle Already Pressent"
                    ,ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN);
        if(this.isFull())
            throw new ParkingLotException("Parking Full",ParkingLotException.ExceptionType.PARKING_IS_FULL);
        ParkingSlot vehicleToBeParkedInThisLot= parkingLot.assignLot(vehicle);
        parkingSpot.assignLotNumber(vehicleToBeParkedInThisLot.slots,vehicle,vehicleToBeParkedInThisLot.slotCapacity);
        vehicle.setLotNumber(parkingLot.getLotNumber()+1);
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
        if(!(parkingLot.checkVehiclePresent(vehicle)))
            throw new ParkingLotException("Vehicle Not Present"
                    ,ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
        if(!this.isFull()) {
            this.sendStatusToParkingOwner();
            this.redirectStaff();
        }
        ParkingSlot vehiclesParkedLot= parkingLot.getLotOfTheVehiclePresent(vehicle);
        int lotNumber=0;
        Vehicle vehicleTobeUnparked=null;
        for(Vehicle vehicles:vehiclesParkedLot.listOfParkingLots){
            if(vehicles.equals(vehicle)){
                vehiclesParkedLot.slots[vehicles.getSlotNumber()-1]= vehiclesParkedLot.slots[vehicles.getSlotNumber()-1]
                        -(1*vehicles.getVehicleSize().getSize());
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
        return parkingLot.checkParkingFullOrNot();
    }

    public ParkingSpot sendStatusToParkingOwner(){
          return new ParkingSpot(this.isFull());
    }

    public AirportSecurity redirectStaff(){
        return new AirportSecurity(!isFull());
    }

    public ParkingSlot getTotalVehiclesParked() {
        totalVehiclesPresent= parkingLot.getVehicleDetails();
        return this;
    }

    public ParkingSlot selectByColor(Vehicle.VehicleColor vehicleColor) {
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(color->color.getVehicleColor()
                .equals(vehicleColor)).collect(Collectors.toList());
        return this;
    }

    public ParkingSlot selectByName(Vehicle.VehicleName vehicleName){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(name->name.getVehicleName()
                .equals(vehicleName)).collect(Collectors.toList());
        return this;
    }

    public ParkingSlot selectByDuration(int withIn){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(time->time
                .getDuration()<=withIn).collect(Collectors.toList());
        return this;
    }

    public ParkingSlot selectBySlotNumber(int slotNumber){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(slotNum->slotNum
                .getSlotNumber()==slotNumber).collect(Collectors.toList());
        return this;
    }

    public ParkingSlot selectByDriverType(Driver driverType){
        totalVehiclesPresent=totalVehiclesPresent.stream().
                filter(type->type.getDriver().equals(driverType)).collect(Collectors.toList());
        return this;
    }

    public ParkingSlot selectBySize(int size){
        totalVehiclesPresent=totalVehiclesPresent.stream().
                filter(sizeOfVehicle->sizeOfVehicle.getVehicleSize().getSize()==size).collect(Collectors.toList());
        return this;
    }

}
