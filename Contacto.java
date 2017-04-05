/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.ais.que.dolor.xd;

import java.util.ArrayList;

/**
 *
 * @author yoel
 */



public class Contacto {
    private String nombre;
    private ArrayList<Numero>listaNumeros=new ArrayList<>();

    public Contacto(String nombre, Numero numero)
    {
    this.nombre=nombre;
    this.listaNumeros.add(numero);
    }
    
    public void set_nombre(String nomb){        
        this.nombre=nomb.toUpperCase();
    }
    public void anadirNumero(Numero numero){
        this.listaNumeros.add(numero);
    }
    
    public ArrayList<Numero> getNumeros(){
        return this.listaNumeros;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    private String mostrarNumeros(){
       
        String cadena=null;
        for(Numero numero:this.listaNumeros){
           cadena= cadena.concat(Integer.toString(numero.getNumero()));
        }
        return cadena;
                
    }       
    
            

    
    
    @Override
    public String toString (){
        return this.nombre+", "+this.mostrarNumeros();
    }
    
    
    
}
