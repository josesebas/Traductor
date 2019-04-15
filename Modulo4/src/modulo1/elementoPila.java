/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1;
import modulo1.reglas.*;
/**
 *
 * @author Eduardo
 */
public class elementoPila extends nodo{
    int codigo=0;
    String valor="";
    nodo regla=null;
    public elementoPila(String valor, int codigo){
        this.codigo = codigo;
        this.valor = valor;
        this.regla =null;
    }
    public elementoPila(){
        this.codigo =0;
        this.valor="";
        this.regla=null;
    }
    public nodo getRegla(){
        return this.regla;
    }
    public void setRegla(nodo asignar){
        this.regla = asignar;
    }
    public int getCodigo(){
        return this.codigo;
    }
    public void setCodigo(int asignar){
        this.codigo = asignar;
    }
    public String getValor(){
        return this.valor;
    }
    public void setValor(String asignar){
        this.valor = asignar;
    }
}
