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
        {0,3,-3,0},
        {2,0,0,4},
        {0,0,-2,0}
    };
    int[] reglas_posiciones={3,3};
    int[] cantidad_desapilar={3,1};
    
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
        boolean continuar=true;
        System.out.println("------Inicio------");
        System.out.println(this.pila);
        while(continuar){
            fila = Integer.parseInt(""+this.pila.get(this.pila.size()-1));
            if (cont==tam) {
                columna=2;//donde se encuentra el fin de la entrada
            }else{
                columna = this.tokens.get(cont).numero;
            }
            accion=tabla[fila][columna];
            
            System.out.println("------Vuelta "+(cont+1)+"-------");
            if (accion<0) {
                System.out.println("Reduccion");
            }else if(accion>0){
                System.out.println("Entrada: "+this.tokens.get(cont).simbolo +" -> "+this.tokens.get(cont).numero);
            }else{
                System.out.println("Sin accion");
            }
            System.out.println("accion: "+accion);
            if (accion>0) {
                this.pila.add(this.tokens.get(cont).numero);
                this.pila.add(accion);
                cont++;
            }else if(accion<0){
                if (accion==-1) {
                    System.out.println("Aceptado");
                    continuar=false;
                }else{
                    //tam-=2;
                    //cont-=2;
                    int regla = Math.abs(accion)-2;
                    System.out.println("regla "+regla);
                    int posicion_regla = this.reglas_posiciones[regla];
                    System.out.println("posicion regla "+posicion_regla );
                    int cantidad_desapilar = (this.cantidad_desapilar[regla])*2;
                    System.out.println("cantidad desapilar "+cantidad_desapilar);
                    for (int desapila = 0; desapila < cantidad_desapilar; desapila++) {
                        this.pila.pop();
                    }
                    int valor_regla = this.tabla[Integer.parseInt(""+this.pila.get(this.pila.size()-1))][posicion_regla];
                    System.out.println("valor_regla "+valor_regla);
                    this.pila.push(regla);
                    this.pila.push(valor_regla);
                }
                System.out.println("");
                
            }else{
            
            }
            System.out.println(this.pila);
            
            
            /*if (cont==tam) {
                continuar=false;
            }*/
        }
        
        

        
        return "";
    }
            
}
