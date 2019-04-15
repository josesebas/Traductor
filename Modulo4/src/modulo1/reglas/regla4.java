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
public class regla4 extends nodo{
    nodo defVar;
    public regla4(ArrayList<nodo> pila, ArrayList<String> datos){
        this.defVar = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(){
        System.out.println("R4 <Definicion>::= <DefVar>");
        this.defVar.muestra();
    }

    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R4 <Definicion>");
        DefaultMutableTreeNode nodoDef= this.defVar.muestraGrafico();
        padre.add(nodoDef);
        return padre;
    }
}
