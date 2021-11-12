/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Dtos.DtoCliente_Obra_Cobertura;
import Dtos.DtoDetalle_Articulo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Detalle_Factura;
import modelo.Factura;
import modelo.MetodoPago;
import modelo.Profesional;
import modelo.Sucursal;

/**
 *
 * @author joako
 */
public class gestorDB {

    public gestorDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(gestorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    String serverBD = "jdbc:sqlserver://DESKTOP-NTLRIRS\\JOAQUIN:1433;databaseName=Farmacia";
    String userBD = "sa";
    String passBD = "1234";

    //---------------------------------------------Obtener de tabla----------------------------------------------------------------------
    public ArrayList<DtoCliente_Obra_Cobertura> obtenerCoberturas(int id) {

        ArrayList<DtoCliente_Obra_Cobertura> LCO = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select c.idCliente,c.nombre,co.idObraSocial,os.nombre,co.idArticulo,co.descuento ,a.precio\n"
                    + "from Clientes c join Obras_Sociales os on c.idObraSocial = os.idObraSocial join Coberturas co on co.idObraSocial = os.idObraSocial join Articulos a on a.idArticulo = co.idArticulo\n"
                    + "where idCliente = " + id);

            while (rs.next()) {

                int idCliente = rs.getInt(1);
                String nombre = rs.getString(2);
                int idObraSocial = rs.getInt(3);
                String nombreObraSocial = rs.getString(4);
                int idArticulo = rs.getInt(5);
                int descuento = rs.getInt(6);
                float precio = rs.getFloat(7);

                DtoCliente_Obra_Cobertura co = new DtoCliente_Obra_Cobertura(idCliente, nombre, idObraSocial, nombreObraSocial, idArticulo, descuento, precio);
                LCO.add(co);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception exc) {

            exc.printStackTrace();

        }

        return LCO;
    }

    public ArrayList<Cliente> obtenerClientes() {

        ArrayList<Cliente> LC = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Clientes");

            while (rs.next()) {

                int idCliente = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                int idObraSocial = rs.getInt(4);

                Cliente c = new Cliente(idCliente, nombre, apellido, idObraSocial);
                LC.add(c);

            }

            rs.close();
            st.close();
            conn.close();

        } catch (Exception exc) {

            exc.printStackTrace();

        }

        return LC;

    }

    public ArrayList<Profesional> obtenerProfesionales() {

        ArrayList<Profesional> LP = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Profesionales");

            while (rs.next()) {

                int idProfesional = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                int matricula = rs.getInt(4);

                Profesional p = new Profesional(idProfesional, nombre, apellido, matricula);
                LP.add(p);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception exc) {

            exc.printStackTrace();

        }

        return LP;
    }

    public ArrayList<MetodoPago> obtenerMetodosPago() {

        ArrayList<MetodoPago> LMP = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Metodos_Pago");

            while (rs.next()) {

                int idMetodo = rs.getInt(1);
                String descripcion = rs.getString(2);

                MetodoPago mp = new MetodoPago(idMetodo, descripcion);
                LMP.add(mp);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception exc) {

            exc.printStackTrace();

        }

        return LMP;
    }

    public ArrayList<Sucursal> obtenerSucursales() {

        ArrayList<Sucursal> LS = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Sucursales");

            while (rs.next()) {

                int idSucursal = rs.getInt(1);
                String direccion = rs.getString(2);

                Sucursal s = new Sucursal(idSucursal, direccion);
                LS.add(s);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception exc) {

            exc.printStackTrace();

        }

        return LS;
    }

    public ArrayList<Articulo> obtenerArticulosID(int id) {

        ArrayList<Articulo> LA = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Articulos where idArticulo=" + id);

            while (rs.next()) {

                int idArticulo = rs.getInt(1);
                String descripcion = rs.getString(2);
                float precio = rs.getFloat(3);
                int stockActual = rs.getInt(4);
                int stockMinimo = rs.getInt(5);
                boolean ventaLibre = rs.getBoolean(6);
                int idTipo = rs.getInt(7);

                Articulo a = new Articulo(idArticulo, descripcion, precio, stockActual, stockMinimo, ventaLibre, idTipo);
                LA.add(a);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception exc) {

            exc.printStackTrace();

        }

        return LA;
    }

    public ArrayList<Articulo> obtenerArticulos() {

        ArrayList<Articulo> LA = new ArrayList<>();
        ArrayList<Articulo> LAS = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Articulos");

            while (rs.next()) {

                int idArticulo = rs.getInt(1);
                String descripcion = rs.getString(2);
                float precio = rs.getFloat(3);
                int stockActual = rs.getInt(4);
                int stockMinimo = rs.getInt(5);
                boolean ventaLibre = rs.getBoolean(6);
                int idTipo = rs.getInt(7);

                Articulo a = new Articulo(idArticulo, descripcion, precio, stockActual, stockMinimo, ventaLibre, idTipo);
                LA.add(a);
            }
            rs.close();
            st.close();
            conn.close();
            int stockActual = 0;
            int stockMinimo = 0;
           
            for (int i = 0; i < LA.size(); i++) {               
                stockActual = LA.get(i).getStockActual();
                stockMinimo = LA.get(i).getStockMinimo();
                if (stockActual > stockMinimo) {
                    LAS.add(LA.get(i));
                }

            }
        } catch (Exception exc) {

            exc.printStackTrace();

        }

        return LAS;
    }

    public ArrayList<Factura> obtenerFacturas() {

        ArrayList<Factura> LF = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Facturas");

            while (rs.next()) {

                int idFactura = rs.getInt(1);
                int idCliente = rs.getInt(2);
                int idProfesional = rs.getInt(3);
                int idMetodo = rs.getInt(4);
                int idSucursal = rs.getInt(5);

                Factura f = new Factura(idFactura, idCliente, idProfesional, idMetodo, idSucursal);
                LF.add(f);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception exc) {

            exc.printStackTrace();

        }

        return LF;
    }

    public ArrayList<Detalle_Factura> obtenerDetalles(int id) {

        ArrayList<Detalle_Factura> LDF = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Detalles_Factura where idFactura= " + id);

            while (rs.next()) {

                int idDetalle = rs.getInt(1);
                int cantidad = rs.getInt(2);
                int idArticulo = rs.getInt(3);
                int idFactura = rs.getInt(4);
                float precioVenta = rs.getFloat(5);
                float descuentoObra = rs.getFloat(6);
                Detalle_Factura df = new Detalle_Factura(idDetalle, cantidad, idArticulo, idFactura, precioVenta,descuentoObra);
                LDF.add(df);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception exc) {

            exc.printStackTrace();

        }

        return LDF;
    }

    public ArrayList<DtoDetalle_Articulo> obtenerDtoDetalle(int id) {

        ArrayList<DtoDetalle_Articulo> LDA = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select df.idArticulo, a.descripcion,df.cantidad, a.precio, df.descuentoObra ,df.precioVenta\n"
                    + "from Detalles_Factura df join Articulos a on df.idArticulo = a.idArticulo\n"
                    + "where df.idFactura = " + id);

            while (rs.next()) {

                int idArticulo = rs.getInt(1);
                String descripcion = rs.getString(2);
                int cantidad = rs.getInt(3);
                float precio = rs.getFloat(4);
                float descuentoObra = rs.getFloat(5);
                float precioVenta = rs.getFloat(6);

                DtoDetalle_Articulo da = new DtoDetalle_Articulo(idArticulo, descripcion, cantidad, precio,descuentoObra, precioVenta);
                LDA.add(da);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception exc) {

            exc.printStackTrace();

        }

        return LDA;
    }

    //------------------------------------------------Inserciones-----------------------------------------------------------
    public void insertarFactura(Factura f) {

        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("insert into Facturas values(" + f.getIdCliente() + "," + f.getIdProfesional() + "," + f.getIdMetodo() + "," + f.getIdSucursal() + ")");

            rs.close();
            st.close();
            conn.close();

        } catch (Exception exc) {

            exc.printStackTrace();

        }
    }

    public void insertarDetalle(Detalle_Factura df) {

        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("insert into Detalles_Factura values(" + df.getCantidad() + "," + df.getIdArticulo() + "," + df.getIdFactura() + "," + df.getPrecioVenta() + "," + df.getDescuentoObra()+ ")");

            rs.close();
            st.close();
            conn.close();

        } catch (Exception exc) {

            exc.printStackTrace();

        }

    }

}
