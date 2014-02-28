<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

<%@ include file="css/mystyle.css" %>

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Botiga Itteria</title>
</head>
<body>
<H1 id="h1" align="center">Benvinguts al SUPERMERCAT ITTERIA!</H1>
<div id="divLogin">
<html:button property="button" value ="Log in" onclick="window.location='Login.jsp'" styleId="button" />
</div>
<div id="divRegister">
<html:button property="button" value ="Sign in" onclick="window.location='RegisterUser.jsp'" styleId="button" styleClass="btn btn-primary"/>
</div>
</body>
</html>