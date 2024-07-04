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
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action2 = request.getParameter("action2");

        switch (action2) {
            case "UserRegistrationServlet":
                response.sendRedirect("UserRegistration.html");
                break;
            case "ViewStation":
                response.sendRedirect("ViewStation.jsp");
                break;
            default:
                response.sendRedirect("menu3.jsp");
                break;
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		 try {
			 Connection con = Db_connection.connect();
	            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM user WHERE email=? AND pass=?");
	            ps1.setString(1, email);
	            ps1.setString(2, pass);
	            ResultSet rs = ps1.executeQuery();
	            if(rs.next()) 
	            {
	            	// Login successful
	                response.setContentType("text/html");
	                PrintWriter out = response.getWriter();
	                out.println("<script type=\"text/javascript\">");
	                out.println("alert('Login Successful..!!');");
	                
	                response.sendRedirect("menu3.jsp");
	            } else {
	            	// Login Failed
	                response.setContentType("text/html");
	                PrintWriter out = response.getWriter();
	                out.println("<script type=\"text/javascript\">");
	                out.println("alert('Login Failed..!!');");
	               
	                out.println("</script>");
	                response.sendRedirect("UserLogin.htm");

	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
