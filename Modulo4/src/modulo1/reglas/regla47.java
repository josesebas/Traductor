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
public class regla47 extends nodo{
    nodo expresion1;
    nodo expresion2;
    String opSum;
    public regla47 (ArrayList<nodo> pila, ArrayList<String> datos){
        this.expresion1 = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        
        datos.remove(datos.size()-1);
        this.opSum = datos.remove(datos.size()-1);//desapila op sum

        this.expresion2 =pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R47 <Expresion>::= <Expresion> opSuma <Expresion>");
        this.expresion2.muestra(tabla_simbolos, ambito, semantico, generacionCodigo);
        this.expresion1.muestra(tabla_simbolos, ambito, semantico, generacionCodigo);
        
        System.out.println(generacionCodigo(tabla_simbolos, ambito, semantico, generacionCodigo));
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito,  ArrayList<String> semantico, String generacionCodigo){
        System.out.println("Semantico suma");
        String[] temp = this.expresion2.semantico( tabla_simbolos, ambito, semantico, generacionCodigo).split("-");
        String[] temp2 = this.expresion1.semantico(tabla_simbolos, ambito, semantico, generacionCodigo).split("-");
        if(temp[0].equals(temp2[0])){
            semantico.add("Success-Tipo de datos iguales");
            return temp[0]+"-"+temp[1]+"+"+temp2[1];
        }else{
            semantico.add("Error-Tipo de datos diferentes");
            return "DIF";
        }
    }
    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R47 <Expresion>");
        DefaultMutableTreeNode nodoExp1= this.expresion1.muestraGrafico();
         DefaultMutableTreeNode nodoOp=new DefaultMutableTreeNode(" opSum "+ this.opSum);
        DefaultMutableTreeNode nodoExp2= this.expresion2.muestraGrafico();
        padre.add(nodoExp2);
        padre.add(nodoOp);
        padre.add(nodoExp1);
//        System.out.println("R47");
        return padre;
    }
}
