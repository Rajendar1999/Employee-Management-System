package com.jsp.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.employee.dao.EmployeeDao;

import com.jsp.employee.entity.Employee;

@Controller
public class EmployeeController {
	
//	Employee Data Access Object interface where all the database methods are written
	@Autowired
	EmployeeDao employeeDao;
	
//	requestMAppring anotation is used to set the url for the page
	
	@RequestMapping("/Registration")
	public String employeeRegistration() {
//	this method i used to display the registration web page by emtering the url we can acces the web page
		return "EmployeeRegistration";
	}
	
	@RequestMapping("/employeeDetails")
	public void getEmployeeDetails(@RequestParam("name") String empname,@RequestParam("salary") double empsalary,@RequestParam("deptno") int empdeptno) {
		
		System.out.println("Employee Name : "+empname);
		System.out.println("Employee salary : "+empsalary);
		System.out.println("Employee Deptno : "+empdeptno);
	}
	
//	@RequestMapping("/valuesintoemployeeobject")
//	@ResponseBody
//	public String getEmployeeDetailsIntoEmployeeObject(Employee employee) {
//		
//		return"<center>Employee Name : "+employee.getEmpname()+
//				" <br>Employee Salary : "+employee.getEmpsalary()+
//				" <br>Employee Deptno : "+employee.getEmpdeptno()+"</center>";
//	}
	
	@RequestMapping("/valuesintoemployeeobject")
//	This method is used get values from restration web page to controller class	
	public String getEmployeeDetailsIntoEmployeeObject(Employee employee,Model model) {

//	thsi method is written in EmployeeDao interface where this method is used to insert employee details into employee table	
		int registration = employeeDao.employeeRegistration(employee);
		if (registration!=0) {
			model.addAttribute("emp", employee);
			return "redirect:/allemployeedetails";
		} else {
			return "EmployeeRegistration";
		}
		
	}
	@RequestMapping("/allemployeedetails")
//	for displaying all employee details on web page
	public String getAllEmployeeDetails(Model model) {
//		method in EmployeeDao to select all employee details
		List<Employee> list = employeeDao.selectAllEmployees();
		model.addAttribute("listofEmployess", list);
		//return "EmployeeDetails";
		return "DisplayAllEmployee";
	}
	
	@RequestMapping("/UpdateEmployee")
	
	public String getEmployeeDetailsBasedOnId(int empid,Model model) {
		Employee employee = employeeDao.getemployeeDetailsbasedonId(empid);
		model.addAttribute("employee", employee);
		return "UpdateEmployeeDetails";
	}
	
	@RequestMapping("/UpdatedEmployeeDetails")
	public String updateEmployee(Employee employee) {
		System.out.println(employee);
		int employeeDetails = employeeDao.updateEmployeeDetails(employee);
		
		if (employeeDetails!=0) {
			return "redirect:/allemployeedetails";
		} else {
			return"UpdateEmployeeDetails";
		}
	}
	
	@RequestMapping("/DeleteEmployee")
	public String deleteEmployeeDetails(int empid) {
		int employee = employeeDao.deleteEmployee(empid);
		if (employee!=0) {
			return "redirect:/allemployeedetails";
		}
		else {
			return"";
		}
	}
}
