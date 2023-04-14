package edu.group3.EmployeeManagement.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.group3.EmployeeManagement.helper.ExcelHelper;
import edu.group3.EmployeeManagement.models.Timesheets;
import edu.group3.EmployeeManagement.repository.ExcelRepository;

@Service
public class ExcelService {

	@Autowired
	ExcelRepository excelRepository;
	
	//Stores Excel data to database
	public void save(MultipartFile file)
	{
		try {
			List<Timesheets> timeSheets = ExcelHelper.excelToData(file.getInputStream());
			excelRepository.saveAll(timeSheets);
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
	//Reads data from the database and return
	public List<Timesheets> getAllTimeSheets()
	{
		return excelRepository.findAll();
	}
	
	public ByteArrayInputStream load() {
		List<Timesheets> timeSheets = excelRepository.findAll();
	
	ByteArrayInputStream in = ExcelHelper.dataToExcel(timeSheets);
	return in;
	}
	
}
