<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="width:100%; height:100vh; background: linear-gradient(200deg,blue,red); background-repeat: no-repeat;">
<center>
<h1>Employee Registration</h1>
<form action="valuesintoemployeeobject" >
<input placeholder="Enter employee name" name="empname"><br><br>
<input placeholder="Enter employee salary" name="empsalary"><br><br>
<input placeholder="Enter employee deptno" name="empdeptno"><br><br>
<input type="reset">
<input type="submit" value="Registration" style="background: blue">
</form>
</center>
</body>
</html>