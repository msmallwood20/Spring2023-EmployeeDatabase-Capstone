package edu.sru.walters.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sru.walters.EmployeeManagementSystem.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
