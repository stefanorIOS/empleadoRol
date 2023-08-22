<%@page import="java.util.LinkedList"%>
<%@page import="Entities.Empleado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    


    
    <title>Foodtruck</title>
    
    <%LinkedList<Empleado> le = (LinkedList<Empleado>)request.getAttribute("listaEmpleados");%>
</head>
<body>

<main>
   <div >
		<div >
            <h1>Listado de Empleados</h1>
            <table>
                <thead>
                <tr>
                    <th>DNI</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
               
                    <th>Estado</th>
                    <th>Editar</th>
                </tr>
                </thead>
                <tbody>
                <% for (Empleado e : le){ %>
                    <tr>
                        <td><%=e.getDni()%></td>
                        <td><%=e.getNombre()%></td>
                        <td><%=e.getApellido() %></td>
                        
                     <%--    <td class="link"><a href="empleadoestado?dni=<%=e.getDni()%>"><%=(e.getHabilitado())?"<i class=\"fa-regular fa-circle-check\"></i>":"<i class=\"fa-regular fa-circle-xmark\"></i>" %></a></td>
                        <td class="link"><a href="empleadoeditar?dni=<%=e.getDni()%>"><i class="fa-solid fa-pencil"></i></a></td>
                        --%>
                        
                    </tr>
                <% }%>
                </tbody>
            </table>
           
        </div>
	</div>
	
</main>
	
	
</body>
</html>