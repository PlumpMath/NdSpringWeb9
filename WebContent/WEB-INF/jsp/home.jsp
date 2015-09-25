<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>
<script type="text/javascript">


	function createCookie(name, value, min) {
		//alert("createcame");
		if (min) {
			var date = new Date();
			date.setTime(date.getTime() + (min * 60 * 1000));
			var expires = "; expires=" + date.toGMTString();
		} else
			var expires = "";
		document.cookie = name + "=" + value + expires + "; path=/";
	}

	function readCookie(c_name) {

		var c_value = document.cookie;
		var c_start = c_value.indexOf(" " + c_name + "=");
		if (c_start == -1)
		  {
		  c_start = c_value.indexOf(c_name + "=");
		  }
		if (c_start == -1)
		  {
		  c_value = null;
		  }
		else
		  {
		  c_start = c_value.indexOf("=", c_start) + 1;
		  var c_end = c_value.indexOf(";", c_start);
		  if (c_end == -1)
		  {
		c_end = c_value.length;
		}
		c_value = unescape(c_value.substring(c_start,c_end));
		}
		return c_value;
	}

// 	function eraseCookie(name) {
// 		alert("erasecame");
// 		createCookie(name, "", -1);
// 	}

	function loadCookie() {
		
		var default_username = readCookie("cname_username");
		var default_password = readCookie("cname_password");
		//alert("uc="+default_username);
 		//alert("pc="+default_password);
		if (default_username === document.getElementById("un").value) {

			//document.getElementsByName("un").value = default_username;
			document.getElementById("pw").value = default_password;
			document.getElementById("chk_remember").checked = true;

		}

	}

	
	
	function loginclick(){
	//	alert("came in login");
	//	alert(document.getElementById("un"));
		var cookie_username1 = document.getElementById("un").value;
		var cookie_password1 = document.getElementById("pw").value;
	//	alert("hi");
	//	alert(cookie_username1);
	//	alert(cookie_password1);		
		if (document.getElementById("chk_remember").checked) {
			
	//		alert("checked");
			createCookie("cname_username", cookie_username1, 1);
			createCookie("cname_password", cookie_password1, 1);

		}
		else{
		//	alert("unchecked");
			eraseCookie("cname_username");
			eraseCookie("cname_password");
			
		}

		
	}
	
</script>
</head>
<title><tiles:insertAttribute name="title" ignore="true"/></title>
<body  >
<div class="login_area">
	<div class="login_topspac"></div>
	<div class="login_top"></div>
	<div class="login_middle">
		<div class="login_header">
			<div class="login_logo">
				<img src="images/logo.png" alt="" />
			</div>
			<div class="key_img">
				<img src="images/key.png" alt="" />
			</div>
		</div>
		<div class="login_content">
			<form:form name="loginform" method="post"  action="authenticate"
				modelAttribute="usermaster">
				<table width="100%" border="0" cellspacing="10" cellpadding="0">
					<tr>
						<td width="120" align="right"></td>
						<td><h2>Login Area</h2></td>
					</tr>
					<tr>
						<td align="right"><form:label path="username">
								<spring:message code="label.username" />
							</form:label></td>
						<td><form:input id="un" path="username" style="width:225px;" onblur="loadCookie()"/></td>
						<td><form:errors path="username" cssClass="error" /></td>
					</tr>
					<tr>
						<td align="right"><form:label path="password">
								<spring:message code="label.password" />
							</form:label></td>
						<td><form:password id = "pw" path="password" style="width:225px;" /></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>

					<tr>
						<td>&nbsp;</td>
						<td><input id="chk_remember" type="checkbox" value="" /> Remember me</td>
					</tr>

					<tr>
						<td>&nbsp;</td>
						<td>
						<a href="forget" class="link_password">Forget Password</a>
						</td>
					</tr>
					
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" onclick="loginclick()"
							value="<spring:message code="label.login" />"
							class="inputbutton btn_small" />
						<a href="register" class="link_password">Create New Account</a>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<div class="login_bottom"></div>
	<!--Login Area End-->
</div>
</body>
