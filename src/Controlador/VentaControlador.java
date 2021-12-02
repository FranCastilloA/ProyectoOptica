/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BaseDeDatos.Conexion;
import java.util.Date;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Francisco Castillo
 * @version 02-12-2021
 * 28-11: Metodos Listar
 * 29-11: Metodo Agregar
 * 02-12: metofo obtener ultima venta, su id
 */
public class VentaControlador {
    
    //metodo para Agregar Venta
    public boolean agregarVenta(Venta venta){
        Date date;
        try{
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            date = venta.getFecha();
            
            String query = "INSERT INTO venta(total, fecha, medio_pago, tipo_documento, numero_operacion, rut_cliente) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            stmt.setInt(1, venta.getTotal());
            stmt.setDate(2, new java.sql.Date(date.getTime()));
            //stmt.setDate(2, (java.sql.Date) venta.getFecha());
            stmt.setString(3, venta.getMedio_pago());
            stmt.setString(4, venta.getTipo_documento());
            stmt.setInt(5, venta.getNumero_operacion());
            stmt.setInt(6, venta.getRut_cliente());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            } catch (SQLException e) {
            System.out.println("Error SQL al agregar Venta: " + e.getMessage());
            return false;
        } catch(Exception e){
            System.out.println("Error al agregar Venta (EXCEPTION): " + e.getMessage());
            return false;
        }
    }
    
    //Metodo para Listar todas las Ventas
    public List<Venta> listarTodos(){
    
        //creamos lista de venta como arreglo
        List<Venta> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT id_venta, total, fecha, medio_pago, tipo_documento, numero_operacion, rut_cliente FROM venta order by id_venta";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId_venta(rs.getInt("id_venta"));
                venta.setTotal(rs.getInt("total"));
                venta.setFecha(rs.getDate("fecha"));
                venta.setMedio_pago(rs.getString("medio_pago"));
                venta.setTipo_documento(rs.getString("tipo_documento"));
                venta.setNumero_operacion(rs.getInt("numero_operacion"));
                venta.setRut_cliente(rs.getInt("rut_cliente"));
                
                lista.add(venta); 
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al Listar Venta: " + e.getMessage());
            
        } catch(Exception e){
            System.out.println("Error al Listar Venta (EXCEPTION): " + e.getMessage());
        }
        return lista;
    }
    
    //Metodo para Listar por Cliente, devolvera 1 o varias ventas
    public List<Venta> listarPorRut(int rut_cliente){
    
        //creamos lista de venta como arreglo
        List<Venta> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT id_venta, total, fecha, medio_pago, tipo_documento, numero_operacion, rut_cliente FROM venta WHERE rut_cliente = ? order by id_venta";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, rut_cliente);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId_venta(rs.getInt("id_venta"));
                venta.setTotal(rs.getInt("total"));
                venta.setFecha(rs.getDate("fecha"));
                venta.setMedio_pago(rs.getString("medio_pago"));
                venta.setTipo_documento(rs.getString("tipo_documento"));
                venta.setNumero_operacion(rs.getInt("numero_operacion"));
                venta.setRut_cliente(rs.getInt("rut_cliente"));
                
                lista.add(venta); 
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al Listar Venta: " + e.getMessage());
            
        } catch(Exception e){
            System.out.println("Error al Listar Venta (EXCEPTION): " + e.getMessage());
        }
        return lista;
    }
    
    //Metodo para Listar por Fecha, devolvera 1 o varias ventas
    public List<Venta> listarPorFecha(Date fecha){
        //creamos lista de venta como arreglo
        List<Venta> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT id_venta, total, fecha, medio_pago, tipo_documento, numero_operacion, rut_cliente FROM venta WHERE fecha = ? order by id_venta";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setDate(1, new java.sql.Date(fecha.getTime()));
            
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId_venta(rs.getInt("id_venta"));
                venta.setTotal(rs.getInt("total"));
                venta.setFecha(rs.getDate("fecha"));
                venta.setMedio_pago(rs.getString("medio_pago"));
                venta.setTipo_documento(rs.getString("tipo_documento"));
                venta.setNumero_operacion(rs.getInt("numero_operacion"));
                venta.setRut_cliente(rs.getInt("rut_cliente"));
                
                lista.add(venta); 
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al Listar Venta: " + e.getMessage());
            
        } catch(Exception e){
            System.out.println("Error al Listar Venta (EXCEPTION): " + e.getMessage());
        }
        return lista;
    }
    
    //Metodo para obtener la ultima venta ingresada
    public int ultimaVenta(){
        int id_venta=0;
        //Venta v = new Venta();
        try {
            Conexion con = new Conexion();
            java.sql.Connection cnx = con.obtenerConexion();
            
            String query = "SELECT MAX(id_venta) AS ultimoid FROM venta";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                id_venta= rs.getInt("ultimoid");
                //v.setId_venta(rs.getInt("ultimoid"));
            }
            //id_venta = v.getId_venta();
            
            rs.close();
            stmt.close();
            cnx.close();
                 
        } catch (Exception e) {
            System.out.println("Error SQL al buscar Cliente"+ e.getMessage());
            
        }
        return id_venta;
    }
}
