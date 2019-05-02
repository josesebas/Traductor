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
public class regla22 extends nodo{
    nodo expresion;
    nodo sentenciaBloque;
    nodo otro;
    public regla22(ArrayList<nodo> pila, ArrayList<String> datos){
        datos.remove(datos.size()-1);//desapila if
        datos.remove(datos.size()-1);//desapila parentesis
        this.expresion = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapila expresion
        this.sentenciaBloque = pila.get(pila.size()-1);
        datos.remove(datos.size()-1);//desapila parentesis
        pila.remove(pila.size()-1);//desapila sentencia
        this.otro = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapila otro
    }
    public void muestra(){
        System.out.println("R22 <Sentencia>::= if ( <Expresion> ) <SentenciaBloque> <Otro>");
        this.expresion.muestra();
        this.sentenciaBloque.muestra();
        this.otro.muestra();
    }
    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R22 <Sentencia>");
        DefaultMutableTreeNode nodoExp= this.expresion.muestraGrafico();
        //DefaultMutableTreeNode nodoParI=new DefaultMutableTreeNode(" ) ");
        DefaultMutableTreeNode nodoSent=this.sentenciaBloque.muestraGrafico();
        //DefaultMutableTreeNode nodoParD=new DefaultMutableTreeNode(" ) ");
        DefaultMutableTreeNode nodoOtro  = this.otro.muestraGrafico();
        padre.add(nodoExp);
        //padre.add(nodoParI);
        padre.add(nodoSent);
        //padre.add(nodoParD);
        padre.add(nodoOtro);
        return padre;
    }
}
