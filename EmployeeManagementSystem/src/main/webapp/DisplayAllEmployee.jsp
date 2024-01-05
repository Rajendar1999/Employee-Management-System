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
<title>Insert title here</title>
<style>
</style>
</head>
<body style="width:100%; height:100vh; background: linear-gradient(200deg,brown,violet); background-repeat: no-repeat;">
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
<form action="UpdatedEmployeeDetails">
<td><input value="<%=employee.getEmpid() %>" readonly="readonly" style="border: none; background: transparent;" ></td>
<td><input class="name" id="name" value="<%=employee.getEmpname() %>" name="empname"  readonly="readonly" style="border: none; background: transparent;"></td>
<td><input class="salary" id="salary" value="<%=employee.getEmpsalary() %>" name="empsalary"  readonly="readonly" style="border: none; background: transparent;"></td>
<td><input class="deptno" id="deptno" value="<%=employee.getEmpdeptno() %>" name="empdeptno"  readonly="readonly" style="border: none; background: transparent;"></td>
<td>
<input type="text" hidden="true" value="<%=employee.getEmpid() %>" name="empid">
<input style="background: blue" type="submit" value="Update" >
</form>
</td>
<td>
<form class="deleteform" >
<input type="text" hidden="true" value="<%=employee.getEmpid() %>" name="empid">
<input class="delete" style="background: red" type="submit" value="Delete" readonly="readonly">
</form>
</td>
</tr>
<%} %>
</table>
</center>
<script>

let inp=document.getElementsByClassName("name")
for (let index = 0; index < inp.length; index++) {
    inp[index].addEventListener("click",()=>{
        inp[index].removeAttribute("readonly")  
        //inp[index].style.border="1px"
        //inp[index].style.background="white"
    })
}
let inp1=document.getElementsByClassName("salary")
for (let index = 0; index < inp1.length; index++) {
    inp1[index].addEventListener("click",()=>{
        inp1[index].removeAttribute("readonly")                  
    })  
}
let inp2=document.getElementsByClassName("deptno")
for (let index = 0; index < inp2.length; index++) {
    inp2[index].addEventListener("click",()=>{
        inp2[index].removeAttribute("readonly")  
    })
}
let del=document.getElementsByClassName("delete")
for (let index = 0; index < del.length; index++) {
   		del[index].addEventListener("click",()=>{
    	let form=document.getElementsByClassName("deleteform")
    	var resp=confirm("Are you sure ?")
            if(resp){
            	form[index].setAttribute("action","DeleteEmployee")
            }
            else{
            	form[index].removeAttribute("action") 
            }
        
        
    })
}
</script>
</body>
</html>