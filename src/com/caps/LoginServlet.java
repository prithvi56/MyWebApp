package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Driver;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String User_Sid = req.getParameter("sid");
		String User_Pass = req.getParameter("pass");
		PrintWriter out = resp.getWriter();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			/*
			 * 1. Load the Driver
			 */
			java.sql.Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Driver Loaded...");

			/*
			 * 2. Get the DB Connection via Driver
			 */
			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db?user=root&password=root";
			con = DriverManager.getConnection(dbUrl); //1st version of getConnection

			System.out.println("Connected...");

			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "select * from students_info where sid=? and password=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(User_Sid));
			pstmt.setString(2, User_Pass);
			rs = pstmt.executeQuery();

			/*
			 * 4. Process the results
			 */
						
			if(rs.next())
			{
				HttpSession session = req.getSession();
				
				int regno = rs.getInt("sid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String passwd = rs.getString("password");
				String type = rs.getString("type");

				out.println(regno);
				out.println(firstname);
				out.println(lastname);
				out.println(gender);
				out.println(passwd);
				out.println(type);
				out.println("*********************");
			}else {
				out.println("Login Failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}







//////////////////////////////////////////////////



