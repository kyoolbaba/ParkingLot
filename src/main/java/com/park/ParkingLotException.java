package com.park;

public class ParkingLotException extends Exception{

    enum ExceptionType{
        PARKING_IS_FULL,INCOMPLETE_DETAILS,VEHICLE_ALREADY_IN,VEHICLE_NOT_PRESENT
        ,INVALID_PARKINGLOT_INPUT,PARKING_SIZE_NOT_AVAILABLE
    }
    ExceptionType type;

    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

}
