package edu.sru.walters.EmployeeManagementSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
	
		@GetMapping("/")
		public String home() 
		{
			return "index";
		}
		
		@GetMapping(value="/loginpage")
		public String login()
		{
			return "loginpage";
		}
		
		@GetMapping(value="/registration")
		public String register()
		{
			return "registration";
		}
		
		@GetMapping(value="/Dashboard")
		public String dashboard()
		{
			return "Dashboard";
		}
}
