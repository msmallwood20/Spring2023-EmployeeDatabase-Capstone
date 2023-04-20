package edu.group3.EmployeeManagement.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.group3.EmployeeManagement.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.username = ?1")
	User findByUsername(String username);
	
	/*
	 * @Query("SELECT DISTINCT u FROM User u JOIN u.roles r WHERE r.name LIKE %?1%")
	 * public Page<User> findAll(String keyword, Pageable pageable);
	 */
}
