/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1;

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
        System.out.println(lex.analizar());
    
    }
    
}
