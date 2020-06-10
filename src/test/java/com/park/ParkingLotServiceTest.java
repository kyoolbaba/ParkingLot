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

    @Test
    public void givenVehicle_whenUnParked_shouldReturnTrue() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            boolean park=parkingLotService.parkTheVehicle("KA04HB1234");
            boolean park1=parkingLotService.parkTheVehicle("KA03HB1234");
            boolean unpark=parkingLotService.unparkTheVehicle("KA03HB1234");
            Assert.assertTrue(unpark);
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenVehicleNotPresent_whenUnParked_shouldThrowException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            boolean park=parkingLotService.parkTheVehicle("KA04HB1234");
            boolean park1=parkingLotService.parkTheVehicle("KA03HB1234");
            boolean unpark=parkingLotService.unparkTheVehicle("KA03HB1004");
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT,e.type);
        }
    }

    @Test
    public void givenVehicleAsEmpty_whenUnParked_shouldThrowException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            boolean park=parkingLotService.parkTheVehicle("KA04HB1234");
            boolean park1=parkingLotService.parkTheVehicle("KA03HB1234");
            boolean unpark=parkingLotService.unparkTheVehicle("");
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicleAsNull_whenUnParked_shouldThrowException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            boolean park=parkingLotService.parkTheVehicle("KA04HB1234");
            boolean park1=parkingLotService.parkTheVehicle("KA03HB1234");
            boolean unpark=parkingLotService.unparkTheVehicle(null);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicle_whenParkingLotFull_shouldThrowException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(2);
            boolean park=parkingLotService.parkTheVehicle("KA04HB1234");
            boolean park1=parkingLotService.parkTheVehicle("KA03HB1234");
            boolean checkAvailability=parkingLotService.checkAvailability();
            Assert.assertFalse(checkAvailability);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }




}
