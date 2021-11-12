<%-- 
    Document   : RegistrarDetalleVentas
    Created on : 7 nov 2021, 23:27:19
    Author     : joako
--%>

<%@page import="modelo.Detalle_Factura"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalles de Factura</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body id='masterBody'>
        <div class="container mt-5">
            <h1 class="text-center">Numero de Factura: <c:out value="${sessionScope.Fac.idFactura}"/></h1>
            <form action="nuevoDetalle" method="POST" id='inputs'>
                <div class="row">
                    <div class=" col-md-6">
                        <label for="exampleInputEmail1" class="form-label">Seleccione Articulo</label>
                        <select name="cmbArticulos" class="form-select">
                            <option value="0">Seleccione...</option>
                            <c:forEach var="s" items="${requestScope.LA}">
                                <option value="${s.idArticulo}"><c:out value="${s.descripcion}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Ingrese Cantidad</label>
                        <input  name="txtCantidad" class="form-control" type="text" placeholder="Ingrese Cantidad">
                    </div>
                    <div class="col-md-12">
                        <label class="form-label">Precio</label>
                        <input name="txtPrecio" class="form-control" type="text" placeholder="Precio" disabled>
                    </div>

                    <div class="d-flex justify-content-center mt-5">
                        <button class="btn btn-dark" type="submit"  name="btnAgregar" id="btnAgregar" />Agregar Producto</button>                       

                    </div>
                </div>
            </form>
        </div>
        <div class="container mt-5">
            <table id="mytable" name="mytable" class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID Articulo</th>
                        <th>Descripcion</th>  
                        <th>Cantidad</th>
                        <th>Precio Unitario</th> 
                        <th>Descuento Obra Social</th>
                        <th>Precio c/ Descuentos</th> 
                        <th>Precio Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.LDA}" var="item">
                        <tr>
                            <td>${item.idArticulo}</td>  
                            <td>${item.descripcion}</td>            
                            <td>${item.cantidad}</td>   
                            <td>${item.precio}</td>  
                            <td>${item.descuentoObra}</td>
                            <td>${item.precioVenta}</td>   
                            <td style="background-color: grey">${item.precioVenta * item.cantidad }</td>  
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
            <div class="text-end">
                <h3>A pagar = ${sessionScope.precioTotal}</h3>
            </div>
        </div>
        <div id='botones'>
            <div class="d-flex justify-content-center mt-5" >
                <div class='me-4'>
                    <button class="btn btn-success" type="button" onclick="window.location = './nuevaFactura'" name="btnFinalizar" id="btnFinalizar" />Finalizar Venta</button>
                </div>
                <div class='ms-5'>
                    <button class="btn btn-warning" type="button" onclick="printDiv()" name="btnFinalizar" id="btnFinalizar" />Descargar Factura</button>
                </div>
            </div>
        </div>

    </body>
    <script>
        function printDiv() {
            // Create and insert new print section
            let form = document.getElementById("inputs");
            form.style.display = "none";
            let botones = document.getElementById("botones");
            botones.style.display = "none";
            window.print();

            window.location.href = "/Farmacia/nuevoDetalle"
            // Clean up print section for future use

            //oldElem.remove() not supported by IE

            return true;
        }
    </script>
</html>
