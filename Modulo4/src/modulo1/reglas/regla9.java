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
public class regla9 extends nodo{
    String tipo;
    String identificador;
    nodo parametros;
    nodo bloqFunc;
    public regla9(ArrayList<nodo> pila, ArrayList<String> datos){
        this.tipo = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);//desapilamos tipo
        
        this.identificador = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);//desapilamos identificador
        
        datos.remove(datos.size()-1);//desapilamos  parentesis
       
        this.parametros  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapilamos parametros
        
        datos.remove(datos.size()-1);//desapilamos parentesis
        
        this.bloqFunc  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapilamos bloqueFucion
        
    }  
    public void muestra(){
        System.out.println("R9 <DefFunc> ::= Tipo: "+this.tipo+" Identificador: "+this.identificador+" ( <Parametros> ) <BloqueFun>");
        this.parametros.muestra();
        this.bloqFunc.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R9 <DefFun>");
        DefaultMutableTreeNode nodoTip=new DefaultMutableTreeNode("Tipo "+this.tipo);
        DefaultMutableTreeNode nodoIde = new DefaultMutableTreeNode("Tipo "+this.identificador);
        DefaultMutableTreeNode nodoParam = this.parametros.muestraGrafico();
        DefaultMutableTreeNode nodoBloq = this.bloqFunc.muestraGrafico();
        padre.add(nodoTip);
        padre.add(nodoIde);
        padre.add(nodoParam);
        padre.add(nodoBloq);
        
        return padre;
    }
    
}
