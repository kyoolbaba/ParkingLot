package com.park;

public class ParkingSpot {
    private boolean displayFullSign;
    ParkingLotService parkingLotService;

    public ParkingSpot(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public ParkingSpot() {
    }

    public ParkingSpot(boolean displayFullSign) {
        this.displayFullSign = displayFullSign;
    }

    public void assignLotNumber(int[] slots, Vehicle vehicle, Integer[] slotCapacity){
        int i;
        if(vehicle.getDriver().equals(Driver.NORMAL)){
        for( i=slots.length-1;i>=0;i--){
            if(slots[i]!=slotCapacity[i]&&(slotCapacity[i]>=(slots[i]+vehicle.getVehicleSize().getSize()))){
                vehicle.setSlotNumber(i+1);
                slots[i] +=1;
                break;
            }
        }
        }else if(vehicle.getDriver().equals(Driver.HANDICAPPED)){
            for( i=0;i<=slots.length-1;i++){
                if(slots[i]!=1*slotCapacity[i]&&(slotCapacity[i]<=(slots[i]+vehicle.getVehicleSize().getSize()))){
                    vehicle.setSlotNumber(i+1);
                    slots[i] +=1;
                    break;
                }
            }
        }
    }


    public ParkingSlot getDetails(){
        return parkingLotService.parkingSlot.getTotalVehiclesParked();
    }


}
