/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1.reglas;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import modulo1.*;
/**
 *
 * @author Eduardo
 */
public class regla3 extends nodo {
    nodo definicion;
    nodo definiciones;
    public regla3(ArrayList<nodo> pila, ArrayList<String>datos){
        this.definicion =  pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapila definicion
        
        this.definiciones  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapila definiciones
                
    }  
    public void muestra(){
        System.out.println("R3 <Definiciones> ::=<Definicion> <Definiciones>");
        this.definicion.muestra();
        this.definiciones.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R3 <Definiciones>");
        DefaultMutableTreeNode nodoDefinicion= this.definicion.muestraGrafico();
        DefaultMutableTreeNode nodoDefiniciones=this.definiciones.muestraGrafico();
        padre.add(nodoDefinicion);
        padre.add(nodoDefiniciones);
        return padre;
    }
}
