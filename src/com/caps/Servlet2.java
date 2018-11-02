package com.caps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Cat;
import com.beans.Dog;

@WebServlet(urlPatterns="/servlet2", 
		initParams=@WebInitParam(name="pwd",value="root"))
public class Servlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("servlet2");
		
		Dog d = (Dog)req.getAttribute("dog");	
		
		ServletContext ctx = getServletContext();
		Cat c = (Cat)ctx.getAttribute("cat");
		
		PrintWriter out = resp.getWriter();
		out.println(d);
		out.println(c);
		
	}
}