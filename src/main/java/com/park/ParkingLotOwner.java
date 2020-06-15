package com.park;

public class ParkingLotOwner {
    private boolean displayFullSign;
    private int PARKING_CHARGES_PER_DAY=10;
    ParkingLotSystem parkingLotSystem;

    public ParkingLotOwner(ParkingLotSystem parkingLotSystem) {
        this.parkingLotSystem = parkingLotSystem;
    }

    public ParkingLotOwner() {
    }

    public ParkingLotOwner(boolean displayFullSign) {
        this.displayFullSign = displayFullSign;
    }

    public void assignLotNumber(int[] lots, Vehicle vehicle, Integer[] slotCapacity){
        int i;
        if(vehicle.getDriver().equals(Driver.NORMAL)){
        for( i=lots.length-1;i>=0;i--){
            if(lots[i]!=slotCapacity[i]&&(slotCapacity[i]>=(lots[i]+vehicle.getVehicleSize()))){
                vehicle.setSlotNumber(i+1);
                lots[i] +=1;
                break;
            }
        }
        }else if(vehicle.getDriver().equals(Driver.HANDICAPPED)){
            for( i=0;i<=lots.length-1;i++){
                if(lots[i]!=1*slotCapacity[i]&&(slotCapacity[i]<=(lots[i]+vehicle.getVehicleSize()))){
                    vehicle.setSlotNumber(i+1);
                    lots[i] +=1;
                    break;
                }
            }
        }
    }


    public ParkingLot getDetails(){
        return parkingLotSystem.parkingLot.getTotalVehiclesParked();
    }


}
