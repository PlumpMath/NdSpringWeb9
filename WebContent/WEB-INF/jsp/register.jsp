<%@page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style>
.error {
color: #ff0000;
font-style: italic;
}

</style>

</head>
<body>
<tiles:insertAttribute name="header" ignore="true" />

<a href="login">Back</a>

 <a href="./register?lang=en">en</a>
    |
    <a href="./register?lang=fr">fr</a>

	<form:form method="post" action="add" modelAttribute="umaster">

		<table>
			<tr>
				<td><form:label path="firstname">
						<spring:message code="label.firstname" />
					</form:label></td>

				<td><form:input path="firstname" /></td>
				<td><form:errors path="firstname" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">
						<spring:message code="label.lastname" />
					</form:label></td>

				<td><form:input path="lastname"/></td>
				<td><form:errors path="lastname" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="username">
						<spring:message code="label.username" />
					</form:label></td>

				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message code="label.password" />
					</form:label></td>

				<td><form:input  path="password" /></td>
				<td><form:errors  path="password" cssClass="error" /></td>
			</tr>
			
						<tr>
				<td><form:label path="roleid">
						<spring:message code="label.roleid" />
					</form:label></td>

				<td><form:input  path="roleid"  /></td>
				<td><form:errors  path="roleid" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td><input type="submit"
					value="Add User" /></td>

				<td><input type="reset"
					value="Cancel"/></td>
			</tr>

		</table>

	</form:form>
	
	<tiles:insertAttribute name="footer" ignore="true" />
</body>
</html>