<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page import="com.market.VO.*"%>
<%@page import="java.util.*;" %>
<div>
<font color="red">
<html:errors/>
</font>
<%//Tenim que obtenir el Map de la sessió
	//En aquest exemple tenim un Map<Producte,Integer>
	Sessio sessio = (Sessio)session.getAttribute("sessio");
	HashMap<Producte, Integer> carrito = new HashMap<Producte,Integer>();
	carrito = (HashMap<Producte, Integer>)sessio.getCarrito();
	
	if(!carrito.isEmpty()){
  %>
 
 	<h1>Carret de la compra</h1>
	<table border="0" cellpadding=""1 cellspacing="1" style="width: 500px;">
		<tbody>
		
		<tr S><td>Producte</td><td>Quantitat</td><td>Imatge</td></tr>
	<%
		//Llistem els keys del Map
		Iterator it = carrito.entrySet().iterator();
		while( it.hasNext() ){ 
			Producte producte = ((Producte)((Map.Entry)it.next()).getKey());
		%>
		<tr>
		<html:form action="DeleteProduct.do">	
				<td><%=producte.getNom()%></td>
				<td><%=carrito.get(producte) %></td>
				<html:hidden property="nom" value="<%=producte.getNom()%>"/>
				<html:hidden property="preu" value="<%=String.valueOf(producte.getPreu())%>"/>
				<html:hidden property="stock" value="<%=String.valueOf(producte.getStock())%>" />
				<html:hidden property="url" value="<%=producte.getUrl()%>"/>
				<td><html:img src="<%=producte.getUrl() %>"/></td>
				<td><html:submit styleClass="btn btn-primary">Elimina</html:submit></td>
		</html:form>
		
		</tr>
		<% } %>
		<!-- <tr><td>Total</td><td></td><td>1000$</td><td></td></tr>-->
		</tbody>
	</table>
	<%} %>
</div>