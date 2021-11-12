/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author joako
 */
public class Articulo {
    private int idArticulo;
    private String descripcion;
    private float precio;
    private int stockActual;
    private int stockMinimo;
    private boolean ventaLibre;
    private int idTipo;

    public Articulo(int idArticulo, String descripcion, float precio, int stockActual, int stockMinimo, boolean ventaLibre, int idTipo) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.ventaLibre = ventaLibre;
        this.idTipo = idTipo;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public boolean isVentaLibre() {
        return ventaLibre;
    }

    public void setVentaLibre(boolean ventaLibre) {
        this.ventaLibre = ventaLibre;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public String toString() {
        return "Articulo{" + "idArticulo=" + idArticulo + ", descripcion=" + descripcion + ", precio=" + precio + ", stockActual=" + stockActual + ", stockMinimo=" + stockMinimo + ", ventaLibre=" + ventaLibre + ", idTipo=" + idTipo + '}';
    }
    
}
