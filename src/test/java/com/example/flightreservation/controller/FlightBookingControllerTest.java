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

import com.example.flightreservation.dto.ResponseDto;
import com.example.flightreservation.dto.TicketDto;
import com.example.flightreservation.exceptions.AccountDetailsNotFoundException;
import com.example.flightreservation.exceptions.BookingDetailsNotFoundException;
import com.example.flightreservation.exceptions.FlightNotFoundException;
import com.example.flightreservation.exceptions.InsufficientBalance;
import com.example.flightreservation.exceptions.SeatsNotAvailbleException;
import com.example.flightreservation.exceptions.TicketsNotFoundException;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.model.Passenger;
import com.example.flightreservation.model.Ticket;
import com.example.flightreservation.service.FlightBookingService;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.Silent.class)
public class FlightBookingControllerTest {

	@InjectMocks
	FlightBookingController flightBookingController;

	@Mock
	FlightBookingService flightBookingService;

	Ticket ticket = new Ticket();
	TicketDto ticketDto = new TicketDto();
	Passenger passenger = new Passenger();
	List<Passenger> passengers = new ArrayList<>();
	Flight flight = new Flight();
	Date date = new Date(12 - 2 - 2020);

	@Test
	public void testSaveTicketForPositive() throws BookingDetailsNotFoundException, SeatsNotAvailbleException,
			AccountDetailsNotFoundException, InsufficientBalance, FlightNotFoundException, TicketsNotFoundException {
		ticket.setTicketId(1l);
		ticket.setReservationDate(date);
		passenger.setPassengerId(1l);
		passenger.setFirstname("sai");
		passenger.setLastname("kumar");
		passenger.setEmail("sai@gmail.com");
		passenger.setPassword("123sai");
		passenger.setPhoneNumber("9666168535");
		passengers.add(passenger);
		flight.setAvailableTickets(12);
		flight.setDepartureDate(date);
		flight.setArrivalDate(date);
		flight.setDestination("chennai");
		flight.setSource("tpt");
		flight.setFlightName("indigoo");
		flight.setFlightNumber(1l);
		flight.setFlightFare(1200l);
		ticketDto.setTicketId(1l);
		ticketDto.setFlight(flight);
		ticketDto.setPassengers(passengers);;
		ticketDto.setNumberOfTickets(8);
		Mockito.when(flightBookingService.bookTicket(ticketDto)).thenReturn((ticket));
		ResponseEntity<ResponseDto> resTicket = flightBookingController.ticketBooking(ticketDto);
		Assert.assertNotNull(resTicket);
	}

	@Test
	public void testSaveTicketForNegitve() throws BookingDetailsNotFoundException, SeatsNotAvailbleException,
			AccountDetailsNotFoundException, InsufficientBalance, FlightNotFoundException, TicketsNotFoundException {
		ticket.setTicketId(1l);
		ticket.setReservationDate(date);
		passenger.setPassengerId(1l);
		passenger.setFirstname("sai");
		passenger.setLastname("kumar");
		passenger.setEmail("sai@gmail.com");
		passenger.setPassword("123sai");
		passenger.setPhoneNumber("9666168535");
		passengers.add(passenger);
		flight.setAvailableTickets(12);
		flight.setDepartureDate(date);
		flight.setArrivalDate(date);
		flight.setDestination("chennai");
		flight.setSource("tpt");
		flight.setFlightName("indigoo");
		flight.setFlightNumber(1l);
		flight.setFlightFare(1200l);
		ticketDto.setTicketId(1l);
		ticketDto.setFlight(flight);
		ticketDto.setPassengers(passengers);
		ticketDto.setNumberOfTickets(8);
		Mockito.when(flightBookingService.bookTicket(Mockito.any(TicketDto.class))).thenReturn((ticket));
		ResponseEntity<ResponseDto> resTicket = flightBookingController.ticketBooking(ticketDto);
		Assert.assertNotNull(resTicket);
	}


	@Test(expected=NullPointerException.class)
	public void testticketBookingForException() throws BookingDetailsNotFoundException, SeatsNotAvailbleException, AccountDetailsNotFoundException, InsufficientBalance, FlightNotFoundException, TicketsNotFoundException{
		Mockito.when(flightBookingService.bookTicket(Mockito.any(TicketDto.class))).thenThrow(NullPointerException.class);
		@SuppressWarnings("unused")
		ResponseEntity<ResponseDto> resTicket = flightBookingController.ticketBooking(ticketDto);
		Assert.assertNotNull(resTicket);

	}
}
		  
	