package com.course.me.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TicketExceptionHandler {

	@ExceptionHandler(TicketException.class)
	public ResponseEntity<String> ticketExceptionHandler(TicketException ticketException) {
		System.out.println(ticketException.getMessage());
		return new ResponseEntity<String>(ticketException.getMessage(), ticketException.getStatusCode());
	}
	
}
