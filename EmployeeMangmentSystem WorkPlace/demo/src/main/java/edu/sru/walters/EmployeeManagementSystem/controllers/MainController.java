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
		
		@GetMapping("/loginPage")
		public String login()
		{
			return "loginPage";
		}
		
		@GetMapping("/registration")
		public String register()
		{
			return "registration";
		}

}
