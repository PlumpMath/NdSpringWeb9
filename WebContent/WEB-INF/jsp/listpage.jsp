<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Page</title>


</head>
<body>


<h1>List Page</h1>

<c:if  test="${!empty userlist}">
<table class="data">
<%HttpSession sessions = request.getSession();%>
<tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>User Name</th>
    <th>Password</th>
     <%if(sessions.getAttribute("role_s").equals(4)){ %>
    <th>Update</th>
    <th>Delete</th>
    <%} %>
</tr>
<c:forEach items="${userlist}" var="user">
    
    <tr>
        <td>${user.firstname}</td>
        <td> ${user.lastname}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        
        <%if(sessions.getAttribute("role_s").equals(4)){ %>
        <td><a href="${pageContext.request.contextPath}/updateuser/${user.userid}">Update</a></td>
        <td><a href="${pageContext.request.contextPath}/deleteuser/${user.userid}">Delete</a></td>
        <%} %>
    </tr>
</c:forEach>
</table>
</c:if>
 


</body>
</html>