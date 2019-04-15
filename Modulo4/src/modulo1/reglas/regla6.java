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
public class regla6 extends nodo{
    String tipo;
    String identificador;
    nodo listaVar;
    public regla6(ArrayList<nodo> pila, ArrayList<String>datos){
        this.tipo = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);//desapilamos tipo
        
        
        this.identificador = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);//desapilamos identificador
        
        this.listaVar  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapilaos listavar
        
        
                                    //desapilamos ;
        datos.remove(datos.size()-1);
    }  
    public void muestra(){
        System.out.println("R6 <DefVar> ::= Tipo: "+this.tipo+" Identificador: "+this.identificador+" <ListaVar> ;");
        this.listaVar.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R6 <DefVar>");
        DefaultMutableTreeNode nodoTip= new DefaultMutableTreeNode("Tipo "+this.tipo);
        DefaultMutableTreeNode nodoIde= new DefaultMutableTreeNode("Identificador "+this.identificador);
        DefaultMutableTreeNode nodoList= this.listaVar.muestraGrafico();
        padre.add(nodoTip);
        padre.add(nodoIde);
        padre.add(nodoList);
        return padre;
    }
}
