package com.park;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ParkingLotTest {

    @Mock
    ParkingLotOwner parkingLotOwner;

    @InjectMocks
    ParkingLot parkingLot;

    @Test
    public void givenParkingLot_whenAddedVehicle_ShouldReturnParkingSlotNumber() {
        try{
            ParkingLot parkingLot = new ParkingLot(2,1,3);
            Assert.assertEquals(1,parkingLot.parkVehicle(new Vehicle("KAO4HB1234")));
        }catch(ParkingLotException e){}
    }
}
