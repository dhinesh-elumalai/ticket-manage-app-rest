package com.course.me.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.me.model.Ticket;

@RestController
public class TicketsController {
	
	List<Ticket> tickets = new ArrayList();
	
	private int availableTickets = 40;


	@PostMapping("/tickets")
	public Ticket bookTicket(@RequestBody Ticket ticket) {
		System.out.println("Received request to book ticket : "+ ticket);
		tickets.add(ticket);
		availableTickets--;
		System.out.println("Ticket booked successfully , Current Ticket List : "+ tickets +" Available Tickets : "+ availableTickets);
		return ticket;
	}
	
	@GetMapping("/tickets")
	public List<Ticket> getAllTickets(){
		return tickets;
	}
	
	
	@PutMapping("/tickets/{ticketId}")
	public String updateTicket(@PathVariable("ticketId") int ticketId, @RequestBody Ticket ticket) {
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getId() == ticketId) {
				tickets.remove(i);
				tickets.add(ticket);
				return "Ticket found with id " + ticketId + " and updated successfully!";
			}
		}
		return "Ticket Not found with id " + ticketId;
	}
	
	@DeleteMapping("/tickets/{ticketId}")
	public String deleteTicket(@PathVariable("ticketId") int ticketId) {
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getId() == ticketId) {
				tickets.remove(i);
				return "Ticket found with id " + ticketId + " and deleted successfully!";
			}
		}
		return "Ticket Not found with id " + ticketId;
	}
	
}
