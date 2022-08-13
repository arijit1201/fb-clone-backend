package com.akagami.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akagami.api.entity.EmployeeEntity;
import com.akagami.api.model.Employee;
import com.akagami.api.service.EmployeeService;

@CrossOrigin(origins = "http://172.20.187.232:3000")
@RestController
@RequestMapping("/api/v1.0")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.createEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}

}
