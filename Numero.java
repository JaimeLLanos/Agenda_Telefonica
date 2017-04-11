/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author yoel
 */
public class Numero {
   private int numero;
    
    public int getNumero(){
        return this.numero;
    }
    
    public void setNumero(int numero){
        this.numero=numero;
    }
    
    public String toString (){
        return Integer.toString(this.getNumero());
    }
            
}
