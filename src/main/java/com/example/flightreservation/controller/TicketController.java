package com.example.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightreservation.dto.TicketResponseDto;
import com.example.flightreservation.exceptions.TicketIdNotFoundException;
import com.example.flightreservation.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired

	 TicketService ticketService;



	 @GetMapping("/ticket")

	 public ResponseEntity<TicketResponseDto> findByTicketId(@RequestParam long id) throws TicketIdNotFoundException{

	 TicketResponseDto ticketDto;

	 ticketDto=ticketService.findByTicketId(id);

	 return new ResponseEntity<>(ticketDto,HttpStatus.OK);

	 }

}
