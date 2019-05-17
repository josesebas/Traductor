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
public class regla34 extends nodo{
    nodo expresion;
    nodo listaArgumentos;
    public regla34(ArrayList<nodo> pila, ArrayList<String> datos){
        datos.remove(datos.size()-1);//desapila ,
        this.expresion = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        this.listaArgumentos = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R34 <ListaArgumentos>::= , <Expresion> <ListaArgumentos>");
        this.expresion.muestra(tabla_simbolos, ambito, semantico,generacionCodigo);
        this.listaArgumentos.muestra(tabla_simbolos, ambito, semantico, generacionCodigo);
        
    }

    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R34 <ListaArgumentos>");
        DefaultMutableTreeNode nodoComa=new DefaultMutableTreeNode(" , ");
        DefaultMutableTreeNode nodoExp= this.expresion.muestraGrafico();
        DefaultMutableTreeNode nodoList=this.listaArgumentos.muestraGrafico();
        padre.add(nodoComa);
        
        padre.add(nodoExp);
        padre.add(nodoList);
        
        
        //System.out.println("R34");
        return padre;
    }
            


}
