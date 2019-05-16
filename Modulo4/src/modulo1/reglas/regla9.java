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
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico){
        System.out.println("R9 <DefFunc> ::= Tipo: "+this.tipo+" Identificador: "+this.identificador+" ( <Parametros> ) <BloqueFun>");
        //--------------------------------Insercion------------------
        boolean encontrado = false;
        for (int i = tabla_simbolos.size()-1; i >-1; i--) {
            String temporal = tabla_simbolos.get(i);
            String[] arreglo = temporal.split("-");
            //System.out.println(this.identificador.equals(arreglo[1]));
            //System.out.println(ambito.equals(arreglo[2]));
             if (this.identificador.equals(arreglo[1])&&(ambito.equals("Global"))) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            tabla_simbolos.add(this.tipo + "-" + this.identificador+"-"+ambito);
            semantico.add("Success-Insercion en tabla de funcion "+this.identificador);
        }else{
            semantico.add("Error-Funcion duplicada "+this.identificador);
        }
        //------------------------------Cambio de ambito
        ambito = this.identificador;
        
        this.bloqFunc.muestra(tabla_simbolos, ambito, semantico);
        this.parametros.muestra(tabla_simbolos, ambito, semantico);
        
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String>semantico){
        return this.tipo;
    }
    
    public DefaultMutableTreeNode muestraGrafico(){
        //System.out.println("R9");
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R9 <DefFun>");
        DefaultMutableTreeNode nodoTip=new DefaultMutableTreeNode("Tipo "+this.tipo);
        DefaultMutableTreeNode nodoIde = new DefaultMutableTreeNode("Identificador "+this.identificador);
        DefaultMutableTreeNode nodoParI = new DefaultMutableTreeNode(" ( ");
        
        DefaultMutableTreeNode nodoParam = this.parametros.muestraGrafico();
        DefaultMutableTreeNode nodoParD = new DefaultMutableTreeNode(" ) ");
        DefaultMutableTreeNode nodoBloq = this.bloqFunc.muestraGrafico();
        
        padre.add(nodoTip);
        padre.add(nodoIde);
        padre.add(nodoParI);
        
        padre.add(nodoBloq);
        
        padre.add(nodoParD);
        
        padre.add(nodoParam);
        
        return padre;
    }

}
