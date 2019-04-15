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
public class regla38 extends nodo{
    float real;
    public regla38(ArrayList<nodo> pila, ArrayList<String> datos){
        this.real = Float.parseFloat(datos.get(datos.size()-1));
        datos.remove(datos.size()-1);
    }
    public void muestra(){
        System.out.println("R38 <Termino>::=Real:");
    }
        public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R38 <Termino>");
        DefaultMutableTreeNode real=new DefaultMutableTreeNode("Real "+this.real);
        padre.add(real);
        return padre;
    }
}
