package com.example.flightreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightreservation.dto.TicketResponseDto;
import com.example.flightreservation.exceptions.TicketIdNotFoundException;
import com.example.flightreservation.model.Ticket;
import com.example.flightreservation.repository.TicketsRepository;

@Service

public class TicketService {

 @Autowired

 TicketsRepository ticketsRepository;

 


 public TicketResponseDto findByTicketId(long id) throws TicketIdNotFoundException {

 Ticket tickets;

 tickets=ticketsRepository.findById(id).orElseThrow(()->new TicketIdNotFoundException("ticket with id not found"));

 TicketResponseDto ticketDto = new TicketResponseDto();

 ticketDto.setDestination(tickets.getFlight().getDestination());

 ticketDto.setFlightId(tickets.getFlight().getFlightNumber());

 ticketDto.setNumberOfBookedTickets(tickets.getNumberOfTickets());

 ticketDto.setPassenger(tickets.getPassenger());

 ticketDto.setReservationDate(tickets.getReservationDate());

 ticketDto.setSource(tickets.getFlight().getSource());

 ticketDto.setTicketId(tickets.getTicketId());

 return ticketDto;

 }

}