package com.park;


import java.util.*;
import java.util.stream.Collectors;

public class ParkingSlot {

    private List<ParkingLot> slotList;
    private int slotNumber;
    ParkingLot parkingLot;
    int totalSpotsPresent;

    public int getSlotNumber() {
        return slotNumber;
    }

    public ParkingSlot(List<ParkingLot> slotList) {
        this.slotList = slotList;
        this.totalSpotsPresent= slotList.stream().mapToInt(spots->spots.sizeOfParkingLot).sum();
    }

    public ParkingSlot() {
    }

    public boolean checkVehiclePresent(Vehicle vehicle){
       return slotList.stream().anyMatch(vehiclesMatch->vehiclesMatch.listOfVehiclesInSlot.contains(vehicle));
    }

    public boolean checkParkingFullOrNot(){
        return this.getVehicleDetails().stream().mapToInt
                (sizeOfVehicles->sizeOfVehicles.getVehicleSize().getSize()).sum()==totalSpotsPresent;
    }

    public ParkingLot assignSlot(Vehicle vehicle) throws ParkingLotException {
         slotNumber =0;
         int sizeCheck=0;
         boolean maneuver=false;
        int size=(int)Double.POSITIVE_INFINITY;
        for(int i = slotList.size()-1; i>=0; i--){
            ParkingLot park= slotList.get(i);
            List<Integer> listOfSlotCapacity= Arrays.asList(park.slotCapacity);
            for(int j=1;j<=park.slots.length-2;j++){
                if(park.slots[j]==0&&park.slots[j-1]==0&&park.slots[j+1]==0&&park.slotCapacity[j]>=vehicle.
                        getVehicleSize().getSize()&&vehicle.getVehicleSize().equals(VehicleSize.LARGE)){
                    maneuver=true;
                    slotNumber =i;}
            }
            if(park.slots[park.slots.length-1]==0&&park.slotCapacity[park.slots.length-1]>=vehicle.getVehicleSize()
                    .getSize()&&vehicle.getVehicleSize().equals(VehicleSize.LARGE)) {
                maneuver=true;
                slotNumber =i;
            }
            if(park.slots[0]==0&&park.slotCapacity[0]>=vehicle.getVehicleSize().getSize()&&vehicle.getVehicleSize()
                    .equals(VehicleSize.LARGE)) {
                maneuver=true;
                slotNumber =i;
            }
            if(maneuver) break;
            Integer maxSizeSlot = listOfSlotCapacity.stream().mapToInt(maximum->maximum).max().orElse(Integer.MAX_VALUE);
            if(park.listOfVehiclesInSlot.size()<=size&&(!(park.listOfVehiclesInSlot.size()>=park.sizeOfParkingLot))
                    &&(vehicle.getVehicleSize().getSize()<=maxSizeSlot)){
                size=park.listOfVehiclesInSlot.size();
                slotNumber =i;
                sizeCheck--;
            }
            sizeCheck++;
        }
        if(sizeCheck== slotList.size()&&vehicle.getVehicleSize().getSize()!=1) {
          if(this.getVehicleDetails().stream().mapToInt
                  (sizeOfVehicles->sizeOfVehicles.getVehicleSize().getSize()).sum()<=totalSpotsPresent){
              this.shuffle(vehicle);
          }
        }
    return slotList.get(slotNumber);
    }

    public List shuffle(Vehicle vehicle) {
//        int max=slotDetailsList.stream().mapToInt(slot->slot.sizeOfParkingLot-slot.listOfVehiclesInSlot.stream().
//                mapToInt(s->s.getVehicleSize().getSize()).sum()).max().getAsInt();
//        for(ParkingLot park: slotDetailsList){
//            for(int i=0;i<=park.slots.length-1;i++){
//                if(vehicle.getVehicleSize().getSize()==3){
//                   // park.slots[i]
//                }
//            }
//        }
        ArrayList listOfUnFilledSlots=new ArrayList();
        ArrayList listOfFilledSlots=new ArrayList();
        for(int i = 0; i< slotList.size(); i++){
            ParkingLot slot= slotList.get(i);
            if(slot.sizeOfParkingLot-slot.listOfVehiclesInSlot.stream().mapToInt(v->v.getVehicleSize().getSize()).sum()>0){
                listOfUnFilledSlots.add(i+1);
                continue;
            }
             listOfFilledSlots.add(i+1);
        }
        return listOfUnFilledSlots;
    }

    public ParkingLot getSlotOfTheVehiclePresent(Vehicle vehicle){
        ParkingLot parkingLot =null;
        for(ParkingLot park: slotList){
            if(park.listOfVehiclesInSlot.contains(vehicle)){
                parkingLot = park;
                break;
            }
        }
        return parkingLot;
    }

    public List<Vehicle> getVehicleDetails(){
        List<Vehicle> listOfVehicles=new ArrayList<>();
        for(ParkingLot park: slotList){
            listOfVehicles.addAll( park.listOfVehiclesInSlot.stream().
                    filter(vehicle->vehicle.getVehicleNumber()!=(null))
                   .collect(Collectors.toList()));
        }
        return listOfVehicles;
    }

}
