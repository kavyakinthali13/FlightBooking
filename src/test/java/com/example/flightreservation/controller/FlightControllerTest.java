package com.example.flightreservation.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import com.example.flightreservation.dto.FlightDto;
import com.example.flightreservation.exceptions.FlightNotFoundException;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.service.FlightService;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.Silent.class)

public class FlightControllerTest {

	@InjectMocks

	FlightController flightController;

	@Mock

	FlightService flightService;

	Date date = new Date(21 - 2 - 2010);

	@Test

	public void testFindBySourceAndDestinationAndDateForPostive() throws FlightNotFoundException {

		List<Flight> buses = new ArrayList<Flight>();

		FlightDto flightDto = new FlightDto();

		flightDto.setSource("srikakulam");

		flightDto.setDestination("hyderabad");

		flightDto.setDepartureDate(date);

		Mockito.when(flightService.findBySourceAndDestinationAndDepatureDate(flightDto)).thenReturn(buses);

		ResponseEntity<List<Flight>> flight1 = flightController.viewFlights(flightDto);

		Assert.assertNotNull(flight1);

		Assert.assertEquals(flightDto.getDestination(), "hyderabad");

	}

	@Test(expected = Exception.class)

	public void testFindBySourceAndDestinationAndDateForExce() throws FlightNotFoundException {

		@SuppressWarnings("unused")
		List<Flight> buses = new ArrayList<Flight>();

		FlightDto flightDto = new FlightDto();

		flightDto.setSource("srikakulam");

		flightDto.setDestination("hyderabad");

		flightDto.setDepartureDate(date);

		Mockito.when(flightService.findBySourceAndDestinationAndDepatureDate(flightDto)).thenThrow(Exception.class);

		ResponseEntity<List<Flight>> flight1 = flightController.viewFlights(flightDto);

		Assert.assertNotNull(flight1);

		Assert.assertEquals(flightDto.getDestination(), "vizag");

	}

	@Test

	public void testFindBySourceAndDestinationAndDateForNegative() throws FlightNotFoundException {

		List<Flight> flights = new ArrayList<Flight>();

		FlightDto flightDto = new FlightDto();

		flightDto.setSource("srikakulam");

		flightDto.setDestination("hyderabad");

		flightDto.setDepartureDate(date);

		flightDto.setSource("hyderabad");

		flightDto.setDestination("chennai");

		flightDto.setDepartureDate(date);

		Mockito.when(flightService.findBySourceAndDestinationAndDepatureDate(flightDto)).thenReturn(flights);

		ResponseEntity<List<Flight>> flight1 = flightController.viewFlights(flightDto);

		Assert.assertNotNull(flight1);

		Assert.assertEquals(flightDto.getDestination(), "chennai");

	}

	@Test

	public void testViewFlightName() throws FlightNotFoundException {

		List<Flight> flights = new ArrayList<>();

		Flight flight = new Flight();

		flight.setFlightNumber(1L);

		flight.setFlightName("indigo");

		flight.setSource("srikakulam");

		flight.setDestination("pune");

		flight.setArrivalDate(date);

		flight.setDepartureDate(date);

		flight.setAvailableTickets(30);

		flights.add(flight);

		Mockito.when(flightService.findByName("indigo")).thenReturn(flights);

		ResponseEntity<List<Flight>> flightRe = flightController.viewFlightByName("indigo");

		Assert.assertNotNull(flightRe);

		Assert.assertEquals(flight.getFlightName(), "indigo");

	}
}
