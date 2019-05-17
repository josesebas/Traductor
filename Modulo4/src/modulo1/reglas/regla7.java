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
public class regla7 extends nodo{
    public regla7(ArrayList<nodo> pila, ArrayList<String> datos){
    }  
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R7 <ListaVar> ::= \\e");
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String>semantico, String generacionCodigo){
        return "";
    }
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public DefaultMutableTreeNode muestraGrafico(){
       // System.out.println("R7");
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R7 <ListaVar>");
        DefaultMutableTreeNode vacio=new DefaultMutableTreeNode("\\e");
        padre.add(vacio);
        
        
        return padre;
    }
}
