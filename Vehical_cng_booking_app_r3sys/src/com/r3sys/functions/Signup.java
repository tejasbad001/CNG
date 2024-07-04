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
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
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
	    String location = request.getParameter("location");
	    String area = request.getParameter("area");
	    String password = request.getParameter("password");
	    try {
	    	Connection con = Db_connection.connect();
	        PreparedStatement ps1 = con.prepareStatement("SELECT * FROM admin WHERE email=?");
	        ps1.setString(1, email);
	        ResultSet rs = ps1.executeQuery();
	        if (rs.next()) {
	        	// User Already Exists!
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User Already Exists!');");
                out.println("window.location.href = 'login.html';");
                out.println("</script>");
	        } else {
	            // Insert details into the table
	            PreparedStatement ps2 = con.prepareStatement("INSERT INTO admin VALUES (?, ?, ?, ?, ?, ?)");
	            ps2.setString(1, name);
	            ps2.setString(2, email);
	            ps2.setString(3, mob);
	            ps2.setString(4, location);
	            ps2.setString(5, area);
	            ps2.setString(6, password);
	            int i = ps2.executeUpdate();
	            if (i > 0) {
	            	// Registration successful
	                response.setContentType("text/html");
	                
	                response.sendRedirect("login.html");
	            } else {
	            	// Registration Failed
	                
	                response.sendRedirect("registeruser.html");
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
		
	}


