package com.park;

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

    public ParkingLot selectLot(){
         lotNumber=0;
        int size=(int)Double.POSITIVE_INFINITY;
        for(int i=listOfLots.size()-1;i>=0;i--){
            ParkingLot park=listOfLots.get(i);
            if(park.listOfParkingLots.size()<=size&&(!(park.listOfParkingLots.size()>=park.sizeOfParkingLot))){
                size=park.listOfParkingLots.size();
                lotNumber=i;
            }
        }
    return listOfLots.get(lotNumber);
    }

}
