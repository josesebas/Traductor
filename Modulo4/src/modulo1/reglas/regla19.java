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
public class regla19 extends nodo {
    public regla19(ArrayList<nodo> pila, ArrayList<String> datos){
    }
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico){
        System.out.println("R19 <Sentencias>::=\\e");
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R19 <Sentencias>");
        DefaultMutableTreeNode vacio=new DefaultMutableTreeNode("\\e");
        padre.add(vacio);
        //System.out.println("R19");
        return padre;
    }
}
