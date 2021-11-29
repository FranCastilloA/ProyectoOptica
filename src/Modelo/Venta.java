
package Modelo;

import java.util.Date;

/**
 *
 * @author Francisco Castillo
 * @version 28-11-2021
 */
public class Venta {
    
    private int id_venta;
    private int total;
    private Date fecha;
    private String medio_pago;
    private String tipo_documento;
    private int numero_operacion;
    private int rut_cliente;

    public Venta() {
    }

    public Venta(int id_venta, int total, Date fecha, String medio_pago, String tipo_documento, int numero_operacion, int rut_cliente) {
        this.id_venta = id_venta;
        this.total = total;
        this.fecha = fecha;
        this.medio_pago = medio_pago;
        this.tipo_documento = tipo_documento;
        this.numero_operacion = numero_operacion;
        this.rut_cliente = rut_cliente;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public int getNumero_operacion() {
        return numero_operacion;
    }

    public void setNumero_operacion(int numero_operacion) {
        this.numero_operacion = numero_operacion;
    }

    public int getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(int rut_cliente) {
        this.rut_cliente = rut_cliente;
    }
    
    
    
}
