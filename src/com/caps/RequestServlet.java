package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/date")

public class RequestServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str = req.getParameter("name");
		String[] str1 = req.getParameterValues("name");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>getParameter() : "+ str +"</h1>");
		
		out.println("<h1>getParameterValues() : "+ Arrays.toString(str1)+"</h1>");

	}
}
