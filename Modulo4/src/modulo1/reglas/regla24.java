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
public class regla24 extends nodo{
    nodo valorRegresa;
    public regla24(ArrayList<nodo> pila, ArrayList<String> datos){
        datos.remove(datos.size()-1);//desapila return      
        this.valorRegresa = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desspila valoregresa
        datos.remove(datos.size()-1);//desapila ;
    }
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico,String generacionCodigo){
        System.out.println("R24 <Sentencia>::= return <ValorRegresa> ;" );
        this.valorRegresa.muestra(tabla_simbolos, ambito, semantico,generacionCodigo);
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R24 <Sentencia>");
        DefaultMutableTreeNode nodoReturn=new DefaultMutableTreeNode(" return ");
        DefaultMutableTreeNode nodoValor= this.valorRegresa.muestraGrafico();
        padre.add(nodoReturn);
        padre.add(nodoValor);
//        System.out.println("R24");
        return padre;
    }
}
