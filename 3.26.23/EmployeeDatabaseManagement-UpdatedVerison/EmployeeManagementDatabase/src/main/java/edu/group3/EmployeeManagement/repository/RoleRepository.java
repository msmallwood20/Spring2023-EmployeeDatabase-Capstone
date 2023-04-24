package edu.group3.EmployeeManagement.repository;

import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.group3.EmployeeManagement.models.Role;
import edu.group3.EmployeeManagement.models.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);
	
    Set<Role> findRolesById(@Param("id") int id);
	
}
