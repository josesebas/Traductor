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
                    if(this.texto_analizar.charAt(indice)==' '){
                        indice++;
                    }else if (Character.isDigit(this.texto_analizar.charAt(indice))) {
                        estado = 1;      
                        indice++;
                        this.respuesta= finCadena(indice,longitud, this.respuesta, "entero\n");
                    }else if(Character.isLetter(this.texto_analizar.charAt(indice))){
                        estado = 2;
                        indice++;
                        this.respuesta = finCadena(indice, longitud, this.respuesta, "cadena\n");
                    }else if(this.texto_analizar.charAt(indice)=='.'){
                        estado = 3;
                        indice++;
                        this.respuesta+=finCadena(indice, longitud, this.respuesta, "invalido\n");
                    }else if(this.texto_analizar.charAt(indice)=='+'){
                        indice++;
                        this.respuesta+="operador adicion\n";
                    }else if(this.texto_analizar.charAt(indice)=='-'){    
                        indice++;
                        this.respuesta+="operador adicion\n";
                    }else if(this.texto_analizar.charAt(indice)=='*'){
                        indice++;
                        this.respuesta+="operador multiplicacion *\n";
                    }else if(this.texto_analizar.charAt(indice)=='/'){
                        indice++;
                        this.respuesta+="operador multiplicacion /\n";
                    }else if(this.texto_analizar.charAt(indice)=='='){
                        indice++;
                        estado = 4;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "operador asignacion\n");
                    }else if(this.texto_analizar.charAt(indice)=='<'){
                        indice++;
                        estado = 5;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "operador relacional < \n");
                    }else if(this.texto_analizar.charAt(indice)=='>'){
                        indice++;
                        estado = 6;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "operador relacional > \n");
                    }else{
                        estado = 404;
                    }
                    break;
                case 1:
                    
                    if (Character.isDigit(this.texto_analizar.charAt(indice))) {
                        estado=1;
                        indice++;
                        this.respuesta = finCadena(indice, longitud, this.respuesta, "entero\n");
                    }else if(this.texto_analizar.charAt(indice) == ' '){
                        this.respuesta+="entero\n";
                        estado = 0;
                    }else if(this.texto_analizar.charAt(indice)=='.'){
                        estado=3;
                        indice++;
                        this.respuesta = finCadena(indice,longitud,this.respuesta,"invalid");
                    }else{
                        estado = 404;
                    }
                    break;
                        
                case 2:
                    if (Character.isLetterOrDigit(this.texto_analizar.charAt(indice))) {
                        estado = 2;
                        indice++;
                        this.respuesta = finCadena(indice, longitud, this.respuesta, "cadena\n");
                    }else if(this.texto_analizar.charAt(indice)==' '){
                        this.respuesta+= "cadena\n";
                        estado=0;
                    }else{
                        estado = 404;
                    }
                    break;
                case 3:
                    if (Character.isDigit(this.texto_analizar.charAt(indice))) {
                        estado=3;
                        indice++;
                        this.respuesta=finCadena(indice, longitud, this.respuesta, "flotante\n");
                    }else if(this.texto_analizar.charAt(indice)==' '){
                        if (Character.isDigit(this.texto_analizar.charAt(indice-1))) {
                            this.respuesta+="flotante\n";
                        }else{
                            this.respuesta+="invalido\n";
                        }

                        estado =0;
                        //indice++;
                    }else{
                        estado=404;
                    }
                    break;
                case 4:
                    if (this.texto_analizar.charAt(indice)=='=') {
                        indice++;
                        estado=0;
                        this.respuesta =finCadena(indice, longitud, this.respuesta,"operador relacional ==\n");
                    }else{
                        this.respuesta+="operador de asignacion =\n";
                        estado = 0;
                    }
                    break;
                case 5:
                    if (this.texto_analizar.charAt(indice)=='=') {
                        estado=0;
                        indice++;
                        this.respuesta =finCadena(indice, longitud, this.respuesta,"operador relacional <=\n");
                    }else{
                        this.respuesta+="operador relacional <\n";
                        estado = 0;
                    }
                    break;
                case 6:
                    if (this.texto_analizar.charAt(indice)=='=') {
                        estado =0;
                        indice++;
                        this.respuesta =finCadena(indice, longitud, this.respuesta,"operador relacional >=\n");
                    }else{
                        this.respuesta += "operador relacional >\n";
                        estado = 0;
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
