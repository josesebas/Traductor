/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1.reglas;
import modulo1.*;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Eduardo
 */
public class regla10 extends nodo {
    public regla10(ArrayList<nodo> pila, ArrayList<String> datos){
    }
    public void muestra(){
        System.out.println("R10 <Parametros>::= \\e");
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R10 <Parametros>");
        DefaultMutableTreeNode vacio= new DefaultMutableTreeNode("\\e");
        padre.add(vacio);
        return padre;
    }
    
}