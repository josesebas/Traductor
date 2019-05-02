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
public class regla27 extends nodo{
    nodo sentenciaBloque;
    public regla27(ArrayList<nodo> pila, ArrayList<String> datos){
        datos.remove(datos.size()-1);//desapila else
        this.sentenciaBloque = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);
    }
    public void muestra(){
        System.out.println("R27 <Otro>::= else <SentenciaBloque>");
        this.sentenciaBloque.muestra();
    }

    public DefaultMutableTreeNode muestraGrafico(){
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R27 <Otro>");
        DefaultMutableTreeNode nodoElse=new DefaultMutableTreeNode(" else ");
        DefaultMutableTreeNode nodoSentencia= this.sentenciaBloque.muestraGrafico();
        padre.add(nodoElse);
        padre.add(nodoSentencia);
        return padre;
    }
}
