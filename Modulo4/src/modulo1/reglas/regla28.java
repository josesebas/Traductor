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
public class regla28  extends nodo{
    nodo sentencias;
    public regla28(ArrayList<nodo> pila, ArrayList<String> datos){
        datos.remove(datos.size()-1);//desapila {
        this.sentencias = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapila sentencia
        datos.remove(datos.size()-1);//desapila }
    }
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R28 <Bloque>::={ <Sentencias> }");
        this.sentencias.muestra(tabla_simbolos, ambito, semantico,generacionCodigo);
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R28 <Bloque>");
        //DefaultMutableTreeNode nodoLlaI=new DefaultMutableTreeNode(" { ");
        DefaultMutableTreeNode nodoSen =  this.sentencias.muestraGrafico();
        //DefaultMutableTreeNode nodoLlaD=new DefaultMutableTreeNode(" } ");
        //padre.add(nodoLlaI);
        padre.add(nodoSen);
        //padre.add(nodoLlaD);
//        System.out.println("R28");
        return padre;
    }
}
