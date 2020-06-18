package com.park;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotTest {

    @Mock
    ParkingSpot parkingSpot;

    @Mock
    ParkingSlot parkingSlot;

    @InjectMocks
    ParkingLot parkingLot;

    @Test
    public void givenVehicle_whenParkedTheVehicle_ShouldAddTheVehicleIntheSlot() {
        try {
            List<ParkingLot> listOfParkingLots = new ArrayList();
             Vehicle vehicle1=new Vehicle("KA04HB21",Driver.NORMAL,VehicleSize.SMALL
                     , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
            Vehicle vehicle2=new Vehicle("KA04HB021",Driver.NORMAL,VehicleSize.SMALL
                    , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
            Vehicle vehicle3=new Vehicle("KA04HB221",Driver.NORMAL,VehicleSize.SMALL
                    , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
             ParkingLot parkingLot1 = new ParkingLot(3, 2, 3, 1);
             ParkingLot parkingLot2 = new ParkingLot(2,  3, 1);
            listOfParkingLots.add(parkingLot1);
            listOfParkingLots.add(parkingLot2);
             when(parkingSlot.checkVehiclePresent(vehicle1)).thenReturn(false);
             when(parkingSlot.checkParkingFullOrNot()).thenReturn(false);
             when(parkingSlot.assignSlot(any(Vehicle.class))).thenReturn(parkingLot2);
             doNothing().when(parkingSpot).assignSpotNumber(any(int[].class),any(Vehicle.class),any(Integer[].class));
             parkingLot.parkTheVehicle(vehicle1);
             parkingLot.parkTheVehicle(vehicle2);
             parkingLot.parkTheVehicle(vehicle3);
            Assert.assertEquals(3, parkingLot2.listOfVehiclesInSlot.size());
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicleObjectNull_whenAdded_shouldThrowException() {
        try {
            parkingLot.parkTheVehicle(null);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicleNumberEmpty_whenAdded_shouldThrowException() {
        try {
            parkingLot.parkTheVehicle(new Vehicle("",Driver.NORMAL,VehicleSize.LARGE,Vehicle.VehicleColor
                    .BLACK,Vehicle.VehicleName.BMW));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicleNumberNull_whenAdded_shouldThrowException() {
        try {
            parkingLot.parkTheVehicle(new Vehicle(null,Driver.NORMAL,VehicleSize.LARGE,Vehicle.VehicleColor
                    .BLACK,Vehicle.VehicleName.BMW));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicleDetails_whenUnparked_shouldReturnVehiclesDetails() {
        try {
            List<Vehicle> listOfVehiclesInSlot = new ArrayList<>();
            Vehicle vehicle1=new Vehicle("KA04HB21",Driver.NORMAL,VehicleSize.SMALL
                    , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
            Vehicle vehicle2=new Vehicle("KA04HB021",Driver.NORMAL,VehicleSize.SMALL
                    , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
            Vehicle vehicle3=new Vehicle("KA04HB221",Driver.NORMAL,VehicleSize.SMALL
                    , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
            vehicle2.setSpotNumber(2);
            listOfVehiclesInSlot.add(vehicle1);
            listOfVehiclesInSlot.add(vehicle2);
            listOfVehiclesInSlot.add(vehicle3);
            ParkingLot vehiclesSlot=new ParkingLot();
            vehiclesSlot.listOfVehiclesInSlot =listOfVehiclesInSlot;
            vehiclesSlot.spots =new int[3];
            vehiclesSlot.spotCapacity = new Integer[]{1,2,3};
            when(parkingSlot.checkVehiclePresent(new Vehicle("KA04HB021"))).thenReturn(true);
            when(parkingSlot.checkParkingFullOrNot()).thenReturn(false);
            when(parkingSlot.getSlotOfTheVehiclePresent(any(Vehicle.class))).thenReturn(vehiclesSlot);
            Assert.assertEquals(3,vehiclesSlot.listOfVehiclesInSlot.size());
            Vehicle unparkedVehicle = parkingLot.unParkTheVehicle(new Vehicle("KA04HB021"));
            Assert.assertEquals("KA04HB021",unparkedVehicle.getVehicleNumber());
            Assert.assertEquals(2,vehiclesSlot.listOfVehiclesInSlot.size());
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenVehiclesObjectAsNull_whenUnparked_shouldThrowException() {
        try{
            parkingLot.unParkTheVehicle(null);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehiclesDetailsEmpty_whenUnparked_shouldThrowException() {
        try{
            parkingLot.unParkTheVehicle(new Vehicle(""));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehiclesDetailsNull_whenUnparked_shouldThrowException() {
        try{
            parkingLot.unParkTheVehicle(new Vehicle(null));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenListOfVehicles_whenSearched_shouldReturnTotalVehiclesPresent() {
        List<Vehicle> listOfVehiclesPresent=new ArrayList<>();
        listOfVehiclesPresent.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB1663",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
        when(parkingSlot.getVehicleDetails()).thenReturn(listOfVehiclesPresent);
        Assert.assertEquals(8,parkingLot.getDetails().totalVehiclesPresent.size());
    }

    @Test
    public void givenListOfVehicles_whenSearchedByWhiteColor_shouldReturnMatchingCars() {
        List<Vehicle> listOfVehiclesPresent=new ArrayList<>();
        listOfVehiclesPresent.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.TOYOTA));
        listOfVehiclesPresent.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.RED,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA));
        listOfVehiclesPresent.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.TOYOTA));
        listOfVehiclesPresent.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB1663",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA));
        when(parkingSlot.getVehicleDetails()).thenReturn(listOfVehiclesPresent);
        List<Vehicle> listOfVehicles=parkingLot.getDetails().selectByColor(Vehicle.VehicleColor.WHITE).
                totalVehiclesPresent;
        Assert.assertEquals(3,listOfVehicles.size());
        Assert.assertEquals("KA04HB1234",listOfVehicles.get(0).getVehicleNumber());
        Assert.assertEquals("KA04HB163",listOfVehicles.get(1).getVehicleNumber());
        Assert.assertEquals("KA04HB1663",listOfVehicles.get(2).getVehicleNumber());
    }

    @Test
    public void givenListOfVehicles_whenSearchedByColorAndBrand_shouldReturnMatchingCars() {
        List<Vehicle> listOfVehiclesPresent=new ArrayList<>();
        listOfVehiclesPresent.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.TOYOTA));
        listOfVehiclesPresent.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.RED,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.TOYOTA));
        listOfVehiclesPresent.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.TOYOTA));
        listOfVehiclesPresent.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB1663",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.TOYOTA));
        when(parkingSlot.getVehicleDetails()).thenReturn(listOfVehiclesPresent);
        List<Vehicle> listOfVehicles=parkingLot.getDetails().selectByColor(Vehicle.VehicleColor.BLUE).
                selectByName(Vehicle.VehicleName.TOYOTA).totalVehiclesPresent;
        Assert.assertEquals(3,listOfVehicles.size());
        Assert.assertEquals("KA04HB134",listOfVehicles.get(0).getVehicleNumber());
        Assert.assertEquals("KA04HB1134",listOfVehicles.get(1).getVehicleNumber());
        Assert.assertEquals("KA04HB1663",listOfVehicles.get(2).getVehicleNumber());
    }

    @Test
    public void givenListOfVehicles_whenSearchedByBMW_shouldReturnMatchingCars() {
        List<Vehicle> listOfVehiclesPresent=new ArrayList<>();
        listOfVehiclesPresent.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.MARUTI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.BMW));
        listOfVehiclesPresent.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.RED,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.BMW));
        listOfVehiclesPresent.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.GREEN,Vehicle.VehicleName.TOYOTA));
        listOfVehiclesPresent.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.TOYOTA));
        listOfVehiclesPresent.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.HYUNDAI));
        listOfVehiclesPresent.add(new Vehicle("KA04HB1663",Driver.NORMAL,VehicleSize.LARGE,
                Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.BMW));
        when(parkingSlot.getVehicleDetails()).thenReturn(listOfVehiclesPresent);
        List<Vehicle> listOfVehicles=parkingLot.getDetails().
                selectByName(Vehicle.VehicleName.BMW).totalVehiclesPresent;
        Assert.assertEquals(3,listOfVehicles.size());
        Assert.assertEquals("KA04HB134",listOfVehicles.get(0).getVehicleNumber());
        Assert.assertEquals("KA04HB13",listOfVehicles.get(1).getVehicleNumber());
        Assert.assertEquals("KA04HB1663",listOfVehicles.get(2).getVehicleNumber());
    }

    @Test
    public void givenVehicleWithName_whenQueried_shouldReturnCarParkedInLast30mins() {
        List<Vehicle> listOfVehiclesPresent=new ArrayList<>();
        listOfVehiclesPresent.add(new Vehicle("KA04HB124",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.BLUE,Vehicle.VehicleName.BMW).setDuration(21));
        listOfVehiclesPresent.add(new Vehicle("KA04HL1054",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA).setDuration(30));
        listOfVehiclesPresent.add(new Vehicle("KA04HL1025",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA).setDuration(60));
        listOfVehiclesPresent.add(new Vehicle("KA04HL1026",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA).setDuration(20));
        listOfVehiclesPresent.add(new Vehicle("KA04HL1027",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.TOYOTA).setDuration(50));
        when(parkingSlot.getVehicleDetails()).thenReturn(listOfVehiclesPresent);
            List<Vehicle> listOfVehiclesParkedIn30Minutes =parkingLot.getDetails().
                    selectByDuration(30).totalVehiclesPresent;
            Assert.assertEquals("KA04HL1026",listOfVehiclesParkedIn30Minutes.get(2).getVehicleNumber());
            Assert.assertEquals("KA04HL1054",listOfVehiclesParkedIn30Minutes.get(1).getVehicleNumber());
            Assert.assertEquals("KA04HB124",listOfVehiclesParkedIn30Minutes.get(0).getVehicleNumber());
            Assert.assertEquals(3,listOfVehiclesParkedIn30Minutes.size());
        }

    @Test
    public void givenVehicleWithName_whenQueried_shouldReturnVehiclesOfSlot2() {
        List<Vehicle> listOfVehiclesPresent=new ArrayList<>();
        Vehicle vehicle1=new Vehicle("KA04HL1027",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW);
        Vehicle vehicle2=new Vehicle("KA04HL107",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW);
        Vehicle vehicle3=(new Vehicle("KA04HL127",Driver.HANDICAPPED,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
        Vehicle vehicle4=(new Vehicle("KA04HL1037",Driver.HANDICAPPED,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
        Vehicle vehicle5=(new Vehicle("KA04HL1327",Driver.HANDICAPPED,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
        Vehicle vehicle6=(new Vehicle("KA04HB124",Driver.HANDICAPPED,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
        Vehicle vehicle7=(new Vehicle("KA04HL1054",Driver.HANDICAPPED,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
        Vehicle vehicle8=(new Vehicle("KA04HL1025",Driver.HANDICAPPED,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
        Vehicle vehicle9=(new Vehicle("KA04HL1026",Driver.NORMAL,VehicleSize.MEDIUM,
                    Vehicle.VehicleColor.RED,Vehicle.VehicleName.BMW));
        vehicle1.setSpotNumber(2);
        vehicle2.setSpotNumber(4);
        vehicle3.setSpotNumber(2);
        vehicle4.setSpotNumber(3);
        vehicle5.setSpotNumber(2);
        vehicle6.setSpotNumber(1);
        vehicle7.setSpotNumber(2);
        vehicle8.setSpotNumber(4);
        vehicle9.setSpotNumber(3);
        listOfVehiclesPresent.add(vehicle1);
        listOfVehiclesPresent.add(vehicle2);
        listOfVehiclesPresent.add(vehicle3);
        listOfVehiclesPresent.add(vehicle4);
        listOfVehiclesPresent.add(vehicle5);
        listOfVehiclesPresent.add(vehicle6);
        listOfVehiclesPresent.add(vehicle7);
        listOfVehiclesPresent.add(vehicle8);
        listOfVehiclesPresent.add(vehicle9);
        when(parkingSlot.getVehicleDetails()).thenReturn(listOfVehiclesPresent);
        List<Vehicle> listOfVehiclesPresentAtBSlot =parkingLot.getDetails().
                    selectBySize(2).selectBySpotNumber(2).selectByDriverType(Driver.HANDICAPPED).totalVehiclesPresent;
        List<Vehicle> listOfVehiclesPresentAtDSlot =parkingLot.getDetails().
                    selectBySize(2).selectBySpotNumber(4).selectByDriverType(Driver.HANDICAPPED).totalVehiclesPresent;
        Assert.assertEquals(1,listOfVehiclesPresentAtDSlot.size());
        Assert.assertEquals(3,listOfVehiclesPresentAtBSlot.size());
        Assert.assertEquals("KA04HL1025",listOfVehiclesPresentAtDSlot.get(0).getVehicleNumber());
        Assert.assertEquals("KA04HL127",listOfVehiclesPresentAtBSlot.get(0).getVehicleNumber());
        Assert.assertEquals("KA04HL1327",listOfVehiclesPresentAtBSlot.get(1).getVehicleNumber());
        Assert.assertEquals("KA04HL1054",listOfVehiclesPresentAtBSlot.get(2).getVehicleNumber());
    }

    @Test
    public void givenVehicleOfLargeSize_whenParkingSpaceNotAvailable_shouldReturnShuffledList() {

    }
}




