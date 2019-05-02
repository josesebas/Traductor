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
public class regla40 extends nodo {
    String identificador;
    nodo argumentos;
    public regla40(ArrayList<nodo> pila, ArrayList<String> datos){
        this.identificador = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);

        datos.remove(datos.size()-1);//desapila (
        
        this.argumentos = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        
        datos.remove(datos.size()-1);//desapila )
    }
    public void muestra(){
        System.out.println("R40 <LlamadaFunc>::= Identificador: "+this.identificador+" ( <Argumentos> ) ");
        this.argumentos.muestra();
    }
     public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R40 <LlamadaFunc>");
        DefaultMutableTreeNode nodoIde = new DefaultMutableTreeNode("Identificador "+this.identificador);
        //DefaultMutableTreeNode nodoParI=new DefaultMutableTreeNode(" ( ");
        DefaultMutableTreeNode nodoArg= this.argumentos.muestraGrafico();
        //DefaultMutableTreeNode nodoParD=new DefaultMutableTreeNode(" ) ");
        padre.add(nodoIde);
        //padre.add(nodoParI);
        padre.add(nodoArg);
        //padre.add(nodoParD);
        return padre;
    }  
   

}
