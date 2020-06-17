package com.park;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParkingSpotTest {

    @InjectMocks
    ParkingSpot parkingSpot;

    @Test
    public void given1VehicleDetails_whenParked_shouldReturnLastSlotNumber() {
        int[] slots=new int[3];
        Integer[] slotCapacity=new Integer[]{3,2,4};
        Vehicle vehicle=new Vehicle("KA04HB21",Driver.NORMAL,VehicleSize.MEDIUM
                , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
        parkingSpot.assignSpotNumber(slots,vehicle,slotCapacity);
        Assert.assertEquals(3,vehicle.getSpotNumber());
        Assert.assertEquals(2,slots[2]);
    }

    @Test
    public void givenVehicleDetailsOfHandiCappedDriver_whenParked_shouldReturnFirstLotNumber() {
        int[] slots=new int[3];
        Integer[] slotCapacity=new Integer[]{3,2,4};
        Vehicle vehicle=new Vehicle("KA04HB6501",Driver.HANDICAPPED,VehicleSize.LARGE
                , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
        parkingSpot.assignSpotNumber(slots,vehicle,slotCapacity);
        Assert.assertEquals(1,vehicle.getSpotNumber());
        Assert.assertEquals(3,slots[0]);
    }

    @Test
    public void given2VehicleDetails_whenParked_shouldReturnLastSlotNumber() {
        int[] slots=new int[3];
        Integer[] slotCapacity=new Integer[]{3,2,4};
        Vehicle vehicle=new Vehicle("KA04HB21",Driver.NORMAL,VehicleSize.MEDIUM
                , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
        Vehicle vehicle1=new Vehicle("KA04HB21",Driver.NORMAL,VehicleSize.MEDIUM
                , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
        parkingSpot.assignSpotNumber(slots,vehicle,slotCapacity);
        parkingSpot.assignSpotNumber(slots,vehicle1,slotCapacity);
        Assert.assertEquals(3,vehicle1.getSpotNumber());
        Assert.assertEquals(4,slots[2]);
    }

    @Test
    public void given2VehicleDetailsOfHandiCappedDriver_whenParked_shouldReturnLastSlotNumber() {
        int[] slots=new int[3];
        Integer[] slotCapacity=new Integer[]{3,2,4};
        Vehicle vehicle=new Vehicle("KA04HB21",Driver.HANDICAPPED,VehicleSize.MEDIUM
                , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
        Vehicle vehicle1=new Vehicle("KA04HB21",Driver.HANDICAPPED,VehicleSize.MEDIUM
                , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
        parkingSpot.assignSpotNumber(slots,vehicle,slotCapacity);
        parkingSpot.assignSpotNumber(slots,vehicle1,slotCapacity);
        Assert.assertEquals(1,vehicle.getSpotNumber());
        Assert.assertEquals(2,vehicle1.getSpotNumber());
        Assert.assertEquals(2,slots[1]);
        Assert.assertEquals(2,slots[0]);
    }

    @Test
    public void givenLargeVehicle_whenParked_shouldReturnSucludedSlotNumber() {
        int[] slots=new int[]{1,0,0,0,2};
        Integer[] slotCapacity=new Integer[]{3,2,4,3,2};
        Vehicle vehicle=new Vehicle("KA04HB21",Driver.NORMAL,VehicleSize.LARGE
                , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
        parkingSpot.assignSpotNumber(slots,vehicle,slotCapacity);
     //   Assert.assertEquals(1,vehicle.getSlotNumber());
        Assert.assertEquals(3,vehicle.getSpotNumber());
        //Assert.assertEquals(2,slots[1]);
       // Assert.assertEquals(2,slots[0]);
    }

    @Test
    public void givenLargeVehicle_whenParked_shouldReturnFirstSlotNumber() {
        int[] slots=new int[]{0,1,2,0,2};
        Integer[] slotCapacity=new Integer[]{3,2,4,3,2};
        Vehicle vehicle=new Vehicle("KA04HB21",Driver.NORMAL,VehicleSize.LARGE
                , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
        parkingSpot.assignSpotNumber(slots,vehicle,slotCapacity);
        Assert.assertEquals(1,vehicle.getSpotNumber());
    }

    @Test
    public void givenLargeVehicle_whenParked_shouldReturnLastSlotNumber() {
        int[] slots=new int[]{1,1,0,0,0};
        Integer[] slotCapacity=new Integer[]{3,2,4,3,3};
        Vehicle vehicle=new Vehicle("KA04HB21",Driver.NORMAL,VehicleSize.LARGE
                , Vehicle.VehicleColor.WHITE,Vehicle.VehicleName.MARUTI);
        parkingSpot.assignSpotNumber(slots,vehicle,slotCapacity);
        Assert.assertEquals(5,vehicle.getSpotNumber());
    }

}
