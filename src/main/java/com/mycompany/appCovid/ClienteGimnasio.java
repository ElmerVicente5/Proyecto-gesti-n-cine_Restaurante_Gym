/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appCovid;

/**
 *
 * @author PC
 */
public class ClienteGimnasio extends Cliente {

    public ClienteGimnasio() {
    }

    public ClienteGimnasio(String nombre, String dpi, double temperatura) {
        super(nombre, dpi, temperatura);
    }
    
    
    
    
      public void validarTemperatura(double temperatura)
    {
     if(temperatura>39)
     {
       System.out.println("su temperatura es demasiado alta, no puede estar en el restaurante");
       ClienteService.crearClienteGimnasio();
     }else if(temperatura<36)
     {
         System.out.println("su temperatura es anormal, no puede estar en el restaurante");
         ClienteService.crearClienteGimnasio();
     }
    } 

    
}
