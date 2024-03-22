package com.course.me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Ticket> bookTicket(@RequestBody TicketDTO ticket) {
		return new ResponseEntity<>(ticketService.bookTicket(ticket), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<TicketDTO>> getAllTickets(){
		return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
	}
	
	
	@PutMapping("/{ticketId}")
	public ResponseEntity<String> updateTicket(@PathVariable("ticketId") int ticketId, @RequestBody Ticket ticket) {
		return new ResponseEntity<>(ticketService.updateTicket(ticketId, ticket), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") int ticketId) {
		return new ResponseEntity<>(ticketService.deleteTicket(ticketId), HttpStatus.ACCEPTED);
	}
	
}
