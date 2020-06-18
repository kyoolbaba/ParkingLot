package com.park;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot  {
     int sizeOfParkingLot;
     ParkingSpot parkingSpot;
     Integer[] spotCapacity;
     List<Vehicle> listOfVehiclesInSlot;
     List<Vehicle> totalVehiclesPresent;
     int[] spots;
     ParkingSlot parkingSlot;


    public ParkingLot(List<ParkingLot> parkingLots) {
        parkingSpot =new ParkingSpot();
        this.parkingSlot =new ParkingSlot(parkingLots);
    }

    public ParkingLot() {
        parkingSlot =new ParkingSlot();
    }

    public ParkingLot(int sizeOfParkingLot, Integer...slotCapacities) throws ParkingLotException {
        parkingSlot =new ParkingSlot();
        listOfVehiclesInSlot = new ArrayList();
        spots =new int[sizeOfParkingLot];
        spotCapacity =slotCapacities;
        this.sizeOfParkingLot = Arrays.stream(slotCapacities).mapToInt(i->i).sum();
        if(sizeOfParkingLot!=slotCapacities.length)
            throw new ParkingLotException("Invalid ParkingLot Input"
                    ,ParkingLotException.ExceptionType.INVALID_PARKINGLOT_INPUT);
    }

    public void parkTheVehicle(Vehicle vehicle) throws ParkingLotException {
        if(vehicle==null||vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(parkingSlot.checkVehiclePresent(vehicle))
            throw new ParkingLotException("Vehicle Already Pressent"
                    ,ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN);
        if(this.isFull())
            throw new ParkingLotException("Parking Full",ParkingLotException.ExceptionType.PARKING_IS_FULL);
        ParkingLot vehicleToBeParkedInThisSlot= parkingSlot.assignSlot(vehicle);
            parkingSpot.assignSpotNumber(vehicleToBeParkedInThisSlot.spots,vehicle,vehicleToBeParkedInThisSlot.spotCapacity);
        vehicle.setSlotNumber(parkingSlot.getSlotNumber()+1);
        vehicleToBeParkedInThisSlot.listOfVehiclesInSlot.add(vehicle);
        if(this.isFull()) {
            this.sendStatus();
        }
    }

    public Vehicle unParkTheVehicle(Vehicle vehicle) throws ParkingLotException {
        if(vehicle==null|| vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
        if(!(parkingSlot.checkVehiclePresent(vehicle)))
            throw new ParkingLotException("Vehicle Not Present"
                    ,ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
        if(!this.isFull()) {
            this.sendStatus();
        }
        ParkingLot vehiclesParkedLot= parkingSlot.getSlotOfTheVehiclePresent(vehicle);
        int lotNumber=0;
        Vehicle vehicleTobeUnparked=null;
        for(Vehicle vehicles:vehiclesParkedLot.listOfVehiclesInSlot){
            if(vehicles.equals(vehicle)){
                vehiclesParkedLot.spots[vehicles.getSpotNumber()-1]= vehiclesParkedLot.spots[vehicles.getSpotNumber()-1]
                        -(1*vehicles.getVehicleSize().getSize());
                vehicleTobeUnparked=vehicles;
                vehiclesParkedLot.listOfVehiclesInSlot.remove(vehicles);
                break;
            }
        }
        return vehicleTobeUnparked;
    }

    public int getOccupiedLots(){
        return listOfVehiclesInSlot.size();
    }

    public boolean isFull(){
        return parkingSlot.checkParkingFullOrNot();
    }

    public void sendStatus(){
        new AirportSecurity(this.isFull());
        new ParkingOwner(this.isFull());
    }


    public ParkingLot getDetails() {
        totalVehiclesPresent= parkingSlot.getVehicleDetails();
        return this;
    }

    public ParkingLot selectByColor(Vehicle.VehicleColor vehicleColor) {
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(color->color.getVehicleColor()
                .equals(vehicleColor)).collect(Collectors.toList());
        return this;
    }

    public ParkingLot selectByName(Vehicle.VehicleName vehicleName){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(name->name.getVehicleName()
                .equals(vehicleName)).collect(Collectors.toList());
        return this;
    }

    public ParkingLot selectByDuration(int withIn){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(time->time
                .getDuration()<=withIn).collect(Collectors.toList());
        return this;
    }

    public ParkingLot selectBySpotNumber(int spotNumber){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(slotNum->slotNum
                .getSpotNumber()==spotNumber).collect(Collectors.toList());
        return this;
    }

    public ParkingLot selectBySlotNumber(int slotNumber){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(slotNum->slotNum
                .getSlotNumber()==slotNumber).collect(Collectors.toList());
        return this;
    }

    public ParkingLot selectVehiclesSizeByLimit(int slotNumber){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(slotNum->slotNum
                .getSlotNumber()<slotNumber).collect(Collectors.toList());
        return this;
    }



    public ParkingLot selectByDriverType(Driver driverType){
        totalVehiclesPresent=totalVehiclesPresent.stream().
                filter(type->type.getDriver().equals(driverType)).collect(Collectors.toList());
        return this;
    }

    public ParkingLot selectBySize(int size){
        totalVehiclesPresent=totalVehiclesPresent.stream().
                filter(sizeOfVehicle->sizeOfVehicle.getVehicleSize().getSize()==size).collect(Collectors.toList());
        return this;
    }

}
