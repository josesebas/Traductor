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
public class regla39 extends nodo{
    String cadena;
    public regla39(ArrayList<nodo> pila, ArrayList<String> datos){
        this.cadena = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);
    }
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico){
        System.out.println("R39 <Termino>::=Cadena:" +this.cadena);
    }
    public String semantico(ArrayList<String>tabla_simbolos, String ambito,ArrayList<String>semantico){
        return "string-"+this.cadena;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R39 <Termino>");
        DefaultMutableTreeNode cadena=new DefaultMutableTreeNode("Cadena "+this.cadena);
        padre.add(cadena);
//        System.out.println("R39");
        return padre;
    }

}
