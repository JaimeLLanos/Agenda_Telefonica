
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
    	if(!existe(contacto)){
    		System.out.println("No se puede añadir un contacto ");
    	}
    	else if (lista_contactos.contains(contacto)){
    		System.out.println("Contacto ya existente");
    	}
    	else{
    		lista_contactos.add(contacto);
    	}
    }

    public void Buscar(String nombre) {
        boolean encontrado = false;

        for (int i = 0; i < contador_contactos; i++) {
            if (nombre.equals(this.lista_contactos[i].getNombre())) {
                System.out.println(this.lista_contactos[i].getNombre() + "-" + "Tf:" + this.lista_contactos[i].getTelefono());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contacto inexistente");
        }
    }
    

    public void Ordenar() {
        Collections.sort(lista_contactos);
    }

    public void Mostrar() {
        if (this.contador_contactos == 0) {
            System.out.println("No hay contactos");
        } else {
            for (int t = 0; t < this.contador_contactos; t++) {
                // Es necesario por precaución usar el this para el metodo, puesto que si se ejecuta muchas veces la referencias a memoria pueden fallar.
                System.out.println(this.lista_contactos[t].getNombre() + "-" + "Tf:" + Integer.toString(this.lista_contactos[t].getTelefono()));
            }
        }
    }

    public void Vaciar() {
       this.lista_contactos = null;
    }

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

    public void Modificar() {
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

}