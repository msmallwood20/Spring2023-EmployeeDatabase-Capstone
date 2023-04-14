package edu.group3.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.group3.EmployeeManagement.models.FileDB;
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String>{

}
