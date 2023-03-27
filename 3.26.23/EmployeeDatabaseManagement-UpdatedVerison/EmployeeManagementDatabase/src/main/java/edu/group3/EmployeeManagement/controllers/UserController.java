package edu.group3.EmployeeManagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.group3.EmployeeManagement.models.User;
import edu.group3.EmployeeManagement.service.UserService;
import edu.group3.EmployeeManagement.service.CountryService;

@Controller
public class UserController {
	
	@Autowired private UserService userService;
	
	//Get All Users
	@GetMapping("users")
	public String findAll(Model model){		
		return "user";
	}	
	
	@RequestMapping("users/findById") 
	@ResponseBody
	public Optional<User> findById(int id)
	{
		return userService.findById(id);
	}
	
	//Add User
	@PostMapping(value="users/addNew")
	public String addNew(User user) {
		userService.save(user);
		return "redirect:/users";
	}	
	
	@RequestMapping(value="users/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(User user) {
		userService.save(user);
		return "redirect:/users";
	}
	
	@RequestMapping(value="users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(int id) {
		userService.delete(id);
		return "redirect:/users";
	}


}
