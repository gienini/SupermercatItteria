<%@page import="com.market.VO.Producte"%>
<%@page import="com.market.VO.Sessio"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

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
<title>Welcome</title>
</head> 
<%! Sessio s = null; %>
 <% s=(Sessio)session.getAttribute("sessio");
 out.print(s.getCarrito().get(new Producte("pera"))); %>
<body>
    <h2>Hola!</h2><br>
</body>
</html>