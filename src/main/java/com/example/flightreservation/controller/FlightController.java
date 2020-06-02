package com.example.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightreservation.dto.FlightDto;
import com.example.flightreservation.exceptions.FlightNotFoundException;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	FlightService flightService;

	@PostMapping("/searchflight")

	public ResponseEntity<List<Flight>> viewFlights(@RequestBody FlightDto flightDto) throws FlightNotFoundException {

		List<Flight> flights = flightService.findBySourceAndDestinationAndDepatureDate(flightDto);

		return new ResponseEntity<>(flights, HttpStatus.OK);

	}

	@GetMapping("/flight/{source}/{destination}")

	public ResponseEntity<List<Flight>> viewFlights(@PathVariable String source, @PathVariable String destination)
			throws FlightNotFoundException {

		List<Flight> flights = flightService.findBySourceAndDestination(source, destination);

		return new ResponseEntity<>(flights, HttpStatus.OK);

	}

	@GetMapping("/flight/{flightName}")

	public ResponseEntity<List<Flight>> viewFlightByName(@PathVariable String flightName) throws FlightNotFoundException {

		List<Flight> flights = flightService.findByName(flightName);

		return new ResponseEntity<>(flights, HttpStatus.OK);

	}

}
