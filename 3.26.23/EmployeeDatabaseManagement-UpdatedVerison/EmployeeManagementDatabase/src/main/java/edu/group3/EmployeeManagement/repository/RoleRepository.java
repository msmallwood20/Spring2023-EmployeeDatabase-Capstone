package edu.group3.EmployeeManagement.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.group3.EmployeeManagement.models.Role;
import edu.group3.EmployeeManagement.models.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

}
