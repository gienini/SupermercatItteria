<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<html>
<style type="text/css">
h2 { color: black;font-family:Verdana; }
}
</style>

<head>
<title>Struts 2</title>
</head>
 
<body>
<h2>Login</h2>

<% if(session.getAttribute("fail") != null){
%>
	<c:out value="Invalid Username/Password"></c:out>
<%
session.removeAttribute("fail");
} %>
<html:form action="/Login">
	<br />
	<bean:message key="label.user.usuari" /> : 
	<html:text property="usuari" size="20" />
	<br />
	<bean:message key="label.user.clau" />
	<html:password property="clau" size="20" />
	<br />
	<html:submit>
		</html:submit>
</html:form>
</body>
</html>


