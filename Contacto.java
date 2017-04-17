/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.ArrayList;



/**
 *
 * @author yoel
 */



public class Contacto implements Serializable, Comparable<Contacto>{
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
    
    
   	public int compareTo(Contacto o) {
   		// TODO Auto-generated method stub
   		return this.nombre.compareTo(o.nombre);
   	
   	}
   	
   	public void eliminarNumero(Numero numero){
   		Numero aux = null;
   		for(Numero n : listaNumeros){
   			if(n == numero){
   				aux = n;
   			}
   		}
   		listaNumeros.remove(aux);
   	}
   	
   	public void modificarNumero(Numero antiguo, Numero nuevo){
   		this.eliminarNumero(antiguo);
   		this.anadirNumero(nuevo);
   	}
   	
   	public void eliminarListaNumero(){
   		this.listaNumeros = null;
   	}
    
}
