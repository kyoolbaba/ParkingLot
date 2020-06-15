package com.park;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ParkingSlotTest {

    @Mock
    ParkingLotOwner parkingLotOwner;

    @InjectMocks
    ParkingSlot parkingSlot;

    @Test
    public void name() {
        try{
            ParkingSlot parkingSlot = new ParkingSlot(2,1,3);
        //    when(parkingLotOwner.
          //  parkingLot.parkTheVehicle();
        }catch(ParkingLotException e){}
    }
}
