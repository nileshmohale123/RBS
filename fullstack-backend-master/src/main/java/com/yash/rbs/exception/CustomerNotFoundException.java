package com.yash.rbs.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	 public CustomerNotFoundException(Long id){
	        super("Could not found the Customer with id "+ id);
	    }

}
