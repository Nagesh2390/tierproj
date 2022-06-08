package com.skillogic.tierprojservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillogic.pojos.UserPojo;
import com.skillogic.tierdb.DataAccess;

public class RegistrationServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		String userName=req.getParameter("userName");
		String userEmail=req.getParameter("userEmail");
		String userNumber=req.getParameter("userNumber");
		String gender=req.getParameter("gender");
		String city=req.getParameter("city");
		String address=req.getParameter("address");
		String [] hobbies=req.getParameterValues("hobbies");
		
		UserPojo up=new UserPojo();
		up.setUserName(userName);
		up.setUserEmail(userEmail);
		up.setUserNumber(userNumber);
		up.setGender(gender);
		up.setCity(city);
		up.setAddress(address);
		String hb="";
		for(String h:hobbies)
			hb=hb+h;
		up.setHobbies(hb);
		
		DataAccess da=new DataAccess();
		int i=da.insert(up);
		if(i>=0) {
			RequestDispatcher rds=req.getRequestDispatcher("Success.html");
			rds.forward(req, res);
		}
		else{
			RequestDispatcher rds=req.getRequestDispatcher("Failure.html");
			rds.forward(req, res);
		}
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
