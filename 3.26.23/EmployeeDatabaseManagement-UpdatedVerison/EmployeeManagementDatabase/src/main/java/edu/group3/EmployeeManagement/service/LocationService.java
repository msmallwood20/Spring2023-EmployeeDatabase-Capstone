package edu.group3.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.group3.EmployeeManagement.models.Location;
import edu.group3.EmployeeManagement.repository.LocationRepository;


@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;

	public List<Location> findAll() {
		return (List<Location>) locationRepository.findAll();
	}

	public Optional<Location> findById(int id) {
		return locationRepository.findById(id);
	}
	
	public void save(Location location) {
		locationRepository.save(location);
	}
	
	public void deleteById(int id) {
		locationRepository.deleteById(id);
	}

	public List<Location> findByDescriptionContaining(String description) {
		return null;
	}	
}
