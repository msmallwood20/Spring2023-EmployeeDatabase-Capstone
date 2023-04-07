package edu.group3.EmployeeManagement.controllers;

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
import org.springframework.web.servlet.view.RedirectView;

import edu.group3.EmployeeManagement.helper.ExcelHelper;
import edu.group3.EmployeeManagement.models.Timesheets;
import edu.group3.EmployeeManagement.service.ExcelService;
import edu.group3.EmployeeManagement.messages.ResponseMessage;

@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/api/excel")
public class ExcelController {

	  @Autowired
	  ExcelService fileService;

	  
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
	  public ResponseEntity<ResponseMessage> upload(@RequestParam("file") MultipartFile file)
	  {
		  String message = "";
		  if (ExcelHelper.hasExcelFormat(file)) {
		      try {
		        fileService.save(file);

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
