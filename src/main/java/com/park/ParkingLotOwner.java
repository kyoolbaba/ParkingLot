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

    public void assignLotNumber(int[] lots, Vehicle vehicle,int[] slotCapacity){
        int i;
        if(vehicle.getDriver().equals(Driver.NORMAL)){
        for( i=lots.length-1;i>=0;i--){
            if(lots[i]!=1*slotCapacity[i]){
                vehicle.setSlotNumber(i+1);
                parkingAtttendent.lotNumber(vehicle.getSlotNumber());
                lots[i] +=1;
                break;
            }
        }
        }else if(vehicle.getDriver().equals(Driver.HANDICAPPED)){
            for( i=0;i>=lots.length-1;i++){
                if(lots[i]!=1*slotCapacity[i]){
                    vehicle.setSlotNumber(i+1);
                    parkingAtttendent.lotNumber(vehicle.getSlotNumber());
                    lots[i] +=1;
                    break;
                }
            }
        }

    }



}
