package com.park;


import java.util.*;
import java.util.stream.Collectors;

public class ParkingSlot {

    private List<ParkingLot> slotDetailsList;
    private int slotNumber;
    ParkingLot parkingLot;

    public int getSlotNumber() {
        return slotNumber;
    }

    public ParkingSlot(List<ParkingLot> slotDetailsList) {
        this.slotDetailsList = slotDetailsList;
    }

    public ParkingSlot() {
    }

    public boolean checkVehiclePresent(Vehicle vehicle){
       return slotDetailsList.stream().anyMatch(vehiclesMatch->vehiclesMatch.listOfVehiclesInSlot.contains(vehicle));
    }

    public boolean checkParkingFullOrNot(){
        return slotDetailsList.stream().allMatch(listOfVehiclesInLot->listOfVehiclesInLot.
                listOfVehiclesInSlot.size()==listOfVehiclesInLot.sizeOfParkingLot);
    }

    public ParkingLot assignSlot(Vehicle vehicle) throws ParkingLotException {
         slotNumber =0;
         int sizeCheck=0;
         boolean maneuver=false;
        int size=(int)Double.POSITIVE_INFINITY;
        for(int i = slotDetailsList.size()-1; i>=0; i--){
            ParkingLot park= slotDetailsList.get(i);
            List<Integer> listOfSlotCapacity= Arrays.asList(park.slotCapacity);
            if(park.slots[park.slots.length-1]==0&&park.slotCapacity[park.slots.length-1]>=vehicle.getVehicleSize()
                    .getSize()&&vehicle.getVehicleSize().equals(VehicleSize.LARGE)) {
                maneuver=true;
                slotNumber =i;
            }
            if(park.slots[0]==0&&park.slotCapacity[0]>=vehicle.getVehicleSize().getSize()&&vehicle.getVehicleSize()
                    .equals(VehicleSize.LARGE)) {
                maneuver=true;
                slotNumber =i;
            }
            for(int j=1;j<=park.slots.length-2;j++){
                if(park.slots[j]==0&&park.slots[j-1]==0&&park.slots[j+1]==0&&park.slotCapacity[j]>=vehicle.
                        getVehicleSize().getSize()&&vehicle.getVehicleSize().equals(VehicleSize.LARGE)){
                    maneuver=true;
                    slotNumber =i;}
            }
            if(maneuver) break;
            Integer maxSizeSlot = listOfSlotCapacity.stream().mapToInt(maximum->maximum).max().orElse(Integer.MAX_VALUE);
            if(park.listOfVehiclesInSlot.size()<=size&&(!(park.listOfVehiclesInSlot.size()>=park.sizeOfParkingLot))
                    &&(vehicle.getVehicleSize().getSize()<=maxSizeSlot)){
                size=park.listOfVehiclesInSlot.size();
                slotNumber =i;
                sizeCheck--;
            }
            sizeCheck++;
        }
        if(sizeCheck== slotDetailsList.size())
            throw new ParkingLotException("Parking slot vehicle is not suitable with any Lot"
                    ,ParkingLotException.ExceptionType.PARKING_SIZE_NOT_AVAILABLE);
    return slotDetailsList.get(slotNumber);
    }

    public ParkingLot getSlotOfTheVehiclePresent(Vehicle vehicle){
        ParkingLot parkingLot =null;
        for(ParkingLot park: slotDetailsList){
            if(park.listOfVehiclesInSlot.contains(vehicle)){
                parkingLot = park;
                break;
            }
        }
        return parkingLot;
    }

    public List getVehicleDetails(){
        List<Vehicle> listOfVehicles=new ArrayList<>();
        for(ParkingLot park: slotDetailsList){
            listOfVehicles.addAll( park.listOfVehiclesInSlot.stream().
                    filter(vehicle->vehicle.getVehicleNumber()!=(null))
                   .collect(Collectors.toList()));
        }
        return listOfVehicles;
    }

}
