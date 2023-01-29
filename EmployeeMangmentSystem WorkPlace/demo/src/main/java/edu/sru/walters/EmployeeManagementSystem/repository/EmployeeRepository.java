package edu.sru.walters.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.sru.walters.EmployeeManagementSystem.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
