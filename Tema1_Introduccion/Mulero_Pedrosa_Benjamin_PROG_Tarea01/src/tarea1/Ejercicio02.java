package tarea1;

import java.util.Scanner;

/**
 * Cálculos aritméticos.
 * Escribe un programa en Java que solicite dos números reales y lleve a cabo los 
 * siguientes cálculos:
 *  1. el triple del primer número,
 *  2. la décima parte del segundo número,
 *  3. el cuadrado del doble del producto de ambos números,
 *  4. la mitad del cuadrado de la suma de ambos números.
 * 
 * @author Benjamin Mulero Pedrosa
 */
public class Ejercicio02 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes

        
        // Variables de entrada
        double numero1, numero2;// Nombramos dos variables de entrada "double". Establecemos las variables 
        //como "double"(coma flotante), porque es más apta para guardar números en memoria que tienen parte entera 
        //y parte decimal, ya que los resultados pueden salir con decimales. Nos aseguramos un mejor fucionamiento.
        
        // Variables de salida
        double resultado1, resultado2, resultado3, resultado4;// Nombramos cuatro variables "double", una por cada resultado.
        
        // Variables auxiliares

        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);//Declaramos la clase Scanner, que nos permitirá introducir por teclado 
        //la cuantía de las variables.
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CÁLCULOS ARITMÉTICOS");
        System.out.println("--------------------");
        System.out.println("Introduzca dos números reales: ");
        System.out.print("Primer número: ");//Sacamos por pantalla, utilizando "System.out.println",  el texto para introducir el primer número.
        numero1= teclado.nextDouble();//Señalamos, que en la variable "numero1" (y continuado al texto anterior), será cargada la cantidad que se establezca por el teclado y será introducida como variable "double".
        System.out.print("Segundo número: ");//Sacamos por pantalla, utilizando "System.out.println",  el texto para introducir el segundo número.
        numero2= teclado.nextDouble();//Señalamos, que en la variable "numero2"(y continuado al texto anterior), será cargada la cantidad que se establezca por el teclado y será introducida como variable "double".


        
        //----------------------------------------------
        //                 Procesamiento                /En los cálculos para el procesamiento, establezco las cuantía con un decimal para resultados más concretos.
        //----------------------------------------------
        
        // Primer cálculo: triple del primer número
        resultado1= 3.0 * numero1;
        // Segundo cálculo: décima parte del segundo número
        resultado2= numero2 / 10.0;
        // Tercer cálculo: cuadrado del doble del producto de ambos números
        resultado3= ((numero1*numero2)*2.0)*((numero1*numero2)*2.0);//En este caso, otra opción sería utilizar "Math.pow (numero,potencia)", que se utiliza para realizar números elevados a una potencia2. Ejemplo: resultado3= Math.pow(((numero1*numero2)*2.0),2.0)
        
        // Cuarto cálculo: mitad del cuadrado de la suma de ambos números
        resultado4= ((numero1+numero2)*(numero1+numero2)) / 2.0;//En este caso también podría utilizarse "Math.pow"
        //----------------------------------------------
        //              Salida de resultados            /Sacamos por pantalla todos los resultados, estableciendo el texto del cálculo, más (+) la variables de salida, "resultado" (Ej.resultado1) 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ("Primer cálculo/Triple del primer número: " + resultado1);
        System.out.println ("Segundo cálculo/Décima parte del segundo número: " + resultado2);
        System.out.println ("Tercer cálculo/Cuadrado del doble del producto de ambos números: " + resultado3);
        System.out.println ("Cuarto cálculo/Mitad del cuadrado de la suma de ambos números: " + resultado4);
                
       
    }    
}

