package com.park;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceTest {

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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL
            ,Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Vehicle vehicle= parkingLot.unParkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,
                    VehicleSize.SMALL,Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            Assert.assertEquals(2,vehicle.getSpotNumber());
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.HANDICAPPED,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Vehicle vehicle=parkingLot.unParkTheVehicle(new Vehicle("KA04HB1024",Driver.HANDICAPPED,VehicleSize.SMALL,
                    Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.BMW));
            Assert.assertEquals(2,vehicle.getSpotNumber());
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HB104",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HB1094",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HB1004",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.MARUTI));
            Vehicle vehicle=parkingLot.unParkTheVehicle(new Vehicle("KA04HB1004"));
            Assert.assertEquals(2,vehicle.getSpotNumber());
            Assert.assertEquals(2,vehicle.getSlotNumber());
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Vehicle vehicle=parkingLot.unParkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Assert.assertEquals(2,vehicle.getSlotNumber());
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HO1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Vehicle vehicle=parkingLot.unParkTheVehicle(new Vehicle("KA04HO1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Assert.assertEquals(1,vehicle.getSlotNumber());
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HB1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HO1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HO0024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.unParkTheVehicle(new Vehicle("KA04HK1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.unParkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Vehicle vehicle=parkingLot.unParkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Assert.assertEquals(2,vehicle.getSlotNumber());
            Assert.assertEquals(2,vehicle.getSpotNumber());
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.LARGE,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Vehicle vehicle=parkingLot.unParkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Assert.assertEquals(1,vehicle.getSlotNumber());
            Assert.assertEquals(1,vehicle.getSpotNumber());
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicleOfLargeSize_whenUnParked_shouldOccupySpotHavingSlotswithSuitableLot() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,1);
            ParkingLot lot2 = new ParkingLot(2,2,2);
            ParkingLot lot3 = new ParkingLot(1,3);;
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.LARGE,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Vehicle vehicle=parkingLot.unParkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Assert.assertEquals(3,vehicle.getSlotNumber());
            Assert.assertEquals(1,vehicle.getSpotNumber());
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Vehicle vehicle=parkingLot.unParkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Assert.assertEquals(2,vehicle.getSlotNumber());
            Assert.assertEquals(2,vehicle.getSpotNumber());
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicleOfSizeMoreThanSlotCapacity_whenUnParked_shouldThrowException() {
        try {
            ParkingLot lot1 = new ParkingLot(2,1,2);
            ParkingLot lot2 = new ParkingLot(2,2,2);
            ParkingLot lot3 = new ParkingLot(1,1);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.LARGE,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HP1024",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            Vehicle vehicle=parkingLot.unParkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.LARGE,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,VehicleSize.MEDIUM
                    ,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.TOYOTA));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.TOYOTA));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.TOYOTA));
            List<Vehicle> listOfVehiclesOfSameColor =parkingLot.getDetails().
                    selectByColor(Vehicle.VehicleColor.BLUE).selectByName(Vehicle.VehicleName.TOYOTA).totalVehiclesPresent;
            Assert.assertEquals("1_2",listOfVehiclesOfSameColor.get(0).getVehicleLocation());
            Assert.assertEquals("2_2",listOfVehiclesOfSameColor.get(1).getVehicleLocation());
            Assert.assertEquals("2_2",listOfVehiclesOfSameColor.get(2).getVehicleLocation());
            Assert.assertEquals("KA04HL1026",listOfVehiclesOfSameColor.get(0).getVehicleNumber());
            Assert.assertEquals("KA04HL1025",listOfVehiclesOfSameColor.get(1).getVehicleNumber());
            Assert.assertEquals("KA04HL1027",listOfVehiclesOfSameColor.get(2).getVehicleNumber());
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.LARGE,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.TOYOTA));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA));
            List<Vehicle> listOfVehicles= parkingLot.getDetails().selectByColor(Vehicle.VehicleColor.WHITE).totalVehiclesPresent;
            Assert.assertEquals(3,listOfVehicles.size());
            Assert.assertEquals("KA04HL1026",listOfVehicles.get(0).getVehicleNumber());
            Assert.assertEquals("KA04HL1027",listOfVehicles.get(1).getVehicleNumber());
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.LARGE,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.TOYOTA));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.TOYOTA));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.BMW));
            List<Vehicle> listOfBMWVehicles =parkingLot.getDetails().
                    selectByName(Vehicle.VehicleName.BMW).totalVehiclesPresent;
            Assert.assertEquals("1_2",listOfBMWVehicles.get(0).getVehicleLocation());
            Assert.assertEquals("KA04HL1054",listOfBMWVehicles.get(0).getVehicleNumber());
            Assert.assertEquals(2,listOfBMWVehicles.size());
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
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.BMW).setDuration(21));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA).setDuration(30));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA).setDuration(60));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA).setDuration(20));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA).setDuration(50));
            List<Vehicle> listOfVehiclesParkedIn30Minutes =parkingLot.getDetails().
                    selectByDuration(30).totalVehiclesPresent;
            Assert.assertEquals("KA04HB124",listOfVehiclesParkedIn30Minutes.get(0).getVehicleNumber());
            Assert.assertEquals("KA04HL1026",listOfVehiclesParkedIn30Minutes.get(1).getVehicleNumber());
            Assert.assertEquals("KA04HL1054",listOfVehiclesParkedIn30Minutes.get(2).getVehicleNumber());
            Assert.assertEquals(3,listOfVehiclesParkedIn30Minutes.size());
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }


    //UseCase16
    @Test
    public void givenVehicleWithName_whenQueried_shouldReturnVehiclesOfSlot2() {
        try {
            ParkingLot lot1 = new ParkingLot(4,1,2,3,1);
            ParkingLot lot2 = new ParkingLot(4,1,6,2,1);
            ParkingLot lot3 = new ParkingLot(2,1,2);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.HANDICAPPED,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1054",Driver.HANDICAPPED,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1025",Driver.HANDICAPPED,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL107",Driver.NORMAL,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL127",Driver.HANDICAPPED,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1037",Driver.HANDICAPPED,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1327",Driver.HANDICAPPED,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA04KL1027",Driver.HANDICAPPED,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA03HL1027",Driver.HANDICAPPED,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            parkingLot.parkTheVehicle(new Vehicle("KA02HL1027",Driver.HANDICAPPED,VehicleSize.MEDIUM,
            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            List<Vehicle> listOfVehiclesPresentAtBSlot =parkingLot.getDetails().
                    selectBySize(2).selectBySpotNumber(1).selectByDriverType(Driver.HANDICAPPED).totalVehiclesPresent;
            List<Vehicle> listOfVehiclesPresentAtDSlot =parkingLot.getDetails().
                    selectBySize(2).selectBySpotNumber(4).selectByDriverType(Driver.HANDICAPPED).totalVehiclesPresent;
//            Assert.assertEquals("KA03HL1027",listOfVehiclesPresentAtDSlot.get(0).getVehicleNumber());
        //    Assert.assertEquals("KA04HL127",listOfVehiclesPresentAtBSlot.get(0).getVehicleNumber());
           // Assert.assertEquals("KA04KL1027",listOfVehiclesPresentAtBSlot.get(1).getVehicleNumber());
           // Assert.assertEquals("KA04HL1327",listOfVehiclesPresentAtBSlot.get(2).getVehicleNumber());
            Assert.assertEquals(1,listOfVehiclesPresentAtDSlot.size());
            Assert.assertEquals(5,listOfVehiclesPresentAtBSlot.size());
        }catch(ParkingLotException e){
        }
    }

    //UseCase17
    @Test
    public void givenVehicleWithName_whenQueried_shouldReturnAllVehicles() {
        try {
            ParkingLot lot1 = new ParkingLot(3,1,2,3);
            ParkingLot lot2 = new ParkingLot(4,1,2,2,1);
            ParkingLot lot3 = new ParkingLot(3,1,2,3);
            ArrayList parkingLots = new ArrayList();
            parkingLots.add(lot1);
            parkingLots.add(lot2);
            parkingLots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(parkingLots);
            parkingLot.parkTheVehicle(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.SMALL,
            Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1054",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1025",Driver.NORMAL,VehicleSize.MEDIUM
                    ,Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1026",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1027",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL107",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL127",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.MARUTI));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1037",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.TOYOTA));
            parkingLot.parkTheVehicle(new Vehicle("KA04HL1327",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.TOYOTA));
            parkingLot.parkTheVehicle(new Vehicle("KA04KL1027",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.TOYOTA));
            parkingLot.parkTheVehicle(new Vehicle("KA03HL1027",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.TOYOTA));
            parkingLot.parkTheVehicle(new Vehicle("KA02HL1027",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.TOYOTA));
            List<Vehicle> listOfVehiclesPresent =parkingLot.getDetails().totalVehiclesPresent;
            Assert.assertEquals(12,listOfVehiclesPresent.size());
            for (Vehicle vehicle : listOfVehiclesPresent){
                System.out.println(vehicle.getVehicleLocation()+" "+vehicle.getVehicleSize().getSize()+vehicle.getVehicleNumber());
            }
        }catch(ParkingLotException e){
        }
    }

}
