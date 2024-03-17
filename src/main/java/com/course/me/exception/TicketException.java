package com.course.me.exception;


public class TicketException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int statusCode;
	
	public int getStatusCode() {
		return statusCode;
	}

	public TicketException(int statusCode, String message, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }
	
	
}
