package edu.sru.walters.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sru.walters.EmployeeManagementSystem.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
