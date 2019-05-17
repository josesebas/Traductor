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
public class regla18 extends nodo{
    nodo sentencia;
    public regla18(ArrayList<nodo> pila, ArrayList<String> datos){
        this.sentencia = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        
        
    }
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico,String generacionCodigo){
        System.out.println("R18 <DefLocal>::=<Sentencia>");
        this.sentencia.muestra(tabla_simbolos, ambito, semantico,generacionCodigo);
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String>semantico,String generacionCodigo){
        return "";
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R18 <DefLocal>");
        DefaultMutableTreeNode nodoSentencia= this.sentencia.muestraGrafico();
        padre.add(nodoSentencia);
        //System.out.println("R18");
        return padre;
    }
}
