/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yoel
 */


import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agenda implements Serializable {

    private ArrayList<Contacto> lista_contactos;
    //private int contador_contactos = 0; // Contador de objetos creados. Variable muy importante.
    
    public Agenda(){
        lista_contactos= new ArrayList<>();   
    }

    public void Consultar(String nombre) {
    	for(Contacto c: lista_contactos){
    		if(nombre.equals(c.getNombre())){
    			System.out.println("Contacto encontrado");
    		}
    	}
    }
    
    private boolean existeContacto(Contacto contacto){
        for(Contacto c:this.lista_contactos){
            if(c.equals(contacto))
                    return true;
        }
        return false;
        
            
    }
    public void Anadir(Contacto contacto) {
    	//El añadir tendra dos metodos. Este sera el encargado de añadir un contacto 
    	// a la lista de contactos
    	if(existeContacto(contacto)){
    		System.out.println("No se puede añadir un contacto, porque ya existe");
    	}
    	else if (lista_contactos.contains(contacto)){
    		System.out.println("Contacto ya existente");
    	}
    	else{
    		lista_contactos.add(contacto);
                this.guardar();
    	}
    }
    
    

    public ArrayList<Contacto> Buscar(String nombre) {
        //boolean encontrado = false;
        String name;
        ArrayList<Contacto> contactosPatron= new ArrayList<>();
        for(Contacto contacto:this.lista_contactos){
           name=contacto.getNombre();
           int resultado=name.indexOf(name);
           if(resultado!=-1)
               contactosPatron.add(contacto);
            
        }
        return contactosPatron;
    }
    
    public Contacto BuscarContacto(String nombre){
    	Contacto c = null;
    	String name;
    	 for(Contacto contacto:this.lista_contactos){
    		 name=contacto.getNombre();
    		 if(name == nombre){
    			 c = contacto;
    		 }
    	 }
    	 
    	 return c;
    }

       /* for (int i = 0; i < contador_contactos; i++) {
            if (nombre.equals(this.lista_contactos[i].getNombre())) {
                System.out.println(this.lista_contactos[i].getNombre() + "-" + "Tf:" + this.lista_contactos[i].getTelefono());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contacto inexistente");
        }
    }
    */
    

    /*public void MostrarOrdenados() {
        Collections.sort(lista_contactos);
    }
    */
    

    public void Mostrar() {
        if(this.lista_contactos==null)
            System.out.println("La agenda esta vacia, no se puede mostrar");
        else{
            for(Contacto contacto:this.lista_contactos){
                System.out.println(contacto);
            }
        }
    }

    public void Vaciar() {
       this.lista_contactos = null;
    }
    
    /*
    public void Eliminar() {
        try {
            boolean encontrado = false;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nombre de contacto a eliminar:");
            String eliminar = teclado.readLine().toUpperCase();
            if (contador_contactos == 0) {
                System.out.println("No hay contactos");
            } else {
                for (int i = 0; i < contador_contactos; i++) {

                    if (eliminar.equals(this.lista_contactos[i].getNombre())) {
                        System.out.println(i + 1 + ". " + this.lista_contactos[i].getNombre() + "-" + "Tf:" + this.lista_contactos[i].getTelefono());
                        encontrado = true;
                    }
                }
                if (encontrado) {
                    System.out.println("¿Qué contacto quieres eliminar, introduce el número asociado?");
                    int eliminar_numero = Integer.parseInt(teclado.readLine());
                    eliminar_numero--;
                    System.out.println("¿Estas seguro (S/N)?");
                    String respuesta;
                    respuesta = teclado.readLine();
                    respuesta = respuesta.toUpperCase();
                    if (respuesta.equals("S")) {
                        Contacto[] temporal = new Contacto[99];
                        int ii = 0;
                        boolean encontrado2=false;
                        for (int i = 0; i < this.contador_contactos; i++) {

                            if (i != eliminar_numero) {
                                // Creo el objeto temporal para el borrado
                                if (!encontrado2)
                                {
                                  temporal[ii] = this.lista_contactos[ii];
                                  ii++;
                                }
                                else
                                {
                                    if (ii<this.contador_contactos)
                                    { temporal[ii] = this.lista_contactos[ii+1];
                                     ii++;
                                    }
                                }

                            } else {
                                temporal[ii] = this.lista_contactos[ii + 1];
                                ii++;
                                encontrado2=true;

                            }
                        }
                        this.contador_contactos--;
                        System.out.println("Contacto eliminado correctamente");
                        for (int j = 0; j < this.contador_contactos; j++) {
                            this.lista_contactos[j] = temporal[j];

                        }

                    }

                } else {
                    System.out.println("Lo siento, No se ha encontrado el nombre");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
    public void Eliminar(Contacto contacto){
        
        if(!existeContacto(contacto))
            System.out.println("No se puede eliminar este contacto puesto que no existe");
        else{
            for(Contacto c:this.lista_contactos){
                if(c.equals(contacto)){
                    this.lista_contactos.remove(contacto);
                }
            }
        }
        //Despues de eliminar el contacto de la estructura de datos, procedemos a eliminar el contacto del fichero de contactos, guardando la ed nueva sin el contacto eliminado
        //O otra cosa que podemos hacer aqui es llamar a un metodo prrivado que seria utilizar el codigo que esta abajo
        //El metodo guardar esta abajo del todo de la clase
        try{
            File file=new File("agenda.txt");
            FileOutputStream fos=new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Contacto c:this.lista_contactos)
                oos.writeObject(c);
            
            oos.flush();
            oos.close();
        }
        catch(IOException e){
            System.out.println("ERROR: "+e.getClass()+" "+e.getMessage());
   
        }
          
        
    }
    
    public void eliminarPorNombre(String nombre){
    	Contacto c = this.BuscarContacto(nombre);
    	this.Eliminar(c);
    }
    

    /*public void Modificar() {
        try {
            boolean encontrado = false;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nombre de contacto a modificar:");
            String eliminar = teclado.readLine().toUpperCase();
            if (contador_contactos == 0) {
                System.out.println("No hay contactos");
            } else {
                for (int i = 0; i < this.contador_contactos; i++) {

                    if (eliminar.equals(this.lista_contactos[i].getNombre())) {
                        System.out.println(i + 1 + ". " + this.lista_contactos[i].getNombre() + "-" + "Tf:" + this.lista_contactos[i].getTelefono());
                        encontrado = true;
                    }
                }
                if (encontrado) {
                    System.out.println("¿Qué contacto quieres modificar?, introduce el número:");
                    int modificar_numero = Integer.parseInt(teclado.readLine());

                    System.out.println("Introduce nombre:");
                    String nombre_nuevo = teclado.readLine();
                    System.out.println("Introduce teléfono, formato numerico:");
                    int telefono_nuevo = Integer.parseInt(teclado.readLine());

                    this.lista_contactos[modificar_numero - 1].set_nombre(nombre_nuevo);
                    this.lista_contactos[modificar_numero - 1].set_telefono(telefono_nuevo);
                    Ordenar();
                } else {
                    System.out.println("No hay contactos con ese nombre");
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
    public void Modificar(Contacto contacto){
        
        if(!existeContacto(contacto))
            System.out.println("No se puede modificar un contacto inexistente!!");
        else{
            for(Contacto c:this.lista_contactos)
                if(c.equals(contacto)){
                    Scanner sc= new Scanner(System.in);
                    System.out.println("Dame nuevo nombre: ");
                    //Aqui estaria bien comprobar si el nombre modificado ya existe en la agenda, para decirle al usuario que ponga otro nombre
                    String nombre=sc.next();
                    c.set_nombre(nombre);
                    
                    System.out.println("Dame un numero: ");
                    int numero = sc.nextInt();
                    for(Numero n:contacto.getNumeros()){
                        if(n.getNumero()==numero){
                            System.out.println("Ya existe ese numero, desea modificar ?(s/n) ");
                            char op= sc.next().charAt(0);
                            if((op=='S')||(op=='s'))
                                    n.setNumero(numero);
                            
                        }
                        else{
                            System.out.println("El numero no existe, desea añadirlo?(s/n) ");
                            char op = sc.next().charAt(0);
                            if((op=='S')||(op=='s'))
                                    c.anadirNumero(n);
                        }
                    }
                }
            this.guardar();
        }
    }
    
    private void guardar(){
        try{
            File file=new File("agenda.txt");
            FileOutputStream fos=new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Contacto c:this.lista_contactos)
                oos.writeObject(c);
            
            oos.flush();
            oos.close();
        }
        catch(IOException e){
            System.out.println("ERROR: "+e.getClass()+" "+e.getMessage());
   
        }
        
        
    }
    
    public void cargar(File fichero){
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try{
            fis=new FileInputStream(fichero);
            ois=new ObjectInputStream(fis);
            this.lista_contactos.clear(); //para vaciar el arraylist que tengamos antes de cargar el fichero en el arraylist
            boolean eof=false;
            while(!eof){
                try{
                    Contacto contacto=(Contacto)ois.readObject();
                    this.lista_contactos.add(contacto);
                }
                catch(EOFException |ClassNotFoundException e){
                    eof=true;
                }
            }
            ois.close();
            fis.close();
        }
        catch(FileNotFoundException e){
            
        }
        catch(IOException e){
            System.out.println("ERROR: "+e.getClass()+": "+e.getMessage());
        }
  
    }
    
    private void guardarConParametro(File file){
        try{
            //File file=new File("agenda.txt");
            FileOutputStream fos=new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Contacto c:this.lista_contactos)
                oos.writeObject(c);
            
            oos.flush();
            oos.close();
        }
        catch(IOException e){
            System.out.println("ERROR: "+e.getClass()+" "+e.getMessage());
   
        }
        
        
    }
                                   


}