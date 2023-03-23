package edu.group3.EmployeeManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//In this Class is our main controller that allows thymeleaf to locate and call web pages from the src/main/resources/templates folder, it also Requires the "@Controller" Tag
@Controller
public class MainController {
	//These methods have the @GetMapping("***") Tag, inside of the parentheses, is the name that thymeleaf will use when calling to find that page-Explained more on the HTML pages
		
	//The return "***"; references directly to the web pages names that are located in the src/main/resources/templates folder
				@GetMapping("/")
				public String viewHomePage() 
				{
					return "index";
				}

				@GetMapping(value="/dashboard")
				public String dashboard()
				{
					return "dashboard";
				}
}
