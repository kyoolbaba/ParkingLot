package com.park;


import java.util.*;
import java.util.stream.Collectors;

public class ParkingLot {

    private List<ParkingSlot> listOfLots;
    private int lotNumber;

    public int getLotNumber() {
        return lotNumber;
    }

    public ParkingLot(List<ParkingSlot> listOfLots) {
        this.listOfLots = listOfLots;
    }

    public boolean checkVehiclePresent(Vehicle vehicle){
       return listOfLots.stream().anyMatch(vehiclesMatch->vehiclesMatch.listOfParkingLots.contains(vehicle));
    }

    public boolean checkParkingFullOrNot(){
        return listOfLots.stream().allMatch(listOfVehiclesInLot->listOfVehiclesInLot.
                listOfParkingLots.size()==listOfVehiclesInLot.sizeOfParkingLot);
    }

    public ParkingSlot selectLot(Vehicle vehicle) throws ParkingLotException {
         lotNumber=0;
         int sizeCheck=0;
        int size=(int)Double.POSITIVE_INFINITY;
        for(int i=listOfLots.size()-1;i>=0;i--){
            ParkingSlot park=listOfLots.get(i);
            List<Integer> list= Arrays.asList(park.slotCapacity);
            Integer maxSizeSlot = list.stream().mapToInt(maximum->maximum).max().orElse(Integer.MAX_VALUE);
            if(park.listOfParkingLots.size()<=size&&(!(park.listOfParkingLots.size()>=park.sizeOfParkingLot))
                    &&(vehicle.getVehicleSize()<=maxSizeSlot)){
                size=park.listOfParkingLots.size();
                lotNumber=i;
                sizeCheck--;
            }
            sizeCheck++;
        }
        if(sizeCheck==listOfLots.size())
            throw new ParkingLotException("Parking slot vehicle is not suitable with any Lot"
                    ,ParkingLotException.ExceptionType.PARKING_SIZE_NOT_AVAILABLE);
    return listOfLots.get(lotNumber);
    }

    public ParkingSlot getLotOfVehicle(Vehicle vehicle){
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
