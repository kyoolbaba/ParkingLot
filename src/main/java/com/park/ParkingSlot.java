package com.park;


import java.util.*;
import java.util.stream.Collectors;

public class ParkingSlot {

    private List<ParkingLot> slotList;
    private int slotNumber;
    ParkingLot parkingLot;
    int totalSpotsPresent;
    ArrayList<Vehicle> vehilesRemoved = new ArrayList<>();

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

    public void shuffle(Vehicle vehicle) {
        List<ParkingLot> restoreCheckPoint=slotList;
        for(int j=slotList.size()-1;j>=0;j--){
            ParkingLot park=slotList.get(j);
            for(int i=park.slotCapacity[park.slots.length-1];i>=0;i++){
                if(park.slotCapacity[i]>=vehicle.getVehicleSize().getSize()&&park.getDetails().selectBySlotNumber(i+1)
                        .selectBySpotNumber(j+1).totalVehiclesPresent.get(0).getVehicleSize().getSize()!=vehicle.getVehicleSize().getSize()){
                    for(Vehicle vehiclesToRemove:park.getDetails().selectBySlotNumber(i+1)
                            .selectBySpotNumber(j+1).totalVehiclesPresent){
                        vehilesRemoved.add(vehiclesToRemove);
                        vehiclesToRemove.setSpotNumber(0);
                        vehiclesToRemove.setSlotNumber(0);
                        park.listOfVehiclesInSlot.remove(vehiclesToRemove);
                    }
                    park.slotCapacity[i]=vehicle.getVehicleSize().getSize();
                    vehicle.setSlotNumber(i+1);
                    vehicle.setSpotNumber(j+1);
                    break;
                }

            }
            boolean replace= vehilesRemoved.stream().allMatch(v->v.getVehicleSize().getSize()==1);
            int maxSize=vehilesRemoved.stream().mapToInt(v->v.getVehicleSize().getSize()).max().getAsInt();

            if(!replace){

            }

        }

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
