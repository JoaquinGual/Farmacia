/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Dtos.DtoCliente_Obra_Cobertura;
import Dtos.DtoDetalle_Articulo;
import controlador.gestorDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Detalle_Factura;
import modelo.Factura;

/**
 *
 * @author joako
 */
@WebServlet(name = "nuevoDetalle", urlPatterns = {"/nuevoDetalle"})
public class nuevoDetalle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        gestorDB gestor = new gestorDB();
        ArrayList<Factura> LF = gestor.obtenerFacturas();

        for (int i = 0; i < LF.size(); i++) {
            Factura fac = LF.get(i);
            HttpSession sessionUltimo = request.getSession(true);
            sessionUltimo.setAttribute("Fac", fac);

        }
        HttpSession sessionUltimo = (HttpSession) request.getSession();
        Factura f = (Factura) sessionUltimo.getAttribute("Fac");
        int idFactura = f.idFactura;
        ArrayList<Articulo> LA = gestor.obtenerArticulos();
        ArrayList<DtoDetalle_Articulo> LDA = gestor.obtenerDtoDetalle(idFactura);
        float precioTotal = 0;
        for (int i = 0; i < LDA.size(); i++) {
            precioTotal += LDA.get(i).getPrecioVenta() * LDA.get(i).getCantidad();
        }
        sessionUltimo.setAttribute("precioTotal", precioTotal);
        

        request.setAttribute("LA", LA);
        request.setAttribute("LDA", LDA);

        RequestDispatcher dispacher = getServletContext().getRequestDispatcher("/RegistrarDetalleVentas.jsp");
        dispacher.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        gestorDB gestor = new gestorDB();

        int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
        int idArticulo = Integer.parseInt(request.getParameter("cmbArticulos"));

        ArrayList<Articulo> LA = gestor.obtenerArticulosID(idArticulo);
        HttpSession sessionUltimo = (HttpSession) request.getSession();
        Factura f = (Factura) sessionUltimo.getAttribute("Fac");
        int idFactura = f.idFactura;
        ArrayList<DtoCliente_Obra_Cobertura> LCO = gestor.obtenerCoberturas(f.idCliente);
        float precioVenta = 0;
        float descuentoObra= 0;
        if (LCO.size() == 0) {
            if (f.idMetodo == 1) {
                precioVenta = LA.get(0).getPrecio() * Float.parseFloat(Double.toString(0.75));
            } else if (f.idMetodo == 2) {
                precioVenta = LA.get(0).getPrecio() * Float.parseFloat(Double.toString(1.10));
            } else {
                float precio = LA.get(0).getPrecio() / 2;
                float recargoTarjeta = precio * Float.parseFloat(Double.toString(1.10));
                float precioEfectivo = precio * Float.parseFloat(Double.toString(0.75));
                precioVenta = recargoTarjeta + precioEfectivo;
            }
        } else {

            for (int i = 0; i < LCO.size(); i++) {
                if (LCO.get(i).getIdArticulo() == idArticulo) {
                    if (f.idMetodo == 1) {
                        precioVenta = (LCO.get(i).getPrecio() - LCO.get(i).getDescuento()) * Float.parseFloat(Double.toString(0.75));                      
                    } else if (f.idMetodo == 2) {
                        precioVenta = LCO.get(i).getPrecio() - LCO.get(i).getDescuento() * Float.parseFloat(Double.toString(1.10));
                    } else {
                        float precio = (LCO.get(i).getPrecio() - LCO.get(i).getDescuento()) / 2;
                        float recargoTarjeta = precio * Float.parseFloat(Double.toString(1.10));
                        float precioEfectivo = precio * Float.parseFloat(Double.toString(0.75));
                        precioVenta = recargoTarjeta + precioEfectivo;
                    }
                    descuentoObra = LCO.get(i).getDescuento() * cantidad;

                    break;
                } else {
                    if (f.idMetodo == 1) {
                        precioVenta = LA.get(0).getPrecio() * Float.parseFloat(Double.toString(0.75));
                    } else if (f.idMetodo == 2) {
                        precioVenta = LA.get(0).getPrecio() * Float.parseFloat(Double.toString(1.10));
                    } else {
                        float precio = LA.get(i).getPrecio() / 2;
                        float recargoTarjeta = precio * Float.parseFloat(Double.toString(1.10));
                        float precioEfectivo = precio * Float.parseFloat(Double.toString(0.75));
                        precioVenta = recargoTarjeta + precioEfectivo;
                    }

                }
            }
        }
        Detalle_Factura df = new Detalle_Factura(0, cantidad, idArticulo, idFactura, precioVenta,descuentoObra);

        gestor.insertarDetalle(df);
        response.sendRedirect("/Farmacia/nuevoDetalle");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
