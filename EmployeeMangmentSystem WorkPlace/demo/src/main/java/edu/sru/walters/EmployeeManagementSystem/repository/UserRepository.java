package edu.sru.walters.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sru.walters.EmployeeManagementSystem.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	
	Users findByEmail(String email);

}
