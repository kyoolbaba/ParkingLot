package com.park;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

public class ParkingLotTest {

    @Mock
    ParkingLotOwner parkingLotOwner;

    @InjectMocks
    ParkingLot parkingLot;

    @Test
    public void name() {
        try{
            ParkingLot parkingLot = new ParkingLot(2,1,3);
        //    when(parkingLotOwner.
          //  parkingLot.parkTheVehicle();
        }catch(ParkingLotException e){}
    }
}
