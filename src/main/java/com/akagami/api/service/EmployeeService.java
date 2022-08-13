package com.akagami.api.service;

import java.util.List;

import com.akagami.api.entity.EmployeeEntity;
import com.akagami.api.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

}
