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
public class regla3 extends nodo {
    nodo definicion;
    nodo definiciones;
    public regla3(ArrayList<nodo> pila, ArrayList<String>datos){
        this.definicion =  pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapila definicion
        
        this.definiciones  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapila definiciones
                
    }  
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R3 <Definiciones> ::=<Definicion> <Definiciones>");
        
        this.definiciones.muestra(tabla_simbolos, ambito, semantico, generacionCodigo);
        this.definicion.muestra(tabla_simbolos, ambito, semantico, generacionCodigo);
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String>semantico){
        return "";
    }
    public DefaultMutableTreeNode muestraGrafico(){
        //System.out.println("R3");
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R3 <Definiciones>");
        DefaultMutableTreeNode nodoDefinicion= this.definicion.muestraGrafico();
        
        DefaultMutableTreeNode nodoDefiniciones=this.definiciones.muestraGrafico();
        padre.add(nodoDefiniciones);
        padre.add(nodoDefinicion);
        
        
        return padre;
    }
}
