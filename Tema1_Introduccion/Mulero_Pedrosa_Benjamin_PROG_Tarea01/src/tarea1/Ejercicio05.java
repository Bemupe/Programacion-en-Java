package tarea1;

import java.util.Scanner;

/**
 * Máquina expendedora de productos.
 * @author Benjamin Mulero Pedrosa
 */
public class Ejercicio05 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes

        // Variables de entrada
        int precio, dinero;// Dos variables de entrada. Introducir, precio y dinero.
        int moVeiRes, moDieRes, moCinRes, moDosRes, moUnoRes;// Establecemos una variable de entrada por cada tipo de moneda 
        //(20cent, 10cetn, 5cent, 2cent, 1cent). En cada una de ella introduciremos su resto correspondiente de la cadena 
        //divisoria para la devolución de las monedas con el mínimo número de monedas.
        //(Ej. Devolución 15cent.
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
        //(20cent, 10cetn, 5cent, 2cent, 1cent). De esta forma, en cada variable se almacenará el número de monedas a devolver, 
        //obtenido de la cadena divisoria del cociente de cada división. 

        int cambio, total;//Establecemos dos variables de salida, una para el cambio a devolver y otra para el total con el mínimo de monedas a devolver.
        // Variables auxiliares

        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("MÁQUINA EXPENDEDORA DE PRODUCTOS");
        System.out.println("--------------------------------");
        System.out.print("Precio del producto (en céntimos): ");
        precio= teclado.nextInt();
        System.out.print("Dinero introducido (en céntimos): ");
        dinero= teclado.nextInt();
                
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        cambio=dinero-precio;
        
        //Restos//Obtenemos los restos de la cadena divisoria como señalamos en el ejemplo anterior y la introducimos en 
        //su correspondiente variable. (20cent, 10cent, 5cent, 2cent, 1cent)
        moVeiRes=cambio%20; 
        moDieRes=moVeiRes%10;
        moCinRes=moDieRes%5;
        moDosRes=moCinRes%2;
        moUnoRes=moDosRes%1;
        //Cocientes/Monedas//Obtenemos los cocientes (monedas a devolver) de la cadena  divisoria como señalamos en el ejemplo anterior y la 
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
        System.out.println ("Monedas de 20 céntimos: " + moVeiCoc);
        System.out.println ("Monedas de 10 céntimos: " + moDieCoc);
        System.out.println ("Monedas de 5 céntimos: " + moCinCoc);
        System.out.println ("Monedas de 2 céntimos: " + moDosCoc);
        System.out.println ("Monedas de 1 céntimos: " + moUnoCoc);
        System.out.println ("Total de monedas: " + total);
    }
    
}
