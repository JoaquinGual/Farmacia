/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

/**
 *
 * @author joako
 */
public class DtoDetalle_Articulo {
    private int idArticulo;
    private String descripcion;
    private int cantidad;
    private float precio;
    private float descuentoObra;
    private float precioVenta;

    public DtoDetalle_Articulo(int idArticulo, String descripcion, int cantidad, float precio,float descuentoObra, float precioVenta) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuentoObra = descuentoObra;
        this.precioVenta = precioVenta;
    }

    
    public int getIdArticulo() {
        return idArticulo;
    }
    

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getDescuentoObra() {
        return descuentoObra;
    }

    public void setDescuentoObra(float descuentoObra) {
        this.descuentoObra = descuentoObra;
    }
    
    
    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "DtoDetalle_Articulo{" + "idArticulo=" + idArticulo + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + ", descuentoObra=" + descuentoObra + ", precioVenta=" + precioVenta + '}';
    }

   
    
    
}
