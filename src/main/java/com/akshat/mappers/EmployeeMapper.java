package com.akshat.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.akshat.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {
	

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		employee.setId(rs.getInt(1));
		employee.setName(rs.getString(2));
		employee.setAge(rs.getInt(3));
		employee.setDate_of_birth(rs.getDate(4));
		return employee;
		
	}
	
}
