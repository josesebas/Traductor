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
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico,String generacionCodigo){
        System.out.println("R1 <programa> ::= <Definiciones>");
        this.definiciones.muestra(tabla_simbolos, ambito, semantico, generacionCodigo);
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return this.definiciones.semantico(tabla_simbolos, ambito, semantico, generacionCodigo);
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        //System.out.println("R1");
        DefaultMutableTreeNode programa = new DefaultMutableTreeNode("R1 <programa>");
        DefaultMutableTreeNode definiciones= this.definiciones.muestraGrafico();  
        programa.add(definiciones);
        
        return programa;
    }
}