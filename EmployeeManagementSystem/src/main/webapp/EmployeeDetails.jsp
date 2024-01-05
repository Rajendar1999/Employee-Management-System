<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.springframework.web.client.HttpClientErrorException.Forbidden"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.employee.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body style="background: rgb(155,155,255);">
<center>
<h1>Registration Successful</h1>
<a href="EmployeeRegistration.jsp"><input type="button" value="Registration"></a>
</center>
<center>
<table border="1" >
<tr >
<th>
Employee ID
</th>
<th>
Employee Name
</th>
<th>
Employee Salary
</th>
<th>
Employee Deptno
</th>
<th colspan="2">
Employee Modification
</th>

</tr>


<% 
List<Employee> list=(List<Employee>)request.getAttribute("listofEmployess");
for(Employee employee : list){
%>
<tr>
<td><%=employee.getEmpid() %></td>
<td><%=employee.getEmpname() %></td>
<td><%=employee.getEmpsalary() %></td>
<td><%=employee.getEmpdeptno() %></td>
<td>
<form action="UpdateEmployee">
<input type="text" hidden="true"  value="<%=employee.getEmpid() %>" name="empid">
<input type="submit" value="Update">
</form>
</td>
<td>
<form action="DeleteEmployee">
<input type="text" hidden="true" value="<%=employee.getEmpid() %>" name="empid">
<input type="submit" value="Delete">
</form>
</td>
</tr>
<%} %>
</table>
</center>
</body>
</html>