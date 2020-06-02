package com.example.flightreservation.exceptions;

@SuppressWarnings("serial")
public class InsufficientBalance extends Exception {
	
	public InsufficientBalance(String string) {
		super("entered amount is greater than the available balance");

	}

}
