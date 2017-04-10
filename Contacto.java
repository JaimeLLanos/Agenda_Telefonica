
/**
 *
 * @author Oscar de la Cuesta - www.palentino.es
 */

import java.util.ArrayList;

public class Contacto implements Comparable<Contacto> {
    private String nombre;
    private ArrayList<Integer> listaNumeros = new ArrayList<>();

    public Contacto(String nombre, int numero)
    {
    this.nombre=nombre;
    this.listaNumeros.add(numero);
    }
    
    public void set_nombre(String nomb){        
        this.nombre=nomb.toUpperCase();
    }
    
    public void anadirNumero(int numero){
        this.listaNumeros.add(numero);
    }
    
    public ArrayList<Integer> getNumeros(){
        return this.listaNumeros;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    private String mostrarNumeros(){
       
        String cadena=null;
        for(Integer numero:this.listaNumeros){
           cadena= cadena.concat(Integer.toString(numero));
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
    
    
    
    
}