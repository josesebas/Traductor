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
public class regla17 extends nodo{
    nodo defVar;
    public regla17(ArrayList<nodo> pila, ArrayList<String> datos){
        
        this.defVar  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapilamos defVAr
    }  
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico,String generacionCodigo){
        System.out.println("R17 <DefLocal> ::= <DefVar>");
        this.defVar.muestra(tabla_simbolos, ambito, semantico,generacionCodigo);
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String>semantico, String generacionCodigo){
        return "";
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public DefaultMutableTreeNode muestraGrafico( ){
        //System.out.println("R17");
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R17 <DefLocal>");
        DefaultMutableTreeNode nodoDefVar= this.defVar.muestraGrafico();
        padre.add(nodoDefVar);
        
        return padre;
    }
}
