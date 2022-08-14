package com.akagami.api.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akagami.api.entity.EmployeeEntity;
import com.akagami.api.model.Employee;
import com.akagami.api.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	private static final Logger log = Logger.getLogger(EmployeeServiceImpl.class.getName());

	@Override
	public Employee createEmployee(Employee employee) {
		try {
			EmployeeEntity employeeEntity = new EmployeeEntity();
			BeanUtils.copyProperties(employee, employeeEntity);
			employeeEntity = repository.save(employeeEntity);
			log.info(employeeEntity.toString());
		} catch (Exception e) {
			log.severe("Exception occured: " + e.getMessage());
			return null;
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll().stream()
				.map(emp -> new Employee(
						emp.getId(),
						emp.getFirstName(), 
						emp.getLastName(), 
						emp.getEmailId()))
				.collect(Collectors.toList());

	}

	@Override
	public boolean deleteEmployee(String id) {
		try {
			EmployeeEntity employee = repository.findById(id).get();
			repository.delete(employee);
			return true;
		}
		catch(Exception e)
		{
			log.info("No employee found with id: "+id);
		}
		return false;
	}

	@Override
	public Employee getEmployee(String id) {
		try {
			EmployeeEntity employee = repository.findById(id).get();
			return new Employee(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId());
		}
		catch(Exception e)
		{
			log.info("No employee found with id: "+id);
		}
		return null;
	}

	@Override
	public Employee updateEmployee(String id, Employee employee) {
		try {
			EmployeeEntity employeeEntity = new EmployeeEntity(id, employee.getFirstName(), employee.getLastName(), employee.getEmailId());
			employeeEntity = repository.save(employeeEntity);
			return new Employee(employeeEntity.getId(), employeeEntity.getFirstName(), employeeEntity.getLastName(), employeeEntity.getEmailId());
		}
		catch(Exception e)
		{
			log.info("No employee found with id: "+id);
		}
		return null;
	}

}
