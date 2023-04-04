package edu.group3.EmployeeManagement.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.group3.EmployeeManagement.helper.ExcelHelper;
import edu.group3.EmployeeManagement.models.Timesheets;
import edu.group3.EmployeeManagement.repository.ExcelRepository;

@Service
public class ExcelService {

	@Autowired
	ExcelRepository excelRepository;
	
	public ByteArrayInputStream load() {
		List<Timesheets> timeSheets = excelRepository.findAll();
	
	ByteArrayInputStream in = ExcelHelper.dataToExcel(timeSheets);
	return in;
	}
	
}
