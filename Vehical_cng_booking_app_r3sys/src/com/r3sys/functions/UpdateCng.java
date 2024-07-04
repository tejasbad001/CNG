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
 * Servlet implementation class UpdateCng
 */
public class UpdateCng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCng() {
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
		String sname=request.getParameter("sname");
		int ucng=Integer.parseInt(request.getParameter("ucng"));
		int cng=0;
		try {
			 Connection con = Db_connection.connect();
	            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM register_cs WHERE sname=?");
	            ps1.setString(1, sname);
	            ResultSet rs = ps1.executeQuery();
	            while(rs.next()) 
	            {
	            	ucng=rs.getInt("cng");
	            } 
	            ucng=ucng-cng;
	            PreparedStatement ps2 = con.prepareStatement("update register_cs set cng=? WHERE sname=?");
	            ps2.setInt(1, ucng);
	            ps2.setString(2, sname);
	            int i=ps2.executeUpdate();
	            if(i>0)
	            {
	            	//Power Updated Successfully
	                response.setContentType("text/html");
	               
	                response.sendRedirect("ViewStation.jsp");
	            }
	            else
	            {
	            	//Failed to Update Power 
	            	 response.setContentType("text/html");
		             
	            	response.sendRedirect("updatecng.html");
	            }
	        } 
			catch (Exception e) 
			{
	            e.printStackTrace();
	        }
		
	}

}
