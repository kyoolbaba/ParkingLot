package com.park;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotServiceTest {

    @Test
    public void givenOneVehicle_whenParked_shouldReturnCharges() {
        try {
            ParkingLotService parkingLotService = new ParkingLotService(50);
            double charges = parkingLotService.entry(new Vehicle("KA04HB124",3));
            Assert.assertEquals(30.0,charges,0.5);
        }catch(ParkingLotException e){}
    }

    @Test
    public void givenTwoVehicle_whenRemovedFirstVehicleAndAddingAnotherVehicle_shouldReturnLastLotNumber() {
        try {
            ParkingLotService parkingLotService = new ParkingLotService(50);
            parkingLotService.entry(new Vehicle("KA04HB124",6));
            parkingLotService.entry(new Vehicle("KA04HB1024",4));
            parkingLotService.exit(new Vehicle("KA04HB124"));
            parkingLotService.entry(new Vehicle("KA03HB124",4));
            Assert.assertEquals(50,parkingLotService.exit(new Vehicle("KA03HB124")),0.2);
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenTwoVehicle_whenParked_shouldReturnTrue() {
        try {
            ParkingLotService parkingLotService = new ParkingLotService(50);
            parkingLotService.entry(new Vehicle("",5));
            double charges = parkingLotService.entry(new Vehicle("KA04HB1234"));
        }catch(ParkingLotException e){
        Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenPersonVehicleAsNull_whenParked_shouldReturnTrue() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            double lotNumber=parkingLotService.entry(null);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenSameVehicleTwice_whenParked_shouldReturnTrue() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            double lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234",5));
            double lotNumber1=parkingLotService.entry(new Vehicle("KA04HB1234",5));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_ALREADY_IN,e.type);
        }
    }

    @Test
    public void givenVehicle_whenUnParked_shouldReturnItsLotNumber() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            double lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234",7));
            double lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234",9));
            int unpark=parkingLotService.exit(new Vehicle("KA04HB1234"));
            Assert.assertEquals(50,unpark);
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenVehicleNotPresent_whenUnParked_shouldThrowException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            parkingLotService.entry(new Vehicle("KA04HB1234",5));
            parkingLotService.entry(new Vehicle("KA03HB1234",6));
            int unpark=parkingLotService.exit(new Vehicle("KA03HB1004"));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT,e.type);
        }
    }

    @Test
    public void givenVehicleAsEmpty_whenUnParked_shouldThrowException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            double lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234",1));
            double lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234",2));
            int unpark=parkingLotService.exit(new Vehicle(""));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicleAsNull_whenUnParked_shouldThrowException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(50);
            double lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234",6));
            double lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234",3));
            int unpark=parkingLotService.exit(null);
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.INCOMPLETE_DETAILS,e.type);
        }
    }

    @Test
    public void givenVehicle_whenParkingLotFull_shouldReturnAvailabilityAsFalse() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(2);
            double lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234",1));
            double lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234",1));
            boolean checkAvailability=parkingLotService.checkAvailability();
            Assert.assertFalse(checkAvailability);
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicle_whenParkingLotFull_shouldReturnAvailabilityAsTrue() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(3);
            double lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234",1));
            double lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234",1));
            boolean checkAvailability=parkingLotService.checkAvailability();
            Assert.assertTrue(checkAvailability);
        }catch(ParkingLotException e){

        }
    }

    @Test
    public void givenVehicle_whenParkingLotNotFull_shouldReturnOccupiedLotsPositiveTesting() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(3);
            double lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234",1));
            double lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234",2));
            Assert.assertEquals(2, parkingLotService.getNumberOfOccupiedLots());
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenVehicle_whenParkingLotNotFull_shouldReturnOccupiedLotsNegativeTesting() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(3);
            double lotNumber=parkingLotService.entry(new Vehicle("KA04HB1234",1));
            double lotNumber1=parkingLotService.entry(new Vehicle("KA03HB1234",2));
            Assert.assertNotEquals(3, parkingLotService.getNumberOfOccupiedLots());
        }catch(ParkingLotException e){
        }
    }

    @Test
    public void givenVehicle_whenParkingLotIsFullParkingAnotherVehicle_shouldThrowParkingFullException() {
        try{
            ParkingLotService parkingLotService = new ParkingLotService(2);
            parkingLotService.entry(new Vehicle("KA04HB1234",1));
            parkingLotService.entry(new Vehicle("KA03HB1234",2));
            parkingLotService.entry(new Vehicle("KA03HV1234",2));
        }catch(ParkingLotException e){
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_IS_FULL,e.type);
        }
    }

}
