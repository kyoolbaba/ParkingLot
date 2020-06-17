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
             doNothing().when(parkingSpot).assignLotNumber(any(int[].class),any(Vehicle.class),any(Integer[].class));
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
            vehicle2.setSlotNumber(2);
            listOfVehiclesInSlot.add(vehicle1);
            listOfVehiclesInSlot.add(vehicle2);
            listOfVehiclesInSlot.add(vehicle3);
            ParkingLot vehiclesSlot=new ParkingLot();
            vehiclesSlot.listOfVehiclesInSlot =listOfVehiclesInSlot;
            vehiclesSlot.slots=new int[3];
            vehiclesSlot.slotCapacity= new Integer[]{1,2,3};
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

//    @Test
//    public void givenListOfVehicles_whenSearchedByColorAndBrand_shouldReturnMatchingCars() {
//        List<Vehicle> listOfVehiclesPresent=new ArrayList<>();
//        listOfVehiclesPresent.add(new Vehicle("KA04HB1234",Driver.NORMAL,VehicleSize.LARGE,
//                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
//        listOfVehiclesPresent.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
//                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
//        listOfVehiclesPresent.add(new Vehicle("KA04HB134",Driver.NORMAL,VehicleSize.LARGE,
//                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
//        listOfVehiclesPresent.add(new Vehicle("KA04HB13",Driver.NORMAL,VehicleSize.LARGE,
//                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
//        listOfVehiclesPresent.add(new Vehicle("KA04HB163",Driver.NORMAL,VehicleSize.LARGE,
//                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
//        listOfVehiclesPresent.add(new Vehicle("KA04HB1134",Driver.NORMAL,VehicleSize.LARGE,
//                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
//        listOfVehiclesPresent.add(new Vehicle("KA04PB134",Driver.NORMAL,VehicleSize.LARGE,
//                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
//        listOfVehiclesPresent.add(new Vehicle("KA04HB1663",Driver.NORMAL,VehicleSize.LARGE,
//                Vehicle.VehicleColor.BLACK,Vehicle.VehicleName.HYUNDAI));
//        when(parkingSlot.getVehicleDetails()).thenReturn(listOfVehiclesPresent);
//        parkingLot.getDetails()
//    }
}




