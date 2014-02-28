<%@page import="com.market.dao.JNDIDAOSessions"%>
<%@page import="com.market.VO.Sessio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Supermercat Iterria |Guardar comanda</title>
<style>
form {
	display: inline;
}
</style>
</head>
<body>
	<h1>Guardar comanda</h1>
	<br></br> Si guarda ara la comanda també tancara la sessió i el proxim
	com que es conecti podra seguir amb la comanda.
	<br></br> Esta d'acord a tancar la comanda?
	<br></br>
	<form action="mostrarproductes.jsp">
		<input type="submit" value="modificar-la">
	</form>
	<form action="index.jsp">
		
		<input type="submit" value="guardar-la">
	</form>
</body>
</html>