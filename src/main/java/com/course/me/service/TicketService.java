package com.course.me.service;

import java.util.List;

import com.course.me.model.Ticket;

public interface TicketService {

	public Ticket bookTicket(Ticket ticket);
	
	public List<Ticket> getAllTickets();
	
	public String updateTicket(int ticketId, Ticket ticket);
	
	public String deleteTicket(int ticketId) ;
}
