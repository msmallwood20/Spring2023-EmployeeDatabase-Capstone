package edu.sru.walters.EmployeeManagementSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//In this Class is our main controller that allows thymeleaf to locate and call web pages from the src/main/resources/templates folder, it also Requires the "@Controller" Tag
@Controller
public class MainController {

//These methods have the @GetMapping("***") Tag, inside of the parentheses, is the name that thymeleaf will use when calling to find that page-Explained more on the HTML pages
//The return "***"; references directly to the web pages names that are located in the src/main/resources/templates folder
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
