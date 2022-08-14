package com.akagami.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akagami.api.entity.EmployeeEntity;
import com.akagami.api.model.Employee;
import com.akagami.api.service.EmployeeService;

@CrossOrigin(origins = "*")
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
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable String id)
	{
		boolean deleted = false;
		deleted = service.deleteEmployee(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", deleted);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable String id)
	{
		Employee employee = new Employee();
		employee = service.getEmployee(id);
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
		employee =service.updateEmployee(id, employee);
		return ResponseEntity.ok(employee);
	}

}
