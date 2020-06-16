package com.park;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ParkingSlotTest {

    @Mock
    ParkingSpot parkingSpot;

    @Mock
    ParkingLot parkingLot;

    @InjectMocks
    ParkingSlot parkingSlot;

    @Test
    public void givenVehicle_whenParkedTheVehicle_ShouldAddTheVehicleIntheSlot() {
        try {
            List<ParkingSlot> listOfParkingSlots = new ArrayList();
             Vehicle vehicle1=new Vehicle("KA04HB21",Driver.NORMAL,VehicleSize.SMALL
                     , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
            Vehicle vehicle2=new Vehicle("KA04HB021",Driver.NORMAL,VehicleSize.SMALL
                    , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
            Vehicle vehicle3=new Vehicle("KA04HB221",Driver.NORMAL,VehicleSize.SMALL
                    , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
             ParkingSlot parkingSlot1 = new ParkingSlot(3, 2, 3, 1);
             ParkingSlot parkingSlot2 = new ParkingSlot(2,  3, 1);
            listOfParkingSlots.add(parkingSlot1);
            listOfParkingSlots.add(parkingSlot2);
             when(parkingLot.checkVehiclePresent(vehicle1)).thenReturn(false);
             when(parkingLot.checkParkingFullOrNot()).thenReturn(false);
             when(parkingLot.assignLot(any(Vehicle.class))).thenReturn(parkingSlot2);
             doNothing().when(parkingSpot).assignLotNumber(any(int[].class),any(Vehicle.class),any(Integer[].class));
             parkingSlot.parkTheVehicle(vehicle1);
             parkingSlot.parkTheVehicle(vehicle2);
             parkingSlot.parkTheVehicle(vehicle3);
            Assert.assertEquals(3,parkingSlot2.listOfParkingLots.size());
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicleObjectNull_whenAdded_shouldThrowException() {
        try {
            parkingSlot.parkTheVehicle(null);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicleNumberEmpty_whenAdded_shouldThrowException() {
        try {
            parkingSlot.parkTheVehicle(new Vehicle("",Driver.NORMAL,VehicleSize.LARGE,Vehicle.VehicleColor
                    .BLACK,Vehicle.VehicleName.BMW));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicleNumberNull_whenAdded_shouldThrowException() {
        try {
            parkingSlot.parkTheVehicle(new Vehicle(null,Driver.NORMAL,VehicleSize.LARGE,Vehicle.VehicleColor
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
            ParkingSlot vehiclesSlot=new ParkingSlot();
            vehiclesSlot.listOfParkingLots=listOfVehiclesInSlot;
            vehiclesSlot.slots=new int[3];
            vehiclesSlot.slotCapacity= new Integer[]{1,2,3};
            when(parkingLot.checkVehiclePresent(new Vehicle("KA04HB021"))).thenReturn(true);
            when(parkingLot.checkParkingFullOrNot()).thenReturn(false);
            when(parkingLot.getLotOfTheVehiclePresent(any(Vehicle.class))).thenReturn(vehiclesSlot);
            Assert.assertEquals(3,vehiclesSlot.listOfParkingLots.size());
            Vehicle unparkedVehicle = parkingSlot.unparkTheVehicle(new Vehicle("KA04HB021"));
            Assert.assertEquals("KA04HB021",unparkedVehicle.getVehicleNumber());
            Assert.assertEquals(2,vehiclesSlot.listOfParkingLots.size());
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenVehiclesObjectAsNull_whenUnparked_shouldThrowException() {
        try{
            parkingSlot.unparkTheVehicle(null);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehiclesDetailsEmpty_whenUnparked_shouldThrowException() {
        try{
            parkingSlot.unparkTheVehicle(new Vehicle(""));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehiclesDetailsNull_whenUnparked_shouldThrowException() {
        try{
            parkingSlot.unparkTheVehicle(new Vehicle(null));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }


}




