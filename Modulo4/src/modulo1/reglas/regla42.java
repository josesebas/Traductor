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
public class regla42 extends nodo{
    nodo bloque;
    public regla42(ArrayList<nodo> pila, ArrayList<String> datos){
        this.bloque = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R42 <SentenciaBloque>::=<Bloque>");
        this.bloque.muestra(tabla_simbolos, ambito, semantico,generacionCodigo);
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R42 <SentenciaBloque>");
        DefaultMutableTreeNode nodoBloq= this.bloque.muestraGrafico();
        padre.add(nodoBloq);
 //       System.out.println("R42");
        return padre;
    }
}
