package Controlador;
import BaseDeDatos.Conexion;
import Modelo.Cliente;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cristian Gonzalez
 * @date 30/11/2021
 */
public class ClienteControlador {
    
    public boolean agregarCliente(Cliente cliente){
                
        try {
            Conexion con = new Conexion();
            java.sql.Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO cliente(rut,dv,nombre_cliente,apellido,telefono,email,activo) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1,cliente.getRut());
            stmt.setString(2,cliente.getDv());
            stmt.setString(3,cliente.getNombre_cliente());
            stmt.setString(4,cliente.getApellido());
            stmt.setInt(5,cliente.getTelefono());
            stmt.setString(6,cliente.getEmail());
            stmt.setBoolean(7, cliente.getActivo());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;           
            
        } catch (Exception e) {
            
            System.out.println("Error SQL al agregar Cliente"+ e.getMessage());
            return false;
        }
    }
    
    public boolean actualizarCliente(Cliente cliente){
                
        try {
            Conexion con = new Conexion();
            java.sql.Connection cnx = con.obtenerConexion();
            
            String query = "UPDATE cliente set nombre_cliente=?, apellido=?, telefono=?, email=?, activo=? WHERE rut=? AND activo=1";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            stmt.setString(1,cliente.getNombre_cliente());
            stmt.setString(2,cliente.getApellido());
            stmt.setInt(3,cliente.getTelefono());
            stmt.setString(4,cliente.getEmail());
            stmt.setBoolean(5,cliente.getActivo());
            stmt.setInt(6,cliente.getRut());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;           
            
        } catch (Exception e) {
            
            System.out.println("Error SQL al modificar Cliente"+ e.getMessage());
            return false;
        }
    }
//Instruccion DELETE que se decidio no utilizar.    
//    public boolean eliminarCliente(int rut){
//        
//        try {
//            Conexion con = new Conexion();
//            java.sql.Connection cnx = con.obtenerConexion();
//            
//            String query = "DELETE FROM cliente WHERE rut=? ";
//            PreparedStatement stmt = cnx.prepareStatement(query);
//            
//            stmt.setInt(1,rut);
//            
//            
//            stmt.executeUpdate();
//            stmt.close();
//            cnx.close();
//            return true;           
//            
//        } catch (Exception e) {
//            System.out.println("Error SQL al eliminar Cliente"+ e.getMessage());
//            return false;
//        }
//    }
// en lugar de DELETE se hizo un "delete" que solo desactiva al cliente.
    public boolean eliminarCliente(int rut){
        
        try {
            Conexion con = new Conexion();
            java.sql.Connection cnx = con.obtenerConexion();
            
            String query = "UPDATE cliente SET activo = 0 WHERE rut=? ";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            stmt.setInt(1,rut);
            
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;           
            
        } catch (Exception e) {
            System.out.println("Error SQL al eliminar Cliente"+ e.getMessage());
            return false;
        }
    }
    
    
    public Cliente buscarCliente(int rut){
        
        Cliente cliente = new Cliente();
        try {
            Conexion con = new Conexion();
            java.sql.Connection cnx = con.obtenerConexion();
            
            String query = "SELECT rut,dv,nombre_cliente,apellido,telefono,email,disponible FROM cliente WHERE apellido=? ";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1,"apellido");
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                cliente.setRut(rs.getInt("rut"));
                cliente.setDv(rs.getString("dv"));
                cliente.setNombre_cliente(rs.getString("nomre_cliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setActivo(rs.getBoolean("activo"));
            }
            
            rs.close();
            stmt.close();
            cnx.close();
                 
        } catch (Exception e) {
            System.out.println("Error SQL al buscar Cliente"+ e.getMessage());
            
        }
        return cliente;
    }
    
    public List<Cliente> buscarTodosClientes(){
        
        List<Cliente> lista = new ArrayList<>();
        
        try {
            Conexion con = new Conexion();
            java.sql.Connection cnx = con.obtenerConexion();
            
            String query = "SELECT rut,dv,nombre_cliente,apellido,telefono,email,disponible FROM cliente ";
            PreparedStatement stmt = cnx.prepareStatement(query);
                        
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setRut(rs.getInt("rut"));
                cliente.setDv(rs.getString("dv"));
                cliente.setNombre_cliente(rs.getString("nomre_cliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setActivo(rs.getBoolean("activo"));
                
                lista.add(cliente);
            }
            
            rs.close();
            stmt.close();
            cnx.close();
                 
        } catch (Exception e) {
            System.out.println("Error SQL al buscar Clientes"+ e.getMessage());
            
        }
                     
        return lista;
    }
    
    
    
    
    
}
