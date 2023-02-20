package edu.sru.walters.EmployeeManagementSystem.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import edu.sru.walters.EmployeeManagementSystem.dto.UserRegistrationDto;
import edu.sru.walters.EmployeeManagementSystem.models.Users;

public interface UserService extends UserDetailsService {
	
	Users save(UserRegistrationDto registrationDto);

}
