package com.course.me.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TicketExceptionHandler {

	@ExceptionHandler(TicketException.class)
	public String ticketExceptionHandler(TicketException ticketException) {
		System.out.println(ticketException.getMessage());
		return ticketException.getMessage();
	}
	
}
