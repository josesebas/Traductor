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
public class regla33 extends nodo{
    public regla33(ArrayList<nodo> pila, ArrayList<String> datos){
    }
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R33 <ListaArgumentos>::=\\e" );
        
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R33 <ListaArgumentos>");
        DefaultMutableTreeNode vacio=new DefaultMutableTreeNode("\\e");
        padre.add(vacio);
//        System.out.println("R33");
        return padre;
    }
}
