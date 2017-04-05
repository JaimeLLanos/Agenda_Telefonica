
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 
 * @author Oscar de la Cuesta Campillo. www.palentino.es
 */
public class Agenda {

    private ArrayList<Contacto> lista_contactos = new ArrayList<>();
    private int contador_contactos = 0; // Contador de objetos creados. Variable muy importante.

    public void Consultar(String nombre) {
    	for(Contacto c: lista_contactos){
    		if(nombre.equals(c.getNombre())){
    			System.out.println("Contacto encontrado");
    		}
    	}
    }

    public void Anadir(Contacto contacto) {
    	//El añadir tendra dos metodos. Este sera el encargado de añadir un contacto 
    	// a la lista de contactos
    	if(!existeContacto(contacto)){
    		System.out.println("No se puede añadir un contacto ");
    	}
    	else if (lista_contactos.contains(contacto)){
    		System.out.println("Contacto ya existente");
    	}
    	else{
    		lista_contactos.add(contacto);
    	}
    }
    
    public boolean existeContacto(Contacto c){
    	return c != null;
    }

    public ArrayList<Contacto> Buscar(String nombre) {
    	ArrayList<Contacto> contactosPatron = new ArrayList<>();
    	String name;
    	int resultado;
    	for(Contacto contacto : this.lista_contactos){
    		name = contacto.getNombre();
    		resultado = name.indexOf(nombre);
    		
    		if(resultado != -1){
    			contactosPatron.add(contacto);
    		}
    	}
    	
    	return contactosPatron;
    }
    

    public void Ordenar() {
        Collections.sort(lista_contactos);
    }

    public void Mostrar() {
    	if(this.lista_contactos == null){
    		System.out.println("No hay na");
    	}
    	else{
    		for(Contacto c : this.lista_contactos){
    			System.out.println(c);
    		}
    	}
    }

    public void Vaciar() {
       this.lista_contactos = null;
    }

    public void Eliminar() {
    
    }

    public void Modificar() {
        
    }

}