package edu.sru.walters.EmployeeManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.sru.walters.EmployeeManagementSystem.configuration.SecurityConfig;
import edu.sru.walters.EmployeeManagementSystem.models.Users;
import edu.sru.walters.EmployeeManagementSystem.repository.UserRepository;

//In this Class is our main controller that allows thymeleaf to locate and call web pages from the src/main/resources/templates folder, it also Requires the "@Controller" Tag
@Controller
public class MainController {

//These methods have the @GetMapping("***") Tag, inside of the parentheses, is the name that thymeleaf will use when calling to find that page-Explained more on the HTML pages
//The return "***"; references directly to the web pages names that are located in the src/main/resources/templates folder
	    @Autowired
	    UserRepository userRepository;
	    
		@GetMapping("/")
		public String viewHomePage() 
		{
			return "index";
		}
		
		@GetMapping(value="/loginpage")
				public String login()
		{
	        return "loginpage";
	    }

		
		@GetMapping(value="/registration")
		public String register(Model model)
		{
			model.addAttribute("users", new Users());
			return "registration";
		}
		
		
		@GetMapping(value="/dashboard")
		public String dashboard()
		{
			return "dashboard";
		}
		
		@GetMapping(value="/accountsettings")
		public String accountsettings()
		{
			return "accountsettings";
		}
		
		@PostMapping("/process_registration")
		public String processRegistration(Users users) {
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(users.getPassword());
			users.setPassword(encodedPassword);
			userRepository.save(users);
		
			return "registrationsucces";
		}
		
		@GetMapping("/users")
		public String listUsers(Model model) {
			List<Users> listUsers = userRepository.findAll();
			model.addAttribute("listUsers", listUsers);
			
			return "users";
		}
}
