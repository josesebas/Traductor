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
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico){
        System.out.println("R16 <DefLocales> ::= <DefLocal> <DefLocales>");
        
        this.defLocales.muestra(tabla_simbolos, ambito, semantico);
        this.defLocal.muestra(tabla_simbolos, ambito, semantico);
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String>semantico){
        return "";
    }
    public DefaultMutableTreeNode muestraGrafico(){
        System.out.println("R16");
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R16 <DefLocales>");
        DefaultMutableTreeNode nodoDefLocal= this.defLocal.muestraGrafico();
        DefaultMutableTreeNode nodoDefLocales=this.defLocales.muestraGrafico();
        padre.add(nodoDefLocales);
        padre.add(nodoDefLocal);
        
        return padre;
    }
}
