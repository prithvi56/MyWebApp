package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/date1")
public class MyFirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String data = req.getParameter("data");
		/*String firstname = req.getParameter("fname");
		String lastname = req.getParameter("lname");
		
		System.out.println(firstname);
		System.out.println(lastname);
		
		
		out.println("<h1>The Date is : "+ new Date() +"</h1>");
		
		out.println("The name is : "+firstname+" "+lastname);*/
		
		out.print(data);
	}
}
