package com.example.flightreservation.dto;
import java.util.Date;
import java.util.List;

import com.example.flightreservation.model.Passenger;
public class TicketResponseDto {

	private Long ticketId;

	private int numberOfBookedTickets;

	private Date reservationDate;

	private long flightId;

	private List<Passenger> passenger;

	private String source;

	private String destination;

	public Long getTicketId() {

		return ticketId;

	}

	public void setTicketId(Long ticketId) {

		this.ticketId = ticketId;

	}

	public int getNumberOfBookedTickets() {

		return numberOfBookedTickets;

	}

	public void setNumberOfBookedTickets(int numberOfBookedTickets) {

		this.numberOfBookedTickets = numberOfBookedTickets;

	}

	public Date getReservationDate() {

		return reservationDate;

	}

	public void setReservationDate(Date reservationDate) {

		this.reservationDate = reservationDate;

	}

	public long getFlightId() {

		return flightId;

	}

	public void setFlightId(long flightId) {

		this.flightId = flightId;

	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public String getSource() {

		return source;

	}

	public void setSource(String source) {

		this.source = source;

	}

	public String getDestination() {

		return destination;

	}

	public void setDestination(String destination) {

		this.destination = destination;

	}

}
