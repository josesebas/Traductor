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
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico){
        System.out.println("R13 <ListaParam> ::= , Tipo: "+this.tipo+" Identificador: "+this.identificador+"<ListaParam>");
        //---------------------------------------------Insercion
        boolean encontrado = false;
        for (int i = tabla_simbolos.size()-1; i >-1; i--) {
            String temporal = tabla_simbolos.get(i);
            String[] arreglo = temporal.split("-");
             if (this.identificador.equals(arreglo[1])&&(ambito.equals(arreglo[2]))) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            tabla_simbolos.add(this.tipo + "-" + this.identificador+"-"+ambito);
            semantico.add("Success-Insercion en tabla de parametro "+this.identificador);
        }else{
            semantico.add("Error-Parametro duplicado "+this.identificador);
        }
        //----------------------------------------------fin
        this.listaParam.muestra(tabla_simbolos, ambito, semantico);
        
    }
    public String semantico(){
        System.out.println("Retornar tipo: "+this.tipo);
        return this.tipo;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        //System.out.println("R13");

        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R13 <ListaParam>");
        DefaultMutableTreeNode nodoComa=new DefaultMutableTreeNode(" , ");
        DefaultMutableTreeNode nodoTipo=new DefaultMutableTreeNode("Tipo: "+this.tipo);
        DefaultMutableTreeNode nodoIden= new DefaultMutableTreeNode("Identificador: "+this.identificador);
        DefaultMutableTreeNode nodoList = this.listaParam.muestraGrafico();
        
        padre.add(nodoComa);
        padre.add(nodoTipo);
        padre.add(nodoIden);
        padre.add(nodoList);
        return padre;
    }
}
