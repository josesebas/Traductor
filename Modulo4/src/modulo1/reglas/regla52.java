/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1.reglas;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Eduardo
 */
public class regla52 extends nodo{
    nodo termino;
    public regla52 (ArrayList<nodo> pila, ArrayList<String> datos){
        this.termino = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(){
        System.out.println("R52 <Expresion>::= <Termino>");
        this.termino.muestra();
        
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R52 <Expresion>");
        DefaultMutableTreeNode nodoTerm= this.termino.muestraGrafico();
        padre.add(nodoTerm);
        return padre;
    }
}