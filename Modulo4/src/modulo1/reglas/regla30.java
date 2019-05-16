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
public class regla30 extends nodo{
    nodo expresion;
    public regla30(ArrayList<nodo> pila, ArrayList<String> datos){
        this.expresion = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico){
        System.out.println("R30 <ValorRegresa>::=<Expresion>");
        this.expresion.muestra(tabla_simbolos, ambito, semantico);
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R30 <ValorRegresa>");
        DefaultMutableTreeNode nodoExp=this.expresion.muestraGrafico();
        padre.add(nodoExp);
//        System.out.println("R30");
        return padre;
    }
}
