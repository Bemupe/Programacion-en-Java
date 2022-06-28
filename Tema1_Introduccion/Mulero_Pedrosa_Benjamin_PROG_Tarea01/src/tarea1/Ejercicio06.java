package tarea1;

/**
 * An�lisis de un texto.
 * 
 * @author Benjamin Mulero Pedrosa
 */
import java.util.Scanner;

public class Ejercicio06 {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaraci�n de variables 
        //----------------------------------------------

        // Constantes

        // Variables de entrada
        String texto;//Declaramos una variable tipo "string" para introducir una frase determinada por teclado.
        // Variables de salida
        boolean cincoCara, comiMayu, termMinu, terPuntos;//Declaramos cuatro variables de salida "boolean" para obtener 
        //el "verdadero" o "falso" de cada uno de los an�lisis. 
        // Variables auxiliares
        
        // Clase Scanner para petici�n de datos de entrada
        Scanner teclado = new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("AN�LISIS DE UN TEXTO");
        System.out.println("--------------------");
        System.out.print("Introduzca un texto: ");
        texto= teclado.nextLine();//Utilizamos "nextLine", para leer cadenas "string" por teclado. 
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        cincoCara=texto.length()>5;//En esta variable, establecemos si es verdadero o falso, que el texto introducido tiene una antidad de caracteres mayor de cinco.
        comiMayu=Character.isUpperCase(texto.charAt(0));//En esta variable, establecemos si es verdadero o falso, que el caracter es may�scula en la posici�n 0 (primer caracter) del texto introducido.
        termMinu=Character.isLowerCase(texto.charAt(texto.length()-1));//En esta variable, establecemos si es verdadero o falso, que el caracter es min�sculas en la posici�n -1(�ltimo caracter) del texto introducido. Para conocer el �ltimo caracter de una frase introducida, tenemos en cuenta la cantidad de caracteres de "texto" (texto.length)  menos uno(-1), y obtenemos la �ltima posici�n.
        terPuntos=texto.endsWith("...");//En esta variable, establecemos si es verdadero o falso, que la frase introducida termina  con (endsWith) puentos suspensivos.
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ("El texto contiene m�s de cinco caracteres: " + cincoCara);
        System.out.println ("El texto comienza con una letra may�scula: " + comiMayu);
        System.out.println ("El texto termina con una letra min�scula: " + termMinu);
        System.out.println ("El texto termina con unos puntos suspensivos(...): " + terPuntos);
    }    
}