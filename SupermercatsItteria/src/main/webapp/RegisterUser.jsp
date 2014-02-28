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
</head>
<body>

	<h2>Pagina de registre</h2>
	<br />
	<br />
	<% if(session.getAttribute("fail") != null){
	%>
	<c:out value="El nom d'Usuari ja esxisteix"></c:out>
	<%
	session.removeAttribute("fail");
	} %>
	<font color="red"> <html:errors />
	</font>

	<html:form action="/Register">
		<br />
		<bean:message key="label.user.username" /> : 
<html:text property="nick" size="20" />
		<br />
		<bean:message key="label.user.name" />
<html:text property="nom" size="20" />
		<br />
		<bean:message key="label.user.age" />
<html:text property="edat" size="20" />
		<br/>
		<bean:message key="label.user.pwd" /> : 
<html:password property="pass" size="20" />
		<br />
		<bean:message key="label.user.pwd2" /> : 
<html:password property="pass2" size="20" />
		<br />
		<bean:message key="label.user.email" /> : 
<html:text property="email" size="20" />
		<br />
		<bean:message key="label.user.telephone" /> : 
<html:text property="telefon" size="20" />
		<br />
		<bean:message key="label.user.compteb" /> : 
<html:text property="compteb" size="20" />
		<br />
		<br />
		<html:submit>
			<bean:message key="label.user.button.submit" />
		</html:submit>

	</html:form>

</body>
</html>