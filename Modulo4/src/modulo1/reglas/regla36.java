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
public class regla36 extends nodo{
    String identificador;
    public regla36(ArrayList<nodo> pila, ArrayList<String> datos){
        this.identificador = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);
    }
    public void muestra(){
        System.out.println("R36 <Termino>::=Identificador: "+this.identificador);
       
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R36 <Termino>");
        DefaultMutableTreeNode nodoIde=new DefaultMutableTreeNode("Identificador: "+this.identificador);
        padre.add(nodoIde);
        return padre;
    }
}
