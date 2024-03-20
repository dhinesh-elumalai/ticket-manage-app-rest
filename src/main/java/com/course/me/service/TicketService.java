package com.course.me.service;

import java.util.List;

import com.course.me.dto.TicketDTO;
import com.course.me.model.Ticket;

public interface TicketService {

	public Ticket bookTicket(TicketDTO ticket);
	
	public List<TicketDTO> getAllTickets();
	
	public String updateTicket(int ticketId, Ticket ticket);
	
	public String deleteTicket(int ticketId) ;
}
