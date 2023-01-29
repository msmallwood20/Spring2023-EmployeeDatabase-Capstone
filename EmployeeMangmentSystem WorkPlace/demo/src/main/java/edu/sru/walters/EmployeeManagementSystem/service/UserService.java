package edu.sru.walters.EmployeeManagementSystem.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import edu.sru.walters.EmployeeManagementSystem.dto.UserRegistrationDto;
import edu.sru.walters.EmployeeManagementSystem.models.User;

public interface UserService extends UserDetailsService {
	
	User save(UserRegistrationDto registrationDto);

}
