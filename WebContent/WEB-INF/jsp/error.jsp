<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR Page</title>
</head>
<body>
<%if(session.getAttribute("username_s") == null)
{
	try{
		response.sendRedirect("index.jsp");
		return;
		}
		catch(Exception e){
			response.sendRedirect("index.jsp");
			
		}
	}
else{
	session.invalidate();
	
}
	%>

<h1> Sorry , You are disabled by an Administrator </h1>

<a href="index.jsp">Login</a> 
</body>
</html>