package edu.group3.EmployeeManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.group3.EmployeeManagement.models.User;
import edu.group3.EmployeeManagement.repository.UserRepository;
import edu.group3.EmployeeManagement.service.MyUserDetailsService;
import edu.group3.EmployeeManagement.service.UserService;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class LoginController {
	
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private MyUserDetailsService userService;
    
    @RequestMapping(value="/login")
	public String login(Model model)
	{
	return "login";
	}
	
	@GetMapping(value="/loginsuccess")
	public String loginsuccess()
	{
	return "loginsuccess";
	}
	
	//User Forgot Or Changing Password
	@GetMapping("/createpassword")
	public String showpassword(Model model)
	{
		model.addAttribute("passwordForm", new User());
		return "createpassword";
	}
	
	@PostMapping("/createpassword")
	public String changePasssword(@ModelAttribute("passwordForm") User useredit, BindingResult bindingResult, Model model)
	{
		String username = useredit.getUsername();
		String oldPassword = useredit.getOldPassword();
	    String newPassword = useredit.getNewPassword();
	    
	    User user = userRepository.findByUsername(username);
	    String currentPassword = user.getPassword();
	    
	    //Checks if old password is null or not before checking if the entered "oldPassword" is found.
	    if (oldPassword != null && !oldPassword.isEmpty() && !passwordEncoder.matches(oldPassword, currentPassword))
	    {
	    	bindingResult.rejectValue("oldPassword", "error.passwordForm", "Incorrect current password.");
	    }
	    //Checks if the entered "newPassword" to change to is empty
	    if (newPassword == null || newPassword.trim().isEmpty())
	    {
	    	bindingResult.rejectValue("newPassword", "error.passwordForm", "New password cannont be empty.");
	    }
	    //Returns to the creatpassword.html page to display errors
	    if (bindingResult.hasErrors()) {
            return "createpassword";
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
	    //Returns to the creatpassword.html page to display the password was correctly successfully
        model.addAttribute("successMessage", "Password changed successfully.");
        return "createpassword";
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
