package com.jsp.employee.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jsp.employee.entity.Employee;




public class EmployeeRowMapperImp implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee=new Employee();
		employee.setEmpid(rs.getInt("empid"));
		employee.setEmpname(rs.getString("empname"));
		employee.setEmpsalary(rs.getDouble("salary"));
		employee.setEmpdeptno(rs.getInt("deptno"));
		return employee;
	}

	

	


}
