package com.park;

public class ParkingSpot {

    public ParkingSpot() { }

    public void assignSpotNumber(int[] slots, Vehicle vehicle, Integer[] slotCapacity){
        int i;

        if(vehicle.getVehicleSize().getSize()==3){
            if(slots[0]==0&&slotCapacity[0]>=vehicle.getVehicleSize().getSize()){
                vehicle.setSpotNumber(1);
                slots[0] +=vehicle.getVehicleSize().getSize();
            }else if(slots[slots.length-1]==0&&slotCapacity[slotCapacity.length-1]>=vehicle.getVehicleSize().getSize()){
                vehicle.setSpotNumber(slots.length);
                slots[slots.length-1] +=vehicle.getVehicleSize().getSize();
            }

            for( i=0;i<slots.length-1;i++){
                if(slots[i]==0&&slotCapacity[i]>=vehicle.getVehicleSize().getSize()&&slots[i-1]==0&&
                        slots[i+1]==0){
                    vehicle.setSpotNumber(i+1);
                    slots[i] +=vehicle.getVehicleSize().getSize();
                    break;
                }
            }
        } else  if(vehicle.getDriver().equals(Driver.NORMAL)){
                    for( i=slots.length-1;i>=0;i--){
                        if(slots[i]!=slotCapacity[i]&&(slotCapacity[i]>=(slots[i]+vehicle.getVehicleSize().getSize()))){
                            vehicle.setSpotNumber(i+1);
                            slots[i] +=vehicle.getVehicleSize().getSize();
                            break;
                        }
                    }
                }else if(vehicle.getDriver().equals(Driver.HANDICAPPED)){
                    for( i=0;i<=slots.length-1;i++){
                        if(slots[i]!=slotCapacity[i]&&(slotCapacity[i]>=(slots[i]+vehicle.getVehicleSize().getSize()))){
                            vehicle.setSpotNumber(i+1);
                        slots[i] +=vehicle.getVehicleSize().getSize();
                    break;
                }
            }
        }
    }

}
