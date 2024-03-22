package com.course.me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.me.model.Employee;
import com.course.me.repo.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/")
	public ResponseEntity<Employee> createEmployee(Employee employee) {
		return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> createEmployee() {
		return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
	}
}
