/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appCovid;

import static com.mycompany.appCovid.app.personasCineSala1;
import static com.mycompany.appCovid.app.personasCineSala2;
import static com.mycompany.appCovid.app.personasCineSala3;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class ClienteDAO {
    
       public static void crearCliente(ClienteCine cliente){
           app conteo=new app();
      Conexion db_connect = new Conexion();
       PreparedStatement ps = null;
       try(Connection Conexion = db_connect.get_connection()){
           try{
               String query = "INSERT INTO `cine` (nombreCliente,dpiCliente,temperatura,sala,numAsiento,fechaHora) VALUES (?,?,?,?,?,now())";
               ps = Conexion.prepareStatement(query);
               ps.setString(1,cliente.getNombre());
               ps.setString(2,cliente.getDpi());
               ps.setDouble(3,cliente.getTemperatura());
               ps.setInt(4,cliente.getNumSala());
               ps.setString(5,cliente.getNumAsiento());
               ps.executeUpdate();
              //conteo.validarConteo(cliente.getNumSala());
        switch (cliente.getNumSala()) {//si se ingresó un cliente a una sala restamos los asientos disponibles
            case 1 -> personasCineSala1=personasCineSala1-1;//
            case 2 -> personasCineSala2=personasCineSala2-1;
            case 3 -> personasCineSala3=personasCineSala3-1;
            default -> {
            }
        }
               System.out.println("cliente agregado");
               
           }catch(SQLException x){
               System.out.println(x);
           }
       }catch(SQLException e){
           System.out.println(e);
       }
        
    }
       public static void crearClienteRestaurante(ClienteRestaurante cliente)
       { app cliente1=new app();
         Conexion db_connect = new Conexion();
       PreparedStatement ps = null;
       try(Connection Conexion = db_connect.get_connection()){
           try{
               String query = "INSERT INTO `restaurante` (nombreCliente,dpiCliente,temperatura,numMesa,fechaHora) VALUES (?,?,?,?,now())";
               ps = Conexion.prepareStatement(query);
               ps.setString(1,cliente.getNombre());
               ps.setString(2,cliente.getDpi());
               ps.setDouble(3,cliente.getTemperatura());
               ps.setInt(4,cliente.getNumeromesa());
          
               ps.executeUpdate();
               cliente1.validarConteoRestaurante(1);
               System.out.println("cliente agregado");
               
           }catch(SQLException x){
               System.out.println(x);
           }
       }catch(SQLException e){
           System.out.println(e);
       }  
       }
       public static void crearClienteGimnasio(ClienteGimnasio cliente)
       {  app cliente1=new app();
         Conexion db_connect = new Conexion();
       PreparedStatement ps = null;
       try(Connection Conexion = db_connect.get_connection()){
           try{
               String query = "INSERT INTO `gimnasio` (nombreCliente,dpiCliente,temperatura,fechaHora) VALUES (?,?,?,now())";
               ps = Conexion.prepareStatement(query);
               ps.setString(1,cliente.getNombre());
               ps.setString(2,cliente.getDpi());
               ps.setDouble(3,cliente.getTemperatura());
              
 
               ps.executeUpdate();
           cliente1.validarConteoGimnasio(1);
               System.out.println("cliente agregado");
               
           }catch(SQLException x){
               System.out.println(x);
           }
       }catch(SQLException e){
           System.out.println(e);
       }  
       }
       public static void leerListadoClienteRestaurante(){
        Conexion db_conexion = new Conexion();
        
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        try(Connection Conexion = db_conexion.get_connection()){
        
            
                String query = "SELECT * FROM `restaurante`";
                ps = Conexion.prepareStatement(query);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    System.out.println("ID:"+rs.getInt("id"));
                    System.out.println("nombre:"+rs.getString("nombreCliente"));
                    System.out.println("dpi:"+rs.getString("dpiCliente"));
                    System.out.println("temperatura:"+rs.getString("temperatura"));
                    System.out.println("numero de mesa:"+rs.getString("numMesa"));
                }
      
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
    }
       public static void leerListadoClienteCine()
       {
         Conexion db_conexion = new Conexion();
        
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        try(Connection Conexion = db_conexion.get_connection()){
        
            
                String query = "SELECT * FROM `cine`";
                ps = Conexion.prepareStatement(query);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    System.out.println("ID: "+rs.getInt("id"));
                    System.out.println("nombre: "+rs.getString("nombreCliente"));
                    System.out.println("dpi: "+rs.getString("dpiCliente"));
                    System.out.println("temperatura: "+rs.getString("temperatura"));
                    System.out.println("numero de sala: "+rs.getString("sala"));
                    System.out.println("numero de asiento: "+rs.getString("numAsiento"));
                }
      
            
        }catch(SQLException e){
            System.out.println(e);
        }   
       }
       public static void busquedaClienteCine(ClienteCine cliente)
       {
        Conexion db_conexion = new Conexion();
        
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        try(Connection Conexion = db_conexion.get_connection()){
        
            
                String query = "SELECT * FROM `cine` WHERE sala LIKE '%"+cliente.getNumSala()+"%' ";
                ps = Conexion.prepareStatement(query);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    System.out.println("ID:"+rs.getInt("id"));
                    System.out.println("nombre:"+rs.getString("nombreCliente"));
                    System.out.println("dpi:"+rs.getString("dpiCliente"));
                    System.out.println("sala:"+rs.getString("sala"));
                    System.out.println("numero de asiento:"+rs.getString("numAsiento"));
                }
      
            
        }catch(SQLException e){
            System.out.println(e);
        }   
       }
       public static void busquedaClienteGimnasio(ClienteGimnasio cliente)
       {
         Conexion db_conexion = new Conexion();
        
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        try(Connection Conexion = db_conexion.get_connection()){
        
            
                String query = "SELECT * FROM `gimnasio` WHERE dpiCliente LIKE '%"+cliente.getDpi()+"%' ";
                ps = Conexion.prepareStatement(query);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    System.out.println("ID:"+rs.getInt("id"));
                    System.out.println("nombre:"+rs.getString("nombreCliente"));
                    System.out.println("dpi:"+rs.getString("dpiCliente"));
                    System.out.println("temperatura:"+rs.getString("temperatura"));
                    System.out.println("fecha:"+rs.getString("fechaHora"));
                }
      
            
        }catch(SQLException e){
            System.out.println(e);
        }     
       }

  
    
}
