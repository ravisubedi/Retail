package com.employee.api;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class employeeController {
	@Autowired
	employeeService empService;
	
	@RequestMapping(method=RequestMethod.POST,value="/employee")
	public String addEmployee(@RequestBody Employee em) {
		boolean type = empService.checkEmployee(em.getEid());
		if(!type) {
		if(em.getEid()<9999 || em.getEid()>100000) {
			return "EID must be of FIVE digit";
		}
		empService.addEmployee(em);
		return "Sucess!!";
		}
		return "Already Exists!!!";
		
	}
	@RequestMapping("/employees")
	public List<Employee> getAllEmployee(){
		return empService.getAllEmployee();
	}
	@RequestMapping("/employee/{eid}")
	public Optional<Employee> getEmployee(@PathVariable int eid){
		return empService.getEmployee(eid);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/employee/{eid}")
	public String updateEmployee(@RequestBody Employee em,@PathVariable int eid) {
		boolean type=empService.checkEmployee(eid);
		if(em.getEid() != eid) {
			return "Not Athorized ";
		}
		if (type) {
			empService.addEmployee(em);
			return "Updated!!";
		}
		return "Employee does not exist";
		
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/employee/{eid}")
	public String deleteEmployeeById(@PathVariable int eid) {
			
		boolean type=empService.checkEmployee(eid);
		if (type) {
			empService.deleteEmployee(eid);	
			return "Deleted!!";
		}
		return "Employee does not exist";
	}

}
