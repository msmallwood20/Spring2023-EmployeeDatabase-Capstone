package edu.group3.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.group3.EmployeeManagement.models.Timesheets;

public interface ExcelRepository extends JpaRepository<Timesheets, Long>{
	Timesheets findByUsername(String username);
}