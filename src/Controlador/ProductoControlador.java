
package Controlador;
import BaseDeDatos.Conexion;
import Modelo.Cliente;
import Modelo.Producto;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abarr
 * @date 30/11/21
 */
public class ProductoControlador {
    //Crear Producto  
   public boolean agregarProducto(Producto producto) throws SQLException{
       
       try {
           Conexion con = new Conexion();
           java.sql.Connection cnx = con.obtenerConexion();
           String query ="INSERT INTO producto(nombre_producto, tipo_producto, descripcion, precio, cantidad, disponible)VALUES(?,?,?,?,?,?)";
           PreparedStatement stmt = cnx.prepareStatement(query);
           stmt.setString(1,producto.getNombre_producto());
           stmt.setString(2,producto.getTipo_producto());
           stmt.setString(3,producto.getDescripcion());
           stmt.setInt(4, producto.getPrecio());
           stmt.setInt(5, producto.getCantidad());
           stmt.setBoolean(6,producto.isDisponible());
           
           stmt.executeUpdate();
           stmt.close();
           cnx.close();
           
           return true; 
           
       } catch (SQLException e) {
           System.out.println("Error SQL al agregar Producto"+ e.getMessage());
           return false;
       }
        
   }
    //Modificar Producto
    public boolean modificarProducto(Producto producto) throws SQLException{
       
       try {
           Conexion con = new Conexion();
           java.sql.Connection cnx = con.obtenerConexion();
           String query ="UPDATE produco set nombre_producto=?, tipo_producto=?, descripcion=?, precio=?, cantidad=?, disponible=?)WHERE id_producto=?";
           PreparedStatement stmt = cnx.prepareStatement(query);
           stmt.setString(1,producto.getNombre_producto());
           stmt.setString(2,producto.getTipo_producto());
           stmt.setString(3,producto.getDescripcion());
           stmt.setInt(4, producto.getPrecio());
           stmt.setInt(5, producto.getCantidad());
           stmt.setBoolean(6,producto.isDisponible());
           stmt.setInt(7,producto.getId_producto());
           
           stmt.executeUpdate();
           stmt.close();
           cnx.close();
           
           return true; 
           
       } catch (SQLException e) {
           System.out.println("Error SQL al Modificar Producto"+ e.getMessage());
           return false;
       }
        
   }    
       //Eliminar Producto
    public boolean eliminarProducto(String nombre_producto) throws SQLException{
       
       try {
           Conexion con = new Conexion();
           java.sql.Connection cnx = con.obtenerConexion();
           String query ="DELETE FROM produco nombre_producto=?";
           PreparedStatement stmt = cnx.prepareStatement(query);
           stmt.setString(1,nombre_producto);
           
           
           stmt.executeUpdate();
           stmt.close();
           cnx.close();
           
           return true; 
           
       } catch (SQLException e) {
           System.out.println("Error SQL al Eliminar Producto"+ e.getMessage());
           return false;
       }
        
   }
   
    //Buscar Producto por el nombre 
    public Producto buscarProducto (String nombre_producto){
        Producto producto = new Producto();
        
        try {
           Conexion con = new Conexion();
           java.sql.Connection cnx = con.obtenerConexion();
           String query ="SELECT id_producto, nombre_producto, tipo_producto, descripcion, precio, cantidad, disponible FROM producto WHERE nombre_producto=?";
           PreparedStatement stmt = cnx.prepareStatement(query);
           stmt.setString(1,nombre_producto);
           
           ResultSet rs = stmt.executeQuery();
           while(rs.next()){
               producto.setId_producto(rs.getInt("id_producto"));
               producto.setNombre_producto(rs.getString("nombre_producto"));
               producto.setTipo_producto(rs.getString("tipo_producto"));
               producto.setPrecio(rs.getInt("precio"));
               producto.setCantidad(rs.getInt("cantidad"));
               producto.setDisponible(rs.getBoolean("disponible"));
               
           }
           rs.close();
           stmt.close();
           cnx.close();
           
       } catch (SQLException e) {
           System.out.println("Error SQL al Buscar Producto"+ e.getMessage());
           
       }
        return producto;
    }
  
        //Buscar Producto por Tipo de producto
    public Producto buscarTipoProducto (String tipo_producto){
        Producto producto = new Producto();
        
        try {
           Conexion con = new Conexion();
           java.sql.Connection cnx = con.obtenerConexion();
           String query ="SELECT id_producto, nombre_producto, tipo_producto, descripcion, precio, cantidad, disponible FROM producto WHERE tipo_producto=?";
           PreparedStatement stmt = cnx.prepareStatement(query);
           stmt.setString(1,tipo_producto);
           
           ResultSet rs = stmt.executeQuery();
           while(rs.next()){
               producto.setId_producto(rs.getInt("id_producto"));
               producto.setNombre_producto(rs.getString("nombre_producto"));
               producto.setTipo_producto(rs.getString("tipo_producto"));
               producto.setPrecio(rs.getInt("precio"));
               producto.setCantidad(rs.getInt("cantidad"));
               producto.setDisponible(rs.getBoolean("disponible"));
               
           }
           rs.close();
           stmt.close();
           cnx.close();
           
       } catch (SQLException e) {
           System.out.println("Error SQL al Buscar Producto"+ e.getMessage());
           
       }
        return producto;
    }
      //Listar productos
    public List<Producto> buscarTodos(){
        List<Producto> lista =new ArrayList<>();
        
        try {
           Conexion con = new Conexion();
           java.sql.Connection cnx = con.obtenerConexion();
           String query ="SELECT id_producto, nombre_producto, tipo_producto, descripcion, precio, cantidad, disponible FROM producto ORDER BY tipo_producto";
           PreparedStatement stmt = cnx.prepareStatement(query);
           
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               Producto producto =new Producto();
               producto.setId_producto(rs.getInt("id_producto"));
               producto.setNombre_producto(rs.getString("nombre_producto"));
               producto.setTipo_producto(rs.getString("tipo_producto"));
               producto.setPrecio(rs.getInt("precio"));
               producto.setCantidad(rs.getInt("cantidad"));
               producto.setDisponible(rs.getBoolean("disponible"));
               
               lista.add(producto);
           }
           rs.close();
           stmt.close();
           cnx.close();
           
       } catch (SQLException e) {
           System.out.println("Error SQL al Listar Producto"+ e.getMessage());
           
       }
        return lista;
            
    }
    
    //Metodo para listar los nombres de los productos, by Fco Castillo
    public List<Producto> listarTodosProductosNombre(){
        List<Producto> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            java.sql.Connection cnx = con.obtenerConexion();
            
            String query = "SELECT nombre_producto FROM producto WHERE disponible = 1";
            PreparedStatement stmt = cnx.prepareStatement(query);
                        
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Producto producto = new Producto();
                producto.setNombre_producto(rs.getString("nombre_producto"));
                
                lista.add(producto);
            }
            
            rs.close();
            stmt.close();
            cnx.close();
                 
        } catch (Exception e) {
            System.out.println("Error SQL al buscar Producto"+ e.getMessage());
            
        }
        return lista;
    }
    
       //Buscador de producto por nombre
    public List<Producto> buscarProductoNombre(String nombre_producto) {

        List<Producto> lista = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            java.sql.Connection cnx = con.obtenerConexion();

            String query = "SELECT id, nombre_producto, tipo_producto, descripcion, precio, cantidad, disponible  FROM producto WHERE nombre_producto=? ORDER BY nombre_producto";

            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombre_producto);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();

           
               producto.setId_producto(rs.getInt("id_producto"));
               producto.setNombre_producto(rs.getString("nombre_producto"));
               producto.setTipo_producto(rs.getString("tipo_producto"));
               producto.setPrecio(rs.getInt("precio"));
               producto.setCantidad(rs.getInt("cantidad"));
               producto.setDisponible(rs.getBoolean("disponible"));
               

                lista.add(producto);

            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (Exception e) {
            System.out.println("Error SQL al buscar Producto" + e.getMessage());

        }

        return lista;
    }
}    
    
  
