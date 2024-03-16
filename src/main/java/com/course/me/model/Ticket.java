package com.course.me.model;


public class Ticket {
	private int id;
	private String source;
	private String destination;
	private double cost;
	private String travelDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	
	public Ticket(int id, String source, String destination, double cost, String travelDate) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.cost = cost;
		this.travelDate = travelDate;
	}
	
	public Ticket() {
		
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", source=" + source + ", destination=" + destination + ", cost=" + cost
				+ ", travelDate=" + travelDate + "]";
	}
	
	
}
