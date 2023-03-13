package edu.group3.EmployeeManagement.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;


import edu.group3.EmployeeManagement.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public Users findByEmail(String email);

}
