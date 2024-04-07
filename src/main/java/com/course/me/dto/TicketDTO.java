package com.course.me.dto;

import com.course.me.enums.Priority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {


	private String title;
	
	
	private String description;
	
	
	private double category;
	
	
	private String department;
	
	
	private Priority priority;
	
	
	private int assignedToId;
	
	
	private String createdBy;

}
