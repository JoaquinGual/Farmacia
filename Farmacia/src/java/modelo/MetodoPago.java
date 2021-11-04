/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author joako
 */
public class MetodoPago {
    private int idMetodo;
    private String descripcion;

    public MetodoPago(int idMetodo, String descripcion) {
        this.idMetodo = idMetodo;
        this.descripcion = descripcion;
    }

    public int getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(int idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MetodoPago{" + "idMetodo=" + idMetodo + ", descripcion=" + descripcion + '}';
    }
    
}
