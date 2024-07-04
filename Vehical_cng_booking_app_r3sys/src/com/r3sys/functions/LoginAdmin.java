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
import com.r3sys.functions.*;



/**
 * Servlet implementation class LoginAdmin
 * @param <User>
 */
public class LoginAdmin<User> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*String action = request.getParameter("action");

        switch (action) {
            case "ViewAllStations":
                response.sendRedirect("ViewAllStations.jsp");
                break;
            case "approvestation":
                response.sendRedirect("AfterView.jsp");
                break;
            case "deletestation":
                response.sendRedirect("ViewAllStations.jsp");
                break;
            default:
                response.sendRedirect("Menu.jsp");
                break;
        }
	}*/
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Connection con=Db_connection.connect();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try
		{
			PreparedStatement ps1=con.prepareStatement("Select * from admin where email=? AND password=?");
			ps1.setString(1, email);
			ps1.setString(2, password);
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				if(email.equals("admin@gmail.com") && password.equals("admin"))
				{
		             
		             // Login successful
		             response.setContentType("text/html");
		             PrintWriter out = response.getWriter();
		             out.println("<script type=\"text/javascript\">");
		             out.println("alert('Login Successful..!!');");
		             out.println("window.location.href = 'Menu.jsp';");
		             
		             out.println("</script>");
				}
			}
			else
				{
					// Login Failed
	                response.setContentType("text/html");
	                PrintWriter out = response.getWriter();
	                out.println("<script type=\"text/javascript\">");
	                out.println("alert('Login Failed..!!');");
	                out.println("window.location.href = 'Login.html';");
	                out.println("</script>");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}



	}


