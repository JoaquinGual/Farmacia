<%-- 
    Document   : RegistrarVentas
    Created on : 4 nov 2021, 2:03:53
    Author     : joako
--%>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.gestorDB"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <select name="cmbClientes">
            <option value="0">Seleccione...</option>
             <c:forEach var="s" items="${requestScope.LC}">
                <option value="${s.idCliente}"><c:out value="${s.nombre}"/></option>
                </c:forEach>
        </select>
         <select name="cmbProfesionales">
             <option value="0">Seleccione...</option>
             <c:forEach var="s" items="${requestScope.LP}">
                <option value="${s.idProfesional}"><c:out value="${s.nombre}"/></option>
                </c:forEach>
        </select>
    </body>
</html>
