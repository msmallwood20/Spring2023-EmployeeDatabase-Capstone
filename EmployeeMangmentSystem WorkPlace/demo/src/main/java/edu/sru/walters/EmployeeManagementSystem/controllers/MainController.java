package edu.sru.walters.EmployeeManagementSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
		@RequestMapping({"/","/HomePage"})
		public String home() {
			return "HomePage";
		}
		
		@RequestMapping({"/LoginPage"})
		public String login()
		{
			return "LoginPage";
		}

}
