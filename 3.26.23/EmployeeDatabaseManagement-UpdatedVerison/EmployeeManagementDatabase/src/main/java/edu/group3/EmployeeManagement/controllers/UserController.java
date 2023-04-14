package edu.group3.EmployeeManagement.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.group3.EmployeeManagement.controllers.MainController;
import edu.group3.EmployeeManagement.helper.ExcelHelper;
import edu.group3.EmployeeManagement.messages.ResponseMessage;
import edu.group3.EmployeeManagement.models.User;
import edu.group3.EmployeeManagement.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import edu.group3.EmployeeManagement.service.CountryService;
import edu.group3.EmployeeManagement.service.ExcelService;

@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/api/excel")
public class UserController {
	
	@Autowired
	private UserService userService;
	
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
	
	
	//Downloading a blank/pre-filled file
	  @GetMapping("/downloadUserSheet")
	  public ResponseEntity<Resource> getFile() {
		  String filename = "AddingUsers.xlsx";
		  InputStreamResource file = new InputStreamResource(userService.load());
		  
		  return ResponseEntity.ok()
			      .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
			      .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			      .body(file);
	  }
	  	
	  //Upload excel sheet to database
	  @PostMapping("/uploadUserSheet")
	  public ResponseEntity<ResponseMessage> upload(@RequestParam("file") MultipartFile file)
	  {
		  String message = "";
		  if (ExcelHelper.hasExcelFormat(file)) {
		      try {
		    	  userService.save(file);

		        message = "Uploaded the file successfully: " + file.getOriginalFilename();
		        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

		        } catch (Exception e) {
		        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		      }
		    }
		  message = "Please upload an excel file!";
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
		  }
}