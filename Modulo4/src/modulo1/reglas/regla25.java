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
public class regla25 extends nodo{
    nodo llamadaFunc;
    public  regla25(ArrayList<nodo> pila, ArrayList<String> datos){
        this.llamadaFunc = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        datos.remove(datos.size()-1);//desapila ;
    }
    public void muestra(){
        System.out.println("R25 <Sentencia>::=<LlamadaFunc> ;");
        this.llamadaFunc.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R25 <Sentencia>");
        DefaultMutableTreeNode nodoLlamada= this.llamadaFunc.muestraGrafico();
        padre.add(nodoLlamada);
        return padre;
    }
}
