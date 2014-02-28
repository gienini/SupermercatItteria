<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Supermercat Iterria | Formulari de pagament</title>
    </head>
    <body>
    <h1>Formulari de pagament</h1>
    
  
    <html:form action="conta">
    <ul>
    <li>
    	 <bean:message key="label.usertarjeta" />
         <html:text property="usertarjeta"></html:text>
         <html:errors property="usertarjeta"/>
     </li>
     <li>
        <bean:message key="label.useradreça"/>
        <html:text property="useradreça"></html:text>
        <html:errors property="useradreça"/>
        <br/>
     </li>
     </ul>
        <html:submit/>
    </html:form>
    </body>
</html>