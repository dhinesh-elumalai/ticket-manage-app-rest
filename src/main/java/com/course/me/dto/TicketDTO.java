package com.course.me.dto;

import com.course.me.enums.Priority;

public class TicketDTO {


	private String title;
	
	
	private String description;
	
	
	private double category;
	
	
	private String department;
	
	
	private Priority priority;
	
	
	private int assignedToId;
	
	
	private String createdBy;


	@Override
	public String toString() {
		return "TicketDTO [title=" + title + ", description=" + description + ", category=" + category + ", department="
				+ department + ", priority=" + priority + ", assignedToId=" + assignedToId + ", createdBy=" + createdBy
				+ "]";
	}

	public TicketDTO() {
		
	}

	public TicketDTO(String title, String description, double category, String department, Priority priority,
			int assignedToId, String createdBy) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.department = department;
		this.priority = priority;
		this.assignedToId = assignedToId;
		this.createdBy = createdBy;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getCategory() {
		return category;
	}


	public void setCategory(double category) {
		this.category = category;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public Priority getPriority() {
		return priority;
	}


	public void setPriority(Priority priority) {
		this.priority = priority;
	}


	public int getAssignedToId() {
		return assignedToId;
	}


	public void setAssignedToId(int assignedToId) {
		this.assignedToId = assignedToId;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
