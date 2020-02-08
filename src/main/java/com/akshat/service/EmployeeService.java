package com.akshat.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshat.model.Employee;
import com.akshat.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public void addEmployee(Employee employee) throws ParseException
	{
		System.out.println("Employee is added by service class");
		employeeRepository.addEmployee(employee);
	}
	
	public List<Employee> displayAll()
	{
		return employeeRepository.findAllEmployees();
	}
	
	
}
