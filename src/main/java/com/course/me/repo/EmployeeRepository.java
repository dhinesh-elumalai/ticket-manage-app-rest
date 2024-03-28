package com.course.me.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.course.me.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Optional<Employee> findByEmail(String email);
	List<Employee> findByDepartment(String department);
	List<Employee> findByDepartmentAndEmail(String department, String email);
	
//	@Query("select * from EMPLOYEE where email=:1")
//	List<Employee> getByEmail(String email);
}
