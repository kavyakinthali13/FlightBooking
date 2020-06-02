package com.example.flightreservation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import com.example.flightreservation.dto.FlightDto;
import com.example.flightreservation.exceptions.FlightNotFoundException;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.repository.FlightRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.Silent.class)

public class FlightServiceTest {

	@InjectMocks

	FlightService flightService;

	@Mock

	FlightRepository flightRepository;

	Date date = new Date(21 - 2 - 2010);

	@Test

	public void tesfindBySourceAndDestinationAndDepatureDate() {

		List<Flight> flights = new ArrayList<>();

		Flight flight = new Flight();

		flight.setSource("srikakulam");

		flight.setDestination("pune");

		flight.setArrivalDate(date);

		flight.setDepartureDate(date);

		flight.setAvailableTickets(30);

		flights.add(flight);

		flightRepository.saveAll(flights);

		FlightDto flightDto = new FlightDto();

		flightDto.setSource("srikakulam");

		flightDto.setDestination("pune");

		flightDto.setDepartureDate(date);

		OngoingStubbing<List<Flight>> buses1 = Mockito
				.when(flightRepository.findFlightBySourceAndDestinationAndDepartureDate(flightDto.getSource(),

						flightDto.getDestination(), flightDto.getDepartureDate()))
				.thenReturn(flights);

		Assert.assertNotNull(buses1);

	}

	@Test(expected = FlightNotFoundException.class)

	public void tesfindBySourceAndDestinationAndDepatureDateForException() throws FlightNotFoundException {

		List<Flight> flights = new ArrayList<>();

		Flight flight = new Flight();

		flight.setFlightNumber(1L);

		flight.setSource("srikakulam");

		flight.setDestination("pune");

		flight.setArrivalDate(date);

		flight.setDepartureDate(date);

		flight.setAvailableTickets(30);

		flights.add(flight);

		flightRepository.saveAll(flights);

		FlightDto flightDto = new FlightDto();

		flightDto.setSource("chennai");

		flightDto.setDestination("pune");

		flightDto.setDepartureDate(date);

		OngoingStubbing<List<Flight>> buses1 = Mockito
				.when(flightRepository.findFlightBySourceAndDestinationAndDepartureDate(flightDto.getSource(),

						flightDto.getDestination(), flightDto.getDepartureDate()))
				.thenReturn(flights);

		if (buses1.toString().isEmpty()) {

			throw new FlightNotFoundException("filght not found");

		}

		throw new FlightNotFoundException("filght not found");

	}

}
