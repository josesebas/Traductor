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
public class regla13 extends nodo {
    String tipo;
    String identificador;
    nodo listaParam;
    public regla13(ArrayList<nodo> pila, ArrayList<String> datos){
        datos.remove(datos.size()-1);//eliminamos  ,
        
        this.tipo  = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);//eliminamos tipo
        
        this.identificador  = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);//eliminamos identificador
        
        this.listaParam  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//eliminamos listaParam
        

    }  
    public void muestra(){
        System.out.println("R13 <ListaParam> ::= , Tipo: "+this.tipo+" Identificador: "+this.identificador+"<ListaParam>");
        this.listaParam.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R13 <ListaPAram>");
        DefaultMutableTreeNode nodoTipo=new DefaultMutableTreeNode("Tipo: "+this.tipo);
        DefaultMutableTreeNode nodoIden= new DefaultMutableTreeNode("Identificador: "+this.identificador);
        DefaultMutableTreeNode nodoList = this.listaParam.muestraGrafico();
        padre.add(nodoTipo);
        padre.add(nodoIden);
        padre.add(nodoList);
        return padre;
    }
}
