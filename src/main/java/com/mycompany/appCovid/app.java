/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appCovid;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author PC
 */
public class app {
    ClienteService cliente= new ClienteService();
    static int personasRestaurante=20;
    static int personasGimnasio=5;
    static int personasCineSala1=20;
    static int personasCineSala2=20;
    static int personasCineSala3=20;
    static int numeroSala=0;
    static int horaInicio;
    
    
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
         Calendar calendario = Calendar.getInstance();
         int hora=calendario.get(Calendar.HOUR_OF_DAY);//captura la hora en que se inicializa el programa
         horaInicio=hora;
         System.out.println("Hora Inicio: "+horaInicio);
         int opcion = 0;
         do{
             System.out.println("-------------------------------");
             System.out.println("  Aplicación de Mensajes ");
             System.out.println("1. Cine");
             System.out.println("2. Restaurante");
             System.out.println("3. Gimnasio");
             System.out.println("4. salir");
             
           opcion = sc.nextInt();
           
           switch(opcion){
               case 1: 
                   cine();
                   
                   break;
               case 2:
                   restaurante();
                  
                   break;
               case 3:
                   gimnasio();
                                   
                   
                   break;
               default:
                   break;
           }
             
         }while(opcion != 4);
       
    }
    public static void cine()
    {
        int opc;
        Scanner sc= new Scanner(System.in);
        System.out.println("-------AlBACINEMA-----");
        System.out.println("1.registrar cliente");
        System.out.println("2.consultar listado de clientes");
        System.out.println("2.buscar cliente");
        opc=sc.nextInt();
        
        switch(opc)
        {
            case 1:
                seleccionarSala();
                        
                break;
            case 2:
                ClienteService.listadoClienteCine();
                //va a la capa servicios a traer la funcion de listar cliente
                break;
            case 3:
                ClienteService.buscarClienteCine();
                //va a la capa servicio a traer la funcion de buscar cliente
            default:
                break;
        }
        
        
        
        
    }
  public static void restaurante()
  {
     int opc;
        Scanner sc= new Scanner(System.in);
        System.out.println("-------COMEDOR CHAOMEN-----");
        System.out.println("1.registrar cliente");
        System.out.println("2.consultar cliente");
        opc=sc.nextInt();
        
        switch(opc)
        {
            case 1:
                ClienteService.crearClienteRestaurante();
                  
                break;
            case 2:
                ClienteService.listadoClienteRestaurante();
                break;
            default:
                break;
        }  
  }
    public static void gimnasio()
    {
       int opc;
        Scanner sc= new Scanner(System.in);
        System.out.println("-------GYM FITNESS-----");
        System.out.println("1.registrar cliente");
        System.out.println("2. buscar cliente");
        opc=sc.nextInt();
        
        switch(opc)
        {
            case 1 -> ClienteService.crearClienteGimnasio();
            case 2 -> ClienteService.buscarClienteGimnasio();
            default -> {
            }
        }   
    }
    public static void seleccionarSala()
    {
        ClienteCine cliente1= new ClienteCine();
      int opc;
        Scanner sc= new Scanner(System.in);
        System.out.println("-------AlBACINEMA-----");
        System.out.println("1.registrar en Sala 1");
        System.out.println("2.registrar en sala 2");
        System.out.println("2.reistrar en sala 3");
        opc=sc.nextInt();
        
        switch(opc)
        {
            case 1:
                System.out.println("--------WAKANDA FOREVER--------");
                if(personasCineSala1>0 && personasCineSala2<=20)//valida si hay asientos disponibles
                {
                    System.out.println("Asientos Disponibles Sala1: "+ personasCineSala1);
                 numeroSala=1;
                    ClienteService.crearCliente();  //llamamos a la funicon para registrar cliente 
                }else{
                    System.out.println("sala llena");
                }
                
                        
                break;
            case 2:
                 System.out.println("--------BLACK ADAM--------");
                if(personasCineSala2>0 && personasCineSala2<=20)
                {
                    System.out.println("Asientos Disponibles Sala1: "+ personasCineSala2);
                     numeroSala=2;
               ClienteService.crearCliente(); 
                }else{
                      System.out.println("sala llena");
                }
              
                break;
            case 3:
                 System.out.println("--------MINIOMS--------");
                if(personasCineSala3>0 && personasCineSala3<=20)
                {
                    System.out.println("Asientos Disponibles Sala1: "+ personasCineSala3);
                 numeroSala=3;
               ClienteService.crearCliente();  
                }else{
                            System.out.println("sala llena");
                }
                
            default:
                break;
        }   
    }
    public void validarConteo(int resta)
    {
         ClienteCine cliente1= new ClienteCine();
        switch (cliente1.getNumSala()) {//si se ingresó un cliente a una sala restamos los asientos disponibles
            case 1 -> personasCineSala1=personasCineSala1-resta;//
            case 2 -> personasCineSala2=personasCineSala2-resta;
            case 3 -> personasCineSala3=personasCineSala3-resta;
            default -> {
            }
        }
        //si se ingresó un cliente a una sala restamos los asientos disponibles
            
    }
    public void validarConteoRestaurante(int resta)
    {
        personasRestaurante=personasRestaurante-resta;
    }
    public void validarConteoGimnasio(int resta)
    {
        personasGimnasio=personasGimnasio-resta;
    }

    public static int getPersonasRestaurante() {
        return personasRestaurante;
    }

    public static void setPersonasRestaurante(int personasRestaurante) {
        app.personasRestaurante = personasRestaurante;
    }

    public static int getPersonasGimnasio() {
        return personasGimnasio;
    }

    public static void setPersonasGimnasio(int personasGimnasio) {
        app.personasGimnasio = personasGimnasio;
    }

    public static int getPersonasCineSala1() {
        return personasCineSala1;
    }

    public static void setPersonasCineSala1(int personasCineSala1) {
        app.personasCineSala1 = personasCineSala1;
    }

    public static int getPersonasCineSala2() {
        return personasCineSala2;
    }

    public static void setPersonasCineSala2(int personasCineSala2) {
        app.personasCineSala2 = personasCineSala2;
    }

    public static int getPersonasCineSala3() {
        return personasCineSala3;
    }

    public static void setPersonasCineSala3(int personasCineSala3) {
        app.personasCineSala3 = personasCineSala3;
    }

    public static int getHoraInicio() {
        return horaInicio;
    }

    public static void setHoraInicio(int horaInicio) {
        app.horaInicio = horaInicio;
    }
    


    
    
}

