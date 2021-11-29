package Modelo;
/**
 *
 * @author Francisco Castillo
 * @version 25-11-2021
 */
public class Usuario {
    
    public int id_usuario, tipo_usuario;
    public String nombre_usuario, password;

    public Usuario() {
    }

    public Usuario(int id_usuario, int tipo_usuario, String nombre_usuario, String password) {
        this.id_usuario = id_usuario;
        this.tipo_usuario = tipo_usuario;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", tipo_usuario=" + tipo_usuario + ", nombre_usuario=" + nombre_usuario + ", password=" + password + '}';
    }
    
    



    
}
