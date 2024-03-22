package com.course.me.exception;

import org.springframework.http.HttpStatus;

public class TicketException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus httpStatus;
	
	public HttpStatus getStatusCode() {
		return httpStatus;
	}

	public TicketException(HttpStatus httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }
	
	
}
