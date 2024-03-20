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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.me.dto.TicketDTO;
import com.course.me.model.Ticket;
import com.course.me.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketsController {
	
    @Autowired
    @Qualifier("ticketService")
	TicketService ticketService;
	
	@PostMapping("/")
	public Ticket bookTicket(@RequestBody TicketDTO ticket) {
		return ticketService.bookTicket(ticket);
	}
	
	@GetMapping("/")
	public List<TicketDTO> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	
	@PutMapping("/{ticketId}")
	public String updateTicket(@PathVariable("ticketId") int ticketId, @RequestBody Ticket ticket) {
		return ticketService.updateTicket(ticketId, ticket);
	}
	
	@DeleteMapping("/{ticketId}")
	public String deleteTicket(@PathVariable("ticketId") int ticketId) {
		return ticketService.deleteTicket(ticketId);
	}
	
}
