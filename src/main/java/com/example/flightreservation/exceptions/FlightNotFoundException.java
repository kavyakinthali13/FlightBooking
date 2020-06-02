package com.example.flightreservation.exceptions;

@SuppressWarnings("serial")
public class FlightNotFoundException extends Exception {

	public FlightNotFoundException(String string) {
		super(string);
	}

}
