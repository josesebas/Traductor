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
public class regla5 extends nodo{
    nodo defFun;
    public regla5(ArrayList<nodo> pila, ArrayList<String>datos){
        this.defFun  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//quitamos defFuncion
    }  
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R5 <Definicion> ::= <DefFunc>");
        this.defFun.muestra(tabla_simbolos, ambito, semantico, generacionCodigo);
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String>semantico, String generacionCodigo){
        return "";
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        //System.out.println("R5");
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R5 <Definicion>");
        DefaultMutableTreeNode nodoDef= this.defFun.muestraGrafico();
        padre.add(nodoDef);
        
        return padre;
    }
}
