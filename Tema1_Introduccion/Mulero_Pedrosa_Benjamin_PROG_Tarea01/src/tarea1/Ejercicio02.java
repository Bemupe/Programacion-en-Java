package tarea1;

import java.util.Scanner;

/**
 * C�lculos aritm�ticos.
 * Escribe un programa en Java que solicite dos n�meros reales y lleve a cabo los 
 * siguientes c�lculos:
 *  1. el triple del primer n�mero,
 *  2. la d�cima parte del segundo n�mero,
 *  3. el cuadrado del doble del producto de ambos n�meros,
 *  4. la mitad del cuadrado de la suma de ambos n�meros.
 * 
 * @author Benjamin Mulero Pedrosa
 */
public class Ejercicio02 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaraci�n de variables 
        //----------------------------------------------

        // Constantes

        
        // Variables de entrada
        double numero1, numero2;// Nombramos dos variables de entrada "double". Establecemos las variables 
        //como "double"(coma flotante), porque es m�s apta para guardar n�meros en memoria que tienen parte entera 
        //y parte decimal, ya que los resultados pueden salir con decimales. Nos aseguramos un mejor fucionamiento.
        
        // Variables de salida
        double resultado1, resultado2, resultado3, resultado4;// Nombramos cuatro variables "double", una por cada resultado.
        
        // Variables auxiliares

        
        // Clase Scanner para petici�n de datos de entrada
        Scanner teclado= new Scanner (System.in);//Declaramos la clase Scanner, que nos permitir� introducir por teclado 
        //la cuant�a de las variables.
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("C�LCULOS ARITM�TICOS");
        System.out.println("--------------------");
        System.out.println("Introduzca dos n�meros reales: ");
        System.out.print("Primer n�mero: ");//Sacamos por pantalla, utilizando "System.out.println",  el texto para introducir el primer n�mero.
        numero1= teclado.nextDouble();//Se�alamos, que en la variable "numero1" (y continuado al texto anterior), ser� cargada la cantidad que se establezca por el teclado y ser� introducida como variable "double".
        System.out.print("Segundo n�mero: ");//Sacamos por pantalla, utilizando "System.out.println",  el texto para introducir el segundo n�mero.
        numero2= teclado.nextDouble();//Se�alamos, que en la variable "numero2"(y continuado al texto anterior), ser� cargada la cantidad que se establezca por el teclado y ser� introducida como variable "double".


        
        //----------------------------------------------
        //                 Procesamiento                /En los c�lculos para el procesamiento, establezco las cuant�a con un decimal para resultados m�s concretos.
        //----------------------------------------------
        
        // Primer c�lculo: triple del primer n�mero
        resultado1= 3.0 * numero1;
        // Segundo c�lculo: d�cima parte del segundo n�mero
        resultado2= numero2 / 10.0;
        // Tercer c�lculo: cuadrado del doble del producto de ambos n�meros
        resultado3= ((numero1*numero2)*2.0)*((numero1*numero2)*2.0);//En este caso, otra opci�n ser�a utilizar "Math.pow (numero,potencia)", que se utiliza para realizar n�meros elevados a una potencia2. Ejemplo: resultado3= Math.pow(((numero1*numero2)*2.0),2.0)
        
        // Cuarto c�lculo: mitad del cuadrado de la suma de ambos n�meros
        resultado4= ((numero1+numero2)*(numero1+numero2)) / 2.0;//En este caso tambi�n podr�a utilizarse "Math.pow"
        //----------------------------------------------
        //              Salida de resultados            /Sacamos por pantalla todos los resultados, estableciendo el texto del c�lculo, m�s (+) la variables de salida, "resultado" (Ej.resultado1) 
        //----------------------------------------------
        System.out.println ();
        System.out.println ("RESULTADO");
        System.out.println ("---------");
        System.out.println ("Primer c�lculo/Triple del primer n�mero: " + resultado1);
        System.out.println ("Segundo c�lculo/D�cima parte del segundo n�mero: " + resultado2);
        System.out.println ("Tercer c�lculo/Cuadrado del doble del producto de ambos n�meros: " + resultado3);
        System.out.println ("Cuarto c�lculo/Mitad del cuadrado de la suma de ambos n�meros: " + resultado4);
                
       
    }    
}

