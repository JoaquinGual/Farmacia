/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author joako
 */
public class Detalle_Factura {
    private int idDetalle;
    private int cantidad;
    private int idArticulo;
    private int idFactura;

    public Detalle_Factura(int idDetalle, int cantidad, int idArticulo, int idFactura) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.idArticulo = idArticulo;
        this.idFactura = idFactura;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public String toString() {
        return "Detalle_Factura{" + "idDetalle=" + idDetalle + ", cantidad=" + cantidad + ", idArticulo=" + idArticulo + ", idFactura=" + idFactura + '}';
    }
}
