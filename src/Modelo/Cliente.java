package Modelo;
/**
 *
 * @author Neotemplar-R480
 */
public class Cliente {

    public int rut, telefono;
    public String dv, nombre_cliente, apellido, email;
    public boolean activo;

    public Cliente() {
    }

    public Cliente(int rut, String dv, String nombre_cliente, String apellido, int telefono, String email, boolean activo) {
        this.rut = rut;
        this.telefono = telefono;
        this.dv = dv;
        this.nombre_cliente = nombre_cliente;
        this.apellido = apellido;
        this.email = email;
        this.activo = activo;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "rut=" + rut + ", telefono=" + telefono + ", dv=" + dv + ", nombre_cliente=" + nombre_cliente + ", apellido=" + apellido + ", email=" + email + ", activo=" + activo + '}';
    }

    
    
    
    
}
