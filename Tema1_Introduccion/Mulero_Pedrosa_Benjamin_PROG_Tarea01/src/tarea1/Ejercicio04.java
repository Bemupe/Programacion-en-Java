package tarea1;

/**
 * Trayecto en dos etapas.
 * 
 * @author Nombre alumno/a
 */
import java.util.Scanner;

public class Ejercicio04 {
 
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaraci�n de variables 
        //----------------------------------------------

        // Constantes
        

        // Variables de entrada
        double depositoIni;//Establecemos una variable de entrada "double" para introducir la cantidad de combustible inicial. 
        
        // Variables de salida
        double consume1, consume2, depositoFin;//Establecemos tres variables de salida "double" para conocer el consumo 
        //del primer trayecto, del segundo y el combustible restante. 
                
        // Variables auxiliares

        
        // Clase Scanner para petici�n de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("TRAYECTO EN DOS ETAPAS");
        System.out.println("----------------------");
        System.out.print("Introduzca la cantidad inicial de litros que se introducen en el dep�sito del veh�culo: ");
        depositoIni= teclado.nextDouble();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        consume1= depositoIni/2;//En esta procesamiento, introducimos en la variable "consume1" la mitad de lo introducido por teclado en el depostioIni. Lo realizamos de forma aritm�tica. Otra forma ser�a "depositoIni*0,50" o realizando una regla de tres (implica escribir m�s).
        consume2= consume1/4;//En este procesamiento, introducimos en la variable "consume2" lo consumido en el segundo trayecto, que corresponde al 25% de lo que quedaba en el dep�sito tras el primer trayecto. Para ello utilizamos "consume1" que contiene la mitad del n�mero inicial. Al igual que el anterior, se pude obtener de varias formas.
        depositoFin= depositoIni-(consume1+consume2);//Finalmente, obtenemos la cantidad que queda en el dep�sito. Restamos al dep�sito inicial, el consumo de los trayectos anteriores y obtenemos los litros restantes.


        //----------------------------------------------    
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ("Litros consumidos en el primer recorrido: " + consume1);
        System.out.println ("Litros consumidos en el segundo recorrido: " + consume2);
        System.out.println ("Litros sobrantes en el dep�sito: " + depositoFin);
    }    
}
