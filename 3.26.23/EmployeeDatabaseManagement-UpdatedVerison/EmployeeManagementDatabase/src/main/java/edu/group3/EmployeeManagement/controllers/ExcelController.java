package edu.group3.EmployeeManagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import edu.group3.EmployeeManagement.helper.ExcelHelper;
import edu.group3.EmployeeManagement.models.Timesheets;
import edu.group3.EmployeeManagement.models.User;
import edu.group3.EmployeeManagement.repository.UserRepository;
import edu.group3.EmployeeManagement.service.ExcelService;
import edu.group3.EmployeeManagement.messages.ResponseMessage;

@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/api/excel")
public class ExcelController {

	  @Autowired
	  ExcelService fileService;

	  @Autowired
	  UserRepository userRepository;
	  
	  //Downloading a blank/pre-filled file
	  @GetMapping("/download")
	  public ResponseEntity<Resource> getFile() {
		  String filename = "blankTimesheet.xlsx";
		  InputStreamResource file = new InputStreamResource(fileService.load());
		  
		  return ResponseEntity.ok()
			      .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
			      .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
			      .body(file);
	  }
	
	//Uploading a filled from timesheet page
	  @PostMapping("/upload")
	  public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
	      if (ExcelHelper.hasExcelFormat(file)) {
	          try {
	              fileService.save(file);

	              String message = "Uploaded the file successfully: " + file.getOriginalFilename();
	              redirectAttributes.addFlashAttribute("successMessage", message); // Add a flash attribute with a success message
	          } catch (Exception e) {
	              String message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	              redirectAttributes.addFlashAttribute("errorMessage", message); // Add a flash attribute with an error message
	          }
	      } else {
	          String message = "Please upload an excel file!";
	          redirectAttributes.addFlashAttribute("errorMessage", message); // Add a flash attribute with an error message
	      }
	      
	      return "redirect:/timesheet"; // Redirect to the "/timesheet" page
	  }
	  //Gets a list of the uploaded files
	  @GetMapping("/view")
	  public ResponseEntity<List<Timesheets>> getAllTimeSheets()
	  {
		  try {
		      List<Timesheets> timeSheets = fileService.getAllTimeSheets();

		      if (timeSheets.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(timeSheets, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
}
