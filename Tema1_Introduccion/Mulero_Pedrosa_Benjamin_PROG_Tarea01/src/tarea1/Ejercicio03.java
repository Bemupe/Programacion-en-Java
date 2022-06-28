
package tarea1;

import java.util.Scanner;

/**
 * Análisis de un número.
 * 
 * @author Benjamin Mulero Pedrosa
 */
public class Ejercicio03 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int numero;//Establecemos una variable de entrada de tipo "int", ya que para el caso que se nos plantea, y 
        //para utilizar números enteros, es mejor usar estas variables. 
        
        // Variables de salida
        boolean esDisCero, esNegativo, entreCeroDiez, esMuTrPoM;//Dado que queremos, que al señalar un número, nos 
        //diga de este, si se cumplen determinados requisitos o no (verdadero (true) o falso (false)), establecemos 4 
        //variables de tipo "boolean", cuyo resultado será positivo o negativo, según la pregunta.   
        
        // Variables auxiliares

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);//Establecemos la clase scanne para obtener por teclado el número.
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ANÁLISIS DE UN NÚMERO");
        System.out.println("---------------------");
        System.out.print("Introduzca un número entero: ");
        numero= teclado.nextInt();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        // Cálculo de los resultados lógicos
        esDisCero=numero!=0;//Utilizamos el operador racional "distinto de (!=)", para preguntar con respecto a la variable "numero": ¿Es el número distinto de cero? 
        esNegativo=numero<0;//Utilizamos el operador racional "menor que (<)", para preguntar con respecto a la variable "numero": ¿Es el número negativo (es menor que cero)? 
        entreCeroDiez= numero>=0 && numero<=10;//Utilizamos los operadores racionales "mayor que (>)", "menor que(<)" y "igual que(=)" y el operador lógico "y(&&)" (para realizar las uniones o conjunciones), para preguntar con respecto a la variable "numero": ¿Está el número entre cero y diez (ambos incluidos)? 
        esMuTrPoM= (numero%3==0) && numero>0 && numero<20;//Por último, utilizamos los elementos anteriores más el módulo (%) para conocer el "resto" de una división entre la variable "numero" y "3", para así conocer si es múltiplo 3: ¿Es número múltiplo de tres, positivo y menor que veinte?. 
       
        //----------------------------------------------
        //              Salida de resultados            //Se realizan las salidas por pantalla.
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ("El número es distinto de cero?: " + esDisCero);
        System.out.println ("El número es negativo: " + esNegativo);
        System.out.println ("El número está entre cero y diez (ambos incluido): " + entreCeroDiez);
        System.out.println ("El número es múltiplo de tres, positivo y menor de veinte: " + esMuTrPoM);
                
       

    }    
}
