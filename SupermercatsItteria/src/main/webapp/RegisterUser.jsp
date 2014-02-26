<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<html>
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
<html:text property="username" size="20" />
		<br />
		<bean:message key="label.user.name" />
<html:text property="name" size="20" />
		<br />
		<bean:message key="label.user.age" />
<html:text property="age" size="20" />
		<br/>
		<bean:message key="label.user.pwd" /> : 
<html:password property="pwd" size="20" />
		<br />
		<bean:message key="label.user.pwd2" /> : 
<html:password property="pwd2" size="20" />
		<br />
		<bean:message key="label.user.email" /> : 
<html:text property="email" size="20" />
		<br />
		<bean:message key="label.user.telephone" /> : 
<html:text property="telephone" size="20" />
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