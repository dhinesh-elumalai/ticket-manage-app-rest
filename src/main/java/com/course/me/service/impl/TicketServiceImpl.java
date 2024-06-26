package com.course.me.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.course.me.dto.TicketDTO;
import com.course.me.enums.Priority;
import com.course.me.exception.TicketException;
import com.course.me.model.User;
import com.course.me.model.Ticket;
import com.course.me.repo.UserRepository;
import com.course.me.repo.TicketRepository;
import com.course.me.service.TicketService;

@Service
@Qualifier("ticketService")
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private UserRepository employeeRepository;
	
	private int availableTickets = 40;
	
	
	public Ticket bookTicket(TicketDTO ticketDto) {
		System.out.println("Received request to book ticket : " + ticketDto);
		availableTickets--;
		try {
			return ticketRepository.save(this.converTicketDTOToEntity(ticketDto));
		} catch (Exception sqlException) {
			System.out.println(sqlException.getMessage());
			throw new TicketException(HttpStatus.INTERNAL_SERVER_ERROR, sqlException.getMessage(), sqlException);
		}

	}
	
	
	public List<TicketDTO> getAllTickets(){
		List<Ticket> tickets= ticketRepository.findAll();
		if(tickets.isEmpty()) {
			throw new TicketException(HttpStatus.NO_CONTENT, "Ticket List is Empty", null);
		}
		return tickets.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}
	
	
	public String updateTicket(int ticketId, Ticket ticket) {
		if (ticketRepository.existsById(ticketId)) {
			ticketRepository.save(ticket);
			return "Ticket found with id " + ticketId + " and updated successfully!";
		}
		throw new TicketException(HttpStatus.NO_CONTENT, "Ticket Not found with id " + ticketId, null);
	}
	
	
	public String deleteTicket(int ticketId) {
		if (ticketRepository.existsById(ticketId)) {
			ticketRepository.deleteById(ticketId);
			return "Ticket found with id " + ticketId + " and updated successfully!";
		}
		throw new TicketException(HttpStatus.NO_CONTENT, "Ticket Not found with id " + ticketId, null);
	}
	
	
	private Ticket converTicketDTOToEntity(TicketDTO ticketDto) {
		Optional<User> employeeOpt = employeeRepository.findById(ticketDto.getAssignedToId());
		if(!employeeOpt.isPresent()) {
			throw new TicketException(HttpStatus.NO_CONTENT, "Employee Id is not valid / found", null);
		}
		Ticket ticket = new Ticket();
		ticket.setAssignedTo(employeeOpt.get());
		ticket.setTitle(ticketDto.getTitle());
		ticket.setDescription(ticketDto.getDescription());
		ticket.setCategory(ticketDto.getCategory());
		ticket.setPriority(ticketDto.getPriority().getValue());
		ticket.setCreatedBy(ticketDto.getCreatedBy());
		
		return ticket;
	}
	
	private TicketDTO convertEntityToDTO(Ticket ticket) {
		TicketDTO ticketDto = new TicketDTO();
		ticketDto.setAssignedToId(ticket.getAssignedTo().getId());
		ticketDto.setTitle(ticket.getTitle());
		ticketDto.setCategory(ticket.getCategory());
		ticketDto.setCreatedBy(ticket.getCreatedBy());
		ticketDto.setDepartment(ticket.getDepartment());
		ticketDto.setDescription(ticket.getDescription());
		return ticketDto;
	}
}
