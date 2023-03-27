package edu.group3.EmployeeManagement.test;


import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import edu.group3.EmployeeManagement.models.Role;
import edu.group3.EmployeeManagement.repository.RoleRepository;
 
public class RoleRepositoryTests {
 
    @Autowired 
    private RoleRepository repo;

    public void testCreateRoles() {
        Role user = new Role("USER");
        Role admin = new Role("ADMIN");
         
        repo.saveAll(List.of(user, admin));
         
        List<Role> listroles = repo.findAll();        
    }
     
}
