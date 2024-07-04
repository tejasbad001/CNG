<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.r3sys.connection.*" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Station</title>
</head>
<body>
<form action=AfterView method="post">
<%
	int id = Integer.parseInt(request.getParameter("id"));
	try
	{
		Connection con = Db_connection.connect();
  		PreparedStatement ps = con.prepareStatement("update register_cs set Status=? where id=?");
  		ps.setString(1, "Approved");
  		ps.setInt(2, id);
  		int i= ps.executeUpdate();
  		{
  			response.sendRedirect("AfterView.jsp");
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