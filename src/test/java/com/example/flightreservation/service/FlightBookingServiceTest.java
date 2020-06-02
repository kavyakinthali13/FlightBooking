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
import org.springframework.beans.BeanUtils;

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
import com.example.flightreservation.repository.FlightBookingRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FlightBookingServiceTest {



	@InjectMocks
	FlightBookingService flightBookingService;

	@Mock
	FlightBookingRepository flightBookingRepository;
	
	Ticket ticket=new Ticket();
	TicketDto ticketDto=new TicketDto();
	Passenger passenger=new Passenger();
	List<Passenger> passengers=new ArrayList<>();
	Flight flight= new Flight();
	Date date=new Date(12-2-2020);
	
	@Test(expected = FlightNotFoundException.class)
	public void testSaveTicketForNegitive() throws BookingDetailsNotFoundException, SeatsNotAvailbleException, AccountDetailsNotFoundException, InsufficientBalance, FlightNotFoundException, TicketsNotFoundException{
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
		
		//
		if ( ticketDto.getPassengers().size() != 0 &&  ticketDto.getFlight().getFlightNumber() != 0) {
			Ticket ticket = new Ticket();
			BeanUtils.copyProperties(ticketDto, ticket);
			
			if(ticketDto.getNumberOfTickets()!=0)
			{
				if (flight.getAvailableTickets() > ticketDto.getNumberOfTickets()) {
					flight.setAvailableTickets(flight.getAvailableTickets() - ticketDto.getNumberOfTickets());
					Mockito.when(flightBookingRepository.save(ticket)).thenReturn((ticket));
				@SuppressWarnings("unused")
				Ticket resTicket = flightBookingService.bookTicket(ticketDto);
					
				} else {
					throw new SeatsNotAvailbleException("please enter no of tickets less than or equal to the NoOfSeatsAvailable ");
				}

			}
			else {
				throw new TicketsNotFoundException("no of tickets should not be empty");
			}
			
		} else {
			throw new BookingDetailsNotFoundException("Missing flight number or  pssenger Id");
		}

			
		}
		
	}
	
	/*
	 * @Test public void testSaveTicketForPositive() throws
	 * BookingDetailsNotFoundException, SeatsNotAvailbleException,
	 * AccountDetailsNotFoundException, InsufficientBalance {
	 * 
	 * Ticket ticket=new Ticket(); User user=new User(); Bus bus= new Bus();
	 * bus.setBusId(23l); bus.setDestination("tpt"); bus.setSource("chennai");
	 * user.setUserId(1l); ticket.setId(1l); ticket.setUser(user);
	 * ticketDto.setBus(bus); ticketDto.setId(1l); ticketDto.setUser(user);
	 * 
	 * Mockito.when(ticketBookingRepository.save(ticket)).thenReturn((ticket));
	 * Ticket resTicket = ticketBookingService.saveTicket(ticketDto); }
	 * 
	 * @Test(expected = NullPointerException.class) public void
	 * testSaveTicketForException() throws BookingDetailsNotFoundException,
	 * SeatsNotAvailbleException, AccountDetailsNotFoundException,
	 * InsufficientBalance { Ticket ticket=new Ticket();
	 * Mockito.when(ticketBookingRepository.save(Mockito.any(Ticket.class))).
	 * thenThrow(NullPointerException.class);
	 * 
	 * @SuppressWarnings("unused") Ticket resTicket =
	 * ticketBookingService.saveTicket(ticketDto); }
	 */

