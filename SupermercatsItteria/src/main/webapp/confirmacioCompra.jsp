<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ page import="com.market.VO.Sessio"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supermercat Iterria | Confirmació pagament</title>
<style>
form {
	display: inline;
}
</style>
</head>
<body>
	<h1>Confirmació pagament</h1>
	<br></br>
	<jsp:useBean id="sessio" class="com.market.VO.Sessio" scope="session" />

	<%
		String targeta = (String) request.getAttribute("targeta");
		String adreça = (String) request.getAttribute("adreça");
		
	%>

	Senyor/a
	<c:out value="${sessio.nick}" />
	amb adreça
	<b><%=adreça%></b> i numero de targeta de credit
	<b><%=targeta%></b> ha realitzat la següent comanda:
	<br></br>

	<c:set var="salary" scope="session" value="${0}" />
	<table border="1">

		<tr>
			<th>Producte</th>
			<th>Quantitat</th>
			<th>Preu Producte</th>
			<th>Cost</th>
		</tr>
		<c:forEach items="${sessio.carrito}" var="item">
			<tr>
				<td><c:out value="${item.key.nom}" /></td>
				<td><c:out value="${item.value}" /></td>
				<td><c:out value="${item.key.preu}" /></td>
				<td><c:out value="${item.key.preu*item.value}" /></td>
				<c:set var="salary" scope="session"
					value="${(item.key.preu*item.value)+salary}" />
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td></td>
			<td><c:out value="Total" /></td>
			<td><c:out value="${salary}" /></td>
		</tr>
	</table>

	<br></br>
	<br></br>

	<form action="formulariConta.jsp">
		<input type="submit" value="Modificar dades de pagament">
	</form>
	<html:form action="logout">
		<input type="submit" value="Realitzar pagamanet">
	</html:form>
	
	

</body>
</html>