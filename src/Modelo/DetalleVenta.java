
package Modelo;

/**
 *
 * @author Francisco Castillo
 * @version 28-11-2021
 */
public class DetalleVenta {
    
    private int cantidad_venta;
    private int id_venta;
    private int id_producto;

    public DetalleVenta() {
    }

    public DetalleVenta(int cantidad_venta, int id_venta, int id_producto) {
        this.cantidad_venta = cantidad_venta;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    
}
