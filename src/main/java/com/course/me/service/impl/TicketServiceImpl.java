package com.course.me.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.course.me.exception.TicketException;
import com.course.me.model.Ticket;
import com.course.me.repo.TicketRepository;
import com.course.me.service.TicketService;

@Service
@Qualifier("ticketService")
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepository ticketRepository;
	
	private int availableTickets = 40;
	
	
	public Ticket bookTicket(Ticket ticket) {
		System.out.println("Received request to book ticket : "+ ticket);
		availableTickets--;
		return ticketRepository.save(ticket);
	}
	
	
	public List<Ticket> getAllTickets(){
		return ticketRepository.findAll();
	}
	
	
	public String updateTicket(int ticketId, Ticket ticket) {
		if (ticketRepository.existsById(ticketId)) {
			ticketRepository.save(ticket);
			return "Ticket found with id " + ticketId + " and updated successfully!";
		}
		throw new TicketException(404, "Ticket Not found with id " + ticketId, null);
	}
	
	
	public String deleteTicket(int ticketId) {
		if (ticketRepository.existsById(ticketId)) {
			ticketRepository.deleteById(ticketId);
			return "Ticket found with id " + ticketId + " and updated successfully!";
		}
		throw new TicketException(404, "Ticket Not found with id " + ticketId, null);
	}
}
