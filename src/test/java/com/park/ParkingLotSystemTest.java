package com.park;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotSystemTest {

    //TestCases for parking slot with multiple spot
    @Test
    public void givenTwoVehicle_whenRemovedFirstVehicleAndAddingAnotherVehicle_shouldReturnSlotNumber() {
        try {
            ParkingLot lot1=new ParkingLot(2,1,2);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            Vehicle vehicle= parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HB1024"));
            Assert.assertEquals(2,vehicle.getSlotNumber());
        }catch(ParkingLotException e){
        }
    }
    //TestCase for Handicapped player
    @Test
    public void givenTwoVehicle_whenAddingHandiCapped_shouldReturnSlotNumber() {
        try {
            ParkingLot lot1=new ParkingLot(2,2,2);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.HANDICAPPED,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            Vehicle vehicle= parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HB1024"));
            Assert.assertEquals(2,vehicle.getSlotNumber());
        }catch(ParkingLotException e){
        }
    }
    //TestCases for parking slot with multiple spot
    @Test
    public void givenThreeVehicle_whenRemovedFirstVehicleAndAddingAnotherVehicle_shouldReturnSLotNumber() {
        try {
            ParkingLot lot1=new ParkingLot(2,1,2);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB104",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB1094",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB1004",Driver.NORMAL,1));
            Vehicle vehicle= parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HB1004"));
            Assert.assertEquals(2,vehicle.getSlotNumber());
            Assert.assertEquals(2,vehicle.getLotNumber());
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenTwoVehicle_whenRemovedFirstVehicleAndAddingAnotherVehicle_shouldReturnLotNumberTest1() {
        try {
            ParkingLot lot1=new ParkingLot(2);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            Vehicle vehicle= parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HB1024"));
            Assert.assertEquals(2,vehicle.getLotNumber());
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenTwoVehicle_whenRemovedFirstVehicleAndAddingAnotherVehicle_shouldReturnLotNumberTest3() {
        try {
            ParkingLot lot1=new ParkingLot(2);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HO1024",Driver.NORMAL,1));
            Vehicle vehicle= parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HO1024"));
            Assert.assertEquals(1,vehicle.getLotNumber());
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenTwoVehicle_whenParked_shouldReturnTrue() {
        try {
            ParkingLot lot1=new ParkingLot(2,1,2);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            //Vehicle vehicle=parkingLotService.exit(new Vehicle("KA04HB1024"));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenPersonVehicleAsNull_whenParked_shouldReturnTrue() {
        try {
            ParkingLot lot1 = new ParkingLot(1,1);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HO1024",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HO0024",Driver.NORMAL,1));
            }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_IS_FULL,e.type);
        }
    }

    @Test
    public void givenSameVehicleTwice_whenParked_shouldReturnTrue() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,3);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,1));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN,e.type);
        }
    }



    @Test
    public void givenVehicleNotPresent_whenUnParked_shouldThrowException() {
        try {
            ParkingLot lot1 = new ParkingLot(2,2,3);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,1));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,1));
            parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HK1024",Driver.NORMAL,1));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT,e.type);
        }
    }

    @Test
    public void givenVehicleOfSize2_whenUnParked_shouldOccupySpotHavingTwoSlots() {
        try {
            ParkingLot lot1 = new ParkingLot(2,2,3);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,2));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HP1024"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            Vehicle vehicle= parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HP1024"));
            Assert.assertEquals(2,vehicle.getLotNumber());
            Assert.assertEquals(1,vehicle.getSlotNumber());
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicleOfSize3_whenUnParked_shouldOccupySpotHavingThreeSlots() {
        try {
            ParkingLot lot1 = new ParkingLot(2,3,2);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,3));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            Vehicle vehicle= parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HB124"));
            Assert.assertEquals(1,vehicle.getLotNumber());
            Assert.assertEquals(1,vehicle.getSlotNumber());
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicleOfSize5_whenUnParked_shouldOccupySpotHavingSlotswithSuitableLot() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,2);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,5));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            Vehicle vehicle= parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HB124"));
            Assert.assertEquals(3,vehicle.getLotNumber());
            Assert.assertEquals(1,vehicle.getSlotNumber());
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicleOfSize3_whenUnParked_shouldOccupySpotHavingSlotswithSuitableLot() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,2);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,3));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            Vehicle vehicle= parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HB124"));
            Assert.assertEquals(2,vehicle.getLotNumber());
            Assert.assertEquals(2,vehicle.getSlotNumber());
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicleOfSizeMoreThanSlotCapacity_whenUnParked_shouldThrowException() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,2);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,6));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,2));
            Vehicle vehicle= parkingLotSystem.unParkTheVehicle(new Vehicle("KA04HB124"));
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
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,6).setColor("WHITE").setVehicleName("MARUTI"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,2).setColor("BLACK").setVehicleName("BMW"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,2).setColor("BLUE").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,2).setColor("blue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,2).setColor("BLue").setVehicleName("TOYOTA"));
            List<Vehicle> listOfVehiclesOfSameColor =new ParkingLotOwner(parkingLotSystem).getDetails().
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
            ParkingLot lot = new ParkingLot(2,1,6);
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,6).setColor("WHITE").setVehicleName("MARUTI"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,2).setColor("WHITE").setVehicleName("BMW"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,2).setColor("BLUE").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,2).setColor("blue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,2).setColor("BLue").setVehicleName("TOYOTA"));
            ParkingLotOwner parkingLotOwner =new ParkingLotOwner(parkingLotSystem);
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
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,6).setColor("WHITE").setVehicleName("MARUTI"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,2).setColor("BLACK").setVehicleName("BMW"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,2).setColor("BLUE").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,2).setColor("blue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,2).setColor("BLue").setVehicleName("TOYOTA"));
            List<Vehicle> listOfBMWVehicles =new ParkingLotOwner(parkingLotSystem).getDetails().
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
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,6)
                    .setColor("WHITE").setVehicleName("MARUTI").setDuration(21));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,2).
                    setColor("BLACK").setVehicleName("BMW").setDuration(30));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,2)
                    .setColor("BLUE").setVehicleName("TOYOTA").setDuration(60));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,2)
                    .setColor("blue").setVehicleName("TOYOTA").setDuration(20));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,2)
                    .setColor("BLue").setVehicleName("TOYOTA").setDuration(50));
            List<Vehicle> listOfVehiclesParkedIn30Minutes =new ParkingLotOwner(parkingLotSystem).getDetails().
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

            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.HANDICAPPED,2)
                    .setColor("WHITE").setVehicleName("MARUTI"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1054",Driver.HANDICAPPED,2).
                    setColor("BLACK").setVehicleName("BMW"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1025",Driver.HANDICAPPED,2)
                    .setColor("BLUE").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,2)
                    .setColor("blue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL107",Driver.NORMAL,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL127",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1037",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1327",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04KL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA03HL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA02HL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            List<Vehicle> listOfVehiclesPresent =new ParkingLotOwner(parkingLotSystem).getDetails().
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
            ParkingLotSystem parkingLotSystem = new ParkingLotSystem(lot1);
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HB124",Driver.HANDICAPPED,1)
                    .setColor("WHITE").setVehicleName("MARUTI"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1054",Driver.HANDICAPPED,2).
                    setColor("BLACK").setVehicleName("BMW"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1025",Driver.HANDICAPPED,2)
                    .setColor("BLUE").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1026",Driver.HANDICAPPED,2)
                    .setColor("blue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL107",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL127",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1037",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04HL1327",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA04KL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA03HL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            parkingLotSystem.parkTheVehicle(new Vehicle("KA02HL1027",Driver.HANDICAPPED,2)
                    .setColor("BLue").setVehicleName("TOYOTA"));
            List<Vehicle> listOfVehiclesPresent =new ParkingLotOwner(parkingLotSystem).getDetails().totalVehiclesPresent;
            Assert.assertEquals(12,listOfVehiclesPresent.size());
        }catch(ParkingLotException e){
        }
    }

}
