package com.employee.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class employeeService {
	@Autowired
	private employeeRepository empRepository;
	
	public void addEmployee(Employee em) {
		empRepository.save(em);
		
	}

	public List<Employee> getAllEmployee() {
		
		return empRepository.findAll();
	}

	public Optional<Employee> getEmployee(int eid) {
		return empRepository.findById(eid);
	}


	public void deleteEmployee(int eid) {
		empRepository.deleteById(eid);
		
	}

	public boolean checkEmployee(int eid) {
		return empRepository.existsById(eid);
		
	}

}
