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
public class regla21 extends nodo{
    String identificador;
    nodo expresion;
    public regla21(ArrayList<nodo> pila, ArrayList<String> datos){
        this.expresion = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        
        this.identificador = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);
        datos.remove(datos.size()-1);
        datos.remove(datos.size()-1);
    }   
    public void muestra(){
        System.out.println("R21 <Sentencia>::= Identificador: "+this.identificador +" =  <Expresion> ;");
        this.expresion.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R21 <Sentencia>");
        DefaultMutableTreeNode nodoIden= new DefaultMutableTreeNode("Identificador: "+ this.identificador);
        DefaultMutableTreeNode nodoIgual=new DefaultMutableTreeNode(" = ");
        DefaultMutableTreeNode nodoExp=this.expresion.muestraGrafico();
        DefaultMutableTreeNode nodoPunto=new DefaultMutableTreeNode(" ; ");
        
        padre.add(nodoIden);
        padre.add(nodoIgual);
        padre.add(nodoExp);
        padre.add(nodoPunto);
        return padre;
    }
}
