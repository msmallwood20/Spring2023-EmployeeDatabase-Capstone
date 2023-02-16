package edu.sru.walters.EmployeeManagementSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
		@GetMapping("/")
		public String home() 
		{
			return "index";
		}
		
		@GetMapping("/LoginPage")
		public String login()
		{
			return "LoginPage";
		}

}
