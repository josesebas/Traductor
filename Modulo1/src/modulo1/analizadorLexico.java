package modulo1;

/**
 *
 * @author Eduardo
 */
public class analizadorLexico {
    String texto_analizar;
    String respuesta="";
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
            
            switch(estado){
                case 0:
                    //--------------------------------------ESCAPAR LOS ESPACIOS
                    if(this.texto_analizar.charAt(indice)==' '||this.texto_analizar.charAt(indice)=='\t'||this.texto_analizar.charAt(indice)=='\n'){
                        indice++;
                    //---------------------------------------ANALIZA ENTEROS
                    }else if (Character.isDigit(this.texto_analizar.charAt(indice))) {
                        estado = 1;      
                        indice++;
                        this.respuesta= finCadena(indice,longitud, this.respuesta, "entero\n");
                    //---------------------------------------ANALIZA CADENAS
                    }else if(this.texto_analizar.charAt(indice)=='"'){
                        estado = 2;
                        indice++;
                        this.respuesta = finCadena(indice, longitud, this.respuesta, "invalido\n");
                    //---------------------------------------ANALIZA PALABRAS RESERVADAS
                    }else if(this.texto_analizar.charAt(indice)=='i'){
                        estado = 10;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\n");
                    }else if(this.texto_analizar.charAt(indice)=='w'){
                        estado = 11;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\n");
                    }else if(this.texto_analizar.charAt(indice)=='r'){
                        estado = 12;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\n");
                    }else if(this.texto_analizar.charAt(indice)=='e'){
                        estado = 13;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\n");
                    }else if(this.texto_analizar.charAt(indice)=='f'){
                        estado = 14;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\n");
                    }else if(this.texto_analizar.charAt(indice)=='v'){
                        estado = 15;
                        indice++;
                        this.respuesta=finCadena(indice,longitud, this.respuesta,"identificador\n");
                    //---------------------------------------ANALIZA IDENTIFICADOR
                    }else if(Character.isLetter(this.texto_analizar.charAt(indice))){
                        estado = 4;
                        indice++;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    //------------------------------------------ANALIZA OPERADOR SUMA
                    }else if(this.texto_analizar.charAt(indice)=='+'){
                        indice++;
                        this.respuesta+="operador adicion\n";
                    //---------------------------------------ANALIZA OPERADOR RESTA
                    }else if(this.texto_analizar.charAt(indice)=='-'){    
                        indice++;
                        this.respuesta+="operador adicion\n";
                    //---------------------------------------ANALIZA OPERADOR MULTIPLICACION
                    }else if(this.texto_analizar.charAt(indice)=='*'){
                        indice++;
                        this.respuesta+="operador multiplicacion *\n";
                    //---------------------------------------ANALIZA OPERADOR DIVISION
                    }else if(this.texto_analizar.charAt(indice)=='/'){
                        indice++;
                        this.respuesta+="operador multiplicacion /\n";
                    //----------------------------------------ANALIZA IGUAL
                    }else if(this.texto_analizar.charAt(indice)=='='){
                        indice++;
                        estado = 5;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "operador asignacion\n");
                    //----------------------------------------ANALIZA MENOR QUE
                    }else if(this.texto_analizar.charAt(indice)=='<'){
                        indice++;
                        estado = 6;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "operador relacional < \n");
                    //----------------------------------------ANALIZA MAYOR QUE
                    }else if(this.texto_analizar.charAt(indice)=='>'){
                        indice++;
                        estado = 7;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "operador relacional > \n");
                    //----------------------------------------ANALIZA AND
                    }else if(this.texto_analizar.charAt(indice)=='&'){
                        indice++;
                        estado = 8;
                        this.respuesta=finCadena(indice,longitud, this.respuesta, "invalido\n");
                    //----------------------------------------ANALIZA OR
                    }else if(this.texto_analizar.charAt(indice)=='|'){
                        estado = 9;
                        indice++;
                        this.respuesta=finCadena(indice, longitud, this.respuesta,"invalido\n");
                    //----------------------------------------ANALIZA NOT
                    }else if(this.texto_analizar.charAt(indice)=='!'){
                        indice++;
                        this.respuesta+="operador not \n";
                    //----------------------------------------ANALIZA PARENTESIS
                    }else if(this.texto_analizar.charAt(indice)=='('){
                        indice++;
                        this.respuesta+="parentesis a\n";
                    }else if(this.texto_analizar.charAt(indice)==')'){
                        indice++;
                        this.respuesta+="parentesis b\n";
                    }
                    //----------------------------------------ANALIZA LLAVES
                    else if(this.texto_analizar.charAt(indice)=='{'){
                        indice++;
                        this.respuesta+="llave a\n";
                    }else if(this.texto_analizar.charAt(indice)=='}'){
                        indice++;
                        this.respuesta+="llave b\n";
                    }
                    //----------------------------------------ANALIZA PUNTO Y COMA
                    else if(this.texto_analizar.charAt(indice)==';'){
                        indice++;
                        this.respuesta+="punto y coma\n";
                    //----------------------------------------ANALIZA $
                    }else if(this.texto_analizar.charAt(indice)=='$'){
                        indice++;
                        this.respuesta+="simbolo pesos\n";
                    }else{
                        estado = 404;
                    }
                    break;
                case 1:
                    
                    if (Character.isDigit(this.texto_analizar.charAt(indice))) {
                        estado=1;
                        indice++;
                        this.respuesta = finCadena(indice, longitud, this.respuesta, "entero\n");
                    }else if(this.texto_analizar.charAt(indice)=='.'){
                        if ((indice+1) == longitud) {
                            estado = 0;
                            this.respuesta+="entero\n";
                        }else{
                            estado = 3;
                            indice++;
                        }
                    }else{
                        estado = 0;
                        this.respuesta+="entero\n";
                    }
                    break;
                        
                case 2:
                    if (this.texto_analizar.charAt(indice)=='"') {
                        estado=0;
                        indice++;
                        this.respuesta +="cadena\n";
                    }else{
                        estado=2;
                        indice++;
                        this.respuesta = finCadena(indice, longitud, this.respuesta,"cadena\n");
                    }
                    break;
                case 3:
                    if (Character.isDigit(this.texto_analizar.charAt(indice))) {
                        estado=3;
                        indice++;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "real\n");
                    }else{
                        if(this.texto_analizar.charAt(indice-1)=='.'){
                            this.respuesta+="entero\n";
                            indice--;
                        }else{
                            this.respuesta+="real\n";
                        }
                        estado=0;
                    }
                    break;
                case 4:
                    if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                        estado=4;
                        indice++;
                        this.respuesta = finCadena(indice, longitud, this.respuesta,"identificador\n");
                    }else{
                        this.respuesta +="identificador\n";
                        estado=0;
                    }
                    break;
                case 5:
                    if (this.texto_analizar.charAt(indice)=='=') {
                        indice++;
                        this.respuesta+="operador relacional ==\n";
                    }else{
                        this.respuesta+="operador de asignacion =\n";
                    }
                    estado = 0;
                    break;
                case 6:
                    if (this.texto_analizar.charAt(indice)=='=') {     
                        indice++;
                        this.respuesta +="operador relacional <=\n";
                    }else{
                        this.respuesta+="operador relacional <\n";
                        
                    }
                    estado=0;
                    break;
                case 7:
                    if (this.texto_analizar.charAt(indice)=='=') {
                        indice++;
                        this.respuesta +="operador relacional >=\n";
                    }else{
                        this.respuesta += "operador relacional >\n";
                    }
                    estado = 0;
                    break;
                case 8:
                    if (this.texto_analizar.charAt(indice)=='&') {
                        this.respuesta+="operador and\n";
                    }else{
                        this.respuesta+="invalido\n";
                    }
                    indice++;
                    estado=0;
                    break;
                case 9:
                    if (this.texto_analizar.charAt(indice)=='|') {
                        this.respuesta+="operador or\n";
                    }else{
                        this.respuesta+="invalido\n";
                    }
                    indice++;
                    estado=0;
                    break;
                case 10:
                    if (this.texto_analizar.charAt(indice)=='f') {
                        this.respuesta+="palabra reservada if\n";
                        indice++;
                        estado = 0;
//                        this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }else if(this.texto_analizar.charAt(indice)=='n'){
                        indice++;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                        if (indice<longitud) {   
                            if (this.texto_analizar.charAt(indice)=='t') {
                                this.respuesta+="palabra reservada int\n";
                                indice++;
                                estado=0;
                            }else{
                                estado = 4;
                            }
                        }
                    }else{
                        estado=4;
                        //this.respuesta = finCadena(indice, longitud, this.respuesta,"identificador\n");
                    }
                    break;
                case 11:
                    if (this.texto_analizar.charAt(indice)=='h') {
                        indice++;
                        this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                        if (indice<longitud) {
                            if (this.texto_analizar.charAt(indice)=='i') {
                                indice++;
                                if (indice<longitud) {
                                    if (this.texto_analizar.charAt(indice)=='l') {
                                        indice++;
                                        if (indice<longitud) {
                                            
                                            if (this.texto_analizar.charAt(indice)=='e') {
                                               this.respuesta +="palabra reservada while\n";
                                               indice++;
                                               estado=0;
                                            }else{
                                                estado=0;
                                            }
                                        
                                        }else{
                                            this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                                        
                                        }
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                                }
                            }else{
                                estado=4;
                            }
                        }
                    }else{
                        estado=4;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
                case 12:
                    if (this.texto_analizar.charAt(indice)=='e') {
                        indice++;
                        this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                        if (indice<longitud) {
                            if (this.texto_analizar.charAt(indice)=='t') {
                                indice++;
                                if (indice<longitud) {
                                    if (this.texto_analizar.charAt(indice)=='u') {
                                        indice++;
                                        if (indice<longitud) {
                                            
                                            if (this.texto_analizar.charAt(indice)=='r') {
                                               indice++;
                                                if (indice<longitud) {
                                                      if (this.texto_analizar.charAt(indice)=='n') {
                                                          indice++;
                                                        this.respuesta +="palabra reservada return\n";
                                                          estado=0;
                                                    }else{
                                                          estado=4;
                                                      }
                                                }else{
                                                    estado=4;
                                                    this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                                                }
                                            }else{
                                                estado=4;
                                            }
                                        
                                        }else{
                                            this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                                        
                                        }
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                                }
                            }else{
                                estado=4;
                            }
                        }
                    }else{
                        estado=4;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
                case 13:
                    if (this.texto_analizar.charAt(indice)=='l') {
                        indice++;
                        this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                        if (indice<longitud) {
                            if (this.texto_analizar.charAt(indice)=='s') {
                                indice++;
                                if (indice<longitud) {
                                    if (this.texto_analizar.charAt(indice)=='e') {
                                        indice++;
                                        this.respuesta +="palabra reservada else\n";
                                        estado=0;
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                            //this.respuesta = finCadena(indice, longitud, this.respuesta, "indetificador\n");
                        }
                    }else{
                        
                        estado=4;
                        //this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
                 case 14:
                    if (this.texto_analizar.charAt(indice)=='l') {
                        indice++;
                        this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                        if (indice<longitud) {
                            if (this.texto_analizar.charAt(indice)=='o') {
                                indice++;
                                if (indice<longitud) {
                                    if (this.texto_analizar.charAt(indice)=='a') {
                                        indice++;
                                        if (indice<longitud) {
                                            
                                            if (this.texto_analizar.charAt(indice)=='t') {
                                               this.respuesta +="palabra reservada float\n";
                                               indice++;
                                               estado=0;
                                            }else{
                                                estado=4;
                                            }
                                        
                                        }else{
                                            this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                                        
                                        }
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                                }
                            }else{
                                estado=4;
                            }
                        }
                    }else{
                        estado=4;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
               case 15:
                    if (this.texto_analizar.charAt(indice)=='o') {
                        indice++;
                        this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                        if (indice<longitud) {
                            if (this.texto_analizar.charAt(indice)=='i') {
                                indice++;
                                if (indice<longitud) {
                                    if (this.texto_analizar.charAt(indice)=='d') {
                                        indice++;
                                        this.respuesta +="palabra reservada void\n";
                                        estado=0;
                                    }else{
                                        estado=4;
                                    }
                                }else{
                                    this.respuesta =finCadena(indice, longitud, this.respuesta,"identificador\n");
                                }
                            }else{
                                estado=4;
                            }
                        }else{
                            //this.respuesta = finCadena(indice, longitud, this.respuesta, "indetificador\n");
                        }
                    }else{
                        
                        estado=4;
                        //this.respuesta=finCadena(indice, longitud, this.respuesta, "identificador\n");
                    }
                    break;
                case 404: 
                    estado = 0;
                    respuesta +="invalido\n";
                    indice++;
                default:
            }
            
            
            
                
            
        }
        return this.respuesta;
    }
    public String finCadena(int indice, int longitud, String respuesta, String fin){
        if (longitud == indice) {
            return respuesta+=fin;
        }
            return respuesta;
    }
}
