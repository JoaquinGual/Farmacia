/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

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
import modelo.Cliente;
import modelo.Factura;
import modelo.MetodoPago;
import modelo.Profesional;
import modelo.Sucursal;

/**
 *
 * @author joako
 */
@WebServlet(name = "nuevaFactura", urlPatterns = {"/nuevaFactura"})
public class nuevaFactura extends HttpServlet {

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
        ArrayList<Cliente> LC = gestor.obtenerClientes();
        ArrayList<Profesional> LP = gestor.obtenerProfesionales();
        ArrayList<MetodoPago> LMP = gestor.obtenerMetodosPago();
        ArrayList<Sucursal> LS = gestor.obtenerSucursales();
        
        
        request.setAttribute("LMP", LMP);
        request.setAttribute("LC", LC);
        request.setAttribute("LP", LP);
        request.setAttribute("LS", LS);
        RequestDispatcher dispacher = getServletContext().getRequestDispatcher("/RegistrarVentas.jsp");
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
        //Insertar Factura
        int cliente = Integer.parseInt(request.getParameter("cmbClientes"));
        int profesional = Integer.parseInt(request.getParameter("cmbProfesionales"));
        int metodoPago = Integer.parseInt(request.getParameter("cmbMetodoPago"));
        int sucursal = Integer.parseInt(request.getParameter("cmbSucursal"));
        Factura f = new Factura(0,cliente, profesional, metodoPago, sucursal);
        gestorDB gestor = new gestorDB();
        gestor.insertarFactura(f);
        
        

        
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
