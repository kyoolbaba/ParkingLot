package com.park;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceTest {

    //TestCases for parking slot with multiple spot
    @Test
    public void givenTwoVehicle_whenRemovedFirstVehicleAndAddingAnotherVehicle_shouldReturnSlotNumber() {
        try {
            ParkingLot lot1=new ParkingLot(2,1,2);
            ParkingLot lot2=new ParkingLot(3,1,3);
            ParkingLot lot3=new ParkingLot(4,2,1,1,2);
            ArrayList parkingLots=new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.entry(new Vehicle("KA04HB124"));
            parkingLotService.entry(new Vehicle("KA04HB1024"));
            Vehicle vehicle=parkingLotService.exit(new Vehicle("KA04HB1024"));
            Assert.assertEquals(3,vehicle.getSlotNumber());
        }catch(ParkingLotException e){
        }
    }
    //TestCases for parking slot with multiple spot
    @Test
    public void givenThreeVehicle_whenRemovedFirstVehicleAndAddingAnotherVehicle_shouldReturnSLotNumber() {
        try {
            ParkingLot lot1=new ParkingLot(2,1,2);
            ParkingLot lot2=new ParkingLot(3,1,3,1);
            ParkingLot lot3=new ParkingLot(4,2,1,1,2);
            ArrayList parkingLots=new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.entry(new Vehicle("KA04HB124"));
            parkingLotService.entry(new Vehicle("KA04HB1024"));
            parkingLotService.entry(new Vehicle("KA04HB104"));
            parkingLotService.entry(new Vehicle("KA04HB1094"));
            parkingLotService.entry(new Vehicle("KA04HB1004"));
            Vehicle vehicle=parkingLotService.exit(new Vehicle("KA04HB1004"));
            Assert.assertEquals(2,vehicle.getSlotNumber());
            Assert.assertEquals(2,vehicle.getLotNumber());
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenTwoVehicle_whenRemovedFirstVehicleAndAddingAnotherVehicle_shouldReturnLotNumberTest1() {
        try {
            ParkingLot lot1=new ParkingLot(2);
            ParkingLot lot2=new ParkingLot(3);
            ParkingLot lot3=new ParkingLot(4);
            ArrayList parkingLots=new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.entry(new Vehicle("KA04HB124"));
            parkingLotService.entry(new Vehicle("KA04HB1024"));
            Vehicle vehicle=parkingLotService.exit(new Vehicle("KA04HB1024"));
            Assert.assertEquals(2,vehicle.getLotNumber());
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenTwoVehicle_whenRemovedFirstVehicleAndAddingAnotherVehicle_shouldReturnLotNumberTest3() {
        try {
            ParkingLot lot1=new ParkingLot(2);
            ParkingLot lot2=new ParkingLot(3);
            ParkingLot lot3=new ParkingLot(4);
            ArrayList parkingLots=new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.entry(new Vehicle("KA04HB124"));
            parkingLotService.entry(new Vehicle("KA04HB1024"));
            parkingLotService.entry(new Vehicle("KA04HP1024"));
            parkingLotService.entry(new Vehicle("KA04HO1024"));
            Vehicle vehicle=parkingLotService.exit(new Vehicle("KA04HO1024"));
            Assert.assertEquals(1,vehicle.getLotNumber());
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenTwoVehicle_whenParked_shouldReturnTrue() {
        try {
            ParkingLot lot1=new ParkingLot(2,1,2);
            ParkingLot lot2=new ParkingLot(3,1,3,1);
            ParkingLot lot3=new ParkingLot(4,2,1,1,2);
            ArrayList parkingLots=new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.entry(new Vehicle(""));
            parkingLotService.entry(new Vehicle("KA04HB1024"));
            //Vehicle vehicle=parkingLotService.exit(new Vehicle("KA04HB1024"));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenPersonVehicleAsNull_whenParked_shouldReturnTrue() {
        try {
            ParkingLot lot1 = new ParkingLot(1,1);
            ParkingLot lot2 = new ParkingLot(2,1,2);
            ParkingLot lot3 = new ParkingLot(1,1);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.entry(new Vehicle("KA04HB124"));
            parkingLotService.entry(new Vehicle("KA04HB1024"));
            parkingLotService.entry(new Vehicle("KA04HP1024"));
            parkingLotService.entry(new Vehicle("KA04HO1024"));
            parkingLotService.entry(new Vehicle("KA04HO0024"));
            }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_IS_FULL,e.type);
        }
    }

    @Test
    public void givenSameVehicleTwice_whenParked_shouldReturnTrue() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,3);
            ParkingLot lot2 = new ParkingLot(1,1);
            ParkingLot lot3 = new ParkingLot(1,1);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.entry(new Vehicle("KA04HB124"));
            parkingLotService.entry(new Vehicle("KA04HP1024"));
            parkingLotService.entry(new Vehicle("KA04HP1024"));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN,e.type);
        }
    }



    @Test
    public void givenVehicleNotPresent_whenUnParked_shouldThrowException() {
        try {
            ParkingLot lot1 = new ParkingLot(2,2,3);
            ParkingLot lot2 = new ParkingLot(1,4);
            ParkingLot lot3 = new ParkingLot(1,2);;
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.entry(new Vehicle("KA04HB124"));
            parkingLotService.entry(new Vehicle("KA04HP1024"));
            parkingLotService.exit(new Vehicle("KA04HK1024"));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT,e.type);
        }
    }


}
