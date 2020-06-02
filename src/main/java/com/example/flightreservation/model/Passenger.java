package com.example.flightreservation.model;
	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.ManyToOne;
	import javax.persistence.Table;

	import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table
	public class Passenger {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long passengerId;
		@JsonIgnore
		private String email;
		@JsonIgnore
		private String password;
		@JsonIgnore
		private String firstname;
		@JsonIgnore
		private String lastname;
		@JsonIgnore
		private String phoneNumber;
		

		@ManyToOne( cascade = CascadeType.ALL)
		@JsonIgnore
		private Ticket ticket;


		public Long getPassengerId() {
			return passengerId;
		}


		public void setPassengerId(Long passengerId) {
			this.passengerId = passengerId;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getFirstname() {
			return firstname;
		}


		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}


		public String getLastname() {
			return lastname;
		}


		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public String getPhoneNumber() {
			return phoneNumber;
		}


		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}


		public Ticket getTicket() {
			return ticket;
		}


		public void setTicket(Ticket ticket) {
			this.ticket = ticket;
		}

	}



