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
public class regla31 extends nodo{
    public regla31(ArrayList<nodo> pila, ArrayList<String> datos){
    }
    public void muestra(){
        System.out.println("R31 <Argumentos>::= \\e");
    }
        public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R31 <Argumentos>");
        DefaultMutableTreeNode vacio=new DefaultMutableTreeNode("\\e");
        padre.add(vacio);
        return padre;
    }
}