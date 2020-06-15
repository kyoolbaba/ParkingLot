package com.park;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingLot {
     int sizeOfParkingLot;
    ParkingLotOwner parkingLotOwner;
     Integer[] slotCapacity;
     int slotNumber;
    List<Vehicle> listOfParkingLots ;
    List<ParkingSlot> listOfSlots;
    List<Vehicle> totalVehiclesPresent;
    ParkingSlot[] parkingSlotList;
    ParkingSlot parkingSlot;
    ParkingLotRepository parkingLotRepository;


    public ParkingLot(int sizeOfParkingLot, Integer...lotCapacities) throws ParkingLotException {
        parkingLotOwner=new ParkingLotOwner();
        listOfParkingLots= new ArrayList();
        parkingSlot=new ParkingSlot();
        parkingSlotList =new ParkingSlot[sizeOfParkingLot];
        this.sizeOfParkingLot = Arrays.stream(lotCapacities).mapToInt(i->i).sum();
        slotCapacity =lotCapacities;
        if(sizeOfParkingLot!=lotCapacities.length)
            throw new ParkingLotException("Invalid ParkingLot Input"
                    ,ParkingLotException.ExceptionType.INVALID_PARKINGLOT_INPUT);
    }

   public int parkVehicle(Vehicle vehicle) throws ParkingLotException {
       if(vehicle==null||vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
            throw new ParkingLotException("No Value Entered",
                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
       if(Arrays.asList(parkingSlotList).stream().anyMatch(slot->slot.listOfVehiclesInSlot.contains(vehicle)))
           throw new ParkingLotException("Vehicle Already Pressent"
                   ,ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN);
       if( Arrays.stream(parkingSlotList).mapToInt(space -> space.slotAvailable).sum()-vehicle.getVehicleSize()>=0)
           throw new ParkingLotException("Parking Full",ParkingLotException.ExceptionType.PARKING_IS_FULL);
       int size=(int)Double.POSITIVE_INFINITY;
       int index=0;
       for(int i=sizeOfParkingLot-1;i>=0;i--){
            ParkingSlot parkingSlot=parkingSlotList[i];
            if(size<=parkingSlot.slotFilled &&slotCapacity[i]<=slotCapacity[i]+vehicle.getVehicleSize()){
                index=i;
            }
       }
       totalVehiclesPresent.add(vehicle);
       parkingSlot.parkTheVehicle( parkingSlotList[index],vehicle.getVehicleSize(),vehicle);
       return index;
   }

   public void unparkVehicle(Vehicle vehicle){
     //  List<List<Vehicle>> matchingParkingSlot=Arrays.asList(listOfParkingLots).stream().filter()
   }


//    public void parkTheVehicle(Vehicle vehicle) throws ParkingLotException {
//        if(vehicle==null||vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
//            throw new ParkingLotException("No Value Entered",
//                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
//        if(parkingLotRepository.checkVehiclePresent(vehicle))
//            throw new ParkingLotException("Vehicle Already Pressent"
//                    ,ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN);
//        if(this.isFull())
//            throw new ParkingLotException("Parking Full",ParkingLotException.ExceptionType.PARKING_IS_FULL);
//        ParkingLot vehicleToBeParkedInThisLot=parkingLotRepository.selectLot(vehicle);
//        parkingLotOwner.assignLotNumber(vehicleToBeParkedInThisLot.slots,vehicle,vehicleToBeParkedInThisLot.slotCapacity);
//        vehicle.setLotNumber(parkingLotRepository.getLotNumber()+1);
//        vehicleToBeParkedInThisLot.listOfParkingLots.add(vehicle);
//        if(this.isFull()) {
//            this.sendStatusToParkingOwner();
//            this.redirectStaff();
//        }
//    }

//    public Vehicle unparkTheVehicle(Vehicle vehicle) throws ParkingLotException {
//        if(vehicle==null|| vehicle.getVehicleNumber()==""||vehicle.getVehicleNumber()==null)
//            throw new ParkingLotException("No Value Entered",
//                    ParkingLotException.ExceptionType.INCOMPLETE_DETAILS);
//        if(!(parkingLotRepository.checkVehiclePresent(vehicle)))
//            throw new ParkingLotException("Vehicle Not Present"
//                    ,ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
//        if(this.isFull()) {
//            this.sendStatusToParkingOwner();
//            this.redirectStaff();
//        }
//        ParkingLot vehiclesParkedLot=parkingLotRepository.getLotOfVehicle(vehicle);
//        int lotNumber=0;
//        Vehicle vehicleTobeUnparked=null;
//        for(Vehicle vehicles:vehiclesParkedLot.listOfParkingLots){
//            if(vehicles.equals(vehicle)){
//                vehiclesParkedLot.slots[vehicles.getSlotNumber()-1]= vehiclesParkedLot.slots[vehicles.getSlotNumber()-1]
//                        -(1*vehicles.getVehicleSize());
//                vehicleTobeUnparked=vehicles;
//                vehiclesParkedLot.listOfParkingLots.remove(vehicles);
//                break;
//            }
//        }
//        return vehicleTobeUnparked;
//    }

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
