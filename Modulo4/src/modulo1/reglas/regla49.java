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
public class regla49 extends nodo{
    nodo expresion1;
    nodo expresion2;
    String opIg;
    public regla49 (ArrayList<nodo> pila, ArrayList<String> datos){
        this.expresion1 = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        
        datos.remove(datos.size()-1);
        this.opIg = datos.remove(datos.size()-1);//desapila ope iguald

        this.expresion2 =pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R49 <Expresion>::= <Expresion> opIgualdad <Expresion>");
        this.expresion2.muestra(tabla_simbolos, ambito, semantico, generacionCodigo);
        this.expresion1.muestra(tabla_simbolos, ambito, semantico, generacionCodigo);
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R49 <Expresion>");
        DefaultMutableTreeNode nodoExp1= this.expresion1.muestraGrafico();
         DefaultMutableTreeNode nodoOp=new DefaultMutableTreeNode(" opIgu "+ this.opIg);
        DefaultMutableTreeNode nodoExp2= this.expresion2.muestraGrafico();
        padre.add(nodoExp2);
        padre.add(nodoOp);
        padre.add(nodoExp1);
//        System.out.println("R49");
        return padre;
    }
}
