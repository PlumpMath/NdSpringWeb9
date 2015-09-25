<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
</head>
<body>

<a href="listpage">Back</a>
 <%HttpSession sessions = request.getSession();%>
<div class="titlebg"><h2><%=sessions.getAttribute("username_s") %>&rsquo;s Profile</h2></div>
            <div class="form_field top_pad">
            <div class="content_block">
           	<form:form method="post" action="${pageContext.request.contextPath}/updateselecteduser.html" modelAttribute="updateusermodel">

            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td valign="top">
                    	<table width="100%" border="0" cellspacing="10" cellpadding="0">
                          <tr>
                            <td align="right"><form:label path="userid">
						<spring:message code="label.userid" />
					</form:label></td>
                            <td><form:input path="userid" readonly="true" /></td>
                          </tr>
                          <tr>
                            <td align="right"><form:label path="firstname">
						<spring:message code="label.firstname" />
					</form:label></td>
                            <td><form:input path="firstname" /></td>
							<form:errors path="firstname" cssClass="error" />
                          </tr>
                          <tr>
                            <td align="right"><form:label path="lastname">
						<spring:message code="label.lastname" />
					</form:label></td>
                            <td><form:input path="lastname"></form:input></td>
							<form:errors path="lastname" cssClass="error"/>
                          </tr>
                          <tr>
                            <td align="right"><form:label path="username">
						<spring:message code="label.username" />
					</form:label></td>
                            <td><form:input path="username" /></td>
							<form:errors path="username" cssClass="error" />
                          </tr>
                          <tr>
                            <td >&nbsp;</td>
							
                            <td><input type="submit" class="inputbutton btn_small"
					value="<spring:message code="label.updateuser"/>" /></td>
                          </tr>
                        </table>
                    </td>
                    <td width="50">&nbsp;</td>
                    <td valign="top"><table width="100%" border="0" cellspacing="10" cellpadding="0">
                          <tr>
                            <td align="right">State/Province:</td>
                            <td><select name="select" id="select">
                              <option>Please Select</option>
                            </select></td>
                          </tr>
                          <tr>
                            <td align="right"> Country;</td>
                            <td><select name="select2" id="select2">
                              <option>Please Select</option>
                            </select></td>
                          </tr>
                          <tr>
                            <td align="right"><form:label path="password">
						<spring:message code="label.password" />
					</form:label></td>
                            <td><form:input  path="password" /></td>
							<form:errors  path="password" cssClass="error" />
                          </tr>
                          <tr>
                            <td align="right"><form:label path="roleid">
						<spring:message code="label.roleid" />
					</form:label></td>
                            <td><form:input path="roleid" /></td>
							<form:errors path="roleid" cssClass="error" />
                          </tr>
                        </table></td>
                  </tr>
                </table>
			</form:form>
            </div>
         </div>