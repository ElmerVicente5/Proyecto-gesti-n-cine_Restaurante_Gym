/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appCovid;

import static com.mycompany.appCovid.ClienteCine.asientos;
import java.util.Random;

/**
 *
 * @author PC
 */
public class ClienteRestaurante extends Cliente {
    int numeromesa;
    int personasPermitidas;
            
    String hora;
    public static char mesas[]= new char[20];
    
    
    public void validarmesa()//validamos las mesas que estaran disponibles
    {
       for(int rArray=0;rArray<mesas.length;rArray++)
       {
           if(rArray %2==0)
           {
             mesas[rArray]='D';// D es el estado de la mesa disponible
                          
           }else
           {
            mesas[rArray]='N';  //N la mesa no está disponible
           }
       }
    }
    public void estadoMesa(int numMesa)//validamos si la mesa ingresada está disponible
    {
      if(mesas[numMesa]=='N')
      {
          System.out.println("la mesa no está disponible por el momento");
          ClienteService.crearClienteRestaurante();
      }
    }
    public void validarTemperatura(double temperatura)//validamos si la temperatura no excede los limites establecidos
    {
     if(temperatura>39)
     {
       System.out.println("su temperatura es demasiado alta, no puede estar en el restaurante");
       ClienteService.crearClienteRestaurante();
     }else if(temperatura<36)
     {
         System.out.println("su temperatura es anormal, no puede estar en el restaurante");
         ClienteService.crearClienteRestaurante();
     }
    }
    public ClienteRestaurante(){}

    public ClienteRestaurante(int numeromesa, int personasPermitidas) {
        this.numeromesa = numeromesa;
        this.personasPermitidas = personasPermitidas;
    }

    public int getNumeromesa() {
        return numeromesa;
    }

    public void setNumeromesa(int numeromesa) {
        this.numeromesa = numeromesa;
    }

    public int getPersonasPermitidas() {
        return personasPermitidas;
    }

    public void setPersonasPermitidas(int personasPermitidas) {
        this.personasPermitidas = personasPermitidas;
    }
      
    
}
