package com.akshat.repository;

import com.akshat.mappers.EmployeeMapper;
import com.akshat.model.Employee;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addEmployee(Employee employee)
	{
		String sql = "INSERT into `employees`(`name`,`age`,`date_of_birth`) VALUES (?,?,?)";
		jdbcTemplate.update(sql,employee.getName(),employee.getAge(),employee.getDate_of_birth());
		System.out.println("Employee is added by Repository class");
	}
	
	public void deleteEmployeeById(long id)
	{
		String sql = "DELETE from `employees` where `id`=?";
		jdbcTemplate.update(sql, id);
		System.out.println("Employee Deleted");
		
	}
	
	public List<Employee> findAllEmployees()
	{
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT * from employees";
		employees = jdbcTemplate.query(sql, new EmployeeMapper());
		return employees;
	}
	
	public int getCount()
	{
		return findAllEmployees().size();
	}
	
	
	
}
