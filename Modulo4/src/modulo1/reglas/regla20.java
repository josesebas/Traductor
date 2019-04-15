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
public class regla20 extends nodo{
    nodo sentencia;
    nodo sentencias;
    public regla20(ArrayList<nodo> pila, ArrayList<String> datos){
        this.sentencia  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        this.sentencias = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(){
        System.out.println("R20 <Sentencias>::=<Sentencia> <Sentencias>");
        this.sentencia.muestra();
        this.sentencias.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R20 <Sentencias>");
        DefaultMutableTreeNode nodoSentencia= this.sentencia.muestraGrafico();
        DefaultMutableTreeNode nodoSentencias=this.sentencias.muestraGrafico();
        padre.add(nodoSentencia);
        padre.add(nodoSentencias);
        return padre;
    }
}