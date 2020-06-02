package com.example.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightreservation.model.Ticket;

public interface TicketsRepository extends JpaRepository<Ticket, Long>{

}
