/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author joako
 */
public class Factura {
    public int idFactura;
    public int idCliente;
    public int idProfesional;
    public int idMetodo;
    public int idSucursal;

    public Factura(int idFactura, int idCliente, int idProfesional, int idMetodo, int idSucursal) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.idProfesional = idProfesional;
        this.idMetodo = idMetodo;
        this.idSucursal = idSucursal;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public int getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(int idMetodo) {
        this.idMetodo = idMetodo;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Override
    public String toString() {
        return "Factura{" + "idFactura=" + idFactura + ", idCliente=" + idCliente + ", idProfesional=" + idProfesional + ", idMetodo=" + idMetodo + ", idSucursal=" + idSucursal + '}';
    }
}
