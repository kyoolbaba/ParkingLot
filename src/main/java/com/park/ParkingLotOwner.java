package com.park;

public class ParkingLotOwner {
    private boolean displayFullSign;

    public ParkingLotOwner(boolean displayFullSign) {
        this.displayFullSign = displayFullSign;
    }

    public ParkingLotOwner() {
    }

    public void assignLotNumber(int[] lots, Vehicle vehicle){
        for(int i=lots.length-1;i>=0;i--){
            if(lots[i]==0){
                vehicle.setLotNumber(i+1);
                lots[i] =1;
                break;
            }
        }
    }



}
