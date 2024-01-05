package com.jsp.employee.dao;

import java.util.List;

import com.jsp.employee.entity.Employee;

public interface EmployeeDao {
	int employeeRegistration(Employee employee);
	List<Employee> selectAllEmployees();
	Employee getemployeeDetailsbasedonId(int empid);
	int updateEmployeeDetails(Employee employee);
	int deleteEmployee(int empid);
}
