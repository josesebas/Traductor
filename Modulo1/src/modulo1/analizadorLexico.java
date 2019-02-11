package modulo1;

/**
 *
 * @author Eduardo
 */
public class analizadorLexico {
    String texto_analizar;
    String respuesta="";
    String valor_analizado="";
    analizadorLexico(String cadena){
        this.texto_analizar = cadena;
    }
    public String analizar(){
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
                        this.respuesta= finCadena(indice,longitud, this.respuesta, "entero\t\t\t\t"+this.valor_analizado+"\n");
                    //---------------------------------------ANALIZA CADENAS
                    }else if(this.texto_analizar.charAt(indice)=='"'){
                        estado = 2;
                        indice++;
                        this.respuesta = finCadena(indice, longitud, this.respuesta, "invalido\t\t\t\t"+this.valor_analizado+"\n");
                    //---------------------------------------ANALIZA PALABRAS RESERVADAS
                    }else if(this.texto_analizar.charAt(indice)=='i'){
                        estado = 10;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                    }else if(this.texto_analizar.charAt(indice)=='w'){
                        estado = 11;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                    }else if(this.texto_analizar.charAt(indice)=='r'){
                        estado = 12;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                    }else if(this.texto_analizar.charAt(indice)=='e'){
                        estado = 13;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                    }else if(this.texto_analizar.charAt(indice)=='f'){
                        estado = 14;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                    }else if(this.texto_analizar.charAt(indice)=='v'){
                        estado = 15;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                    //---------------------------------------ANALIZA IDENTIFICADOR
                    }else if(Character.isLetter(this.texto_analizar.charAt(indice))){
                        estado = 4;
                        indice++;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\t\t\t\t"+this.valor_analizado+"\n");
                    //------------------------------------------ANALIZA OPERADOR SUMA
                    }else if(this.texto_analizar.charAt(indice)=='+'){
                        indice++;
                        this.respuesta+="operador adicion\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    //---------------------------------------ANALIZA OPERADOR RESTA
                    }else if(this.texto_analizar.charAt(indice)=='-'){    
                        indice++;
                        this.respuesta+="operador adicion\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    //---------------------------------------ANALIZA OPERADOR MULTIPLICACION
                    }else if(this.texto_analizar.charAt(indice)=='*'){
                        indice++;
                        this.respuesta+="operador multiplicacion *\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    //---------------------------------------ANALIZA OPERADOR DIVISION
                    }else if(this.texto_analizar.charAt(indice)=='/'){
                        indice++;
                        this.respuesta+="operador multiplicacion /\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    //----------------------------------------ANALIZA IGUAL
                    }else if(this.texto_analizar.charAt(indice)=='='){
                        indice++;
                        estado = 5;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "operador asignacion\t\t\t\t"+this.valor_analizado+"\n");
                    //----------------------------------------ANALIZA MENOR QUE
                    }else if(this.texto_analizar.charAt(indice)=='<'){
                        indice++;
                        estado = 6;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "operador relacional < \t\t\t\t"+this.valor_analizado+"\n");
                    //----------------------------------------ANALIZA MAYOR QUE
                    }else if(this.texto_analizar.charAt(indice)=='>'){
                        indice++;
                        estado = 7;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "operador relacional > \t\t\t\t"+this.valor_analizado+"\n");
                    //----------------------------------------ANALIZA AND
                    }else if(this.texto_analizar.charAt(indice)=='&'){
                        indice++;
                        estado = 8;
                        this.respuesta=finCadena(indice,longitud, this.respuesta, "invalido\t\t\t\t"+this.valor_analizado+"\n");
                    //----------------------------------------ANALIZA OR
                    }else if(this.texto_analizar.charAt(indice)=='|'){
                        estado = 9;
                        indice++;
                        this.respuesta=finCadena(indice, longitud, this.respuesta,"invalido\t\t\t\t"+this.valor_analizado+"\n");
                    //----------------------------------------ANALIZA NOT
                    }else if(this.texto_analizar.charAt(indice)=='!'){
                        indice++;
                        this.respuesta+="operador not \t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    //----------------------------------------ANALIZA PARENTESIS
                    }else if(this.texto_analizar.charAt(indice)=='('){
                        indice++;
                        this.respuesta+="parentesis a\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    }else if(this.texto_analizar.charAt(indice)==')'){
                        indice++;
                        this.respuesta+="parentesis b\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    }
                    //----------------------------------------ANALIZA LLAVES
                    else if(this.texto_analizar.charAt(indice)=='{'){
                        indice++;
                        this.respuesta+="llave a\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    }else if(this.texto_analizar.charAt(indice)=='}'){
                        indice++;
                        this.respuesta+="llave b\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    }
                    //----------------------------------------ANALIZA PUNTO Y COMA
                    else if(this.texto_analizar.charAt(indice)==';'){
                        indice++;
                        this.respuesta+="punto y coma\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    //----------------------------------------ANALIZA $
                    }else if(this.texto_analizar.charAt(indice)=='$'){
                        indice++;
                        this.respuesta+="simbolo pesos\t\t\t\t"+this.valor_analizado+"\n";
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
                        this.respuesta = finCadena(indice, longitud, this.respuesta, "entero\t\t\t\t"+this.valor_analizado+"\n");
                    }else if(this.texto_analizar.charAt(indice)=='.'){
                        if ((indice+1) == longitud) {
                            estado = 0;
                            this.valor_analizado=this.valor_analizado.substring(0, this.valor_analizado.length() - 1);
                            this.respuesta+="entero\t\t\t\t"+this.valor_analizado+"\n";
                            this.valor_analizado="";
                        }else{
                            estado = 3;
                            indice++;
                        }
                    }else{
                        estado = 0;
                        String temp=this.valor_analizado.substring(0, this.valor_analizado.length() - 1);
                        this.respuesta+="entero\t\t\t\t"+temp+"\n";
                        this.valor_analizado="";
                    }
                    break;
                        
                case 2:
                    if (this.texto_analizar.charAt(indice)=='"') {
                        estado=0;
                        indice++;
                        this.respuesta +="cadena\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    }else{
                        estado=2;
                        indice++;
                        this.respuesta = finCadena(indice, longitud, this.respuesta,"cadena\t\t\t\t"+this.valor_analizado+"\n");
                    }
                    break;
                case 3:
                    if (Character.isDigit(this.texto_analizar.charAt(indice))) {
                        estado=3;
                        indice++;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "real\t\t\t\t"+this.valor_analizado+"\n");
                    }else{
                        if(this.texto_analizar.charAt(indice-1)=='.'){
                            String temp=this.valor_analizado.substring(0, this.valor_analizado.length() - 2);
                            this.respuesta+="entero\t\t\t\t"+temp+"\n";
                            this.valor_analizado=this.valor_analizado.substring(temp.length(), this.valor_analizado.length() - 1);
                            indice--;
                        }else{
                             this.valor_analizado=this.valor_analizado.substring(0, this.valor_analizado.length() - 1);
                            this.respuesta+="real\t\t\t\t"+this.valor_analizado+"\n";
                            this.valor_analizado="";
                        }
                        estado=0;
                    }
                    break;
                case 4:
                    if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                        estado=4;
                        indice++;
                        this.respuesta = finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                        //this.valor_analizado="";
                    }else{
                        this.valor_analizado=this.valor_analizado.substring(0, this.valor_analizado.length() - 1);
                        this.respuesta +="identificador\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                        estado=0;
                    }
                    break;
                case 5:
                    if (this.texto_analizar.charAt(indice)=='=') {
                        indice++;
                        this.respuesta+="operador relacional ==\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    }else{
                        this.valor_analizado="=";
                        this.respuesta+="operador de asignacion =\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    }
                    estado = 0;
                    break;
                case 6:
                    if (this.texto_analizar.charAt(indice)=='=') {     
                        indice++;
                        this.respuesta +="operador relacional <=\t\t\t\t"+this.valor_analizado+"\n";
                    }else{
                        this.valor_analizado="<";
                        this.respuesta+="operador relacional <\t\t\t\t"+this.valor_analizado+"\n";
                        
                        
                    }
                    this.valor_analizado="";
                    estado=0;
                    break;
                case 7:
                    if (this.texto_analizar.charAt(indice)=='=') {
                        indice++;
                        this.respuesta +="operador relacional >=\t\t\t\t" +this.valor_analizado+"\n";
                    }else{
                        this.valor_analizado=""+this.texto_analizar.charAt(indice-1);
                        this.respuesta += "operador relacional >\t\t\t\t"+this.valor_analizado+"\n";
                    }
                    this.valor_analizado="";
                    estado = 0;
                    break;
                case 8:
                    if (this.texto_analizar.charAt(indice)=='&') {
                        indice++;
                        this.respuesta+="operador and\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    }else{
                        this.valor_analizado=""+this.texto_analizar.charAt(indice-1);
                        this.respuesta+="invalido\t\t\t\t"+this.valor_analizado+"\n";
                        this.valor_analizado="";
                    }
                    
                    estado=0;
                    break;
                case 9:
                    if (this.texto_analizar.charAt(indice)=='|') {
                        indice++;
                        this.respuesta+="operador or\t\t\t\t"+this.valor_analizado+"\n";
                    }else{
                        this.valor_analizado=""+this.texto_analizar.charAt(indice-1);
                        this.respuesta+="invalido\t\t\t\t"+this.valor_analizado+"\n";
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
                                this.respuesta+="palabra reservada if\t\t\t\t"+this.valor_analizado+"\n";
                                this.valor_analizado="";
                                estado = 0;
                            }
                        }else{
                               this.respuesta+="palabra reservada if\t\t\t\t"+this.valor_analizado+"\n";
                                this.valor_analizado="";
                                estado = 0;
                        }
                       
                        
                        
//                        this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }else if(this.texto_analizar.charAt(indice)=='n'){
                        indice++;
                        
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\t\t\t\t"+this.valor_analizado+"\n");
                        if (indice<longitud) {   
                            if (this.texto_analizar.charAt(indice)=='t') {
                                this.valor_analizado+=this.texto_analizar.charAt(indice);
                                indice++;
                                if (indice<longitud) {
                                    if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                                        estado=4;
                                    }else{
                                        this.respuesta+="palabra reservada int \t\t\t\t"+this.valor_analizado+"\n";
                                        this.valor_analizado="";
                                        estado=0; 
                                    }
                                }else{
                                    this.respuesta+="palabra reservada int \t\t\t\t"+this.valor_analizado+"\n";
                                        this.valor_analizado="";
                                        estado=0;

                                }
                                
                            }else{
                                estado = 4;
                                //this.valor_analizado=this.valor_analizado.substring(0, this.valor_analizado.length()-1);
                            }
                        }else{
                            this.respuesta=finCadena(indice,longitud, this.respuesta, "identificador\t\t\t\t"+this.valor_analizado+"\n");
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
                        this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
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
                                                        this.respuesta +="palabra reservada while\t\t\t\t"+this.valor_analizado+"\n";
                                                        this.valor_analizado="";
                                                        estado=0;
                                                    }
                                                }else{
                                                    this.respuesta +="palabra reservada while\t\t\t\t"+this.valor_analizado+"\n";
                                                        this.valor_analizado="";
                                                        estado=0;
                                                }
                                                
                                            }else{
                                                //this.respuesta+="identificador\t\t\t\t"+this.valor_analizado+"\n";
                                                //this.valor_analizado="";
                                                estado=4;
                                            }
                                        
                                        }else{
                                            this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                                        
                                        }
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                             this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                        }
                    }else{
                        estado=4;
                        //this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
                case 12:
                    if (this.texto_analizar.charAt(indice)=='e') {
                        indice++;
                        this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
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
                                                                  this.respuesta +="palabra reservada return\t\t\t\t"+this.valor_analizado+"\n";
                                                                  this.valor_analizado="";
                                                                  estado=0;
                                                            }
                                                          }else{
                                                              this.respuesta +="palabra reservada return\t\t\t\t"+this.valor_analizado+"\n";
                                                                this.valor_analizado="";
                                                                estado=0;
                                                          }
                                                          
                                                       
                                                    }else{
                                                          estado=4;
                                                      }
                                                }else{
                                                    estado=4;
                                                    this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\t\t\t\t"+this.valor_analizado+"\n");
                                                }
                                            }else{
                                                estado=4;
                                                
                                            }
                                        
                                        }else{
                                            this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                                        
                                        }
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                            this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\t\t\t\t"+this.valor_analizado+"\n");
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
                                                this.respuesta +="palabra reservada else\t\t\t\t"+this.valor_analizado+"\n";
                                                this.valor_analizado="";
                                                estado=0;
                                            }
                                        }else{
                                            this.respuesta +="palabra reservada else\t\t\t\t"+this.valor_analizado+"\n";
                                            this.valor_analizado="";
                                            estado=0;
                                        }
                                        
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                            this.respuesta = finCadena(indice, longitud, this.respuesta, "indetificador\t\t\t\t"+this.valor_analizado+"\n");
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
                                                        this.respuesta +="palabra reservada float\t\t\t\t"+this.valor_analizado+"\n";
                                                        this.valor_analizado="";
                                                        estado=0;
                                                    }
                                                }else{
                                                    this.respuesta +="palabra reservada float\t\t\t\t"+this.valor_analizado+"\n";
                                                    this.valor_analizado="";

                                                    estado=0;
                                                }
                                               
                                            }else{
                                                estado=4;
                                            }
                                        
                                        }else{
                                            this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                                        
                                        }
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                            this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\t\t\t\t"+this.valor_analizado+"\n");
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
                                                this.respuesta +="palabra reservada void\t\t\t\t"+this.valor_analizado+"\n";
                                                this.valor_analizado="";
                                                estado=0;
                                            }
                                        }else{
                                            this.respuesta +="palabra reservada void\t\t\t\t"+this.valor_analizado+"\n";
                                            this.valor_analizado="";
                                            estado=0;  
                                        }
                                        
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\t\t\t\t"+this.valor_analizado+"\n");
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                            this.respuesta = finCadena(indice, longitud, this.respuesta, "indetificador\t\t\t\t"+this.valor_analizado+"\n");
                        }
                    }else{
                        
                        estado=4;
                        //this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
                case 404: 
                    estado = 0;
                    respuesta +="invalido\t\t\t\t"+this.valor_analizado+"\n";
                    this.valor_analizado="";
                    indice++;
                    break;
                default:    
            }
            
            
            
                
            
        }
        return this.respuesta;
    }
    public String finCadena(int indice, int longitud, String respuesta, String fin){
        if (longitud == indice) {
            this.valor_analizado="";
            return respuesta+=fin;
        }
            return respuesta;
    }
}
