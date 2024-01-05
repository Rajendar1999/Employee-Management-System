<%@page import="com.jsp.employee.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Employee employee=(Employee)request.getAttribute("employee");%>
<center>
<form action="UpdatedEmployeeDetails">
<input type="text" value="<%=employee.getEmpid()%>" name="empid" hidden="true"><br><br>
<input type="text" value="<%=employee.getEmpname()%>" name="empname"><br><br>
<input type="text" value="<%=employee.getEmpsalary()%>" name="empsalary"><br><br>
<input type="text" value="<%=employee.getEmpdeptno()%>" name="empdeptno"><br><br>
<input type="submit" value="Update">
</form>
</center>
</body>
</html>