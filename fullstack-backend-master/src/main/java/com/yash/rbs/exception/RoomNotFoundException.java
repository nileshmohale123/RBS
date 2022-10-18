package com.yash.rbs.exception;

public class RoomNotFoundException extends RuntimeException {
	
    public RoomNotFoundException(Long id){
        super("Could not found the Room with id "+ id);
    }

}
