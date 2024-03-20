package com.course.me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/")
	public List<Employee> createEmployee() {
		return employeeRepository.findAll();
	}
}
