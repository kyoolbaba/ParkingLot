package com.park;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotTest {

    @Test
    public void givenListOfParkingLots_whenParkedSameCarTwice_ShouldReturnTruePositiveTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot2=new ParkingSlot(2);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB1344",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot3=new ParkingSlot(2);
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertTrue(parkingLot.checkVehiclePresent(new Vehicle("KA04HB1344",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI)));
        }catch(ParkingLotException e){}
        }

    @Test
    public void givenListOfParkingLots_whenParkedSameCarTwice_ShouldReturnTrueNegativeTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot2=new ParkingSlot(2);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB1344",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot3=new ParkingSlot(2);
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertFalse(parkingLot.checkVehiclePresent(new Vehicle("KA07HB1344",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI)));
        }catch(ParkingLotException e){}
        }

    @Test
    public void givenListOfParkingLots_whenParkingIsFull_ShouldReturnTruePositiveTesting() {
        try {
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1 = new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot2 = new ParkingSlot(2);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot3 = new ParkingSlot(2);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfParkingLots.add(new Vehicle("KA04HB113",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);
            ;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertTrue(parkingLot.checkParkingFullOrNot());
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenParkingIsFull_ShouldReturnTrueNegativeTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot2=new ParkingSlot(2);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot3=new ParkingSlot(3);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfParkingLots.add(new Vehicle("KA04HB113",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertFalse(parkingLot.checkParkingFullOrNot());
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTest1PositiveTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1663",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertEquals(lot2, parkingLot.
                    assignLot(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI)));
        }catch(ParkingLotException e){}

    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTest1NegativeTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1663",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertNotEquals(lot3, parkingLot.
                    assignLot(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI)));
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTest2PositiveTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertEquals(lot3,  parkingLot.
                    assignLot(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW)));
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTest2NegativeTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertEquals(lot3,  parkingLot.
                    assignLot(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW)));
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenSearched_ShouldReturnLotAndSlotOfVehiclePositiveTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.TATA));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.TATA));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            ParkingSlot parkingSlot = parkingLot.getLotOfTheVehiclePresent(new Vehicle("KA04HB1134",
                    Driver.NORMAL,VehicleSize.MEDIUM,Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.TATA));
            Assert.assertEquals(lot3, parkingSlot);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenSearched_ShouldReturnLotAndSlotOfVehicleNegativeTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            ParkingSlot parkingSlot = parkingLot.
                    getLotOfTheVehiclePresent(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                            Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
            Assert.assertNotEquals(lot1, parkingSlot);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenSearched_ShouldReturnVehiclesPresent() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2,1,2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.HYUNDAI));
            ParkingSlot lot2=new ParkingSlot(4,1,2,3,1);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.BMW));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.SMALL,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            ParkingSlot lot3=new ParkingSlot(4,1,2,3,1);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            List<Vehicle> listOfVehicles= parkingLot.
                    getVehicleDetails();
            Assert.assertEquals(7,listOfVehicles.size());
        }catch(ParkingLotException e){}
    }

}
