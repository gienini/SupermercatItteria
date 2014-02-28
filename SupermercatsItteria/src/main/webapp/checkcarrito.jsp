<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ page import="com.market.VO.Sessio"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
h2 { color: black;font-family:Verdana; }
}
<%@ include file="css/bootstrap.min.css" %>
body {
background-color:#D8D8D8;
}
form {
	display: inline;
}
</style>
<head>
<title>Supermercat Iterria | Comprovació Comanda</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>rap</title>

</head>
<body>
<h1>Comprovació Comanda</h1><br></br>
	<jsp:useBean id="sessio" class="com.market.VO.Sessio" scope="session"/>




	Senyor
	<c:out value="${sessio.nick}" />
	la seva comanda es la seguent:
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

	<br></br> Que vols fer amb aquesta comanda:
	<br></br>

	<form action="mostrarproductes.jsp">
		<input type="submit" value="modificar-la">
	</form>
	<form action="guardarComanda.jsp">
		<input type="submit" value="guardar-la">
	</form>
	<form action="formulariConta.jsp">
		<input type="submit" value="pagar-la">
	</form>
</html>