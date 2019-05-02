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
public class regla47 extends nodo{
    nodo expresion1;
    nodo expresion2;
    String opSum;
    public regla47 (ArrayList<nodo> pila, ArrayList<String> datos){
        this.expresion1 = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        
        datos.remove(datos.size()-1);
        this.opSum = datos.remove(datos.size()-1);//desapila op sum

        this.expresion2 =pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(){
        System.out.println("R47 <Expresion>::= <Expresion> opSuma <Expresion>");
        this.expresion1.muestra();
        this.expresion2.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R47 <Expresion>");
        DefaultMutableTreeNode nodoExp1= this.expresion1.muestraGrafico();
         DefaultMutableTreeNode nodoOp=new DefaultMutableTreeNode(" opSum "+ this.opSum);
        DefaultMutableTreeNode nodoExp2= this.expresion2.muestraGrafico();
        padre.add(nodoExp1);
        padre.add(nodoOp);
        padre.add(nodoExp2);
        return padre;
    }
}
