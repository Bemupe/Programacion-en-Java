package tarea1;

/**
 * Análisis de un texto.
 * 
 * @author Benjamin Mulero Pedrosa
 */
import java.util.Scanner;

public class Ejercicio06 {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes

        // Variables de entrada
        String texto;//Declaramos una variable tipo "string" para introducir una frase determinada por teclado.
        // Variables de salida
        boolean cincoCara, comiMayu, termMinu, terPuntos;//Declaramos cuatro variables de salida "boolean" para obtener 
        //el "verdadero" o "falso" de cada uno de los análisis. 
        // Variables auxiliares
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ANÁLISIS DE UN TEXTO");
        System.out.println("--------------------");
        System.out.print("Introduzca un texto: ");
        texto= teclado.nextLine();//Utilizamos "nextLine", para leer cadenas "string" por teclado. 
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        cincoCara=texto.length()>5;//En esta variable, establecemos si es verdadero o falso, que el texto introducido tiene una antidad de caracteres mayor de cinco.
        comiMayu=Character.isUpperCase(texto.charAt(0));//En esta variable, establecemos si es verdadero o falso, que el caracter es mayúscula en la posición 0 (primer caracter) del texto introducido.
        termMinu=Character.isLowerCase(texto.charAt(texto.length()-1));//En esta variable, establecemos si es verdadero o falso, que el caracter es minúsculas en la posición -1(último caracter) del texto introducido. Para conocer el último caracter de una frase introducida, tenemos en cuenta la cantidad de caracteres de "texto" (texto.length)  menos uno(-1), y obtenemos la última posición.
        terPuntos=texto.endsWith("...");//En esta variable, establecemos si es verdadero o falso, que la frase introducida termina  con (endsWith) puentos suspensivos.
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ("El texto contiene más de cinco caracteres: " + cincoCara);
        System.out.println ("El texto comienza con una letra mayúscula: " + comiMayu);
        System.out.println ("El texto termina con una letra minúscula: " + termMinu);
        System.out.println ("El texto termina con unos puntos suspensivos(...): " + terPuntos);
    }    
}