package com.r3sys.functions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.r3sys.connection.Db_connection;


/**
 * Servlet implementation class RegisterStation
 */
public class RegisterStation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterStation() {
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
		String sname,address,city,taluka,district,otime,ctime,mob,latitude,longitude,password,status="Pending";
		sname = request.getParameter("sname");
		address = request.getParameter("address");
		city = request.getParameter("city");
		taluka = request.getParameter("taluka");
		district = request.getParameter("district");
		otime = request.getParameter("otime");
		ctime = request.getParameter("ctime");
		mob = request.getParameter("mob");
		latitude = request.getParameter("latitude");
		longitude = request.getParameter("longitude");
		password = request.getParameter("password");
		int cng = Integer.parseInt(request.getParameter("cng"));
		
		try
		{
			Connection con = Db_connection.connect();
			PreparedStatement ps1 = con.prepareStatement("insert into register_cs  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1, 0);
			ps1.setString(2, sname);
			ps1.setString(3, address);
			ps1.setString(4, city);
			ps1.setString(5, taluka);
			ps1.setString(6, district);
			ps1.setString(7, otime);
			ps1.setString(8, ctime);
			ps1.setString(9, mob);
			ps1.setString(10, latitude);
			ps1.setString(11, longitude);
			ps1.setString(12, password);
			ps1.setInt(13,cng);
			ps1.setString(14, status);
			int i = ps1.executeUpdate();
			if(i>0)
			{
				// Registration successful
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Registration Successful..!!');");
                out.println("window.location.href = 'ViewStation.jsp';");
                out.println("</script>");
			}
			else
			{
				// Registration Failed
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Registration Failed..!!');");
                out.println("window.location.href = 'addnewstation.html';");
                out.println("</script>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}

