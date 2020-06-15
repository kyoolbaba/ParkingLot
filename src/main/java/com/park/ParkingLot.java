package com.park;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParkingLot {
     int sizeOfParkingLot;
    ParkingLotOwner parkingLotOwner;
     Integer[] slotCapacity;
    List<Vehicle> listOfParkingLots ;
    List<Vehicle> totalVehiclesPresent;
    private int[] slots;
    ParkingLotRepository parkingLotRepository;

    public ParkingLot(List<ParkingLot> parkingSlots) {
        parkingLotOwner=new ParkingLotOwner();
        parkingLotRepository=new ParkingLotRepository(parkingSlots);
    }

    public ParkingLot(int sizeOfParkingLot,Integer...slotCapacities) throws ParkingLotException {
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
        if(parkingLotRepository.checkVehiclePresent(vehicle))
            throw new ParkingLotException("Vehicle Already Pressent"
                    ,ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN);
        if(this.isFull())
            throw new ParkingLotException("Parking Full",ParkingLotException.ExceptionType.PARKING_IS_FULL);
        ParkingLot vehicleToBeParkedInThisLot=parkingLotRepository.selectLot(vehicle);
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
                vehiclesParkedLot.slots[vehicles.getSlotNumber()-1]= vehiclesParkedLot.slots[vehicles.getSlotNumber()-1]
                        -(1*vehicles.getVehicleSize());
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

    public ParkingLot getTotalVehiclesParked() {
        totalVehiclesPresent= parkingLotRepository.getVehicleDetails();
        return this;
    }

    public ParkingLot selectByColor(String matches){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(color->color.getColor()
                .equals(matches.toUpperCase())).collect(Collectors.toList());
        return this;
    }

    public ParkingLot selectByName(String vehicleName){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(name->name.getVehicleName()
                .equals(vehicleName.toUpperCase())).collect(Collectors.toList());
        return this;
    }

    public ParkingLot selectByDuration(int withIn){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(time->time
                .getDuration()<=withIn).collect(Collectors.toList());
        return this;
    }

    public ParkingLot selectBySlotNumber(int slotNumber){
        totalVehiclesPresent=totalVehiclesPresent.stream().filter(slotNum->slotNum
                .getSlotNumber()==slotNumber).collect(Collectors.toList());
        return this;
    }

    public ParkingLot selectByDriverType(Driver driverType){
        totalVehiclesPresent=totalVehiclesPresent.stream().
                filter(type->type.getDriver().equals(driverType)).collect(Collectors.toList());
        return this;
    }

    public ParkingLot selectBySize(int size){
        totalVehiclesPresent=totalVehiclesPresent.stream().
                filter(siz->siz.getVehicleSize()==size).collect(Collectors.toList());
        return this;
    }

}
