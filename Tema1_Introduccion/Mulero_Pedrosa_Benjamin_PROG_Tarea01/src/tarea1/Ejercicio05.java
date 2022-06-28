package tarea1;

import java.util.Scanner;

/**
 * M�quina expendedora de productos.
 * @author Benjamin Mulero Pedrosa
 */
public class Ejercicio05 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaraci�n de variables 
        //----------------------------------------------

        // Constantes

        // Variables de entrada
        int precio, dinero;// Dos variables de entrada. Introducir, precio y dinero.
        int moVeiRes, moDieRes, moCinRes, moDosRes, moUnoRes;// Establecemos una variable de entrada por cada tipo de moneda 
        //(20cent, 10cetn, 5cent, 2cent, 1cent). En cada una de ella introduciremos su resto correspondiente de la cadena 
        //divisoria para la devoluci�n de las monedas con el m�nimo n�mero de monedas.
        //(Ej. Devoluci�n 15cent.
        //    15/20cent
        //           Cociente=0 (0 Monedas a entregar de 20cent)
        //           Resto=15 (15cent. restan por devolver)
        //                    15/10cetn
        //                           Cociciente=1(1 moneda a entregar de 10 cent)
        //                           Resto= 5 (5cent. restan por devolver)
        //                                    5/5cent
        //                                           Cociente=1 (1 moneda a entregar de 5cent)
        //                                           Resto=0 (0 monedas restan por entregar)
        //)
        
        // Variables de salida
        int moVeiCoc, moDieCoc, moCinCoc, moDosCoc, moUnoCoc;//Establecemos una variable de salida por cada tipo de moneda 
        //(20cent, 10cetn, 5cent, 2cent, 1cent). De esta forma, en cada variable se almacenar� el n�mero de monedas a devolver, 
        //obtenido de la cadena divisoria del cociente de cada divisi�n. 

        int cambio, total;//Establecemos dos variables de salida, una para el cambio a devolver y otra para el total con el m�nimo de monedas a devolver.
        // Variables auxiliares

        // Clase Scanner para petici�n de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("M�QUINA EXPENDEDORA DE PRODUCTOS");
        System.out.println("--------------------------------");
        System.out.print("Precio del producto (en c�ntimos): ");
        precio= teclado.nextInt();
        System.out.print("Dinero introducido (en c�ntimos): ");
        dinero= teclado.nextInt();
                
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        cambio=dinero-precio;
        
        //Restos//Obtenemos los restos de la cadena divisoria como se�alamos en el ejemplo anterior y la introducimos en 
        //su correspondiente variable. (20cent, 10cent, 5cent, 2cent, 1cent)
        moVeiRes=cambio%20; 
        moDieRes=moVeiRes%10;
        moCinRes=moDieRes%5;
        moDosRes=moCinRes%2;
        moUnoRes=moDosRes%1;
        //Cocientes/Monedas//Obtenemos los cocientes (monedas a devolver) de la cadena  divisoria como se�alamos en el ejemplo anterior y la 
        //introducimos en su correspondiente variable. (20cent, 10cent, 5cent, 2cent, 1cent)
        moVeiCoc=cambio/20;
        moDieCoc=moVeiRes/10;
        moCinCoc=moDieRes/5;
        moDosCoc=moCinRes/2;
        moUnoCoc=moDosRes/1;
        //Total de monedas
        total=moVeiCoc+moDieCoc+moCinCoc+moDosCoc+moUnoCoc;//Obtenemos el total de monedas a devolver sumando todas la 
        //variables cocientes de cada tipo de moneda.
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ("El cambio es: " + cambio);
        System.out.println ("Monedas de 20 c�ntimos: " + moVeiCoc);
        System.out.println ("Monedas de 10 c�ntimos: " + moDieCoc);
        System.out.println ("Monedas de 5 c�ntimos: " + moCinCoc);
        System.out.println ("Monedas de 2 c�ntimos: " + moDosCoc);
        System.out.println ("Monedas de 1 c�ntimos: " + moUnoCoc);
        System.out.println ("Total de monedas: " + total);
    }
    
}
