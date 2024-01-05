package com.jsp.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@RequestMapping("/userRegistraion")
	public String userRegistration() {

		return "UserRegistration";
	}
	
	@RequestMapping("/userDetails")
	private void getUserDetails(@RequestParam("name") String username,@RequestParam("emailid")String useremailid,@RequestParam("mobilenum")String mobilenumber,@RequestParam("password")String userpassword) {
		System.out.println("User Name: "+username);
		System.out.println("User Email Id: " +useremailid);
		System.out.println("User Mobile Number : " +mobilenumber);
		System.out.println("User Password : "+userpassword);
	}
}
