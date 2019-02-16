package modulo1;

import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class analizadorLexico {
    String texto_analizar;
    ArrayList<token> respuesta = new ArrayList<token>();
    String valor_analizado="";
    analizadorLexico(String cadena){
        this.texto_analizar = cadena;
    }
    
    public ArrayList analizar(){
        int longitud = this.texto_analizar.length();
        //System.out.println(longitud);
        int indice = 0;
        int estado = 0;
        //char[] cadena2 = this.texto_analizar.toCharArray();
        
        while(indice<this.texto_analizar.length()){
            this.valor_analizado+=this.texto_analizar.charAt(indice);
            switch(estado){
                case 0:
                    //--------------------------------------ESCAPAR LOS ESPACIOS
                    if(this.texto_analizar.charAt(indice)==' '||this.texto_analizar.charAt(indice)=='\t'||this.texto_analizar.charAt(indice)=='\n'){
                        indice++;
                    //---------------------------------------ANALIZA ENTEROS
                    }else if (Character.isDigit(this.texto_analizar.charAt(indice))) {
                        estado = 1;      
                        indice++;
                        finCadena(indice,longitud, 1, "entero", this.valor_analizado);
                    //---------------------------------------ANALIZA CADENAS
                    }else if(this.texto_analizar.charAt(indice)=='"'){
                        estado = 2;
                        indice++;
                        finCadena(indice, longitud, -1,"invalido",this.valor_analizado);
                    //---------------------------------------ANALIZA PALABRAS RESERVADAS
                    }else if(this.texto_analizar.charAt(indice)=='i'){
                        estado = 10;
                        indice++;
                        finCadena(indice,longitud, 0, "identificador",this.valor_analizado);
                    }else if(this.texto_analizar.charAt(indice)=='w'){
                        estado = 11;
                        indice++;
                        finCadena(indice,longitud, 0, "identificador",this.valor_analizado);
                    }else if(this.texto_analizar.charAt(indice)=='r'){
                        estado = 12;
                        indice++;
                        finCadena(indice,longitud, 0,"identificador",this.valor_analizado);
                    }else if(this.texto_analizar.charAt(indice)=='e'){
                        estado = 13;
                        indice++;
                        finCadena(indice,longitud, 0,"identificador",this.valor_analizado);
                    }else if(this.texto_analizar.charAt(indice)=='f'){
                        estado = 14;
                        indice++;
                        finCadena(indice,longitud, 0,"identificador",this.valor_analizado);
                    }else if(this.texto_analizar.charAt(indice)=='v'){
                        estado = 15;
                        indice++;
                        finCadena(indice,longitud, 0,"identificador",this.valor_analizado);
                    //---------------------------------------ANALIZA IDENTIFICADOR
                    }else if(Character.isLetter(this.texto_analizar.charAt(indice))){
                        estado = 4;
                        indice++;
                        finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                    //------------------------------------------ANALIZA OPERADOR SUMA
                    }else if(this.texto_analizar.charAt(indice)=='+'){
                        indice++;
                        this.respuesta.add(new token(5, "opSuma","+"));
                        this.valor_analizado="";
                    //---------------------------------------ANALIZA OPERADOR RESTA
                    }else if(this.texto_analizar.charAt(indice)=='-'){    
                        indice++;
                        this.respuesta.add(new token(5, "opSuma","-"));
                        this.valor_analizado="";
                    //---------------------------------------ANALIZA OPERADOR MULTIPLICACION
                    }else if(this.texto_analizar.charAt(indice)=='*'){
                        indice++;
                        this.respuesta.add(new token(6, "opMul","*"));  
                        this.valor_analizado="";
                    //---------------------------------------ANALIZA OPERADOR DIVISION
                    }else if(this.texto_analizar.charAt(indice)=='/'){
                        indice++;
                        this.respuesta.add(new token(6, "opMul","/"));  
                        this.valor_analizado="";
                    //----------------------------------------ANALIZA IGUAL
                    }else if(this.texto_analizar.charAt(indice)=='='){
                        indice++;
                        estado = 5;
                        finCadena(indice, longitud, 18,"operador asignacion","=");
                    //----------------------------------------ANALIZA MENOR QUE
                    }else if(this.texto_analizar.charAt(indice)=='<'){
                        indice++;
                        estado = 6;
                        finCadena(indice, longitud, 7,"operador relacional","<");
                    //----------------------------------------ANALIZA MAYOR QUE
                    }else if(this.texto_analizar.charAt(indice)=='>'){
                        indice++;
                        estado = 7;
                        finCadena(indice, longitud, 7,"operador relacional",">");
                    //----------------------------------------ANALIZA AND
                    }else if(this.texto_analizar.charAt(indice)=='&'){
                        indice++;
                        estado = 8;
                       finCadena(indice, longitud, -1,"invalido","&");
                    //----------------------------------------ANALIZA OR
                    }else if(this.texto_analizar.charAt(indice)=='|'){
                        estado = 9;
                        indice++;
                        finCadena(indice, longitud, -1,"invalido","|");
                    //----------------------------------------ANALIZA NOT
                    }else if(this.texto_analizar.charAt(indice)=='!'){
                        indice++;
                        if (indice<longitud) {
                            if (this.texto_analizar.charAt(indice)=='=') {
                                indice++;
                                this.respuesta.add(new token(11,"opIgualdad","!="));
                            }else{
                                this.respuesta.add(new token(10,"not","!"));
                                estado=0;
                            }
                        }else{
                            this.respuesta.add(new token(10,"not","!"));
                        }
                        this.valor_analizado="";
                    //----------------------------------------ANALIZA PARENTESIS
                    }else if(this.texto_analizar.charAt(indice)=='('){
                        indice++;
                        this.respuesta.add(new token(14,"(","("));
                        this.valor_analizado="";
                    }else if(this.texto_analizar.charAt(indice)==')'){
                        indice++;
                        this.respuesta.add(new token(15,")",")"));
                        this.valor_analizado="";
                    }
                    //----------------------------------------ANALIZA LLAVES
                    else if(this.texto_analizar.charAt(indice)=='{'){
                        indice++;
                        this.respuesta.add(new token(16,"{","{"));
                        this.valor_analizado="";
                    }else if(this.texto_analizar.charAt(indice)=='}'){
                        indice++;
                        this.respuesta.add(new token(17,"}","}"));
                        this.valor_analizado="";
                    }
                    //----------------------------------------ANALIZA PUNTO Y COMA
                    else if(this.texto_analizar.charAt(indice)==';'){
                        indice++;
                        this.respuesta.add(new token(12,";",";"));
                        this.valor_analizado="";
                    }
                    //----------------------------------------ANALIZA COMA
                    else if(this.texto_analizar.charAt(indice)==','){
                        indice++;
                        this.respuesta.add(new token(13,",",","));
                        this.valor_analizado="";
                    //----------------------------------------ANALIZA $
                    }else if(this.texto_analizar.charAt(indice)=='$'){
                        indice++;
                        this.respuesta.add(new token(23,"$","$"));
                        this.valor_analizado="";
                    }else{
                        estado = 404;
                        this.valor_analizado="";
                    }
                    break;
                case 1:
                    
                    if (Character.isDigit(this.texto_analizar.charAt(indice))) {
                        estado=1;
                        indice++;
                        finCadena(indice, longitud, 1,"entero",this.valor_analizado);
                    }else if(this.texto_analizar.charAt(indice)=='.'){
                        if ((indice+1) == longitud) {
                            estado = 0;
                            this.valor_analizado=this.valor_analizado.substring(0, this.valor_analizado.length() - 1);
                            this.respuesta.add(new token(1,"entero",this.valor_analizado));
                            this.valor_analizado="";
                        }else{
                            estado = 3;
                            indice++;
                        }
                    }else{
                        estado = 0;
                        String temp=this.valor_analizado.substring(0, this.valor_analizado.length() - 1);
                        this.respuesta.add(new token(1,"entero",temp));
                        this.valor_analizado="";
                    }
                    break;
                        
                case 2:
                    if (this.texto_analizar.charAt(indice)=='"') {
                        estado=0;
                        indice++;
                        this.respuesta.add(new token(3,"cadena",this.valor_analizado));
                        this.valor_analizado="";
                    }else{
                        estado=2;
                        indice++;
                        finCadena(indice, longitud, 3,"cadena",this.valor_analizado);
                    }
                    break;
                case 3:
                    if (Character.isDigit(this.texto_analizar.charAt(indice))) {
                        estado=3;
                        indice++;
                        finCadena(indice, longitud, 2,"real",this.valor_analizado);
                    }else{
                        if(this.texto_analizar.charAt(indice-1)=='.'){
                            String temp=this.valor_analizado.substring(0, this.valor_analizado.length() - 2);
                            this.respuesta.add(new token(1,"entero",temp));
                            this.valor_analizado=this.valor_analizado.substring(temp.length(), this.valor_analizado.length() - 1);
                            indice--;
                        }else{
                             this.valor_analizado=this.valor_analizado.substring(0, this.valor_analizado.length() - 1);
                            this.respuesta.add(new token(2,"real",this.valor_analizado));
                            this.valor_analizado="";
                        }
                        estado=0;
                    }
                    break;
                case 4:
                    if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                        estado=4;
                        indice++;
                        finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                        //this.valor_analizado="";
                    }else{
                        this.valor_analizado=this.valor_analizado.substring(0, this.valor_analizado.length() - 1);
                        this.respuesta.add(new token(0,"identificador",this.valor_analizado));
                        this.valor_analizado="";
                        estado=0;
                    }
                    break;
                case 5:
                    if (this.texto_analizar.charAt(indice)=='=') {
                        indice++;
                        this.respuesta.add(new token(11,"opIgualdad",this.valor_analizado));
                        this.valor_analizado="";
                    }else{
                        this.valor_analizado="=";
                        this.respuesta.add(new token(18,"=",this.valor_analizado));
                        this.valor_analizado="";
                    }
                    estado = 0;
                    break;
                case 6:
                    if (this.texto_analizar.charAt(indice)=='=') {     
                        indice++;
                        this.respuesta.add(new token(7,"opRelac",this.valor_analizado));
                    }else{
                        this.valor_analizado="<";
                        this.respuesta.add(new token(7,"opRelac",this.valor_analizado));
                        
                        
                    }
                    this.valor_analizado="";
                    estado=0;
                    break;
                case 7:
                    if (this.texto_analizar.charAt(indice)=='=') {
                        indice++;
                        this.respuesta.add(new token(7,"opRelac",this.valor_analizado));
                    }else{
                        this.valor_analizado=""+this.texto_analizar.charAt(indice-1);
                        this.respuesta.add(new token(7,"opRelac",this.valor_analizado));
                    }
                    this.valor_analizado="";
                    estado = 0;
                    break;
                case 8:
                    if (this.texto_analizar.charAt(indice)=='&') {
                        indice++;
                        this.respuesta.add(new token(9,"opAnd",this.valor_analizado));
                        this.valor_analizado="";
                    }else{
                        this.valor_analizado=""+this.texto_analizar.charAt(indice-1);
                        this.respuesta.add(new token(-1,"invalido",this.valor_analizado));
                        this.valor_analizado="";
                    }
                    
                    estado=0;
                    break;
                case 9:
                    if (this.texto_analizar.charAt(indice)=='|') {
                        indice++;
                        this.respuesta.add(new token(8,"opOr",this.valor_analizado));
                    }else{
                        this.valor_analizado=""+this.texto_analizar.charAt(indice-1);
                        this.respuesta.add(new token(-1,"invalido",this.valor_analizado));
                    }
                    this.valor_analizado="";
                    
                    estado=0;
                    break;
                case 10:
                    if (this.texto_analizar.charAt(indice)=='f') {
                        indice++;
                        if (indice<longitud) {
                             if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                                estado=4;
                            }else{
                                this.respuesta.add(new token(19,"if",this.valor_analizado));
                                this.valor_analizado="";
                                estado = 0;
                            }
                        }else{
                                this.respuesta.add(new token(19,"if",this.valor_analizado));
                                this.valor_analizado="";
                                estado = 0;
                        }
                       
                        
                        
//                        this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }else if(this.texto_analizar.charAt(indice)=='n'){
                        indice++;
                        
                        finCadena(indice, longitud, 0, "identificador",this.valor_analizado);
                        if (indice<longitud) {   
                            if (this.texto_analizar.charAt(indice)=='t') {
                                this.valor_analizado+=this.texto_analizar.charAt(indice);
                                indice++;
                                if (indice<longitud) {
                                    if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                                        estado=4;
                                    }else{
                                        this.respuesta.add(new token(4,"tipo",this.valor_analizado));
                                        this.valor_analizado="";
                                        estado=0; 
                                    }
                                }else{
                                    this.respuesta.add(new token(4,"tipo",this.valor_analizado));
                                    this.valor_analizado="";
                                    estado=0;

                                }
                                
                            }else{
                                estado = 4;
                                //this.valor_analizado=this.valor_analizado.substring(0, this.valor_analizado.length()-1);
                            }
                        }else{
                            finCadena(indice,longitud, 0,"identificador",this.valor_analizado);
                        }
                    }else{
                        estado=4;
                        //this.valor_analizado=this.valor_analizado.substring(0, this.valor_analizado.length()-1);
                        //this.respuesta = finCadena(indice, longitud, this.respuesta,"identificador\n");
                    }
                    break;
                case 11:
                    if (this.texto_analizar.charAt(indice)=='h') {
                        indice++;
                        finCadena(indice,longitud, 0,"identificador",this.valor_analizado);
                        if (indice<longitud) {
                            if (this.texto_analizar.charAt(indice)=='i') {
                                this.valor_analizado+=this.texto_analizar.charAt(indice);
                                indice++;
                                
                                if (indice<longitud) {
                                    if (this.texto_analizar.charAt(indice)=='l') {
                                        this.valor_analizado+=this.texto_analizar.charAt(indice);
                                        indice++;
                                        if (indice<longitud) {
                                            
                                            if (this.texto_analizar.charAt(indice)=='e') {
                                               this.valor_analizado+=this.texto_analizar.charAt(indice);
                                               indice++;
                                                if (indice<longitud) {
                                                    if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                                                        estado=4;

                                                    }else{
                                                        this.respuesta.add(new token(20,"while",this.valor_analizado));
                                                        this.valor_analizado="";
                                                        estado=0;
                                                    }
                                                }else{
                                                    this.respuesta.add(new token(20,"while",this.valor_analizado));
                                                    this.valor_analizado="";
                                                    estado=0;
                                                }
                                                
                                            }else{
                                                //this.respuesta+="identificador\t\t\t\t"+this.valor_analizado+"\n";
                                                //this.valor_analizado="";
                                                estado=4;
                                            }
                                        
                                        }else{
                                            finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                                        
                                        }
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                             finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                        }
                    }else{
                        estado=4;
                        //this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
                case 12:
                    if (this.texto_analizar.charAt(indice)=='e') {
                        indice++;
                        finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                        if (indice<longitud) {
                            if (this.texto_analizar.charAt(indice)=='t') {
                                this.valor_analizado+='t';
                                indice++;
                                if (indice<longitud) {
                                    this.valor_analizado+=this.texto_analizar.charAt(indice);
                                    if (this.texto_analizar.charAt(indice)=='u') {
                                        indice++;
                                        if (indice<longitud) {
                                            
                                            if (this.texto_analizar.charAt(indice)=='r') {
                                                this.valor_analizado+=this.texto_analizar.charAt(indice);
                                               indice++;
                                                if (indice<longitud) {
                                                      if (this.texto_analizar.charAt(indice)=='n') {
                                                          this.valor_analizado+=this.texto_analizar.charAt(indice);
                                                          indice++;
                                                          
                                                          if (indice<longitud) {
                                                              if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                                                                estado =4;
                                                            }else{
                                                                  this.respuesta.add(new token(21,"return",this.valor_analizado));
                                                                  this.valor_analizado="";
                                                                  estado=0;
                                                            }
                                                          }else{
                                                              this.respuesta.add(new token(21,"return",this.valor_analizado));
                                                                this.valor_analizado="";
                                                                estado=0;
                                                          }
                                                          
                                                       
                                                    }else{
                                                          estado=4;
                                                      }
                                                }else{
                                                    estado=4;
                                                    finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                                                }
                                            }else{
                                                estado=4;
                                                
                                            }
                                        
                                        }else{
                                            finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                                        
                                        }
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                            finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                        }
                    }else{
                        estado=4;
                        //this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
                case 13:
                    if (this.texto_analizar.charAt(indice)=='l') {
                        indice++;
                        //this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                        if (indice<longitud) {
                            if (this.texto_analizar.charAt(indice)=='s') {
                                this.valor_analizado+=this.texto_analizar.charAt(indice);
                                indice++;
                                if (indice<longitud) {
                                    if (this.texto_analizar.charAt(indice)=='e') {
                                        this.valor_analizado+=this.texto_analizar.charAt(indice);
                                        indice++;
                                        if (indice<longitud) {
                                            if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                                                estado=4;
                                            }else{
                                                this.respuesta.add(new token(22,"else",this.valor_analizado));
                                                this.valor_analizado="";
                                                estado=0;
                                            }
                                        }else{
                                           this.respuesta.add(new token(22,"else",this.valor_analizado));
                                            this.valor_analizado="";
                                            estado=0;
                                        }
                                        
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                   finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                            finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                        }
                    }else{
                        
                        estado=4;
                        //this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
                 case 14:
                    if (this.texto_analizar.charAt(indice)=='l') {
                        indice++;
                        //this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                        if (indice<longitud) {
                            if (this.texto_analizar.charAt(indice)=='o') {
                                this.valor_analizado+=this.texto_analizar.charAt(indice);
                                indice++;
                                if (indice<longitud) {
                                    if (this.texto_analizar.charAt(indice)=='a') {
                                        this.valor_analizado+=this.texto_analizar.charAt(indice);
                                        indice++;
                                        if (indice<longitud) {
                                            
                                            if (this.texto_analizar.charAt(indice)=='t') {
                                               this.valor_analizado+=this.texto_analizar.charAt(indice);
                                               indice++;
                                                if (indice<longitud) {
                                                    if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                                                        estado=4;
                                                    }else{
                                                        this.respuesta.add(new token(4,"tipo",this.valor_analizado));
                                                        this.valor_analizado="";
                                                        estado=0;
                                                    }
                                                }else{
                                                    this.respuesta.add(new token(4,"tipo",this.valor_analizado));
                                                    this.valor_analizado="";

                                                    estado=0;
                                                }
                                               
                                            }else{
                                                estado=4;
                                            }
                                        
                                        }else{
                                            finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                                        
                                        }
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                            finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                        }
                    }else{
                        estado=4;
                        //this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
               case 15:
                    if (this.texto_analizar.charAt(indice)=='o') {
                        //this.valor_analizado+=this.texto_analizar.charAt(indice);
                        indice++;
                        //this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                        if (indice<longitud) {
                            if (this.texto_analizar.charAt(indice)=='i') {
                                this.valor_analizado+=this.texto_analizar.charAt(indice);
                                indice++;
                                if (indice<longitud) {
                                    if (this.texto_analizar.charAt(indice)=='d') {
                                        this.valor_analizado+=this.texto_analizar.charAt(indice);
                                        indice++;
                                        if (indice<longitud) {
                                            if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                                                estado=4;
                                            }else{
                                                this.respuesta.add(new token(4,"tipo",this.valor_analizado));
                                                this.valor_analizado="";
                                                estado=0;
                                            }
                                        }else{
                                            this.respuesta.add(new token(4,"tipo",this.valor_analizado));
                                            this.valor_analizado="";
                                            estado=0;  
                                        }
                                        
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                            finCadena(indice, longitud, 0,"identificador",this.valor_analizado);
                        }
                    }else{
                        
                        estado=4;
                        //this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
                case 404: 
                    estado = 0;
                    this.respuesta.add(new token(-1,"invalido",this.valor_analizado));
                    this.valor_analizado="";
                    indice++;
                    break;
                default:    
            }
            
            
            
                
            
        }
        return this.respuesta;
    }
    public void finCadena(int indice, int longitud, int numero, String simbolo, String valor){
        if (longitud == indice) {
            token temp = new token(numero,simbolo,valor);
            this.respuesta.add(temp);
        }
    }
}
