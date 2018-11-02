package com.caps;

import java.io.IOException;

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

@WebServlet(urlPatterns="/servlet1", 
		initParams=@WebInitParam(name="pwd",value="root"))
public class Servlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet1");
		
		Dog d = new Dog();
		d.setName("Bingo");
		d.setColor("White");
		d.setBreed("Pomerian");
		req.setAttribute("dog", d);
		
		
		Cat c = new Cat();
		c.setName("genie");
		c.setColor("black");
		c.setGender("male");
		
		ServletContext ctx = getServletContext();
		ctx.setAttribute("cat", c);
		
		
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/servlet2");
		dispatcher.include(req, resp);
	}
}