package com.park;


import java.util.*;
import java.util.stream.Collectors;

public class ParkingLot {

    private List<ParkingSlot> listOfLots;
    private int slotNumber;

    public int getSlotNumber() {
        return slotNumber;
    }

    public ParkingLot(List<ParkingSlot> listOfLots) {
        this.listOfLots = listOfLots;
    }

    public ParkingLot() {
    }

    public boolean checkVehiclePresent(Vehicle vehicle){
       return listOfLots.stream().anyMatch(vehiclesMatch->vehiclesMatch.listOfParkingLots.contains(vehicle));
    }

    public boolean checkParkingFullOrNot(){
        return listOfLots.stream().allMatch(listOfVehiclesInLot->listOfVehiclesInLot.
                listOfParkingLots.size()==listOfVehiclesInLot.sizeOfParkingLot);
    }

    public ParkingSlot assignLot(Vehicle vehicle) throws ParkingLotException {
         slotNumber =0;
         int sizeCheck=0;
         boolean maneuver=false;
        int size=(int)Double.POSITIVE_INFINITY;
        for(int i=listOfLots.size()-1;i>=0;i--){
            ParkingSlot park=listOfLots.get(i);
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
            if(park.listOfParkingLots.size()<=size&&(!(park.listOfParkingLots.size()>=park.sizeOfParkingLot))
                    &&(vehicle.getVehicleSize().getSize()<=maxSizeSlot)){
                size=park.listOfParkingLots.size();
                slotNumber =i;
                sizeCheck--;
            }
            sizeCheck++;
        }
        if(sizeCheck==listOfLots.size())
            throw new ParkingLotException("Parking slot vehicle is not suitable with any Lot"
                    ,ParkingLotException.ExceptionType.PARKING_SIZE_NOT_AVAILABLE);
    return listOfLots.get(slotNumber);
    }

    public ParkingSlot getLotOfTheVehiclePresent(Vehicle vehicle){
        ParkingSlot parkingSlot =null;
        for(ParkingSlot park:listOfLots){
            if(park.listOfParkingLots.contains(vehicle)){
                parkingSlot = park;
                break;
            }
        }
        return parkingSlot;
    }

    public List getVehicleDetails(){
        List<Vehicle> listOfVehicles=new ArrayList<>();
        for(ParkingSlot park:listOfLots){
            listOfVehicles.addAll( park.listOfParkingLots.stream().
                    filter(vehicle->vehicle.getVehicleNumber()!=(null))
                   .collect(Collectors.toList()));
        }
        return listOfVehicles;
    }

}
