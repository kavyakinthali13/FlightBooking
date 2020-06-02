package com.example.flightreservation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.flightreservation.dto.TicketResponseDto;
import com.example.flightreservation.exceptions.TicketIdNotFoundException;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.model.Passenger;
import com.example.flightreservation.model.Ticket;
import com.example.flightreservation.repository.FlightRepository;
import com.example.flightreservation.repository.TicketsRepository;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.Silent.class)

public class TicketServiceTest {

	@InjectMocks

	TicketService ticketService;

	@Mock

	TicketsRepository ticketsRepository;

	@Mock

	FlightRepository flightRepository;

	@Test(expected = TicketIdNotFoundException.class)

	public void testFindByTicketId() throws TicketIdNotFoundException {
		Date date = new Date(22 - 2 - 2020);
		List<Passenger> passengers = new ArrayList<>();
		Passenger passenger = new Passenger();

		passenger.setEmail("gs@gmail.com");

		passenger.setFirstname("gs");

		passenger.setLastname("chin1");

		passenger.setPassengerId(200L);

		passenger.setPassword("hai");

		passenger.setPhoneNumber("9876543210");
		passengers.add(passenger);

		Flight flight = new Flight();

		flight.setAvailableTickets(60);

		flight.setDestination("pune");

		flight.setFlightNumber(800L);

		flight.setSource("sklm");

		flightRepository.save(flight);

		Ticket tickets = new Ticket();

		tickets.setTicketId(100L);

		tickets.setReservationDate(date);

		tickets.setNumberOfTickets(40);

		tickets.setFlight(flight);

		tickets.setPassenger(passengers);;

		ticketsRepository.save(tickets);

		tickets = ticketsRepository.findById(3000L)
				.orElseThrow(() -> new TicketIdNotFoundException("ticket with id not found"));
		/* Throw(new TicketIdNotFoundException("ticket with id not found")) */;

		TicketResponseDto ticketDto = new TicketResponseDto();

		ticketDto.setDestination("pune");

		ticketDto.setFlightId(800L);

		ticketDto.setNumberOfBookedTickets(40);

		ticketDto.setPassenger(passengers);;

		ticketDto.setReservationDate(date);

		ticketDto.setSource("sklm");

		ticketDto.setTicketId(100L);

		Assert.assertEquals(tickets.getTicketId(), ticketDto.getTicketId());

	}

}