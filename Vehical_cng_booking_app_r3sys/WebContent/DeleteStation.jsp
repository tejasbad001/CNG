<%@page import="com.r3sys.connection.*" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Station</title>
</head>
<body>
<form action=ViewAllStations method="post">
<%
	int id = Integer.parseInt(request.getParameter("id"));
	try
	{
		Connection con = Db_connection.connect();
  		PreparedStatement ps = con.prepareStatement("delete from register_cs where id=?");
  		ps.setInt(1, id);
  		int i= ps.executeUpdate();
  		{
  			response.sendRedirect("ViewAllStations.jsp");
  		}
	}
	catch(Exception e)
	{
		response.sendRedirect("DeleteStation.jsp");
		e.printStackTrace();
	}
%>
</form>
</body>
</html>