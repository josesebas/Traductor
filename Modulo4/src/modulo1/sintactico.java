/*
 * To change this license header,    choose License Headers in Project Properties.
 * To change this template file,     choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1;

import java.util.ArrayList;
import modulo1.reglas.*;
import java.util.Stack;

/**
 *
 * @author Eduardo
 */
public class sintactico {
    ArrayList<token> tokens;
    String respuesta="";
    ArrayList<elementoPila> pila= new ArrayList<elementoPila>();
    ArrayList<String> valoresArbol = new ArrayList<String>();
    ArrayList<nodo> nodosArbol = new ArrayList<nodo>();
    nodo programa = new nodo();
    int[][] tabla1= {
        {2, 0,  0,  1}, 
        {0, 0,  -1, 0}, 
        {0, 3,  -3, 0}, 
        {2, 0,  0,  4}, 
        {0, 0,  -2, 0}
    };
    int[] reglas_posiciones1={3, 3};
    int[] cantidad_desapilar1={3,    1};

    int [][] gramatica= 
{{0,    0,  0,  0,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -3, 1,  2,  3,  4,  0,  6,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -1, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -2, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -3, 0,  7,  3,  4,  0,  6,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  -5, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -5, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {8,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  -6, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -6, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -4, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -8, 10, 11, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  9,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  12, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {13,   0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  15, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -11,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  14, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {-7,   0,  0,  0,  -7, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -7, 0,  -7, -7, -7, 0,  -7, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -8, 10, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  16, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  17, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {18,   0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -9, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  20, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  19, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  22, 0,  -13,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  21, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  -10,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -10,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {27,   0,  0,  0,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -16,    0,  28, 29, 30, 0,  0,  0,  0,  0,  25, 0,  0,  0,  0,  0,  23, 24, 0,  26, 0,  0,  0,  0,  0,  0,  31, 0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -12,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  32, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  33, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {27,   0,  0,  0,  5,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -16,    0,  28, 29, 30, 0,  0,  0,  0,  0,  25, 0,  0,  0,  0,  0,  34, 24, 0,  26, 0,  0,  0,  0,  0,  0,  31, 0,  0}, 
 {-18,  0,  0,  0,  -18,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -18,    0,  -18,    -18,    -18,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {-19,  0,  0,  0,  -19,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -19,    0,  -19,    -19,    -19,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  36, 0,  0,  0,  35, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  37, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  38, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  -30,    0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  39, 0,  0,  44, 45, 0,  40},    
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  50, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {51,   0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  -15,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -15,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -17,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  52},    
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, -32,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  53, 0,  44, 45, 0,  54},    
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  55},    
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  56},    
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  57, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  59, 58, 60, 63, 62, 0,  61, -31,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  64},    
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  65},    
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  66},    
 {0,    0,  0,  0,  0,  -53,    -53,    -53,    -53,    -53,    0,  -53,    -53,    -53,    0,  -53,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  -36,    -36,    -36,    -36,    -36,    0,  -36,    -36,    -36,    0,  -36,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  -37,    -37,    -37,    -37,    -37,    0,  -37,    -37,    -37,    36, -37,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  -38,    -38,    -38,    -38,    -38,    0,  -38,    -38,    -38,    0,  -38,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  -39,    -39,    -39,    -39,    -39,    0,  -39,    -39,    -39,    0,  -39,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  -40,    -40,    -40,    -40,    -40,    0,  -40,    -40,    -40,    0,  -40,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {-26,  0,  0,  0,  -26,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -26,    0,  -26,    -26,    -26,    -26,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  22, 0,  -13,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  67, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  59, 58, 60, 63, 62, 0,  61, 68, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  69, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  59, 58, 60, 63, 62, 0,  61, 0,  71, 0,  -34,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  70, 0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  59, 58, 60, 63, 62, 0,  61, 0,  0,  0,  72, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  59, 58, 60, 63, 62, 0,  61, 0,  0,  0,  73, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {-25,  0,  0,  0,  -25,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -25,    0,  -25,    -25,    -25,    -25,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  74},    
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  75},    
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  76},    
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  77},    
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  78},    
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  79},    
 {0,    0,  0,  0,  0,  59, 58, 60, 63, 62, 0,  61, 0,  0,  0,  80, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  -45,    -45,    -45,    -45,    -45,    0,  -45,    -45,    -45,    0,  -45,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  -46,    -46,    -46,    -46,    -46,    0,  -46,    -46,    -46,    0,  -46,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -14,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {-22,  0,  0,  0,  -22,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -22,    0,  -22,    -22,    -22,    -22,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  -41,    -41,    -41,    -41,    -41,    0,  -41,    -41,    -41,    0,  -41,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -33,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {46,   47, 48, 49, 0,  42, 0,  0,  0,  0,  43, 0,  0,  0,  41, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  44, 45, 0,  81},    
 {27,   0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  85, 0,  0,  28, 29, 30, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  83, 0,  84, 0,  0,  0,  0,  31, 82, 0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  85, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  86, 0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  -47,    -47,    -47,    -47,    -47,    0,  -47,    -47,    -47,    0,  -47,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  -48,    58, -48,    -48,    -48,    0,  -48,    -48,    -48,    0,  -48,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  59, 58, -49,    -49,    -49,    0,  -49,    -49,    -49,    0,  -49,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  59, 58, 60, -50,    -50,    0,  -50,    -50,    -50,    0,  -50,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  59, 58, 60, -51,    -51,    0,  61, -51,    -51,    0,  -51,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  59, 58, 60, -52,    62, 0,  61, -52,    -52,    0,  -52,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  -44,    -44,    -44,    -44,    -44,    0,  -44,    -44,    -44,    0,  -44,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  59, 58, 60, 63, 62, 0,  61, 0,  71, 0,  -34,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  87, 0,  0,  0,  0}, 
 {-27,  0,  0,  0,  -27,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -27,    0,  -27,    -27,    -27,    89, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  88, 0,  0,  0,  0,  0,  0,  0,  0}, 
 {-42,  0,  0,  0,  -42,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -42,    0,  -42,    -42,    -42,    -42,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {-43,  0,  0,  0,  -43,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -43,    0,  -43,    -43,    -43,    -43,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {27,   0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -20,    0,  28, 29, 30, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  90, 91, 0,  0,  0,  0,  0,  0,  31, 0,  0}, 
 {-24,  0,  0,  0,  -24,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -24,    0,  -24,    -24,    -24,    -24,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -35,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {-23,  0,  0,  0,  -23,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -23,    0,  -23,    -23,    -23,    -23,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {27,   0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  85, 0,  0,  28, 29, 30, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  83, 0,  84, 0,  0,  0,  0,  31, 92, 0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  93, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {27,   0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -20,    0,  28, 29, 30, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  94, 91, 0,  0,  0,  0,  0,  0,  31, 0,  0}, 
 {-28,  0,  0,  0,  -28,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -28,    0,  -28,    -28,    -28,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {-29,  0,  0,  0,  -29,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -29,    0,  -29,    -29,    -29,    -29,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}, 
 {0,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  -21,    0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0}};
    int[] reglas_posiciones = 
    {24, 25, 25, 26, 26, 27, 28, 28, 29, 30, 30, 31, 31, 32, 33, 33, 34, 34, 35, 35, 36, 36, 36, 36, 36, 37, 37, 38, 39, 39, 40, 40, 41, 41, 42, 42, 42, 42, 42, 43, 44, 44, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45};	
    int[] cantidad_desapilar = 
        {1,   0,  2,  1,  1,  4,  0,  3,  6,  0,  3,  0,  4,  3,  0,  2,  1,  1,  0,  2,  4,  6,  5,  3,  2,  0,  2,  3,  0,  1,  0,  2,  0,  3,  1,  1,  1,  1,  1,  4,  1,  1,  3,  2,  2,  3,  3,  3,  3,  3,  3,  1};
    String[] name_reglas= 
    {"programa", "Definiciones", "Definiciones", "Definicion", "Definicion", "DefVar", "ListaVar", "ListaVar", "DefFunc",   "Parametros", "Parametros", "ListaParam", "ListaParam", "BloqFunc", "DefLocales", "DefLocales", "DefLocal", "DefLocal", "Sentencias", "Sentencias", "Sentencia", "Sentencia", "Sentencia", "Sentencia", "Sentencia", "Otro", "Otro", "Bloque", "ValorRegresa", "ValorRegresa", "Argumentos", "Argumentos", "ListaArgumentos", "ListaArgumentos", "Termino", "Termino", "Termino", "Termino", "Termino", "LlamadaFunc", "SentenciaBloque", "SentenciaBloque", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion"};
    // inicializacion del sintactico
    sintactico(ArrayList<token> tokens){
        this.tokens =tokens;
        //this.pila.push(new token(23,  "$",    "$"));
        this.pila.add(new elementoPila("$",2));
        this.pila.add(new elementoPila("0",0));

    }
    public nodo analizar(){
        int fila,    columna,    accion = 0;
        int tam = this.tokens.size();
        int cont = 0;
        int acum = 0;
        boolean continuar=true;
        while(continuar){
            elementoPila temp = new elementoPila();
            temp =  this.pila.get(this.pila.size()-1);
            fila = temp.codigo;
            
            if (cont==tam) {
                columna=23;//donde se encuentra el fin de la entrada
            }else{
                columna = this.tokens.get(cont).numero;
            }
            accion=gramatica[fila][columna];
            
            System.out.println("------Vuelta "+(acum)+"-------");
            System.out.println("fila "+fila+" columna "+columna);
            //------------------------------------------------------------------ evalua acciones
            if (accion<0) {
                System.out.println("Reduccion");
            }else if(accion>0){
                System.out.println("Entrada: "+this.tokens.get(cont).simbolo);
            }else{
                System.out.println("Sin accion");
            }
            //System.out.println("accion: "+accion);
            //------------------------------------------------------------------ desplazamientos
            if (accion>0) {
                this.pila.add(new elementoPila(this.tokens.get(cont).simbolo,this.tokens.get(cont).numero));
                this.pila.add(new elementoPila("d"+accion,accion));
                cont++;
            //------------------------------------------------------------------ reducciones
            }else if(accion<0){
                // estado de aceptacion
                if (accion==-1) {
                    System.out.println("Aceptado");
                    continuar=false;
                    this.pila.remove(this.pila.size()-1);
                    this.pila.remove(this.pila.size()-1);
                    
                // todas las demas reglas
                }else{
                    // obtener numero de regla
                    int regla = Math.abs(accion)-2;
                    System.out.println("regla "+(regla+1));
                    // obtener posicion de la regla
                    int posicion_regla = this.reglas_posiciones[regla];
                    
                    System.out.println("posicion regla "+posicion_regla );
                    // obtener cantidad a desapilar
                    int cantidad_desapilar = (this.cantidad_desapilar[regla])*2;
                    System.out.println("cantidad desapilar "+cantidad_desapilar);
                    this.valoresArbol.clear();
                    for (int desapila = 0; desapila < cantidad_desapilar; desapila++) {
                        this.pila.remove(this.pila.size()-1);
                        this.valoresArbol.add(this.pila.get(this.pila.size()-1).getValor());
                        this.pila.remove(this.pila.size()-1);
                        desapila++;
                    }
                    
                    
                    int valor_regla = this.gramatica[this.pila.get(this.pila.size()-1).codigo][posicion_regla];
                    System.out.println("x:"+this.pila.get(this.pila.size()-1).codigo+" y:"+posicion_regla);
                    System.out.println("Valor casilla: "+valor_regla);
                    crearNodo(regla);
                    
                    this.pila.add(new elementoPila(this.name_reglas[regla],regla));
                    this.pila.add(new elementoPila(""+valor_regla,valor_regla));
                }
                System.out.println("");
                
            }else{
                continuar=false;
            
            }
            System.out.println("Pila");
            for (elementoPila item : this.pila) {
                System.out.print(item.valor+", ");
            }
            System.out.println("");
            
                    acum++;
            
            
           
        }
        /*if (this.programa!=null) {
            this.programa.muestra();
        }*/
        

        
        return programa;
    }
    public void crearNodo( int regla_num){
        System.out.println("pila de datos "+this.valoresArbol);
        System.out.println("regla nodos "+ regla_num);
        int valor = 0;
        switch(regla_num){
            case 0:
                //creacion de regla
                regla1 temporal1 = new regla1(this.nodosArbol, this.valoresArbol);
                //apilamos regla a pila
                //this.nodosArbol.add(temporal1);
                //referencia a inicio de arbol
                this.programa= temporal1;
                /*System.out.println("---raiz---");
                System.out.println(this.raiz);*/
                break;
            case 1:
                //creacion y apilacion regla vacia
                regla2 temporal2 = new regla2(this.nodosArbol, this.valoresArbol);
                //apilamos regla a pila
                this.nodosArbol.add(temporal2);
                break;
            case 2:
                //creacion regla
                regla3 temporal3 = new regla3(this.nodosArbol, this.valoresArbol);
                //apilamos regla a pila
                this.nodosArbol.add(temporal3);
                break;
            case 3:
                //creacion de regla
                regla4 temporal4 = new regla4(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal4);
                break;
            case 4:
                //creacion de regla
                regla5 temporal5 = new regla5(this.nodosArbol, this.valoresArbol);
                //apilamos regla a pila
                this.nodosArbol.add(temporal5);
                break;
            case 5:
                //creacion de regla
                regla6 temporal6  = new regla6(this.nodosArbol, this.valoresArbol);
                 //apilamos regla a pila
                this.nodosArbol.add(temporal6);
                break;
            case 6:
                //creacion y apilacion de regla vacia
                regla7 temporal7  = new regla7(this.nodosArbol, this.valoresArbol);
                //apilamos regla a pila
                this.nodosArbol.add(temporal7);
                break;
            case 7:
                //creacion de regla
                regla8 temporal8 = new regla8(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal8);
                break;
            case 8:
                //creacion de regla
                regla9 temporal9 = new regla9(this.nodosArbol, this.valoresArbol);
                 //apilamos regla a pila
                this.nodosArbol.add(temporal9);
                
                break;
            case 9: 
                //creacion de regla
                regla10 temporal10 = new regla10(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal10);
                break;
            case 10:
                //creacion de regla
                regla11 temporal11= new regla11(this.nodosArbol, this.valoresArbol);
                 //apilamos regla a pila
                this.nodosArbol.add(temporal11);
                
                break;
            case 11:
                //creacion de regla y apilamos vacia
                regla12 temporal12 = new regla12(this.nodosArbol, this.valoresArbol);
                //apilamos regla a pila
                this.nodosArbol.add(temporal12);
                break;
            case 12:
                //creacion de regla
                regla13 temporal13 = new regla13(this.nodosArbol, this.valoresArbol);
                //apilamos regla a pila
                this.nodosArbol.add(temporal13);
                break;
            case 13:
                //creacion de regla
                regla14 temporal14 = new regla14(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal14);
                break;
            case 14:
                //creacion de regla y apilamos regla vacia
                regla15 temporal15 = new regla15(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal15);
                break;
            case 15:
                //creacion de regla
                regla16 temporal16 = new regla16(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal16);
                
                break;
            case 16:
                regla17 temporal17 = new regla17(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal17);
                break;
            case 17:
                //creacion de regla
                regla18 temporal18 = new regla18(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal18);
                break;
            case 18:
                //creacion de regla
                regla19 temporal19 = new regla19(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal19);
                break;
            case 19:
                //creacion de regla
                regla20 temporal20 = new regla20(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal20);
                break;
            case 20:
                //creacion de regla
                regla21 temporal21 = new regla21(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal21);
                break;
            case 21:
                //creacion de regla
                regla22 temporal22 = new regla22(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal22);
                break;
            case 22:
                //creacion de regla
                regla23 temporal23 = new regla23(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal23);
                break;
            case 23:
                //creacion de regla
                regla24 temporal24 = new regla24(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal24);
                break;
            case 24:
                //creacion de regla
                regla25 temporal25 = new regla25(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal25);
                break;
            case 25:
                //creacion de regla
                regla26 temporal26 = new regla26(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal26);
                break;
            case 26:
                //creacion de regla
                regla27 temporal27 = new regla27(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal27);
                break;
            case 27:
                //creacion de regla
                regla28 temporal28 = new regla28(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal28);
                break;
            case 28:
                //creacion de regla
                regla29 temporal29 = new regla29(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal29);
                break;
            case 29:
                //creacion de regla
                regla30 temporal30 = new regla30(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal30);
                break;
            case 30:
                //creacion de regla
                regla31 temporal31 = new regla31(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal31);
                break;
            case 31:
                //creacion de regla
                regla32 temporal32 = new regla32(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal32);
                break;
            case 32:
                //creacion de regla
                regla33 temporal33 = new regla33(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal33);
                break;
            case 33:
                //creacion de regla
                regla34 temporal34 = new regla34(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal34);
                break;
            case 34:
                //creacion de regla
                regla35 temporal35 = new regla35(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal35);
                break;
            case 35:
                //creacion de regla
                regla36 temporal36 = new regla36(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal36);
                break;
            case 36:
                //creacion de regla
                regla37 temporal37 = new regla37(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal37);
                break;
            case 37:
                //creacion de regla
                regla38 temporal38 = new regla38(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal38);
                break;
            case 38:
                //creacion de regla
                regla39 temporal39 = new regla39(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal39);
                break;
            case 39:
                //creacion de regla
                regla40 temporal40 = new regla40(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal40);
                break;
            case 40:
                //creacion de regla
                regla41 temporal41 = new regla41(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal41);
                break;
            case 41:
                //creacion de regla
                regla42 temporal42 = new regla42(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal42);
                break;
            case 42:
                //creacion de regla
                regla43 temporal43 = new regla43(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal43);
                break;
            case 43:
                //creacion de regla
                regla44 temporal44 = new regla44(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal44);
                break;
            case 44:
                //creacion de regla
                regla45 temporal45 = new regla45(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal45);
                break;
            case 45:
                //creacion de regla
                regla46 temporal46 = new regla46(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal46);
                break;
            case 46:
                //creacion de regla
                regla47 temporal47 = new regla47(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal47);
                break;
            case 47:
                //creacion de regla
                regla48 temporal48 = new regla48(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal48);
                break;
            case 48:
                //creacion de regla
                regla49 temporal49 = new regla49(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal49);
                break;
            case 49:
                //creacion de regla
                regla50 temporal50 = new regla50(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal50);
                break;
            case 50:
                //creacion de regla
                regla51 temporal51 = new regla51(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal51);
                break;
            case 51:
                //creacion de regla
                regla52 temporal52 = new regla52(this.nodosArbol, this.valoresArbol);
                //apilamos regla
                this.nodosArbol.add(temporal52);
                break;
            default:
        }
        
        /*for (int i = 0; i <this.nodosArbol.size(); i++) {
            this.nodosArbol.get(i).muestra();
            System.out.println("------------------------------NODOS-----------------");
        }*/
    }            
}
