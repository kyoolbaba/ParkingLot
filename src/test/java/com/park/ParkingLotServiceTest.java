package com.park;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotServiceTest {

    @Test
    public void givenOneVehicle_whenParked_shouldReturnTrue() {
        try {
            ParkingLotService parkingLotService = new ParkingLotService(50);
            int lotNumber = parkingLotService.entry(new Vehicle("KA04HB124"));
            Assert.assertEquals(50,lotNumber);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenTwoVehicle_whenRemovingFirstVehicleAndAddingANotherVehicle_shouldLotNumber() {
        try {
            ParkingLotService parkingLotService = new ParkingLotService(50);
            int lotNumber = parkingLotService.entry(new Vehicle("KA04HB124"));
            parkingLotService.entry(new Vehicle("KA04HB1024"));
            parkingLotService.exit(new Vehicle("KA04HB124"));
            int lotNumber1 = parkingLotService.entry(new Vehicle("KA03HB124"));
            Assert.assertEquals(50,lotNumber1);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN,e.type);
        }
    }

    @Test
    public void givenTwoVehicle_whenRemovingFirstVehicleAndAddingAnotherVehicle_shouldLotNumber() {
        try {
            ParkingLotService parkingLotService = new ParkingLotService(50);
            int lotNumber = parkingLotService.entry(new Vehicle("KA04HB124"));
            parkingLotService.entry(new Vehicle("KA04HB1024"));
            parkingLotService.exit(new Vehicle("KA04HB124"));
            int lotNumber1 = parkingLotService.entry(new Vehicle("KA03HB124"));
            int lotNumber2=parkingLotService.entry(new Vehicle("KA03HB1244"));
            Assert.assertEquals(48,lotNumber2);
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenTwoVehicle_whenParked_shouldReturnTrue() {
        try {
            ParkingLotService parkingLotService = new ParkingLotService(50);
            int lotNumber = parkingLotService.entry(new Vehicle("KA04HB124"));
            int lotNumber1 = parkingLotService.entry(new Vehicle("KA04HB1234"));
            Assert.assertEquals(49,lotNumber1);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenPersonVehicleAsNull_whenParked_shouldReturnTrue() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            int lotNumber=parkingLotService.entry(null);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenSameVehicleTwice_whenParked_shouldReturnTrue() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            int lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234"));
            int lotNumber1=parkingLotService.entry(new Vehicle("KA04HB1234"));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN,e.type);
        }
    }

    @Test
    public void givenVehicle_whenUnParked_shouldReturnTrue() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            int lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234"));
            int lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234"));
            boolean unpark=parkingLotService.exit(new Vehicle("KA03HB1234"));
            Assert.assertTrue(unpark);
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenVehicleNotPresent_whenUnParked_shouldThrowException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            int lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234"));
            int lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234"));
            boolean unpark=parkingLotService.exit(new Vehicle("KA03HB1004"));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT,e.type);
        }
    }

    @Test
    public void givenVehicleAsEmpty_whenUnParked_shouldThrowException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            int lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234"));
            int lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234"));
            boolean unpark=parkingLotService.exit(new Vehicle(""));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicleAsNull_whenUnParked_shouldThrowException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            int lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234"));
            int lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234"));
            boolean unpark=parkingLotService.exit(null);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicle_whenParkingLotFull_shouldThrowException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(2);
            int lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234"));
            int lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234"));
            boolean checkAvailability=parkingLotService.checkAvailability();
            Assert.assertFalse(checkAvailability);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicle_whenParkingLotFull_shouldReturnRedirectStaffAsTrue() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(2);
            int lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234"));
            int lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234"));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicle_whenParkingLotNotFull_shouldReturnRedirectStaffAsFalse() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(3);
            int lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234"));
            int lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234"));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

}
