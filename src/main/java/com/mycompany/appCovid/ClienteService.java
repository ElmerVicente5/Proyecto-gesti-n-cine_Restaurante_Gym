/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appCovid;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class ClienteService {
    public ClienteService(){}
    
    public static void crearCliente(){
        ClienteCine cliente = new ClienteCine();
        cliente.validarasientos();
        Calendar calendario = Calendar.getInstance();
         int horActual=calendario.get(Calendar.HOUR_OF_DAY);
         int validar=horActual-app.horaInicio;
         if(validar==2)
         {
             app.personasCineSala1=20;
             app.personasCineSala2=20;
             app.personasCineSala3=20;
         }
          
          Scanner sc = new Scanner(System.in);
        System.out.println("Inserte nombre: ");
        String nom = sc.nextLine();
        
        System.out.println(" ");
        System.out.println("Inserte DPI: ");
        String dpi = sc.nextLine();
        System.out.println("Temperatura: ");
        double temp=sc.nextDouble();
        cliente.validarTemperatura(temp);
        cliente.asignarAsientos();
        System.out.println("Asiento asignado: "+cliente.getNumeroAsiento());
        //System.out.println("Sala: ");
        //int sal=sc.nextInt();
        System.out.println("ejemplo");
        
        cliente.setNombre(nom);
        cliente.setTemperatura(temp);
        cliente.setDpi(dpi);
        cliente.setNumSala(app.numeroSala);
        
       
        cliente.setNumAsiento(cliente.numeroAsiento);
        ClienteDAO.crearCliente(cliente);   
         
        
        //registro.setMensaje(mens);
       // registro.setAutor_mensaje(nom);
       
       // MensajesDAO.crearMensajeDB(registro);
        
        
    
    }
     
    public static void crearClienteRestaurante()
    {
        ClienteRestaurante cliente= new ClienteRestaurante();
    Calendar calendario = Calendar.getInstance();
         int horActual=calendario.get(Calendar.HOUR_OF_DAY);
         if(app.horaInicio<horActual)
         {
             app.personasRestaurante=20;
         }
        cliente.validarmesa();
        System.out.println("lugares disponibles: "+app.personasRestaurante);
        if(app.personasRestaurante>0 && app.personasRestaurante<=20)
                {
                 Scanner sc = new Scanner(System.in);
        
        System.out.println("Inserte nombre: ");
        String nom = sc.nextLine();
        
        System.out.println(" ");
        System.out.println("Inserte DPI: ");
        String dpi = sc.nextLine();
        System.out.println("Temperatura: ");
        double temp=sc.nextDouble();
        cliente.validarTemperatura(temp);
        System.out.println("numero mesa: ");
        int sal=sc.nextInt();
        cliente.estadoMesa(sal);
        
        cliente.setNombre(nom);
        cliente.setDpi(dpi);
        cliente.setTemperatura(temp);
        cliente.setNumeromesa(sal);
        ClienteDAO.crearClienteRestaurante(cliente);   
                }else{
            System.out.println("restaurante lleno");
        }
        
    }
    public static void crearClienteGimnasio()
    {
        Calendar calendario = Calendar.getInstance();
         int horActual=calendario.get(Calendar.HOUR_OF_DAY);
         int validar=horActual-app.horaInicio;
        
        switch (validar) {
            case 0 -> {
                System.out.println("lugares disponibles: "+app.personasGimnasio);
                ClienteGimnasio cliente= new ClienteGimnasio();
                if(app.personasGimnasio>0 && app.personasGimnasio<=5)
                {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Inserte nombre: ");
                    String nom = sc.nextLine();
                    
                    System.out.println(" ");
                    System.out.println("Inserte DPI: ");
                    String dpi = sc.nextLine();
                    System.out.println("Temperatura: ");
                    double temp=sc.nextDouble();
                    cliente.validarTemperatura(temp);
                    cliente.setNombre(nom);
                    cliente.setDpi(dpi);
                    cliente.setTemperatura(temp);
                    ClienteDAO.crearClienteGimnasio(cliente);
                }
            }
            case 2 -> System.out.println("no puede ingresar cliente Personal Haciendo limpieza");
            case 3 -> app.personasGimnasio=5;
            default -> {
            }
        }
        
     
    }
    public static void listadoClienteRestaurante()
    {
        ClienteDAO.leerListadoClienteRestaurante();
    }
    public static void listadoClienteCine()
    {
        ClienteDAO.leerListadoClienteCine();
    }
    public static void buscarClienteCine()
    {
        ClienteCine cliente = new ClienteCine();
      Scanner sc = new Scanner(System.in); 
      System.out.println("Inserte sala: ");
        int dpi = sc.nextInt();
        cliente.setNumSala(dpi);
        ClienteDAO.busquedaClienteCine(cliente);
        
    }
    public static void buscarClienteGimnasio()
    {
        ClienteGimnasio cliente= new ClienteGimnasio();
        Scanner sc = new Scanner(System.in); 
      System.out.println("Inserte DPI: ");
        String dpi = sc.nextLine();
        cliente.setDpi(dpi);
       ClienteDAO.busquedaClienteGimnasio(cliente);
        
    }
    
}
