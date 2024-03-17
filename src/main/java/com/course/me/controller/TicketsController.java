package com.course.me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.me.model.Ticket;
import com.course.me.service.TicketService;

@RestController
public class TicketsController {
	
    @Autowired
    @Qualifier("ticketService")
	TicketService ticketService;
	
	@PostMapping("/tickets")
	public Ticket bookTicket(@RequestBody Ticket ticket) {
		return ticketService.bookTicket(ticket);
	}
	
	@GetMapping("/tickets")
	public List<Ticket> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	
	@PutMapping("/tickets/{ticketId}")
	public String updateTicket(@PathVariable("ticketId") int ticketId, @RequestBody Ticket ticket) {
		return ticketService.updateTicket(ticketId, ticket);
	}
	
	@DeleteMapping("/tickets/{ticketId}")
	public String deleteTicket(@PathVariable("ticketId") int ticketId) {
		return ticketService.deleteTicket(ticketId);
	}
	
}
