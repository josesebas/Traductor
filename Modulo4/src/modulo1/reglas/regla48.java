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
public class regla48 extends nodo{
    nodo expresion1;
    nodo expresion2;
    public regla48 (ArrayList<nodo> pila, ArrayList<String> datos){
        this.expresion1 = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        
        datos.remove(datos.size()-1);//desapila op relac

        this.expresion2 =pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(){
        System.out.println("R48 <Expresion>::= <Expresion> opRelac <Expresion>");
        this.expresion1.muestra();
        this.expresion2.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R48 <Expresion>");
        DefaultMutableTreeNode nodoExp1= this.expresion1.muestraGrafico();
        DefaultMutableTreeNode nodoExp2= this.expresion2.muestraGrafico();
        padre.add(nodoExp1);
        padre.add(nodoExp2);
        return padre;
    }
}