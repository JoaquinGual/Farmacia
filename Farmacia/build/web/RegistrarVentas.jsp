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
        <title>Nueva Venta</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-5">
            <div class="container-fluid">
                <a class="navbar-brand" href="nuevaFactura">Farmacia Joita</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="nuevaFactura">Registrar Venta</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Dropdown
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Disabled</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>

        <div class="text-center">
            <h1>Registrar Nueva Venta</h1>
        </div>

        <div class="container mt-5" id="div">
            <hr/>
            <form id="nuevaFactura" method="POST" action="nuevaFactura">

                <div class="row">
                    <div class=" col-md-6">
                        <label for="exampleInputEmail1" class="form-label">Seleccione Cliente</label>
                        <select name="cmbClientes" class="form-select">
                            <option value="0">Seleccione...</option>
                            <c:forEach var="s" items="${requestScope.LC}">
                                <option value="${s.idCliente}"><c:out value="${s.nombre}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-6">

                        <label for="exampleInputEmail1" class="form-label">Seleccione Profesional</label>
                        <select name="cmbProfesionales" class="form-select">
                            <option value="0">Seleccione...</option>
                            <c:forEach var="s" items="${requestScope.LP}">
                                <option value="${s.idProfesional}"><c:out value="${s.nombre}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-12">

                        <label for="exampleInputEmail1" class="form-label">Metodo de Pago</label>
                        <select name="cmbMetodoPago" class="form-select">
                            <option value="0">Seleccione...</option>
                            <c:forEach var="s" items="${requestScope.LMP}">
                                <option value="${s.idMetodo}"><c:out value="${s.descripcion}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-12">
                        <label for="exampleInputEmail1" class="form-label">Sucursal</label>
                        <select name="cmbSucursal" class="form-select">
                            <option value="0">Seleccione...</option>
                            <c:forEach var="s" items="${requestScope.LS}">
                                <option value="${s.idSucursal}"><c:out value="${s.direccion}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="d-flex justify-content-center mt-5">
                        <button class="btn btn-dark" type="submit"  name="btnGenerar" id="btnGenerar" />Generar Factura Nueva</button>
                    </div>
                    <div class="d-flex justify-content-center mt-5">
                <button class="btn btn-success" type="button" onclick="window.location = './nuevoDetalle'" name="btnFinalizar" id="btnFinalizar" />Retomar Factura anterior</button>
            </div>
                </div>
            </form>
        </div>
    </body>
</html>
