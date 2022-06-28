
package tarea1;

import java.util.Scanner;

/**
 * An�lisis de un n�mero.
 * 
 * @author Benjamin Mulero Pedrosa
 */
public class Ejercicio03 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaraci�n de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        int numero;//Establecemos una variable de entrada de tipo "int", ya que para el caso que se nos plantea, y 
        //para utilizar n�meros enteros, es mejor usar estas variables. 
        
        // Variables de salida
        boolean esDisCero, esNegativo, entreCeroDiez, esMuTrPoM;//Dado que queremos, que al se�alar un n�mero, nos 
        //diga de este, si se cumplen determinados requisitos o no (verdadero (true) o falso (false)), establecemos 4 
        //variables de tipo "boolean", cuyo resultado ser� positivo o negativo, seg�n la pregunta.   
        
        // Variables auxiliares

        // Clase Scanner para petici�n de datos de entrada
        Scanner teclado= new Scanner (System.in);//Establecemos la clase scanne para obtener por teclado el n�mero.
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("AN�LISIS DE UN N�MERO");
        System.out.println("---------------------");
        System.out.print("Introduzca un n�mero entero: ");
        numero= teclado.nextInt();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        // C�lculo de los resultados l�gicos
        esDisCero=numero!=0;//Utilizamos el operador racional "distinto de (!=)", para preguntar con respecto a la variable "numero": �Es el n�mero distinto de cero? 
        esNegativo=numero<0;//Utilizamos el operador racional "menor que (<)", para preguntar con respecto a la variable "numero": �Es el n�mero negativo (es menor que cero)? 
        entreCeroDiez= numero>=0 && numero<=10;//Utilizamos los operadores racionales "mayor que (>)", "menor que(<)" y "igual que(=)" y el operador l�gico "y(&&)" (para realizar las uniones o conjunciones), para preguntar con respecto a la variable "numero": �Est� el n�mero entre cero y diez (ambos incluidos)? 
        esMuTrPoM= (numero%3==0) && numero>0 && numero<20;//Por �ltimo, utilizamos los elementos anteriores m�s el m�dulo (%) para conocer el "resto" de una divisi�n entre la variable "numero" y "3", para as� conocer si es m�ltiplo 3: �Es n�mero m�ltiplo de tres, positivo y menor que veinte?. 
       
        //----------------------------------------------
        //              Salida de resultados            //Se realizan las salidas por pantalla.
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ("El n�mero es distinto de cero?: " + esDisCero);
        System.out.println ("El n�mero es negativo: " + esNegativo);
        System.out.println ("El n�mero est� entre cero y diez (ambos incluido): " + entreCeroDiez);
        System.out.println ("El n�mero es m�ltiplo de tres, positivo y menor de veinte: " + esMuTrPoM);
                
       

    }    
}
