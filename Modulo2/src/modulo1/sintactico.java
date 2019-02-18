/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Eduardo
 */
public class sintactico {
    ArrayList<token> tokens;
    String respuesta="";
    Stack pila;
    int[][] tabla= {
        {2,0,0,1},
        {0,0,-1,0},
        {0,3,0,0},
        {4,0,0,0},
        {0,0,-2,0}
    };
    
    sintactico(ArrayList<token> tokens){
        this.tokens =tokens;
        this.pila = new Stack<>();
        //this.pila.push(new token(23,"$","$"));
        this.pila.push("$");
        this.pila.push(0);
        
        /*this.pila.push(1);
        this.pila.push("gola");
        this.pila.push(tokens.get(0).simbolo);
        while(!pila.empty()){
            System.out.println(pila.pop());
        }*/
        //System.out.println(this.pila.size());
    }
    public String analizar(){
        int fila, columna, accion = 0;
        int tam = this.tokens.size();
        int cont =0;
        boolean aceptacion=false;
        System.out.println("------Inicio------");
        System.out.println(this.pila);
        while(cont<tam){
            fila = Integer.parseInt(""+this.pila.get(this.pila.size()-1));
            columna = this.tokens.get(cont).numero;
            accion=tabla[fila][columna];
            System.out.println("------Vuelta "+(cont+1)+"-------");
            System.out.println("entrada: "+this.tokens.get(cont).simbolo +" -> "+this.tokens.get(cont).numero);
            System.out.println("accion: "+accion);
            if (accion>0) {
                this.pila.add(this.tokens.get(cont).numero);
                this.pila.add(accion);
            }else if(accion<0){
                System.out.println("");
            }else{
            
            }
            System.out.println(this.pila);
            
            cont++;
        }
        
        

        
        return "";
    }
            
}
