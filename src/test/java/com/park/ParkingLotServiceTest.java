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
            ParkingLot lot2=new ParkingLot(2,1,3);
            ParkingLot lot3=new ParkingLot(4,2,1,1,2);
            ArrayList parkingLots=new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            Vehicle vehicle=parkingLotService.unParkTheVehicle(new Vehicle("KA04HB1024"));
            Assert.assertEquals(2,vehicle.getSlotNumber());
        }catch(ParkingLotException e){
        }
    }
    //TestCase for Handicapped player
    @Test
    public void givenTwoVehicle_whenAddingHandiCapped_shouldReturnSlotNumber() {
        try {
            ParkingLot lot1=new ParkingLot(2,2,2);
            ParkingLot lot2=new ParkingLot(2,1,3);
            ParkingLot lot3=new ParkingLot(4,2,1,1,2);
            ArrayList parkingLots=new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.HANDICAPPED,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            Vehicle vehicle=parkingLotService.unParkTheVehicle(new Vehicle("KA04HB1024"));
            Assert.assertEquals(2,vehicle.getSlotNumber());
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
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB104",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB1094",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB1004",Driver.NORMAL,1));
            Vehicle vehicle=parkingLotService.unParkTheVehicle(new Vehicle("KA04HB1004"));
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
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            Vehicle vehicle=parkingLotService.unParkTheVehicle(new Vehicle("KA04HB1024"));
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
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HO1024",Driver.NORMAL,1));
            Vehicle vehicle=parkingLotService.unParkTheVehicle(new Vehicle("KA04HO1024"));
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
            parkingLotService.parkTheVehicle(new Vehicle("",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
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
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HO1024",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HO0024",Driver.NORMAL,1));
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
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,1));
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
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,1));
            parkingLotService.unParkTheVehicle(new Vehicle("KA04HK1024",Driver.NORMAL,1));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT,e.type);
        }
    }

    @Test
    public void givenVehicleOfSize2_whenUnParked_shouldOccupySpotHavingTwoSlots() {
        try {
            ParkingLot lot1 = new ParkingLot(2,2,3);
            ParkingLot lot2 = new ParkingLot(2,2,1);
            ParkingLot lot3 = new ParkingLot(1,2);;
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,2));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            parkingLotService.unParkTheVehicle(new Vehicle("KA04HP1024"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            Vehicle vehicle=parkingLotService.unParkTheVehicle(new Vehicle("KA04HP1024"));
            Assert.assertEquals(2,vehicle.getLotNumber());
            Assert.assertEquals(1,vehicle.getSlotNumber());
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicleOfSize3_whenUnParked_shouldOccupySpotHavingThreeSlots() {
        try {
            ParkingLot lot1 = new ParkingLot(2,3,2);
            ParkingLot lot2 = new ParkingLot(2,2,1);
            ParkingLot lot3 = new ParkingLot(1,2);;
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,3));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            Vehicle vehicle=parkingLotService.unParkTheVehicle(new Vehicle("KA04HB124"));
            Assert.assertEquals(1,vehicle.getLotNumber());
            Assert.assertEquals(1,vehicle.getSlotNumber());
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicleOfSize5_whenUnParked_shouldOccupySpotHavingSlotswithSuitableLot() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,2);
            ParkingLot lot2 = new ParkingLot(2,2,4);
            ParkingLot lot3 = new ParkingLot(1,5);;
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,5));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            Vehicle vehicle=parkingLotService.unParkTheVehicle(new Vehicle("KA04HB124"));
            Assert.assertEquals(3,vehicle.getLotNumber());
            Assert.assertEquals(1,vehicle.getSlotNumber());
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicleOfSize3_whenUnParked_shouldOccupySpotHavingSlotswithSuitableLot() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,2);
            ParkingLot lot2 = new ParkingLot(2,2,3);
            ParkingLot lot3 = new ParkingLot(1,1,5);;
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,3));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            Vehicle vehicle=parkingLotService.unParkTheVehicle(new Vehicle("KA04HB124"));
            Assert.assertEquals(2,vehicle.getLotNumber());
            Assert.assertEquals(2,vehicle.getSlotNumber());
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicleOfSizeMoreThanSlotCapacity_whenUnParked_shouldThrowException() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,2);
            ParkingLot lot2 = new ParkingLot(2,2,3);
            ParkingLot lot3 = new ParkingLot(1,5);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,6));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            Vehicle vehicle=parkingLotService.unParkTheVehicle(new Vehicle("KA04HB124"));
            Assert.assertEquals(3,vehicle.getLotNumber());
            Assert.assertEquals(1,vehicle.getSlotNumber());
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_SIZE_NOT_AVAILABLE,e.type);
        }
    }


    @Test
    public void givenVehicleWithColor_whenQuried_shouldReturnListOfCarsMachtingColor() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,6);
            ParkingLot lot2 = new ParkingLot(2,2,6);
            ParkingLot lot3 = new ParkingLot(1,6);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,6).setColor("WHITE").setVehicleName("MARUTI"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,2).setColor("BLACK").setVehicleName("BMW"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,2).setColor("BLUE").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,2).setColor("blue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,2).setColor("BLue").setVehicleName("TOYOTA"));
            List<Vehicle> listOfVehiclesOfSameColor =new ParkingLotOwner(parkingLotService).getDetails().
                    selectByColor("blue").selectByName("toyota").totalVehiclesPresent;
            Assert.assertEquals("1_2",listOfVehiclesOfSameColor.get(0).getVehicleLocation());
            Assert.assertEquals("2_2",listOfVehiclesOfSameColor.get(1).getVehicleLocation());
            Assert.assertEquals("3_1",listOfVehiclesOfSameColor.get(2).getVehicleLocation());
            Assert.assertEquals("KA04HL1026",listOfVehiclesOfSameColor.get(0).getVehicleNumber());
            Assert.assertEquals("KA04HL1027",listOfVehiclesOfSameColor.get(1).getVehicleNumber());
            Assert.assertEquals("KA04HL1025",listOfVehiclesOfSameColor.get(2).getVehicleNumber());
            Assert.assertEquals(3,listOfVehiclesOfSameColor.size());
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }
    //UseCase12
    @Test
    public void givenVehicleWithColorAndName_whenQuried_shouldReturnListOfMachtingCars() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,6);
            ParkingLot lot2 = new ParkingLot(2,2,6);
            ParkingLot lot3 = new ParkingLot(1,6);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,6).setColor("WHITE").setVehicleName("MARUTI"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,2).setColor("WHITE").setVehicleName("BMW"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,2).setColor("BLUE").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,2).setColor("blue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,2).setColor("BLue").setVehicleName("TOYOTA"));
            ParkingLotOwner parkingLotOwner =new ParkingLotOwner(parkingLotService);
            List<Vehicle> listOfVehicles=parkingLotOwner.getDetails().selectByColor("white").totalVehiclesPresent;
            Assert.assertEquals(2,listOfVehicles.size());
            Assert.assertEquals("KA04HB124",listOfVehicles.get(0).getVehicleNumber());
            Assert.assertEquals("KA04HL1054",listOfVehicles.get(1).getVehicleNumber());
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    //UseCase14
    @Test
    public void givenVehicleWithName_whenQuried_shouldReturnListOfMachtingCars() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,5);
            ParkingLot lot2 = new ParkingLot(2,2,6);
            ParkingLot lot3 = new ParkingLot(1,6);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,6).setColor("WHITE").setVehicleName("MARUTI"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,2).setColor("BLACK").setVehicleName("BMW"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,2).setColor("BLUE").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,2).setColor("blue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,2).setColor("BLue").setVehicleName("TOYOTA"));
            List<Vehicle> listOfBMWVehicles =new ParkingLotOwner(parkingLotService).getDetails().
                    selectByName("bmw").totalVehiclesPresent;
            Assert.assertEquals("1_2",listOfBMWVehicles.get(0).getVehicleLocation());
            Assert.assertEquals("KA04HL1054",listOfBMWVehicles.get(0).getVehicleNumber());
            Assert.assertEquals(1,listOfBMWVehicles.size());
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    //UseCase15
    @Test
    public void givenVehicleWithName_whenQueried_shouldReturnCarParkedInLast30mins() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,5);
            ParkingLot lot2 = new ParkingLot(2,2,6);
            ParkingLot lot3 = new ParkingLot(1,6);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,6)
                    .setColor("WHITE").setVehicleName("MARUTI").setDuration(21));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,2).
                    setColor("BLACK").setVehicleName("BMW").setDuration(30));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,2)
                    .setColor("BLUE").setVehicleName("TOYOTA").setDuration(60));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,2)
                    .setColor("blue").setVehicleName("TOYOTA").setDuration(20));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,2)
                    .setColor("BLue").setVehicleName("TOYOTA").setDuration(50));
            List<Vehicle> listOfVehiclesParkedIn30Minutes =new ParkingLotOwner(parkingLotService).getDetails().
                    selectByDuration(30).totalVehiclesPresent;
            Assert.assertEquals("KA04HL1054",listOfVehiclesParkedIn30Minutes.get(0).getVehicleNumber());
            Assert.assertEquals("KA04HL1026",listOfVehiclesParkedIn30Minutes.get(1).getVehicleNumber());
            Assert.assertEquals("KA04HB124",listOfVehiclesParkedIn30Minutes.get(2).getVehicleNumber());
            Assert.assertEquals(3,listOfVehiclesParkedIn30Minutes.size());
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }


    //UseCase16
    @Test
    public void givenVehicleWithName_whenQueried_shouldReturnVehiclesOfSlot2() {
        try {
            ParkingLot lot1 = new ParkingLot(3,1,2,3);
            ParkingLot lot2 = new ParkingLot(3,1,6,2);
            ParkingLot lot3 = new ParkingLot(2,1,2);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.HANDICAPPED,2)
                    .setColor("WHITE").setVehicleName("MARUTI"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1054",Driver.HANDICAPPED,2).
                    setColor("BLACK").setVehicleName("BMW"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1025",Driver.HANDICAPPED,2)
                    .setColor("BLUE").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,2)
                    .setColor("blue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL107",Driver.NORMAL,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL127",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1037",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1327",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04KL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA03HL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA02HL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            List<Vehicle> listOfVehiclesPresent =new ParkingLotOwner(parkingLotService).getDetails().
                    selectBySize(2).selectBySlotNumber(2).selectByDriverType(Driver.HANDICAPPED).totalVehiclesPresent;

            Assert.assertEquals("KA04HL127",listOfVehiclesPresent.get(0).getVehicleNumber());
            Assert.assertEquals("KA04KL1027",listOfVehiclesPresent.get(1).getVehicleNumber());
            Assert.assertEquals("KA04HL1327",listOfVehiclesPresent.get(2).getVehicleNumber());

            Assert.assertEquals(3,listOfVehiclesPresent.size());
        }catch(ParkingLotException e){
        }
    }

    //UseCase17
    @Test
    public void givenVehicleWithName_whenQueried_shouldReturnAllVehicles() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,5);
            ParkingLot lot2 = new ParkingLot(2,1,6);
            ParkingLot lot3 = new ParkingLot(1,1);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLotService parkingLotService = new ParkingLotService(parkingLots);
            parkingLotService.parkTheVehicle(new Vehicle("KA04HB124",Driver.HANDICAPPED,1)
                    .setColor("WHITE").setVehicleName("MARUTI"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1054",Driver.HANDICAPPED,2).
                    setColor("BLACK").setVehicleName("BMW"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1025",Driver.HANDICAPPED,2)
                    .setColor("BLUE").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1026",Driver.HANDICAPPED,2)
                    .setColor("blue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL107",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL127",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1037",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04HL1327",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA04KL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA03HL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotService.parkTheVehicle(new Vehicle("KA02HL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            List<Vehicle> listOfVehiclesPresent =new ParkingLotOwner(parkingLotService).getDetails().totalVehiclesPresent;
            Assert.assertEquals(12,listOfVehiclesPresent.size());
        }catch(ParkingLotException e){
        }
    }

}
