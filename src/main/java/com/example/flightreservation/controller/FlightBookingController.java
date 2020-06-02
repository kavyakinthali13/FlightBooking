package com.example.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightreservation.dto.ResponseDto;
import com.example.flightreservation.dto.TicketDto;
import com.example.flightreservation.exceptions.AccountDetailsNotFoundException;
import com.example.flightreservation.exceptions.BookingDetailsNotFoundException;
import com.example.flightreservation.exceptions.FlightNotFoundException;
import com.example.flightreservation.exceptions.InsufficientBalance;
import com.example.flightreservation.exceptions.SeatsNotAvailbleException;
import com.example.flightreservation.exceptions.TicketsNotFoundException;
import com.example.flightreservation.service.FlightBookingService;

@RestController
public class FlightBookingController {
	@Autowired
	private FlightBookingService flightBookingService;
	
	
	@PostMapping("/bookTicket")
	public ResponseEntity<ResponseDto> ticketBooking(@RequestBody TicketDto ticketDto) throws SeatsNotAvailbleException, BookingDetailsNotFoundException, AccountDetailsNotFoundException, InsufficientBalance, FlightNotFoundException, TicketsNotFoundException  {
		ResponseDto ticketResponseDto=new ResponseDto();
		flightBookingService.bookTicket(ticketDto);
		ticketResponseDto.setMessage("tickets booked successfully");
		ticketResponseDto.getMessage();
		return new ResponseEntity<>(ticketResponseDto, HttpStatus.OK);	
	}

}
