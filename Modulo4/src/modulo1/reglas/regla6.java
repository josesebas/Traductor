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
public class regla6 extends nodo{
    String tipo;
    String identificador;
    nodo listaVar;
    public regla6(ArrayList<nodo> pila, ArrayList<String>datos){
        this.tipo = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);//desapilamos tipo
        
        
        this.identificador = datos.get(datos.size()-1);
        datos.remove(datos.size()-1);//desapilamos identificador
        
        this.listaVar  = pila.get(pila.size()-1);
        pila.remove(pila.size()-1);//desapilaos listavar
        
        
                                    //desapilamos ;
        datos.remove(datos.size()-1);
    }  

    
    public String generacionCodigo(ArrayList<String>tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        return null;
    }
    public void muestra(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("R6 <DefVar> ::= Tipo: "+this.tipo+" Identificador: "+this.identificador+" <ListaVar> ;");
        //-------------------------------------insercion----------------------
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
            semantico.add("Success-Insercion en tabla de variable "+this.identificador);
        }else{
            semantico.add("Error-Varible duplicada "+this.identificador);
        }
        //-------------------------------------fin------------------------
        this.listaVar.muestra(tabla_simbolos, ambito, semantico, generacionCodigo);
        
    }
    public String semantico(ArrayList<String> tabla_simbolos, String ambito, ArrayList<String> semantico, String generacionCodigo){
        System.out.println("Retornar tipo: "+this.tipo);
        return this.tipo;
    }
    public DefaultMutableTreeNode muestraGrafico(){
        
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("R6 <DefVar>");
        DefaultMutableTreeNode nodoTip= new DefaultMutableTreeNode("Tipo "+this.tipo);
        DefaultMutableTreeNode nodoIde= new DefaultMutableTreeNode("Identificador "+this.identificador);
        
        DefaultMutableTreeNode nodoList= this.listaVar.muestraGrafico();
        
        padre.add(nodoTip);
        padre.add(nodoIde);
        padre.add(nodoList);
        
        return padre;
    }
}
