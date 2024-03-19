package com.course.me.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.me.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
