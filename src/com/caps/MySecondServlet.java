package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySecondServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstname = req.getParameter("fname");
		String lastname = req.getParameter("lname");
		
		System.out.println(firstname);
		System.out.println(lastname);
		PrintWriter out = resp.getWriter();
		out.println("<h1>The Date is: "+ new Date() +"</h1>");
		out.println("The Name is: "+firstname+ " "+ lastname);
	}
}