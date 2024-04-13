package com.course.me.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.course.me.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
	List<User> findByDepartment(String department);
	List<User> findByDepartmentAndEmail(String department, String email);
}
