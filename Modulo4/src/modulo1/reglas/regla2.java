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
public class regla2 extends nodo{
    public regla2(ArrayList<nodo> pila, ArrayList<String> datos){
    }  
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico){
        System.out.println("R2 <Definiciones> ::= \\e ");
    }
    public DefaultMutableTreeNode muestraGrafico(){
        //System.out.println("R2");
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R2 <Definiciones>");
        DefaultMutableTreeNode vacio=new DefaultMutableTreeNode("\\e");
        padre.add(vacio);
        
        return padre;
    }
}
