package com.park;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ParkingLotRepository {

    private List<ParkingLot> listOfLots;
    private int lotNumber;

    public int getLotNumber() {
        return lotNumber;
    }

    public ParkingLotRepository(List<ParkingLot> listOfLots) {
        this.listOfLots = listOfLots;
    }

    public boolean checkVehiclePresent(Vehicle vehicle){
       return listOfLots.stream().anyMatch(vehiclesMatch->vehiclesMatch.listOfParkingLots.contains(vehicle));
    }

    public boolean checkParkingFullOrNot(){
        return listOfLots.stream().allMatch(listOfVehiclesInLot->listOfVehiclesInLot.
                listOfParkingLots.size()==listOfVehiclesInLot.sizeOfParkingLot);
    }

    public ParkingLot selectLot(Vehicle vehicle) throws ParkingLotException {
         lotNumber=0;
         int sizeCheck=1;
        int size=(int)Double.POSITIVE_INFINITY;
        for(int i=listOfLots.size()-1;i>=0;i--){
            ParkingLot park=listOfLots.get(i);
            List<Integer> list= Arrays.asList(park.slotCapacity);
            Integer maxSizeSlot = list.stream().mapToInt(maximum->maximum).max().orElse(Integer.MAX_VALUE);
            if(park.listOfParkingLots.size()<=size&&(!(park.listOfParkingLots.size()>=park.sizeOfParkingLot))
                    &&(vehicle.getVehicleSize()<=maxSizeSlot)){
                size=park.listOfParkingLots.size();
                lotNumber=i;
            }
            sizeCheck++;
        }
        if(sizeCheck==listOfLots.size())
            throw new ParkingLotException("Parking slot vehicle is not suitable with any Lot"
                    ,ParkingLotException.ExceptionType.PARKING_SIZE_NOT_AVAILABLE);
    return listOfLots.get(lotNumber);
    }

    public ParkingLot getLotOfVehicle(Vehicle vehicle){
        ParkingLot parkingLot=null;
        for(ParkingLot park:listOfLots){
            if(park.listOfParkingLots.contains(vehicle)){
                parkingLot = park;
                break;
            }
        }
        return parkingLot;
    }

}
