/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appCovid;
import java.util.Random;

/**
 *
 * @author PC
 */
public class ClienteCine extends Cliente{
    
    int numSala;
    int personasPermitidas=20;
    String numAsiento;
    String numeroAsiento;
    public static int asientos[][] = new int[10][10];
    public static int asientosdisponibles[][]=new int[20][2];
    
    
    
    public ClienteCine()
    {
        
    }
    public ClienteCine(int numSala, String numAsiento){
        this.numAsiento=numAsiento;
        this.numSala=numSala;
        
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public String getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

   
    
    public void validarasientos()//validadmos los asientos que estaran disponibles
    {
        int asientosTotal=0;
        int p=0,n=2,distanciaSillas=9,disSillaImp=4;
        //en las variables distanciasilla puede cambiar la distancia de los asientos
        for(int l=0;l<asientos.length;l++)
        {
            if(asientosTotal==20) break;//si ya llegó el limite de asientos a validar se rompe el ciclo
            for(int k=0;k<2;k++)
          {
              if(asientosTotal==20) break;
           if(l %2==0)//si la fila es impar que se validen los siguientes asientos
          {
             asientos[l][p]=1; 
             //asientosdisponibles[l][0]=l;
             //asientosdisponibles[l][1]=p;
             p=p+distanciaSillas;
             asientosTotal++;
             
          }else{
               
              asientos[l][n]=1; 
              //asientosdisponibles[l][0]=l;
            // asientosdisponibles[l][1]=n;
              n=n+disSillaImp;
              asientosTotal++;
             
          }   
          }
            p=0;
            n=2;
          
        }     
        
      
        
       
    }
    public void asignarAsientos()//funcion para retornar un asiento al azar
    {
       
        int random1;
        int random2;
        boolean asiento=true;
        do{
           random1= (int) (Math.random()*8+1);
           random2= (int) (Math.random()*8+1);
           if(asientos[random1][random2]==1)
           {
               asientos[random1][random2]=0;
             numeroAsiento=" "+random1+random2;//capturamos la fila y la columna del asiento
         
          
            asiento=false;
           }
            
        }while(asiento);
    
       
    }
       public void validarTemperatura(double temperatura)//validamos la temperatura
    {
     if(temperatura>39)
     {
       System.out.println("su temperatura es demasiado alta, no puede estar en el restaurante");
       ClienteService.crearCliente();
     }else if(temperatura<36)
     {
         System.out.println("su temperatura es anormal, no puede estar en el restaurante");
         ClienteService.crearCliente();
     }
    }

    
    
   
    
}
