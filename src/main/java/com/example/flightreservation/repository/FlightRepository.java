package com.example.flightreservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightreservation.model.Flight;

@Repository

public interface FlightRepository extends JpaRepository<Flight, Long> {

	List<Flight> findFlightBySourceAndDestinationAndDepartureDate(String source, String destination,
			Date departureDate);

	List<Flight> findFlightBySourceAndDestination(String source, String destination);

	List<Flight> findByFlightName(String flightName);

}
