<%@page import="com.market.dao.JNDIDAOProductes"%>
<%@page import="com.market.dao.IDAOProductes"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="java.io.ObjectInputStream.GetField"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%JNDIDAOProductes dades = new JNDIDAOProductes();
%>
<%@page import="java.util.*" %>
<%@page import="com.market.VO.*" %>
<title>Insert title here</title>
</head>
<body>

<br />
		<table border="1" cellpadding="1" cellspacing="1" style="width: 500px;">
			<tbody>
			<tr>
			<td>Producte</td><td>Quantitat</td><td>Preu</td><td>Imatge</td>
			</tr>
					<%
					int i;
					List<Producte> prod = new ArrayList<Producte>();
					prod = dades.getAll();
					Iterator it = prod.iterator();
					
		            // Recorrem el resultat, fins que hi hagi registres per legir, y escrivim el resultat per pantalla.
		            while(it.hasNext())
		            {
		            Producte producte = (Producte) it.next();
		            %>
		            
		                		<tr>
		                		
		                		<html:form action="/carro.do">
		                		
		                			<td><html:text property="nom" value="<%=producte.getNom()%>" /></td>
		                			
		                			<td><html:text  property="quantitat" value="0" /></td>
		                			
		                			<td><html:text property="preu"  value="<%=String.valueOf(producte.getPreu()) %>"  /></td>
		                			
		                			<html:hidden property="stock"  value="<%=String.valueOf(producte.getStock()) %>" />
		                			
		                			<html:hidden property="url"  value="<%=producte.getUrl() %>"/>
		                			
		                			<td><html:image src="<%=producte.getUrl() %>"></html:image></td>
		                			
		                			<td><html:submit value="Comprar"/></td>
		                			
		                		</html:form>
		                		
		                       	</tr>
		                  
		           <% }%>		
			</tbody>
		</table>
		<br />
		
		<html:link href="checkcarrito.jsp"> Continuar </html:link>

		

</body>
</html>