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
 * Servlet implementation class LoginStation
 */
public class LoginStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginStation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action1 = request.getParameter("action1");

        switch (action1) {
            case "RegisterStation":
                response.sendRedirect("addnewstation.html");
                break;
            case "ViewStation":
                response.sendRedirect("ViewStation.jsp");
                break;
            case "UpdatePowerServlet":
                response.sendRedirect("updatecng.html");
                break;
            default:
                response.sendRedirect("menu2.jsp");
                break;
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Connection con=Db_connection.connect();
		String mob = request.getParameter("mob");
		String password = request.getParameter("password");
		
		try
		{
			PreparedStatement ps1=con.prepareStatement("Select * from register_cs where mob=? AND password=? AND Status=?");
			ps1.setString(1, mob);
			ps1.setString(2, password);
			ps1.setString(3, "Approved");
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				// Login successful
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Login Successful..!!');");
                out.println("window.location.href = 'menu2.jsp';");
                out.println("</script>");
			}
			else
			{
				// Login Failed
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Login Failed..!!');");
                out.println("window.location.href = 'loginstation.html';");
                out.println("</script>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	}


