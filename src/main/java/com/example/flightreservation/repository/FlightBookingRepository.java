package com.example.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightreservation.model.Ticket;
@Repository
public interface FlightBookingRepository extends JpaRepository<Ticket, Long> {

}
