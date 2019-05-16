/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1.reglas;
import modulo1.*;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 *
 * @author Eduardo
 */
public class regla4 extends nodo{
    nodo defVar;
    public regla4(ArrayList<nodo> pila, ArrayList<String> datos){
        this.defVar = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico){
        System.out.println("R4 <Definicion>::= <DefVar>");
        this.defVar.muestra(tabla_simbolos, ambito,semantico);
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String>semantico){
        return "";
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R4 <Definicion>");
        DefaultMutableTreeNode nodoDef= this.defVar.muestraGrafico();
        padre.add(nodoDef);
        //System.out.println("R4");
        return padre;
    }
}
