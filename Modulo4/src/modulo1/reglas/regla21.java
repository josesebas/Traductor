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
public class regla21 extends nodo{
    String identificador;
    nodo expresion;
    public regla21(ArrayList<nodo> pila, ArrayList<String> datos){
        this.expresion = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
        
        this.identificador = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);
        datos.remove(datos.size()-1);
        datos.remove(datos.size()-1);
    }   
    public void muestra(ArrayList<String> tabla_simbolos,String ambito, ArrayList<String> semantico){
        System.out.println("R21 <Sentencia>::= Identificador: "+this.identificador +" =  <Expresion> ;");
        this.expresion.muestra(tabla_simbolos, ambito, semantico);
        
        //System.out.println("semantico asignacion");
        
        System.out.println(semantico(tabla_simbolos, ambito,semantico));
        
        //System.out.println(tabla_simbolos);
        
    }
    public String semantico(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String>semantico){
        String respuesta ="";
        int posicion=0;
        System.out.println("analizando "+this.identificador);
        for (int i = 0; i <tabla_simbolos.size(); i++) {
            System.out.println("analizado ciclo "+tabla_simbolos.get(i).split("-")[1]);
            if (tabla_simbolos.get(i).split("-")[1].equals(this.identificador) ) {
                respuesta = tabla_simbolos.get(i).split("-")[0];
                posicion=i;
            }
        }
        String[] temp = this.expresion.semantico(tabla_simbolos, ambito,semantico).split("-");
        System.out.println("tipo dato asignacion der "+temp[0]);
        if (respuesta.equals("")) {
            //System.out.println("Variable no declarada en asignacion");
            semantico.add("Error-Variable no declarada");
            return "";
        }else if(respuesta.equals(temp[0])){
            
            //System.out.println("tipos de datos iguales en asignacion");
            semantico.add("Success-Tipos de datos iguales en asignacion");
            tabla_simbolos.set(posicion, tabla_simbolos.get(posicion)+"-"+temp[1]);
            return "";
        
        }else{
            //System.out.println("tipos de datos diferentes en asignacion");
            semantico.add("Error-Tipos de datos diferentes en asignacion");
            return "";
        }
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R21 <Sentencia>");
        DefaultMutableTreeNode nodoIden= new DefaultMutableTreeNode("Identificador: "+ this.identificador);
        DefaultMutableTreeNode nodoIgual=new DefaultMutableTreeNode(" = ");
        DefaultMutableTreeNode nodoExp=this.expresion.muestraGrafico();
        DefaultMutableTreeNode nodoPunto=new DefaultMutableTreeNode(" ; ");
        
        padre.add(nodoIden);
        padre.add(nodoIgual);
        padre.add(nodoExp);
        padre.add(nodoPunto);
//        System.out.println("R21");
        return padre;
    }
}
