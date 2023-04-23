package edu.group3.EmployeeManagement.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.group3.EmployeeManagement.helper.ExcelHelper;
import edu.group3.EmployeeManagement.helper.UserHelper;
import edu.group3.EmployeeManagement.models.Timesheets;
import edu.group3.EmployeeManagement.models.User;
import edu.group3.EmployeeManagement.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//Get All Users
	public List<User> findAll(){
		return userRepository.findAll();
	}	
	
	//Get User By Id
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}	
	
	//Delete User
	public void delete(int id) {
		userRepository.deleteById(id);
	}
	
	//Update User
	public void save(User user) {
		userRepository.save(user);
	}
	
	
	//Stores User Excel data to database
	public void save(MultipartFile file)
	{
		try {
			List<User> users = UserHelper.excelToData(file.getInputStream());
			userRepository.saveAll(users);
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
	//Reads data from the database and return
	public List<User> getAllTimeSheets()
	{
		return userRepository.findAll();
	}
	
	public ByteArrayInputStream load() {
		List<User> users = userRepository.findAll();
	
	ByteArrayInputStream in = UserHelper.dataToUser(users);
	return in;
	}
}
