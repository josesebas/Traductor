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
public class regla32 extends nodo{
    nodo expresion;
    nodo listaArgumentos;
    public regla32(ArrayList<nodo> pila, ArrayList<String> datos){
        this.expresion = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        this.listaArgumentos = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(){
        System.out.println("R32 <Argumentos>::=<Expresion> <ListaArgumentos>");
        this.expresion.muestra();
        this.listaArgumentos.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R32 <Argumentos>");
        DefaultMutableTreeNode nodoExp= this.expresion.muestraGrafico();
        DefaultMutableTreeNode nodoLis=this.listaArgumentos.muestraGrafico();
        padre.add(nodoExp);
        padre.add(nodoLis);
        return padre;
    }
}