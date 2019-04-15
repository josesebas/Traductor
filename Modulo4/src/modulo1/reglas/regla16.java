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
public class regla16 extends nodo{
    nodo defLocal;
    nodo defLocales;
    public regla16(ArrayList<nodo> pila, ArrayList<String> datos){
        this.defLocal  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapilamos defLocal
        
        this.defLocales  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapilamos defLocales
        
       
        
        
    }     
    public void muestra(){
        System.out.println("R16 <DefLocales> ::= <DefLocal> <DefLocales>");
        this.defLocal.muestra();
        this.defLocales.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R16 <DefLocales>");
        DefaultMutableTreeNode nodoDefLocal= this.defLocal.muestraGrafico();
        DefaultMutableTreeNode nodoDefLocales=this.defLocales.muestraGrafico();
        padre.add(nodoDefLocal);
        padre.add(nodoDefLocales);
        return padre;
    }
}
