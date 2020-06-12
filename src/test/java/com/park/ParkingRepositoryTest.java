package com.park;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class ParkingRepositoryTest {

    @Test
    public void givenListOfParkingLots_whenParkedSameCarTwice_ShouldReturnTruePositiveTesting() {
        List<ParkingLot> listOfParkingLots = new ArrayList();
        ParkingLot lot1=new ParkingLot(2);
        lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
        lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
        ParkingLot lot2=new ParkingLot(2);
        lot2.listOfParkingLots.add(new Vehicle("KA04HB1344"));
        ParkingLot lot3=new ParkingLot(2);
        listOfParkingLots.add(lot1);
        listOfParkingLots.add(lot2);;
        listOfParkingLots.add(lot3);
        ParkingLotRepository parkingLotRepository= new ParkingLotRepository(listOfParkingLots);
        Assert.assertTrue(parkingLotRepository.checkVehiclePresent(new Vehicle("KA04HB1344")));
    }

    @Test
    public void givenListOfParkingLots_whenParkedSameCarTwice_ShouldReturnTrueNegativeTesting() {
        List<ParkingLot> listOfParkingLots = new ArrayList();
        ParkingLot lot1=new ParkingLot(2);
        lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
        lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
        ParkingLot lot2=new ParkingLot(2);
        lot2.listOfParkingLots.add(new Vehicle("KA04HB1344"));
        ParkingLot lot3=new ParkingLot(2);
        listOfParkingLots.add(lot1);
        listOfParkingLots.add(lot2);;
        listOfParkingLots.add(lot3);
        ParkingLotRepository parkingLotRepository= new ParkingLotRepository(listOfParkingLots);
        Assert.assertFalse(parkingLotRepository.checkVehiclePresent(new Vehicle("KA07HB1344")));
    }

    @Test
    public void givenListOfParkingLots_whenParkingIsFull_ShouldReturnTruePositiveTesting() {
        List<ParkingLot> listOfParkingLots = new ArrayList();
        ParkingLot lot1=new ParkingLot(2);
        lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
        lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
        ParkingLot lot2=new ParkingLot(2);
        lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
        lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
        ParkingLot lot3=new ParkingLot(2);
        lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
        lot3.listOfParkingLots.add(new Vehicle("KA04HB113"));
        listOfParkingLots.add(lot1);
        listOfParkingLots.add(lot2);;
        listOfParkingLots.add(lot3);
        ParkingLotRepository parkingLotRepository= new ParkingLotRepository(listOfParkingLots);
        Assert.assertTrue(parkingLotRepository.checkParkingFullOrNot());
    }

    @Test
    public void givenListOfParkingLots_whenParkingIsFull_ShouldReturnTrueNegativeTesting() {
        List<ParkingLot> listOfParkingLots = new ArrayList();
        ParkingLot lot1=new ParkingLot(2);
        lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
        lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
        ParkingLot lot2=new ParkingLot(2);
        lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
        lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
        ParkingLot lot3=new ParkingLot(3);
        lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
        lot3.listOfParkingLots.add(new Vehicle("KA04HB113"));
        listOfParkingLots.add(lot1);
        listOfParkingLots.add(lot2);;
        listOfParkingLots.add(lot3);
        ParkingLotRepository parkingLotRepository= new ParkingLotRepository(listOfParkingLots);
        Assert.assertFalse(parkingLotRepository.checkParkingFullOrNot());
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTest1PositiveTesting() {
        List<ParkingLot> listOfParkingLots = new ArrayList();
        ParkingLot lot1=new ParkingLot(2);
        lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
        lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
        ParkingLot lot2=new ParkingLot(4);
        lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
        lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
        lot2.listOfParkingLots.add(new Vehicle("KA04HB163"));
        ParkingLot lot3=new ParkingLot(4);
        lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
        lot3.listOfParkingLots.add(new Vehicle("KA04PB134"));
        lot3.listOfParkingLots.add(new Vehicle("KA04HB1663"));
        listOfParkingLots.add(lot1);
        listOfParkingLots.add(lot2);;
        listOfParkingLots.add(lot3);
        ParkingLotRepository parkingLotRepository= new ParkingLotRepository(listOfParkingLots);
        Assert.assertEquals(lot2,parkingLotRepository.selectLot());
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTest1NegativeTesting() {
        List<ParkingLot> listOfParkingLots = new ArrayList();
        ParkingLot lot1=new ParkingLot(2);
        lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
        lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
        ParkingLot lot2=new ParkingLot(4);
        lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
        lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
        lot2.listOfParkingLots.add(new Vehicle("KA04HB163"));
        ParkingLot lot3=new ParkingLot(4);
        lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
        lot3.listOfParkingLots.add(new Vehicle("KA04PB134"));
        lot3.listOfParkingLots.add(new Vehicle("KA04HB1663"));
        listOfParkingLots.add(lot1);
        listOfParkingLots.add(lot2);;
        listOfParkingLots.add(lot3);
        ParkingLotRepository parkingLotRepository= new ParkingLotRepository(listOfParkingLots);
        Assert.assertNotEquals(lot3,parkingLotRepository.selectLot());
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTest2PositiveTesting() {
        List<ParkingLot> listOfParkingLots = new ArrayList();
        ParkingLot lot1=new ParkingLot(2);
        lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
        lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
        ParkingLot lot2=new ParkingLot(4);
        lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
        lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
        lot2.listOfParkingLots.add(new Vehicle("KA04HB163"));
        ParkingLot lot3=new ParkingLot(4);
        lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
        lot3.listOfParkingLots.add(new Vehicle("KA04PB134"));
        listOfParkingLots.add(lot1);
        listOfParkingLots.add(lot2);;
        listOfParkingLots.add(lot3);
        ParkingLotRepository parkingLotRepository= new ParkingLotRepository(listOfParkingLots);
        Assert.assertEquals(lot3,  parkingLotRepository.selectLot());
    }

    @Test
    public void givenListOfParkingLots_whenParking_ShouldReturnLotTest2NegativeTesting() {
        List<ParkingLot> listOfParkingLots = new ArrayList();
        ParkingLot lot1=new ParkingLot(2);
        lot1.listOfParkingLots.add(new Vehicle("KA04HB1234"));
        lot1.listOfParkingLots.add(new Vehicle("KA04HB134"));
        ParkingLot lot2=new ParkingLot(4);
        lot2.listOfParkingLots.add(new Vehicle("KA04HB134"));
        lot2.listOfParkingLots.add(new Vehicle("KA04HB13"));
        lot2.listOfParkingLots.add(new Vehicle("KA04HB163"));
        ParkingLot lot3=new ParkingLot(4);
        lot3.listOfParkingLots.add(new Vehicle("KA04HB1134"));
        lot3.listOfParkingLots.add(new Vehicle("KA04PB134"));
        listOfParkingLots.add(lot1);
        listOfParkingLots.add(lot2);;
        listOfParkingLots.add(lot3);
        ParkingLotRepository parkingLotRepository= new ParkingLotRepository(listOfParkingLots);
        Assert.assertNotEquals(lot2,  parkingLotRepository.selectLot());
    }
}
