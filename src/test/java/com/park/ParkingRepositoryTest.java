package com.park;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingRepositoryTest {

    @Test
    public void givenListOfParkingLots_whenParkedSameCarTwice_ShouldReturnTruePositiveTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
            ParkingSlot lot2=new ParkingSlot(2);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB1344"));
            ParkingSlot lot3=new ParkingSlot(2);
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertTrue(parkingLot.checkVehiclePresent(new Vehicle("KA04HB1344")));
        }catch(ParkingLotException e){}
        }

    @Test
    public void givenListOfParkingLots_whenParkedSameCarTwice_ShouldReturnTrueNegativeTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
            ParkingSlot lot2=new ParkingSlot(2);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB1344"));
            ParkingSlot lot3=new ParkingSlot(2);
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertFalse(parkingLot.checkVehiclePresent(new Vehicle("KA07HB1344")));
        }catch(ParkingLotException e){}
        }

    @Test
    public void givenListOfParkingLots_whenParkingIsFull_ShouldReturnTruePositiveTesting() {
        try {
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1 = new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
            ParkingSlot lot2 = new ParkingSlot(2);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
            ParkingSlot lot3 = new ParkingSlot(2);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
            lot3.listOfParkingLots.add(new Vehicle("KA04HB113"));
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
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
            ParkingSlot lot2=new ParkingSlot(2);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
            ParkingSlot lot3=new ParkingSlot(3);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
            lot3.listOfParkingLots.add(new Vehicle("KA04HB113"));
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
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163"));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134"));
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1663"));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertEquals(lot2, parkingLot.
                    selectLot(new Vehicle("KA04HB1134",Driver.NORMAL,3)));
        }catch(ParkingLotException e){}

    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTest1NegativeTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163"));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134"));
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1663"));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertNotEquals(lot3, parkingLot.
                    selectLot(new Vehicle("KA04HB1134",Driver.NORMAL,3)));
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTest2PositiveTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163"));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134"));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertEquals(lot3,  parkingLot.
                    selectLot(new Vehicle("KA04HB1134",Driver.NORMAL,3)));
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTest2NegativeTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163"));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134"));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            Assert.assertEquals(lot3,  parkingLot.
                    selectLot(new Vehicle("KA04HB1134",Driver.NORMAL,3)));
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenSearched_ShouldReturnLotAndSlotOfVehiclePositiveTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163"));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134"));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            ParkingSlot parkingSlot = parkingLot.getLotOfVehicle(new Vehicle("KA04HB1134",Driver.NORMAL,3));
            Assert.assertEquals(lot3, parkingSlot);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenSearched_ShouldReturnLotAndSlotOfVehicleNegativeTesting() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
            ParkingSlot lot2=new ParkingSlot(4);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163"));
            ParkingSlot lot3=new ParkingSlot(4);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134"));
            listOfParkingSlots.add(lot1);
            listOfParkingSlots.add(lot2);;
            listOfParkingSlots.add(lot3);
            ParkingLot parkingLot = new ParkingLot(listOfParkingSlots);
            ParkingSlot parkingSlot = parkingLot.
                    getLotOfVehicle(new Vehicle("KA04HB1134",Driver.NORMAL,3));
            Assert.assertNotEquals(lot1, parkingSlot);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenListOfParkingLots_whenSearched_ShouldReturnVehiclesPresent() {
        try{
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
            ParkingSlot lot1=new ParkingSlot(2,1,2);
            lot1.listOfParkingLots.add(new Vehicle("KA04HB1234",Driver.NORMAL,2,Vehicle.VehicleColor.WHITE));
            lot1.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,1,Vehicle.VehicleColor.RED));
            ParkingSlot lot2=new ParkingSlot(4,1,2,3,1);
            lot2.listOfParkingLots.add(new Vehicle("KA04HB134",Driver.NORMAL,3,Vehicle.VehicleColor.WHITE));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB13",Driver.NORMAL,2));
            lot2.listOfParkingLots.add(new Vehicle("KA04HB163",Driver.NORMAL,1));
            ParkingSlot lot3=new ParkingSlot(4,1,2,3,1);
            lot3.listOfParkingLots.add(new Vehicle("KA04HB1134",Driver.NORMAL,2));
            lot3.listOfParkingLots.add(new Vehicle("KA04PB134",Driver.NORMAL,2,Vehicle.VehicleColor.WHITE));
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
