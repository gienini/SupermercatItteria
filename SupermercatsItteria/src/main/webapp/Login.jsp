<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
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
<link rel="stylesheet" href="<html:rewrite page='estil.css'/>" type="text/css" media="screen"/>
<script src="<c:url value="/js/jquery.min.js" />"></script>
<script src="<c:url value="/js/bootstrap.min.js" />"></script>
<title>Struts 2</title>
</head>
 
<body>

<div align="center">
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
	<html:text property="usuari" size="20" style="width:250px" styleClass="form-group form-control" />
	<br />
	<bean:message key="label.user.clau" />
	<html:password property="clau" size="20" style="width:250px" styleClass="form-group form-control" />
	<br />
	<html:submit>
		</html:submit>
</html:form>
</div>
</body>
</html>


