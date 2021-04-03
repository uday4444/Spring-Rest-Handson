package com.cognizant.springrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrest.model.Employee;
import com.cognizant.springrest.service.EmployeeService;

@RestController
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		LOGGER.info("Start of getAllEmployees method");
		LOGGER.debug("Employees : {}",employeeService.getAllEmployees());
		LOGGER.info("End of getAllEmployees method");
		return employeeService.getAllEmployees();
	}
	
	@PutMapping("/employees")
	public void updateEmployee(@RequestBody @Validated Employee employee)
	{
		LOGGER.info("Start of updateEmployee method");
		employeeService.updateEmployee(employee);
		LOGGER.debug("Employees : {}",employeeService.getAllEmployees());
		LOGGER.info("End of updateEmployee method");
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable String id)
	{
		LOGGER.info("Start of deleteEmployee method");
		employeeService.deleteEmployee(id);
		LOGGER.debug("Employees : {}",employeeService.getAllEmployees());
		LOGGER.info("End of deleteEmployee method");
		
	}
}
