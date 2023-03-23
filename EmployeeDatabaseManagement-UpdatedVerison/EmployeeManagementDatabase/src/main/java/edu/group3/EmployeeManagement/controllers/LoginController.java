package edu.group3.EmployeeManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.group3.EmployeeManagement.models.User;
import edu.group3.EmployeeManagement.repository.UserRepository;

import org.springframework.ui.Model;

@Controller
public class LoginController {
	
    @Autowired
    UserRepository userRepository;
	
	@GetMapping(value="/login")
	public String login()
	{
	return "login";
	}
	
	@GetMapping(value="/loginsuccess")
	public String loginsuccess()
	{
	return "loginsuccess";
	}
	
	@GetMapping(value="/registration")
	public String register(Model model)
	{
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping("/registrationsucces")
	public String processRegistration(User user) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
	
		return "registrationsucces";
	}
	
	@GetMapping("/user")
	public String listUsers(Model model) {
		List<User> listUsers = userRepository.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "user";
	}
	
}
