/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1;
import modulo1.reglas.*;
/**
 *
 * @author Eduardo
 */
public class nodo {
    public reglas regla;
    public nodo izq;
    public nodo der;
    
    public nodo(){
       this.izq = null;
       this.der = null;
    }
    public reglas getRegla(){
        return this.regla;
    }
    public nodo getNodoDerecho(){
        return this.der;
    }
    public nodo getNodoIzquierdo(){
        return this.izq;
    }
    public void setNodoDerecho(nodo setNodo){
        this.der = setNodo;
    }
    public void setNodoIzquierdo (nodo setNodo){
        this.izq =setNodo;
    }

}
