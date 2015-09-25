<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link href="${pageContext.request.contextPath}/css/stylesheet.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="main" class="mainbg">
		<div id="wrapper">
			<!--main area start-->
			<div id="header">
				<tiles:insertAttribute name="header" />
				<tiles:insertAttribute name="menu" />
			</div>
			<tiles:insertAttribute name="body" />
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>