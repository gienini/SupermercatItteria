<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	<h2>Pagina de registre</h2>
	<br />
	<br /> Totes les dades estan correctes?
	<html:form action="/Validation">
		<bean:message key="label.user.username" /> : 
	<%=session.getAttribute("nick")%>
		<br />
		<bean:message key="label.user.name" />:
	<%=session.getAttribute("nom")%>
		<br />
		<bean:message key="label.user.age" />:
	<%=session.getAttribute("edat")%>
		<br />
		<bean:message key="label.user.email" /> : 
	<%=session.getAttribute("email")%>
		<br />
		<bean:message key="label.user.telephone" /> : 
	<%=session.getAttribute("telefon")%>
		<br />
		<bean:message key="label.user.compteb" /> : 
	<%=session.getAttribute("compteb")%>
		<br />

		<html:submit>
			<bean:message key="label.user.button.si" />
		</html:submit>
	</html:form>
	<input type="button" onClick="location.href='RegisterUser.jsp'"
		value='No'>



</body>
</html>