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
public class regla40 extends nodo {
    String identificador;
    nodo argumentos;
    public regla40(ArrayList<nodo> pila, ArrayList<String> datos){
        this.identificador = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);

        datos.remove(datos.size()-1);//desapila (
        
        this.argumentos = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        
        datos.remove(datos.size()-1);//desapila )
    }
    public void muestra(ArrayList<String> tabla_simbolos,String ambito,ArrayList<String> semantico){
        System.out.println("R40 <LlamadaFunc>::= Identificador: "+this.identificador+" ( <Argumentos> ) ");
        this.argumentos.muestra(tabla_simbolos, ambito, semantico);
        System.out.println(semantico(tabla_simbolos, ambito, semantico));
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String>semantico){
        boolean encontrado = false;
        for (int i = 0; i < tabla_simbolos.size(); i++) {
            if (tabla_simbolos.get(i).split("-")[1].equals(this.identificador)) {
                encontrado =true;
            }
        }
        if (encontrado) {
            semantico.add("Success-llamada funcion existente");
        }else{
            semantico.add("Error-llamada funcion inexistente");
        }
        return "";
    }
     public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R40 <LlamadaFunc>");
        DefaultMutableTreeNode nodoIde = new DefaultMutableTreeNode("Identificador "+this.identificador);
        //DefaultMutableTreeNode nodoParI=new DefaultMutableTreeNode(" ( ");
        DefaultMutableTreeNode nodoArg= this.argumentos.muestraGrafico();
        //DefaultMutableTreeNode nodoParD=new DefaultMutableTreeNode(" ) ");
        padre.add(nodoIde);
        //padre.add(nodoParI);
        padre.add(nodoArg);
        //padre.add(nodoParD);
        //System.out.println("R40");
        return padre;
    }  
   

}
