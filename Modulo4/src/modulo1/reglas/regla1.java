/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1.reglas;
import modulo1.*;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

public class regla1 extends nodo {
    nodo definiciones;
    public regla1(ArrayList<nodo> pila, ArrayList<String> datos){
        this.definiciones = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//elimina dato que agregamos a definiciones
    }
    public void muestra(){
        System.out.println("R1 <programa> ::= <Definiciones>");
        this.definiciones.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode programa = new DefaultMutableTreeNode("R1 <programa>");
        DefaultMutableTreeNode definiciones= this.definiciones.muestraGrafico();  
        programa.add(definiciones);
        return programa;
    }
}