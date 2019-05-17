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
public class regla8 extends nodo{
    String identificador;
    nodo listaVar;
    public regla8(ArrayList<nodo> pila, ArrayList<String> datos){
        this.listaVar = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        
        this.identificador = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);
    }
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R8 <ListaVar>::= , Identificador: "+this.identificador+" <ListaVar>");
        this.listaVar.muestra(tabla_simbolos, ambito, semantico,generacionCodigo);
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R8 <Definiciones>");
        DefaultMutableTreeNode nodoComa=new DefaultMutableTreeNode(" , ");
        DefaultMutableTreeNode nodoIde=new DefaultMutableTreeNode("Identificador "+this.identificador);
        DefaultMutableTreeNode nodoList = this.listaVar.muestraGrafico();
        padre.add(nodoComa);
        padre.add(nodoIde);
        padre.add(nodoList);
 //       System.out.println("R8");
        return padre;
    }
}
