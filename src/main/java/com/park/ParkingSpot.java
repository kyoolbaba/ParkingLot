package com.park;

public class ParkingSpot {

    ParkingLotService parkingLotService;

    public ParkingSpot(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public ParkingSpot() { }

    public void assignLotNumber(int[] slots, Vehicle vehicle, Integer[] slotCapacity){
        int i;
        if(vehicle.getDriver().equals(Driver.NORMAL)){
            for( i=slots.length-1;i>=0;i--){
                if(slots[i]!=slotCapacity[i]&&(slotCapacity[i]>=(slots[i]+vehicle.getVehicleSize().getSize()))){
                    vehicle.setSlotNumber(i+1);
                    slots[i] +=vehicle.getVehicleSize().getSize();
                    break;
                }
            }
        }else if(vehicle.getDriver().equals(Driver.HANDICAPPED)){
            for( i=0;i<=slots.length-1;i++){
                if(slots[i]!=slotCapacity[i]&&(slotCapacity[i]>=(slots[i]+vehicle.getVehicleSize().getSize()))){
                    vehicle.setSlotNumber(i+1);
                    slots[i] +=vehicle.getVehicleSize().getSize();
                    break;
                }
            }
        }
    }

}
