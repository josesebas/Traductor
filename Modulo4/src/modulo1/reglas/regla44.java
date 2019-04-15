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
public class regla44 extends nodo{
    nodo expresion;
    public regla44(ArrayList<nodo> pila, ArrayList<String> datos){
        datos.remove(datos.size()-1);//desapila op suma
        this.expresion = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(){
        System.out.println("R44 <Expresion>::= opSuma <Expresion>");
        this.expresion.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R44 <Definicion>");
        DefaultMutableTreeNode nodoExp= this.expresion.muestraGrafico();
        padre.add(nodoExp);
        return padre;
    }
}
