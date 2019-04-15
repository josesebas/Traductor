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
public class regla11 extends nodo {
    String tipo;
    String identificador;    
    nodo listaParam;
    public regla11(ArrayList<nodo> pila, ArrayList<String> datos){
        
        this.tipo  =  datos.get(datos.size()-1);
        datos.remove(datos.size()-1);//elimina dato de tipo
        
        this.identificador  =  datos.get(datos.size()-1);
        datos.remove(datos.size()-1);//elimina dato de identificador
        
        this.listaParam  =  pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//elimina dato de lista param 
           
    }
    public void muestra(){
        System.out.println("R11 <Parametros>::= Tipo: "+this.tipo+"  Identificador: "+this.identificador+" <ListaParam>");
        this.listaParam.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R11 <Parametros>");
        DefaultMutableTreeNode nodoTipo= new DefaultMutableTreeNode("Tipo: "+this.tipo);
        DefaultMutableTreeNode nodoIde=new DefaultMutableTreeNode("Identificador: "+this.identificador);
        DefaultMutableTreeNode nodoList = this.listaParam.muestraGrafico();
        padre.add(nodoTipo);
        padre.add(nodoIde);
        padre.add(nodoList);
        return padre;
    }

}
