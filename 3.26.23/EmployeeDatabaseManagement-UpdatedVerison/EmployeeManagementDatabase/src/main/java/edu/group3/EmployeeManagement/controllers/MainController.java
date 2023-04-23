package edu.group3.EmployeeManagement.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.group3.EmployeeManagement.models.Role;
import edu.group3.EmployeeManagement.models.Timesheets;
import edu.group3.EmployeeManagement.models.User;
import edu.group3.EmployeeManagement.models.UserPrincipal;
import edu.group3.EmployeeManagement.repository.ExcelRepository;
import edu.group3.EmployeeManagement.repository.RoleRepository;
import edu.group3.EmployeeManagement.repository.UserRepository;
import edu.group3.EmployeeManagement.service.UserService;

//In this Class is our main controller that allows thymeleaf to locate and call web pages from the src/main/resources/templates folder, it also Requires the "@Controller" Tag
@Controller
public class MainController {
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private RoleRepository rRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ExcelRepository excelRepository;
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
			
				@GetMapping(value="/accountsettings")
				public String accountsettings()
				{
					return "accountsettings";
				}
			
				@GetMapping(value="/timesheet")
				public String timesheet()
				{
					return "timesheet";
				}
			
				@GetMapping(value="/manageusers")
				public ModelAndView manageusers()
				{
					ModelAndView mavUser = new ModelAndView("manageusers");
					mavUser.addObject("user", uRepo.findAll());
					return mavUser;
				}
				
				//Updating Role
			    @GetMapping("/editroles")
			    public String showUserForm(Model model) {
			        return "editroles";
			    }

			    @PostMapping("/editroles")
			    public String processUserForm() {

			        return "redirect:/editroles/success";
			    }
			
				//Adding Users-Admin Access Only
				@GetMapping("/addusers")
				public String addUsers()
				{
					return "addusers";
				}
				
				@GetMapping(value="/fileserver")
				public String fileserver()
				{
					return "fileserver";
				}
			
				@GetMapping(value="/inbox")
				public String inbox()
				{
					return "inbox";
				}
			
				@GetMapping(value="/systemlog")
				public String systemlog()
				{
					return "systemlog";
				}
			
				@GetMapping(value="/payrollAdmin")
				public ModelAndView payrolluser()
				{
					ModelAndView payUser = new ModelAndView("payrollAdmin");
					payUser.addObject("user", uRepo.findAll());
					return payUser;
				}
				
				@GetMapping(value="/payrollUser")
				public ModelAndView payrolladmin()
				{
					ModelAndView myUser = new ModelAndView("payrollUser");
					myUser.addObject("user", uRepo.findAll());
					return myUser;
				}
}
