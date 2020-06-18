package com.park;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingSlotTest {

    @Test
    public void givenListOfParkingLots_whenParkedSameCarTwice_ShouldReturnTruePositiveTesting() {
        try{
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot lot1=new ParkingLot(2);
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot2=new ParkingLot(2);
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB1344",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot3=new ParkingLot(2);
            listOfParkingLots.add(lot1);
            listOfParkingLots.add(lot2);
            listOfParkingLots.add(lot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            Assert.assertTrue(parkingSlot.checkVehiclePresent(new Vehicle("KA04HB1344",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI)));
        }catch(ParkingLotException e){}
        }

    @Test
    public void givenListOfParkingLots_whenParkedSameCarTwice_ShouldReturnTrueNegativeTesting() {
        try{
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot lot1=new ParkingLot(2);
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot2=new ParkingLot(2);
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB1344",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot3=new ParkingLot(2);
            listOfParkingLots.add(lot1);
            listOfParkingLots.add(lot2);;
            listOfParkingLots.add(lot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            Assert.assertFalse(parkingSlot.checkVehiclePresent(new Vehicle("KA07HB1344",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI)));
        }catch(ParkingLotException e){}
        }

    @Test
    public void givenListOfParkingLots_whenParkingIsFull_ShouldReturnTruePositiveTesting() {
        try {
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot lot1 = new ParkingLot(2);
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot2 = new ParkingLot(2);
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot3 = new ParkingLot(2);
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB113",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            listOfParkingLots.add(lot1);
            listOfParkingLots.add(lot2);
            ;
            listOfParkingLots.add(lot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            Assert.assertTrue(parkingSlot.checkParkingFullOrNot());
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenParkingIsFull_ShouldReturnTrueNegativeTesting() {
        try{
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot lot1=new ParkingLot(2);
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot2=new ParkingLot(2);
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot3=new ParkingLot(3);
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB113",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            listOfParkingLots.add(lot1);
            listOfParkingLots.add(lot2);;
            listOfParkingLots.add(lot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            Assert.assertFalse(parkingSlot.checkParkingFullOrNot());
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLottPositiveTesting() {
        try{
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot lot1=new ParkingLot(2);
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot2=new ParkingLot(4);
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot3=new ParkingLot(4);
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB1663",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            listOfParkingLots.add(lot1);
            listOfParkingLots.add(lot2);;
            listOfParkingLots.add(lot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            Assert.assertEquals(lot2, parkingSlot.
                    assignSlot(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI)));
        }catch(ParkingLotException e){}

    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTestNegativeTesting() {
        try{
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot lot1=new ParkingLot(2);
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot2=new ParkingLot(4);
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot3=new ParkingLot(4);
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB1663",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            listOfParkingLots.add(lot1);
            listOfParkingLots.add(lot2);;
            listOfParkingLots.add(lot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            Assert.assertNotEquals(lot3, parkingSlot.
                    assignSlot(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI)));
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotPositiveTesting() {
        try{
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot lot1=new ParkingLot(2);
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            ParkingLot lot2=new ParkingLot(4);
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            ParkingLot lot3=new ParkingLot(4);
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            listOfParkingLots.add(lot1);
            listOfParkingLots.add(lot2);;
            listOfParkingLots.add(lot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            Assert.assertEquals(lot3,  parkingSlot.
                    assignSlot(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW)));
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotNegativeTesting() {
        try{
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot lot1=new ParkingLot(2);
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            ParkingLot lot2=new ParkingLot(4);
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            ParkingLot lot3=new ParkingLot(4);
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            listOfParkingLots.add(lot1);
            listOfParkingLots.add(lot2);
            listOfParkingLots.add(lot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            Assert.assertEquals(lot3,  parkingSlot.
                    assignSlot(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW)));
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenSearched_ShouldReturnLotAndSlotOfVehiclePositiveTesting() {
        try{
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot lot1=new ParkingLot(2);
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            ParkingLot lot2=new ParkingLot(4);
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB13",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB163",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            ParkingLot lot3=new ParkingLot(4);
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB1134",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.TATA));
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04PB134",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.TATA));
            listOfParkingLots.add(lot1);
            listOfParkingLots.add(lot2);;
            listOfParkingLots.add(lot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            ParkingLot parkingLot = parkingSlot.getSlotOfTheVehiclePresent(new Vehicle("KA04HB1134",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.TATA));
            Assert.assertEquals(lot3, parkingLot);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenSearched_ShouldReturnLotAndSlotOfVehicleNegativeTesting() {
        try{
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot lot1=new ParkingLot(2);
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            ParkingLot lot2=new ParkingLot(4);
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            ParkingLot lot3=new ParkingLot(4);
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            listOfParkingLots.add(lot1);
            listOfParkingLots.add(lot2);;
            listOfParkingLots.add(lot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            ParkingLot parkingLot = parkingSlot.
                    getSlotOfTheVehiclePresent(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            Assert.assertNotEquals(lot1, parkingLot);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenSearched_ShouldReturnVehiclesPresent() {
        try{
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot lot1=new ParkingLot(2,1,2);
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            lot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.HYUNDAI));
            ParkingLot lot2=new ParkingLot(4,1,2,3,1);
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.BMW));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            lot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            ParkingLot lot3=new ParkingLot(4,1,2,3,1);
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            lot3.listOfVehiclesInSlot.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            listOfParkingLots.add(lot1);
            listOfParkingLots.add(lot2);;
            listOfParkingLots.add(lot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            List<Vehicle> listOfVehicles= parkingSlot.
                    getVehicleDetails();
            Assert.assertEquals(7,listOfVehicles.size());
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenLargeVehicle_whenParked_shouldReturnSecludedLotNumber() {
        try {
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot slot1 = new ParkingLot(5, 3, 3,3,3,1);
            slot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            slot1.spots =new int[]{2,0,0,0,2};
            ParkingLot slot2 = new ParkingLot(4, 1, 2, 3, 1);
            slot2.spots =new int[]{1,0,1,0};
            slot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB163", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            ParkingLot slot3 = new ParkingLot(4, 1, 2, 3, 1);
            slot3.spots =new int[]{1,2,0,1};
            listOfParkingLots.add(slot1);
            listOfParkingLots.add(slot2);
            listOfParkingLots.add(slot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            ParkingLot parkingLot = parkingSlot.assignSlot(new Vehicle("KA06HB784",Driver.NORMAL,VehicleSize.LARGE,Vehicle.VehicleColor
                    .BLACK,Vehicle.VehicleName.BMW));
            Assert.assertEquals(slot1, parkingLot);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenLargeVehicle_whenParked_shouldReturnLastSlotEmpty() {
        try {
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot slot1 = new ParkingLot(5, 3, 3,3,3,1);
            slot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            slot1.spots =new int[]{2,0,1,0,2};
            ParkingLot slot2 = new ParkingLot(4, 1, 2, 3, 4);
            slot2.spots =new int[]{1,0,1,0};
            slot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB163", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            ParkingLot slot3 = new ParkingLot(4, 1, 2, 3, 1);
            slot3.spots =new int[]{1,2,0,1};
            listOfParkingLots.add(slot1);
            listOfParkingLots.add(slot2);
            listOfParkingLots.add(slot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            ParkingLot parkingLot = parkingSlot.assignSlot(new Vehicle("KA06HB784",Driver.NORMAL,VehicleSize.LARGE,Vehicle.VehicleColor
                    .BLACK,Vehicle.VehicleName.BMW));
            Assert.assertEquals(slot2, parkingLot);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenLargeVehicle_whenParked_shouldReturnFirstSlotEmpty() {
        try {
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot slot1 = new ParkingLot(5, 3, 3,3,3,1);
            slot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            slot1.spots =new int[]{2,0,1,0,2};
            ParkingLot slot2 = new ParkingLot(4, 2, 2, 3, 1);
            slot2.spots =new int[]{0,0,1,0};
            slot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB163", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            ParkingLot slot3 = new ParkingLot(4, 4, 2, 3, 1);
            slot3.spots =new int[]{0,2,0,1};
            listOfParkingLots.add(slot1);
            listOfParkingLots.add(slot2);
            listOfParkingLots.add(slot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            ParkingLot parkingLot = parkingSlot.assignSlot(new Vehicle("KA06HB784",Driver.NORMAL,VehicleSize.LARGE,Vehicle.VehicleColor
                    .BLACK,Vehicle.VehicleName.BMW));
            Assert.assertEquals(slot3, parkingLot);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenLotDetails_whenAdded_shouldReturnTotalSpotsPresent() {
        try {
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot slot1 = new ParkingLot(5, 3, 3,3,3,1);
            slot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            slot1.spots =new int[]{2,0,1,0,2};
            ParkingLot slot2 = new ParkingLot(4, 2, 2, 3, 1);
            slot2.spots =new int[]{0,0,1,0};
            slot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB163", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            ParkingLot slot3 = new ParkingLot(4, 4, 2, 3, 1);
            slot3.spots =new int[]{0,2,0,1};
            listOfParkingLots.add(slot1);
            listOfParkingLots.add(slot2);
            listOfParkingLots.add(slot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            Assert.assertEquals(31, parkingSlot.totalSpotsPresent);
        }catch(ParkingLotException e){}
    }


    @Test
    public void givenLotDetails_whenAdded_shouldReturnParkingFull() {
        try {
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot slot1 = new ParkingLot(2, 1,2);
            slot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            slot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1034", Driver.NORMAL, VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            ParkingLot slot2 = new ParkingLot(3, 2, 2, 1);
            slot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB063", Driver.NORMAL, VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            slot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB1603", Driver.NORMAL, VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            slot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB160", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            ParkingLot slot3 = new ParkingLot(1, 1);
            slot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB160", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            listOfParkingLots.add(slot1);
            listOfParkingLots.add(slot2);
            listOfParkingLots.add(slot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            Assert.assertTrue(parkingSlot.checkParkingFullOrNot());
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenLotDetails_whenAdded_shouldReturnParkingNotFull() {
        try {
            List<ParkingLot> listOfParkingLots = new ArrayList();
            ParkingLot slot1 = new ParkingLot(2, 1,2);
            slot1.listOfVehiclesInSlot.add(new Vehicle("KA04HB1234", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            ParkingLot slot2 = new ParkingLot(3, 2, 2, 1);
            slot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB063", Driver.NORMAL, VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            slot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB1603", Driver.NORMAL, VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            slot2.listOfVehiclesInSlot.add(new Vehicle("KA04HB160", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            ParkingLot slot3 = new ParkingLot(1, 1);
            slot3.listOfVehiclesInSlot.add(new Vehicle("KA04HB160", Driver.NORMAL, VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE, Vehicle.VehicleName.MARUTI));
            listOfParkingLots.add(slot1);
            listOfParkingLots.add(slot2);
            listOfParkingLots.add(slot3);
            ParkingSlot parkingSlot = new ParkingSlot(listOfParkingLots);
            Assert.assertFalse(parkingSlot.checkParkingFullOrNot());
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenVehicleDetails_whenAdded_shouldReturnLotForShuffle() {
        try {
            List<ParkingLot> listOfSlots=new ArrayList<>();
            Vehicle vehicle1=new Vehicle("KA04HL1027",Driver.NORMAL,VehicleSize.LARGE,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW);
            Vehicle vehicle2=new Vehicle("KA04HL107",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW);
            Vehicle vehicle3=(new Vehicle("KA04HL127",Driver.HANDICAPPED,VehicleSize.SMALL,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            Vehicle vehicle4=(new Vehicle("KA04HL1037",Driver.HANDICAPPED,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            Vehicle vehicle5=(new Vehicle("KA04HL1327",Driver.HANDICAPPED,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            vehicle1.setSpotNumber(1);
            vehicle2.setSpotNumber(2);
            vehicle3.setSpotNumber(3);
            vehicle4.setSpotNumber(1);
            vehicle1.setSlotNumber(1);
            vehicle2.setSlotNumber(1);
            vehicle3.setSlotNumber(1);
            vehicle4.setSlotNumber(2);
            ParkingLot parkingLot1=new ParkingLot(3,3,2,1);
            ParkingLot parkingLot2=new ParkingLot(2,2,1);
            parkingLot1.spots =new int[]{3,1,1};
            parkingLot2.spots =new int[]{2,0};
            parkingLot1.listOfVehiclesInSlot.add(vehicle1);
            parkingLot1.listOfVehiclesInSlot.add(vehicle2);
            parkingLot1.listOfVehiclesInSlot.add(vehicle3);
            parkingLot2.listOfVehiclesInSlot.add(vehicle4);
            listOfSlots.add(parkingLot1);
            listOfSlots.add(parkingLot2);
            ParkingSlot parkingSlot=new ParkingSlot(listOfSlots);
            parkingSlot.shuffle(vehicle5);
            Assert.assertEquals(2,vehicle2.getSlotNumber());
            Assert.assertEquals(2,vehicle2.getSlotNumber());
            Assert.assertEquals(1,vehicle5.getSlotNumber());
            Assert.assertEquals(2,vehicle5.getSpotNumber());
        }catch(ParkingLotException e ){}
    }

    @Test
    public void givenVehicleDetails_whenAddedLargeVehicles_shouldReturnLotForShuffle() {
        try {
            List<ParkingLot> listOfSlots=new ArrayList<>();
            Vehicle vehicle1=new Vehicle("KA04HL1027",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW);
            Vehicle vehicle2=new Vehicle("KA04HL107",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW);
            Vehicle vehicle3=(new Vehicle("KA04HL127",Driver.HANDICAPPED,VehicleSize.SMALL,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            Vehicle vehicle4=(new Vehicle("KA04HL1037",Driver.HANDICAPPED,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            Vehicle vehicle5=(new Vehicle("KA04HL1327",Driver.HANDICAPPED,VehicleSize.LARGE,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            vehicle1.setSpotNumber(1);
            vehicle2.setSpotNumber(2);
            vehicle3.setSpotNumber(3);
            vehicle4.setSpotNumber(1);
            vehicle1.setSlotNumber(1);
            vehicle2.setSlotNumber(1);
            vehicle3.setSlotNumber(1);
            vehicle4.setSlotNumber(2);
            ParkingLot parkingLot1=new ParkingLot(3,3,2,1);
            ParkingLot parkingLot2=new ParkingLot(2,2,1);
            parkingLot1.spots =new int[]{2,1,1};
            parkingLot2.spots =new int[]{2,0};
            parkingLot1.listOfVehiclesInSlot.add(vehicle1);
            parkingLot1.listOfVehiclesInSlot.add(vehicle2);
            parkingLot1.listOfVehiclesInSlot.add(vehicle3);
            parkingLot2.listOfVehiclesInSlot.add(vehicle4);
            listOfSlots.add(parkingLot1);
            listOfSlots.add(parkingLot2);
            ParkingSlot parkingSlot=new ParkingSlot(listOfSlots);
            parkingSlot.shuffle(vehicle5);
            Assert.assertEquals(1,vehicle2.getSlotNumber());
            Assert.assertEquals(2,vehicle2.getSpotNumber());
            Assert.assertEquals(1,vehicle5.getSlotNumber());
            Assert.assertEquals(1,vehicle5.getSpotNumber());
        }catch(ParkingLotException e ){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }


}
