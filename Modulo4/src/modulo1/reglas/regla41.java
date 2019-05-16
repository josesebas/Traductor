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
public class regla41 extends nodo{
    nodo sentencia;
    public regla41(ArrayList<nodo> pila, ArrayList<String> datos){
        this.sentencia = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico){
        System.out.println("R41 <SentenciaBloque>::=<Sentencia>");
        this.sentencia.muestra(tabla_simbolos, ambito, semantico);
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R41 <SentenciaBloque>");
        DefaultMutableTreeNode nodoSen= this.sentencia.muestraGrafico();
        padre.add(nodoSen);
//        System.out.println("R41");
        return padre;
    }
}
