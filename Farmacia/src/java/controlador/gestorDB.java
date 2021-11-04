/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

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

    public ArrayList<Articulo> obtenerArticulos() {

        ArrayList<Articulo> LA = new ArrayList<>();
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
        } catch (Exception exc) {

            exc.printStackTrace();

        }

        return LA;
    }

    public ArrayList<Factura> obtenerFacturas() {

        ArrayList<Factura> LF = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Articulos");

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

    public ArrayList<Detalle_Factura> obtenerDetalles() {

        ArrayList<Detalle_Factura> LDF = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Articulos");

            while (rs.next()) {

                int idDetalle = rs.getInt(1);
                int cantidad = rs.getInt(2);
                int idArticulo = rs.getInt(3);
                int idFactura = rs.getInt(4);

                Detalle_Factura df = new Detalle_Factura(idDetalle, cantidad, idArticulo, idFactura);
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

    //------------------------------------------------Inserciones-----------------------------------------------------------
    public void insertarFactura(int idCliente, int idProfesional, int idMetodo, int idSucursal) {

        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("insert into Facturas values(" + idCliente + "," + idProfesional + "," + idMetodo + "," + idSucursal + ")");

            rs.close();
            st.close();
            conn.close();

        } catch (Exception exc) {

            exc.printStackTrace();

        }
    }

    public void insertarDetalle(int cantidad, int idArticulo, int idFactura) {

        try {

            Connection conn = DriverManager.getConnection(serverBD, userBD, passBD);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("insert into Detalles_Factura values(" + cantidad + "," + idArticulo + "," + idFactura + ")");

            rs.close();
            st.close();
            conn.close();

        } catch (Exception exc) {

            exc.printStackTrace();

        }

    }

}
