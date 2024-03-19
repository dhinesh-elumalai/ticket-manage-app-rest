package com.course.me.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TICKET")
public class Ticket {
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="SOURCE", nullable = false)
	private String source;
	@Column(name="DESTINATION", nullable = false)
	private String destination;
	@Column(name="COST")
	private double cost;
	@Column(name="TRAVEL_DATE")
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
