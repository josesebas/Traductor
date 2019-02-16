/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1;

import java.util.ArrayList;
import java.util.Scanner;

public class Modulo1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingresa el texto a analizar : ");
        String cadena = entrada.nextLine();
        
        analizadorLexico lex = new analizadorLexico(cadena);
        ArrayList<token> tokens = lex.analizar();
        int tam = tokens.size();
        /*for (int i = 0; i < tam; i++) {
            System.out.println(tokens.get(i).numero+"\t"+tokens.get(i).simbolo);
        }*/
        
        sintactico sintac = new sintactico(tokens);
        System.out.println(sintac.analizar());
    }
    
}
