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
public class regla23 extends nodo{
    nodo expresion;
    nodo bloque;
    
    public regla23(ArrayList<nodo> pila, ArrayList<String> datos){
        datos.remove(datos.size()-1);//desapila while
        datos.remove(datos.size()-1);//desapila parentesis
        this.expresion = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapila expresion
        this.bloque = pila.get(pila.size()-1);
        datos.remove(datos.size()-1);//desapila parentesis
        pila.remove(pila.size()-1);//despila bloque
    }
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico){
        System.out.println("R23 <Sentencia>::= while ( <Expresion> ) <Bloque>");
        
        this.bloque.muestra(tabla_simbolos, ambito, semantico);
        this.expresion.muestra(tabla_simbolos, ambito, semantico);
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R23 <Sentencia>");
        DefaultMutableTreeNode nodoWhile=new DefaultMutableTreeNode(" while");
        DefaultMutableTreeNode nodoExp= this.expresion.muestraGrafico();
        DefaultMutableTreeNode nodoBloq=this.bloque.muestraGrafico();
        padre.add(nodoWhile);
        padre.add(nodoBloq);
        padre.add(nodoExp);
        
        //System.out.println("R23");
        return padre;
    }
}

