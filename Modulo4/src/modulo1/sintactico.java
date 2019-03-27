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
    ArrayList<elementoPila> arbolSintactico = new ArrayList<elementoPila>();
    ArrayList<nodo> pilaNodos = new ArrayList<nodo>();
    nodo raiz = new nodo();
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
        {24, 25, 25, 26, 26, 27, 28, 28, 29, 30, 30, 31, 31, 32, 33, 33, 34, 34, 35, 35, 35, 36, 36, 36, 36, 36, 37, 37, 38, 39, 39, 40, 40, 41, 41, 42, 42, 42, 42, 42, 43, 44, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45};
    int[] cantidad_desapilar = 
        {1,   0,  2,  1,  1,  4,  0,  3,  6,  0,  3,  0,  4,  3,  0,  2,  1,  1,  0,  2,  4,  6,  5,  3,  2,  0,  2,  3,  0,  1,  0,  2,  0,  3,  1,  1,  1,  1,  1,  4,  1,  1,  3,  2,  2,  3,  3,  3,  3,  3,  3,  1};
    String[] name_reglas= 
    {"programa", "Definiciones", "Definiciones", "Definicion", "Definicion", "DefVar", "ListaVar", "ListaVar", "DefFunc",   "Parametros", "Parametros", "ListaParam", "ListaParam", "BloqFunc", "DefLocales", "DefLocales", "DefLocal", "DefLocal", "Sentencias", "Sentencias", "Sentencia", "Sentencia", "Sentencia", "Sentencia", "Sentencia", "Otro", "Otro", "Bloque", "ValorRegresa", "ValorRegresa", "Argumentos", "Argumentos", "ListaArgumentos", "ListaArgumentos", "Termino", "Termino", "Termino", "Termino", "Termino", "LlamadaFunc", "SentenciaBloque", "SentenciaBloque", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion", "Expresion"};
    sintactico(ArrayList<token> tokens){
        this.tokens =tokens;
        //this.pila.push(new token(23,  "$",    "$"));
        this.pila.add(new elementoPila("$",2));
        this.pila.add(new elementoPila("0",0));
        
        /*this.pila.push(1);
        this.pila.push("gola");
        this.pila.push(tokens.get(0).simbolo);
        while(!pila.empty()){
            System.out.println(pila.pop());
        }*/
        //System.out.println(this.pila.size());
    }
    public String analizar(){
        int fila,    columna,    accion = 0;
        int tam = this.tokens.size();
        int cont = 0;
        int acum = 0;
        boolean continuar=true;
        while(continuar){
            elementoPila temp = this.pila.get(this.pila.size()-1);
            fila = temp.valorNum;
            
            if (cont==tam) {
                columna=23;//donde se encuentra el fin de la entrada
            }else{
                columna = this.tokens.get(cont).numero;
            }
            accion=gramatica[fila][columna];
            
            System.out.println("------Vuelta "+(acum)+"-------");
            System.out.println("fila "+fila+" columna "+columna);
            if (accion<0) {
                System.out.println("Reduccion");
            }else if(accion>0){
                System.out.println("Entrada: "+this.tokens.get(cont).simbolo);
            }else{
                System.out.println("Sin accion");
            }
            System.out.println("accion: "+accion);
            if (accion>0) {
                this.pila.add(new elementoPila(this.tokens.get(cont).simbolo,this.tokens.get(cont).numero));
                this.pila.add(new elementoPila("d"+accion,accion));
                cont++;
            }else if(accion<0){
                if (accion==-1) {
                    System.out.println("Aceptado");
                    continuar=false;
                    this.pila.remove(this.pila.size()-1);
                    elementoPila guardar =new elementoPila();
                    guardar = this.pila.get(this.pila.size()-1);
                    this.arbolSintactico.add(guardar);
                    this.pila.remove(this.pila.size()-1);
                    preOrden(this.raiz);
                }else{
                    int regla = Math.abs(accion)-2;
                    //System.out.println("Crear nodo"+regla);
                    crearNodo(regla);
                    System.out.println("regla "+(regla+1));
                    int posicion_regla = this.reglas_posiciones[regla];
                    //System.out.println("posicion regla "+posicion_regla );
                    int cantidad_desapilar = (this.cantidad_desapilar[regla])*2;
                    System.out.println("cantidad desapilar "+cantidad_desapilar);
                    elementoPila guardar =new elementoPila();
                    for (int desapila = 0; desapila < cantidad_desapilar; desapila++) {
                        this.pila.remove(this.pila.size()-1);
                        guardar = this.pila.get(this.pila.size()-1);
                        this.arbolSintactico.add(guardar);
                        this.pila.remove(this.pila.size()-1);
                        
                        desapila++;
                    }
                    int valor_regla =this.gramatica[this.pila.get(this.pila.size()-1).valorNum][posicion_regla];
                    System.out.println("valor_regla "+valor_regla);
                    this.pila.add(new elementoPila(this.name_reglas[regla],regla));
                    this.pila.add(new elementoPila(""+valor_regla,valor_regla));
                }
                System.out.println("");
                
            }else{
                continuar=false;
            
            }
            System.out.println("Pila");
            for (elementoPila item : this.pila) {
                System.out.print(item.valorCar+", ");
            }
            System.out.println("");
            acum++;
            
            
           
        }
        /*System.out.println("elementos del programa");
        for (int i = this.arbolSintactico.size()-1; i > 0; i--) {
            System.out.print(this.arbolSintactico.get(i).valorCar+",");
        }*/
        

        
        return "";
    }
    public void crearNodo( int regla){
        System.out.println("regla nodos "+ regla);
        switch(regla){
            case 0:
                regla1 temporal1 = new regla1();
                this.raiz.regla= temporal1;
                this.raiz.izq = this.pilaNodos.get(this.pilaNodos.size()-1);
                this.raiz.der = null;
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                System.out.println("---raiz---");
                System.out.println(this.raiz.izq.getRegla().getTipo());
                //System.out.println(this.raiz.der.getRegla().getTipo());
 //               System.out.println("regla del  "+this.raiz.getRegla().getTipo());
                break;
            case 1:
                regla2 temporal2 = new regla2();
                nodo temp2 = new nodo();
                temp2.regla = temporal2;
                temp2.izq=null;
                temp2.der = null;
                this.pilaNodos.add(temp2);
                System.out.println("regla del nodo "+temp2.getRegla().getTipo());
                break;
            case 2:
                regla3 temporal3 = new regla3();
                nodo temp3 = new nodo();
                temp3.regla = temporal3;
                temp3.izq=this.pilaNodos.get(this.pilaNodos.size()-1);
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                temp3.der =this.pilaNodos.get(this.pilaNodos.size()-1); 
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                this.pilaNodos.add(temp3);
                break;
            case 3:
                break;
            case 4:
                regla5 temporal5 = new regla5();
                nodo temp5 = new nodo();
                temp5.regla = temporal5;
                temp5.izq=this.pilaNodos.get(this.pilaNodos.size()-1);
                temp5.der = null;
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                this.pilaNodos.add(temp5);
                break;
            case 5:
                regla6 temporal6  = new regla6();
                nodo temp6 = new nodo();
                temp6.regla = temporal6;
                temp6.izq =this.pilaNodos.get(this.pilaNodos.size()-1);
                temp6.der=null;
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                this.pilaNodos.add(temp6);
                break;
            case 6:
                regla7 temporal7  = new regla7();
                nodo temp7 = new nodo();
                temp7.regla = temporal7;
                temp7.izq= null;
                temp7.der=null;
                this.pilaNodos.add(temp7);
                break;
            case 7:
                break;
            case 8:
                regla9 temporal9 = new regla9();
                nodo temp9 = new nodo();
                temp9.regla=temporal9;
                temp9.izq=this.pilaNodos.get(this.pilaNodos.size()-1);
                System.out.println("nodo 9 izq "+temp9.izq.getRegla().getTipo());
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                temp9.der = this.pilaNodos.get(this.pilaNodos.size()-1);
                System.out.println("nodo 9 der "+temp9.der.getRegla().getTipo());
                
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                this.pilaNodos.add(temp9);
                
                break;
            case 9: 
                break;
            case 10:
                regla11 temporal11= new regla11();
                nodo temp11 = new nodo();
                temp11.regla = temporal11;
                temp11.izq = this.pilaNodos.get(this.pilaNodos.size()-1);
                temp11.der = null;
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                this.pilaNodos.add(temp11);
                
                break;
            case 11:
                regla12 temporal12 = new regla12();
                nodo temp12 = new nodo();
                temp12.regla = temporal12;
                temp12.izq = null;
                temp12.der=null;
                this.pilaNodos.add(temp12);
                break;
            case 12:
                regla13 temporal13 = new regla13();
                nodo temp13 = new nodo();
                temp13.regla=temporal13;
                temp13.izq=this.pilaNodos.get(this.pilaNodos.size()-1);
                temp13.der = null;
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                this.pilaNodos.add(temp13);
                break;
            case 13:
                regla14 temporal14 = new regla14();
                nodo temp14 = new nodo();
                temp14.regla=temporal14;
                temp14.izq=this.pilaNodos.get(this.pilaNodos.size()-1);
                temp14.der = null;
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                this.pilaNodos.add(temp14);
                break;
            case 14:
                regla15 temporal15 = new regla15();
                nodo temp15 = new nodo();
                temp15.regla = temporal15;
                temp15.izq = null;
                temp15.der=null;
                this.pilaNodos.add(temp15);
                break;
            case 15:
                regla16 temporal16 = new regla16();
                nodo temp16 = new nodo();
                temp16.regla=temporal16;
                temp16.izq=this.pilaNodos.get(this.pilaNodos.size()-1);
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                temp16.der = this.pilaNodos.get(this.pilaNodos.size()-1);
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                this.pilaNodos.add(temp16);
                temporal16=null;
                temp16=null;
                
                break;
            case 16:
                regla17 temporal17 = new regla17();
                nodo temp17 = new nodo();
                temp17.regla=temporal17;
                temp17.izq=this.pilaNodos.get(this.pilaNodos.size()-1);
                temp17.der = null;
                this.pilaNodos.remove(this.pilaNodos.size()-1);
                this.pilaNodos.add(temp17);
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 21:
                break;
            case 22:
                break;
            case 23:
                break;
            case 24:
                break;
            case 25:
                break;
            case 26:
                break;
            case 27:
                break;
            case 28:
                break;
            case 29:
                break;
            case 30:
                break;
            case 31:
                break;
            case 32:
                break;
            case 33:
                break;
            case 34:
                break;
            case 35:
                break;
            case 36:
                break;
            case 37:
                break;
            case 38:
                break;
            case 39:
                break;
            case 40:
                break;
            case 41:
                break;
            case 42:
                break;
            case 43:
                break;
            case 44:
                break;
            case 45:
                break;
            case 46:
                break;
            case 47:
                break;
            case 48:
                break;
            case 49:
                break;
            case 50:
                break;
            case 51:
                break;
            case 52:
                break;
            default:
        }
    }
    
          //Metodo Preorden
  public static void preOrden(nodo raiz) {
    if (raiz != null) {
      System.out.println(raiz.getRegla().getTipo() + " - ");
      System.out.print("izq ");preOrden(raiz.getNodoIzquierdo());
      System.out.print("der ");preOrden(raiz.getNodoDerecho());
    }else{
        System.out.println("null -");
    }
  }
 
      //Metodo Inorden
  public static void inOrden(nodo raiz) {
    if (raiz != null) {
      inOrden(raiz.getNodoIzquierdo());
      System.out.print(raiz.getRegla().getTipo()+ " - ");
      inOrden(raiz.getNodoDerecho());
    }
  }
 
  //Metodo PostOrden
  public static void posOrden(nodo raiz) {
    if (raiz != null) {
      posOrden(raiz.getNodoIzquierdo());
      posOrden(raiz.getNodoDerecho());
      System.out.print(raiz.getRegla().getTipo()+ " - ");
    }
  }
            
}
