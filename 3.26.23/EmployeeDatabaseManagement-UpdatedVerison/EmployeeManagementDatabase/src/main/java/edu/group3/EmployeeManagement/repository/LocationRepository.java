package edu.group3.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.group3.EmployeeManagement.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
