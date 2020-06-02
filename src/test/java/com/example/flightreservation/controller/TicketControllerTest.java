package com.example.flightreservation.controller;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import com.example.flightreservation.dto.TicketResponseDto;
import com.example.flightreservation.exceptions.TicketIdNotFoundException;
import com.example.flightreservation.model.Ticket;
import com.example.flightreservation.service.TicketService;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.Silent.class)

public class TicketControllerTest {



 @InjectMocks

 TicketController ticketController;

  @Mock

  TicketService ticketService;

  @Test

  public void testFindByTicketId() throws TicketIdNotFoundException {

   TicketResponseDto ticketDto = new TicketResponseDto();

  ticketDto.setNumberOfBookedTickets(40);

  ticketDto.setReservationDate(new Date(2020-05-19));

  ticketDto.setTicketId(100L);

  Ticket ticket = new Ticket();

  ticket.setNumberOfTickets(40);

  ticket.setReservationDate(new Date(2020-05-19));

  ticket.setTicketId(100L);



  try {

   Mockito.when(ticketService.findByTicketId(100L)).thenReturn(ticketDto);

  } catch (TicketIdNotFoundException e) {

   // TODO Auto-generated catch block

   e.printStackTrace();

  }

  @SuppressWarnings("unused")
ResponseEntity<TicketResponseDto> dto1=ticketController.findByTicketId(100L);



  }

  @Test(expected=TicketIdNotFoundException.class)

  public void testFindByTicketIdForException() throws TicketIdNotFoundException {

   TicketResponseDto ticketDto = new TicketResponseDto();

  ticketDto.setNumberOfBookedTickets(40);

  ticketDto.setReservationDate(new Date(2020-05-19));

  ticketDto.setTicketId(100L);

  Ticket ticket = new Ticket();

  ticket.setNumberOfTickets(40);

  ticket.setReservationDate(new Date(2020-05-19));

  ticket.setTicketId(100L);



  try {

   Mockito.when(ticketService.findByTicketId(500L)).thenThrow(new TicketIdNotFoundException("ticket with id not found"));

  } catch (TicketIdNotFoundException e) {

   // TODO Auto-generated catch block

   e.printStackTrace();

  }

  @SuppressWarnings("unused")
ResponseEntity<TicketResponseDto> dto1=ticketController.findByTicketId(500L);
Assert.assertNotNull(dto1);


  }



}
