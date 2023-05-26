package com.sneg.likevavo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneg.likevavo.entities.Ticket;
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
