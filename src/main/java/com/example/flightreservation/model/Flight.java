package com.example.flightreservation.model;

	import java.util.Date;
	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;

	import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table
	public class Flight {
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long flightNumber;
		@JsonIgnore
		private String flightName;
		@JsonIgnore
	    private String source;
		@JsonIgnore
	    private String destination;
		@JsonIgnore
	    @Temporal(TemporalType.DATE)
	    private Date departureDate;
		@JsonIgnore
	    @Temporal(TemporalType.DATE)
	    private Date arrivalDate;
		@JsonIgnore
	    private int availableTickets;
		@JsonIgnore
	    private int totalSeats;
		@JsonIgnore
	    private long flightFare;
	   
	    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	    @JsonIgnore
	    private List<Ticket> tickets;

		public Long getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(Long flightNumber) {
			this.flightNumber = flightNumber;
		}

		public String getFlightName() {
			return flightName;
		}

		public void setFlightName(String flightName) {
			this.flightName = flightName;
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

		public Date getDepartureDate() {
			return departureDate;
		}

		public void setDepartureDate(Date departureDate) {
			this.departureDate = departureDate;
		}

		public Date getArrivalDate() {
			return arrivalDate;
		}

		public void setArrivalDate(Date arrivalDate) {
			this.arrivalDate = arrivalDate;
		}

		public int getAvailableTickets() {
			return availableTickets;
		}

		public void setAvailableTickets(int availableTickets) {
			this.availableTickets = availableTickets;
		}

		public int getTotalSeats() {
			return totalSeats;
		}

		public void setTotalSeats(int totalSeats) {
			this.totalSeats = totalSeats;
		}

		public long getFlightFare() {
			return flightFare;
		}

		public void setFlightFare(long flightFare) {
			this.flightFare = flightFare;
		}

		public List<Ticket> getTickets() {
			return tickets;
		}

		public void setTickets(List<Ticket> tickets) {
			this.tickets = tickets;
		}
	    

	}




