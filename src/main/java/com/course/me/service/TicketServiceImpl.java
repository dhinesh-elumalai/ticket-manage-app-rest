package com.course.me.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.course.me.exception.TicketException;
import com.course.me.model.Ticket;

@Service
@Qualifier("ticketService")
public class TicketServiceImpl implements TicketService{

	List<Ticket> tickets = new ArrayList<>();
	
	private int availableTickets = 40;
	
	
	public Ticket bookTicket(Ticket ticket) {
		System.out.println("Received request to book ticket : "+ ticket);
		tickets.add(ticket);
		availableTickets--;
		System.out.println("Ticket booked successfully , Current Ticket List : "+ tickets +" Available Tickets : "+ availableTickets);
		return ticket;
	}
	
	
	public List<Ticket> getAllTickets(){
		return tickets;
	}
	
	
	public String updateTicket(int ticketId, Ticket ticket) {
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getId() == ticketId) {
				tickets.remove(i);
				tickets.add(ticket);
				return "Ticket found with id " + ticketId + " and updated successfully!";
			}
		}
		throw new TicketException(404, "Ticket Not found with id " + ticketId, null);
	}
	
	
	public String deleteTicket(int ticketId) {
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getId() == ticketId) {
				tickets.remove(i);
				return "Ticket found with id " + ticketId + " and deleted successfully!";
			}
		}
		throw new TicketException(404, "Ticket Not found with id " + ticketId, null);
	}
}
