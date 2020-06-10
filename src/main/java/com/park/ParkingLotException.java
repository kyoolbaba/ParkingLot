package com.park;

public class ParkingLotException extends Exception{

    enum ExceptionType{
        PARKING_IS_FULL,INCOMPLETE_DETAILS,VEHICLE_ALREADY_IN,VEHICLE_NOT_PRESENT
    }
    ExceptionType type;

    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

}
