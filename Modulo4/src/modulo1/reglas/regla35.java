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
public class regla35 extends nodo{
    nodo llamadaFunc;
    public regla35(ArrayList<nodo> pila, ArrayList<String> datos){
        this.llamadaFunc = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(){
        System.out.println("R35 <Termino>::=<LlamadaFunc>");
        this.llamadaFunc.muestra();
    }

    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R35 <Termino>");
        DefaultMutableTreeNode nodoLlamada= this.llamadaFunc.muestraGrafico();
        padre.add(nodoLlamada);
        return padre;
    }
}
