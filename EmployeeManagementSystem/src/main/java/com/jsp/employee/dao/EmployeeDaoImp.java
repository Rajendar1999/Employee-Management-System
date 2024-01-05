package com.jsp.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jsp.employee.entity.Employee;
import com.jsp.employee.rowmapper.EmployeeRowMapperImp;
@Component
public class EmployeeDaoImp implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int employeeRegistration(Employee employee) {
		
		return jdbcTemplate.update("insert into employee(empname,salary,deptno) values(?,?,?)", 
				employee.getEmpname(),employee.getEmpsalary(),employee.getEmpdeptno());
		
	}

	@Override
	public List<Employee> selectAllEmployees() {
		
		return jdbcTemplate.query("Select * from employee", new EmployeeRowMapperImp());
		
	}

	@Override
	public Employee getemployeeDetailsbasedonId(int empid) {
		return jdbcTemplate.queryForObject("select * from employee where empid=?", new EmployeeRowMapperImp(),empid);
	}

	@Override
	public int updateEmployeeDetails(Employee employee) {
		
		return jdbcTemplate.update("update employee set empname=?,salary=?,deptno=? where empid=?", 
				employee.getEmpname(),employee.getEmpsalary(),employee.getEmpdeptno(),employee.getEmpid());
		
	}

	@Override
	public int deleteEmployee(int empid) {
		
		return jdbcTemplate.update("delete from employee where empid=?",empid);
	}

	

}
