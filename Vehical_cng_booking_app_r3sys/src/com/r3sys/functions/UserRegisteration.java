package com.r3sys.functions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.connection.Db_connection;



/**
 * Servlet implementation class UserRegisteration
 */
public class UserRegisteration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisteration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String mob = request.getParameter("mob");
	    String pass = request.getParameter("pass");
	    String city = request.getParameter("city");
	    try {
	    	Connection con = Db_connection.connect();
	        PreparedStatement ps1 = con.prepareStatement("SELECT * FROM user WHERE email=?");
	        ps1.setString(1, email);
	        ResultSet rs = ps1.executeQuery();
	        if (rs.next()) {
	            System.out.println("User Already Exists!");
	            response.sendRedirect("UserLogin.html");
	        } else {
	            // Insert details into the table
	            PreparedStatement ps2 = con.prepareStatement("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?)");
	            ps2.setInt(1, 0);
	            ps2.setString(2, name);
	            ps2.setString(3, email);
	            ps2.setString(4, mob);
	            ps2.setString(5, pass);
	            ps2.setString(6, city);
	            int i = ps2.executeUpdate();
	            if (i > 0) {
	            	// Registration successful
	                response.setContentType("text/html");
	                PrintWriter out = response.getWriter();
	                out.println("<script type=\"text/javascript\">");
	                out.println("alert('Registration Successful..!!');");
	                out.println("</script>");
	                response.sendRedirect("UserLogin.html");
	            } else {
	            	// Registration Failed
	                response.setContentType("text/html");
	                PrintWriter out = response.getWriter();
	                out.println("<script type=\"text/javascript\">");
	                out.println("alert('Registration Failed..!!');");
	               
	                out.println("</script>");
	                response.sendRedirect("UserRegistration.html");
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
