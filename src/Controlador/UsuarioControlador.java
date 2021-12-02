
package Controlador;

import BaseDeDatos.Conexion;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Cristian Gonzalez
 * 
 */
public class UsuarioControlador {
    
    //Buscador de usuario por nombre y pass.
    public Usuario buscarUsuario(String nombre, String pass) {

        Usuario usuario = new Usuario();

        try {
            Conexion con = new Conexion();
            java.sql.Connection cnx = con.obtenerConexion();

            String query = "SELECT id_usuario,nombre_usuario,password,tipo_usuario FROM usuario WHERE nombre_usuario=? AND password=? ";

            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setString(2, pass);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTipo_usuario(rs.getInt("tipo_usuario"));
            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (Exception e) {
            System.out.println("Error SQL al buscar cliente" + e.getMessage());

        }

        return usuario;
    }
    
}
