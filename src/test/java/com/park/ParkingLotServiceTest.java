package com.park;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotServiceTest {

    @Test
    public void givenPersonVehicle_whenParked_shouldReturnTrue() {
        try {
            ParkingLotService parkingLotService = new ParkingLotService(50);
            boolean park = parkingLotService.parkTheVehicle("KA04HB124");
            Assert.assertTrue(park);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenPersonVehicleAsNull_whenParked_shouldReturnTrue() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            boolean park=parkingLotService.parkTheVehicle(null);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenSameVehicleTwice_whenParked_shouldReturnTrue() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            boolean park=parkingLotService.parkTheVehicle("KA04HB1234");
            boolean park1=parkingLotService.parkTheVehicle("KA04HB1234");
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN,e.type);
        }
    }


}
