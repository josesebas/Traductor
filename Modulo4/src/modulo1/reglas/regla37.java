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
public class regla37 extends nodo{
    int entero;
    public regla37(ArrayList<nodo> pila, ArrayList<String> datos){
        this.entero = Integer.parseInt(datos.get(datos.size()-1));
        datos.remove(datos.size()-1);
    }
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R37 <Termino>::=Entero: "+this.entero);
        
    }
    public String semantico(ArrayList<String>tabla_simbolos, String ambito,ArrayList<String>semantico, String generacionCodigo){
        return "int-"+this.entero;
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R37 <Termino>");
        DefaultMutableTreeNode nodoEnt=new DefaultMutableTreeNode("Entero "+ this.entero);
        padre.add(nodoEnt);
        //System.out.println("R37");
        return padre;
    }

}
