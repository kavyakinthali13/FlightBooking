package com.example.flightreservation.dto;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.flightreservation.model.Flight;
import com.example.flightreservation.model.Passenger;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TicketDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
	private Long  ticketId;

	private int numberOfTickets;
	private long beneficiaryAccountNumber;
	private long accountNumber;
	
	@Temporal(TemporalType.DATE)
	private Date reservationDate;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Flight flight;

	@ManyToOne(cascade = CascadeType.MERGE)
	private List<Passenger> passengers;
	

	public long getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(long beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
    
	
}
