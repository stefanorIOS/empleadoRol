<%@page import="Entities.Empleado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to the JSP</title>

<% Empleado p1 = new Empleado(); %> 
<% p1 = (Empleado) request.getAttribute("usuario"); %>



</head>
<body>
	<h1>Esta es su sesion</h1>
	<h1><%=p1.getNombre()%></h1>
	<h1><%=p1.getDni()%></h1>
	
	 <a class="btn btn-info" role="button" href="cerrarSessionServlet">Cierre session</a>

</body>
</html>