package com.park;

public class ParkingLotOwner {
    private boolean displayFullSign;
    ParkingAtttendent parkingAtttendent;
    private int PARKING_CHARGES_PER_DAY=10;

    public ParkingLotOwner(boolean displayFullSign) {
        this.displayFullSign = displayFullSign;
    }

    public ParkingLotOwner() {
        parkingAtttendent=new ParkingAtttendent();
    }

    public void assignLotNumber(int[] lots, Vehicle vehicle,int lotNumber){
        int i;
        for( i=lots.length-1;i>=0;i--){
            if(lots[i]==0){
                vehicle.setSlotNumber(Integer.toString(lotNumber)+1);
                vehicle.setCharges(vehicle.getNoOfDays()*PARKING_CHARGES_PER_DAY);
                parkingAtttendent.lotNumber(vehicle.getSlotNumber());
                lots[i] =1;

                break;

            }
        }

    }



}
