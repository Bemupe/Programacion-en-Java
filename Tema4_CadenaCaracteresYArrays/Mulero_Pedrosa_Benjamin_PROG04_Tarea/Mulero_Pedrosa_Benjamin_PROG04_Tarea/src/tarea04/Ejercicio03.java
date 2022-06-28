package tarea04;

import java.util.Arrays;


/**
 * Ejercicio 3. Inversión de palabras.
 * @author nombre y apellidos del alumno/a
 */

public class Ejercicio03 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        // 1.- Declaración del array de objetos String de entrada
        // (Textos "Reconocer", "AMANECER", "Esto no es un palindromo",
        //    "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
        //    "A man a plan and a canal, Panama", "No deseo ese don..."
        String[] textos={"\"Reconocer\";","\"AMANECER\";","\"Esto no es un palindromo\";",//Establecemos los textos con todo incluido como señala el ejercicio(comas, punto y comas, dos puntos, mayúsculas..)
            "\"Dabale arroz a la zorra el abad.\";","\"A man, a plan, a canal: Panama.\";",
            "\"A man a plan and a canal, Panama.\";","\"No deseo ese don...\"."};
        
        String[] elimi_sig_puntua =new String [textos.length];//Array de string donde almacenamos los textos sin signos de puntuación.
        // Variables de salida
        
        // 2.- Declaración de un array de String para los resultados
        String[] resultados;
        
        
        // Variables auxiliares

        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("INVERSIÓN DE PALABRAS");
        System.out.println("---------------------");


        // 3.- Reservamos espacio para el array de resultados (procura no usar un literal)
        resultados=new String[textos.length];
        
        // 4.- Mostramos el contenido del array de textos por pantalla
        // colocando cada texto en una línea diferente
        int contador=0;//Contador para establecer el número del texto
        for (int i=0;i<textos.length;i++)
                {
                    contador=1+contador;
                     System.out.println("-Texto "+contador+" : "+textos[i].toString());
                }

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 5.- Recorremos el array de textos.
        // Para cada texto:
        //   5.1.- obtenemos cada palabra del texto;
        //   5.2.- invertimos cada palaba del texto;
        //   5.3.- almacenamos cada palabra invertida separadas por espacios en una misma cadena.
        //         Esa cadena de palabras invertidas se almacenará en el array de resultados

        //LIMPIAMOS
        for (int i=0;i<textos.length;i++)//Con un for, eliminamos signos de puntuación. 
               //Finalmente lo alamacenamos todo modificado en "elimi_sig_puntua".
           {
               elimi_sig_puntua[i]=textos[i].replaceAll("\\p{Punct}","");
           }
        
        System.out.println("RESULTADOS OBTENIDOS");//Sacamos ya por pantalla el cartel de 
        //"Resultados Obtenidos", ya que de otro modo si lo introduzco en el for se me repetirá por cada iteración.
        System.out.println("--------------------");
        
        //OBTENEMOS CADA TEXTO DEL ARRAY "TEXTOS", REORDENAMOS CADA PALABRA Y SACAMOS POR PANTALLA   
        int contador2=0;
        for (int i=0;i<elimi_sig_puntua.length;i++)//Creamos un primer for donde vamos seleccionando los textos del array "Textos". Cada uno de ellos se introduce en el StringBuilder.
        {
            contador2=1+contador2;
            StringBuilder pala_alreves = new StringBuilder();
            pala_alreves.append(elimi_sig_puntua[i].toString());
            String alreves = "", temp = "";
            
            for(int a = 0; a <= pala_alreves.length()-1; a++)//Con el segundo for, 
                //y tras introducir el texto en el StringBuilder, ponemos del revés 
                //cada palabra. En el caso de las frases, cada palabra permanece en su lugar pero con las letras al revés.
            {
                temp += pala_alreves.charAt(a);
                if((pala_alreves.charAt(a) == ' ') || (a == pala_alreves.length()-1))
                {
                    
                    for(int j = temp.length()-1; j >= 0; j--)
                    {
                        alreves += temp.charAt(j);
                        if((j == 0) && (a != pala_alreves.length()-1))
                            alreves += " ";
                    }
                    temp = "";
                }
            }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------//Vamos obteniendo los resultados conforme va pasando la iteración.
        
        // 6.- Mostdramos los resultado por pantalla.
        // Recorremos el array de textos y para cada texto:
        
        //   6.1. Mostramos el texto original 
        System.out.println("Texto "+contador2+": "+textos[i].toString());
        
        //   6.2. Mostramos el texto con las palabras invertidas 
        System.out.println("Palabras invertidas: "+alreves+"\n");       
        }   
    }   
}