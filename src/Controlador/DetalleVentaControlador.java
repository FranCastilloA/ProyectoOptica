/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BaseDeDatos.Conexion;
import Modelo.DetalleVenta;
import Modelo.DetalleVenta2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Francisco Castillo
 * @version 29-11-2021
 */
public class DetalleVentaControlador {
    
    //Metodo para Agregar Detalle Venta
    public boolean agregarDetalleVenta(DetalleVenta detalleventa){
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO detalle_venta(cantidad_venta, id_venta, id_producto)VALUES (?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            stmt.setInt(1, detalleventa.getCantidad_venta());
            stmt.setInt(2, detalleventa.getId_venta());
            stmt.setInt(3, detalleventa.getId_producto());
                        
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar Detalle Venta: " + e.getMessage());
            return false;
        } catch(Exception e){
            System.out.println("Error al agregar Detalle Venta (EXCEPTION): " + e.getMessage());
            return false;
        }
    }
    
    //Metodo para Listar todas los Detalle Ventas
    public List<DetalleVenta> listarTodos(){
        //creamos lista de venta como arreglo
        List<DetalleVenta> lista = new ArrayList<>();
        try{
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT cantidad_venta, id_venta, id_producto FROM detalle_venta order by id_producto";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DetalleVenta detalleventa = new DetalleVenta();
                detalleventa.setCantidad_venta(rs.getInt("cantidad_venta"));
                detalleventa.setId_venta(rs.getInt("id_venta"));
                detalleventa.setId_producto(rs.getInt("id_producto"));
                
                lista.add(detalleventa); 
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al Listar Detalle Venta: " + e.getMessage());
            
        } catch(Exception e){
            System.out.println("Error al Listar Detalle Venta (EXCEPTION): " + e.getMessage());
        }
        return lista;
    }
    
    //Metodo para Listar todos los Detalle Ventas con el join correspondiente
    public List<DetalleVenta2> listarPorIdVenta(int id_venta){
        //creamos lista de venta como arreglo
        List<DetalleVenta2> lista = new ArrayList<>();
        
        try{
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT p.nombre_producto , dv.cantidad_venta, p.precio, (dv.cantidad_venta * p.precio) AS subtotal FROM producto p JOIN detalle_venta dv ON p.id_producto = dv.id_producto JOIN venta v ON dv.id_venta = v.id_venta WHERE v.id_venta = ? order by p.nombre_producto";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_venta);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                DetalleVenta2 dv2 = new DetalleVenta2();
                dv2.setNombre_producto(rs.getString("p.nombre_producto"));
                dv2.setCantidad_venta(rs.getInt("dv.cantidad_venta"));
                dv2.setPrecio_unitario(rs.getInt("p.precio"));
                dv2.setSubtotal(rs.getInt("subtotal"));
                
                lista.add(dv2); 
            }
            
        } catch (SQLException e) {
            System.out.println("Error SQL al Listar Detalle Venta: " + e.getMessage());
            
        } catch(Exception e){
            System.out.println("Error al Listar Detalle Venta (EXCEPTION): " + e.getMessage());
        }
        return lista;
    }
}
