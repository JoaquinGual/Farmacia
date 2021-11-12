package Dtos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joako
 */
public class DtoCliente_Obra_Cobertura {
    private int idCliente;
    private String nombre;
    private int idObraSocial;
    private String nombreObraSocial;
    private int idArticulo;
    private int descuento;
    private float precio;

    public DtoCliente_Obra_Cobertura(int idCliente, String nombre, int idObraSocial, String nombreObraSocial, int idArticulo, int descuento,float precio) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.idObraSocial = idObraSocial;
        this.nombreObraSocial = nombreObraSocial;
        this.idArticulo = idArticulo;
        this.descuento = descuento;
        this.precio = precio;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdObraSocial() {
        return idObraSocial;
    }

    public void setIdObraSocial(int idObraSocial) {
        this.idObraSocial = idObraSocial;
    }

    public String getNombreObraSocial() {
        return nombreObraSocial;
    }

    public void setNombreObraSocial(String nombreObraSocial) {
        this.nombreObraSocial = nombreObraSocial;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "DtoCliente_Obra_Cobertura{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", idObraSocial=" + idObraSocial + ", nombreObraSocial=" + nombreObraSocial + ", idArticulo=" + idArticulo + ", descuento=" + descuento + ", precio=" + precio + '}';
    }
    

    
    
}
