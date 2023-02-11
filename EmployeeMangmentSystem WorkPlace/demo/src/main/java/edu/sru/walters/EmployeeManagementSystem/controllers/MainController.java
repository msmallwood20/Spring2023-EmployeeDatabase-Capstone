package edu.sru.walters.EmployeeManagementSystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
		@GetMapping("/HomePage")
		public String home() {
			return "HomePage";
		}
}
