<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<html>
	<style type="text/css">
h2 { color: black;font-family:Verdana; }
}
<%@ include file="css/bootstrap.min.css" %>
body {
background-color:#D8D8D8;
}
</style>
	
<head>
</head>
<body>

	<h2>Struts - Validator Example</h2>

	Thanks you for the registration <%=session.getAttribute("nom")%>
	<html:link href="index.jsp"> TORNAR </html:link>

</body>
</html>