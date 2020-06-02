package com.example.flightreservation.dto;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class FlightDto {

	private String source;

	private String destination;

	@Temporal(TemporalType.DATE)

	private Date departureDate;

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

	public Date getDepartureDate() {

		return departureDate;

	}

	public void setDepartureDate(Date departureDate) {

		this.departureDate = departureDate;

	}
}
