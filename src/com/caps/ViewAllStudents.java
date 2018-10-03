package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

@WebServlet("/ViewAllStudents")
public class ViewAllStudents extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
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
			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db"
					+ "?user=root&password=prithvi57";
			con = DriverManager.getConnection(dbUrl); //1st version of getConnection

			System.out.println("Connected...");

			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "select * from students_info";

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			/*
			 * 4. Process the results
			 */
			out.print("<html>");
			out.print("<body>");
			out.print("<h1 align=center>View All Students Info</h1>");
			
			out.print("<table border=2px height=200px width=500px align=center>");
			out.print("<tr><th>Sid</th> <th>firstname</th> <th>lastname</th> "+
			"<th>gender</th> <th>password</th> <th>type</th>");
						
			while(rs.next()){
				
				out.print("<tr><td align=center>"+rs.getInt("sid")+"</td>"
						+"<td align=center>"+ rs.getString("firstname")+ "</td>"
						+"<td align=center>"+rs.getString("lastname")+"</td>"
						+"<td align=center>"+rs.getString("gender")+"</td>"
						+"<td align=center>"+rs.getString("password")+"</td>"
						+"<td align=center>"+rs.getString("type")+"</td></tr>");
				
			}
			out.print("</table border=2px>");
			out.print("</body>");
			out.print("</html>");
			
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
				stmt.close();
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

