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
public class regla14 extends nodo{
    nodo defLocales;
    public regla14(ArrayList<nodo> pila, ArrayList<String> datos){
        datos.remove(datos.size()-1);//desapilamos {
        
        this.defLocales  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapilamos defLocales
        
        datos.remove(datos.size()-1);//desapilamos  y }
    }  
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico){
        System.out.println("R14 <BloqFunc> ::= { <DefLocales> }");
        this.defLocales.muestra(tabla_simbolos, ambito, semantico);
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String>semantico){
        return "";
    }
    public DefaultMutableTreeNode muestraGrafico(){
        //System.out.println("R14");
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R14 <BloqFun>");
        //DefaultMutableTreeNode nodoLlaI=new DefaultMutableTreeNode(" { ");
        DefaultMutableTreeNode nodoDefL=this.defLocales.muestraGrafico();
        //DefaultMutableTreeNode nodoLlaD=new DefaultMutableTreeNode(" } ");
        //padre.add(nodoLlaI);
        padre.add(nodoDefL);
        //padre.add(nodoLlaD);
        
        return padre;
    }
}
