/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Francisco Castillo
 * @version 29-11-2021
 */
public class DetalleVenta2 {
    
    private String nombre_producto;
    private int cantidad_venta;
    private int precio_unitario;
    private int subtotal;

    public DetalleVenta2() {
    }

    public DetalleVenta2(String nombre_producto, int cantidad_venta, int precio_unitario, int subtotal) {
        this.nombre_producto = nombre_producto;
        this.cantidad_venta = cantidad_venta;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
