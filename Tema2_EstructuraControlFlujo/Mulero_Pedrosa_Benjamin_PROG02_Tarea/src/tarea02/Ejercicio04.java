package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 4: puntuación de un texto.
 *
 * @author Nombre alumno/a
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes

        // Variables de entrada
        String texto;//Establezco variable string para introducir el texto
        int multiplicador, resultado;//Establezco variables int, una para introducir el número multiplicador y la otra para introducir el resultado final 
        int valor=0;//Variable para hacer el cálculo de la cotabilidad de los caracteres.
        // Variables de salida
        
        // Variables auxiliares

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("VALOR DE UN TEXTO");
        System.out.println("-----------------");
        do//Utilizo do/while para hacer un bucle, del cual se saldrá cuando se introduzca el número de carateres señalados. 
        {
            System.out.println("Introduzca un texto con al menos 5 caracteres: ");
            texto= teclado.nextLine();
        } 
        while (texto.length()<5);//Mientras la cantidad de caracteres de la variable texto sea menor de 5 se ejecutará lo establecido entre llaves.
        //Se saldrá del bucle, cuando la cantidad de caracteres introducidos sea mayor de 5.
        
        do//Utilizo do/while para hacer un bucle, del cual se saldrá cuando se introduzca el número de multiplicador señalado. 
        {
            System.out.println("Introduzca el valor del multiplicador (entre 1-3): ");
            multiplicador= teclado.nextInt();
        } 
        while (multiplicador<1||multiplicador>3);//Mientras multiplicador sea menor que 1 o mayor de 3 se seguirá cumpliendo el "do".
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------               
        for ( int j = 0; j < texto.length(); j++ )//Establezco un "for" para ir analizando caracter por caracter e introducir las puntuaciones en la variable valor. 
            //El for continuará mientras "j" sea menor de la cantidad de caracteres de la variable "texto". 
         {
             switch(texto.charAt(j))//Realizo el cálculo del valor, utilizando un "switch" utilizando "case" según las puntuaciones y caracteres señalados por el ejercicio. 
             {
                 case 'a': case'A': case 'e': case 'E': case'i': case 'I': case 'o': case'O': case 'u': case'U':     
                     valor += 1;
                     break;
                 case 'x': case 'y': case'z':
                     valor += 2;
                     break;
                 case 'X':
                     valor += 5;
                     break;
                 default://Resto de caracteres
                     valor -= 1;
             }
         }
        resultado=valor*multiplicador;//Calculo el resultado final, multiplicando el valor obtenido del switch (introducido en la variable "valor") con el multiplicador.
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("El valor del texto es: "+resultado);//Sacamos por consola el resultado.
    }
}
