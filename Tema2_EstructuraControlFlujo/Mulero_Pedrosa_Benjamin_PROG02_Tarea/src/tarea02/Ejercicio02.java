package tarea02;

import java.util.Scanner;

/**
 *
 * Ejercicio 2: Análisis del año.
 * 
 * @author Nombre alumno/a
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes

        // Variables de entrada
        int año,dife_año;//Establezco dos variables int, una para cargarla con el año que se introduce y la otra para conocer la diferecia de años.
        String siglo,momento,dif_text;//Establezco tres variables string, siglo: 
        //para introducir el siglo, momento: para introducir si el momentos es, 
        //anterior o posterior y por último di_text: para señalar si faltan o han pasado.
        siglo="";//Inicializo las variables string.
        momento="";
        dif_text="";
        // Variables de salida
        
        // Variables auxiliares

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("ANÁLISIS DEL AÑO");
        System.out.println("----------------");
        System.out.println("Introduzca un año (Entre 1801-2100): ");
        año= teclado.nextInt();//Intoducimos por teclado el año.
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------       
        if (año>=1801&&año<=2100)//Establecemos el intervalo de años para realizar los procesos y que serán los años válidos para el funcionamiento.
        {  
            if (año>=1801&&año<=1900) siglo="XIX";//Según el rango de años llenaremos la variable siglo con su siglo correspondiente.
            if (año>=1901&&año<=2000) siglo="XX";
            if (año>=2001&&año<=2100) siglo="XXI";
            
            dife_año=2021-año;//Obtenemos la diferencia de años.
            
            if (dife_año<0)//Si el resultado anterior es menor que cero, es decir, negativo.
            {
                dife_año=dife_año*-1;//Multiplicamos la diferencia por -1 para hacerla positiva y ya sabemos que la diferencia es "posterior" y "faltan".
                momento="es posterior al";
                dif_text="Faltan ";
            } 
            else//Si dife_año es mayor que 0, es decir, no negativo, la diferencia sabemos que es "anterior" y "han pasado". 
            {
                momento="es anterior al";
                dif_text="Han pasado ";
            }
          
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
           System.out.println("RESULTADO");
           System.out.println("---------");
           if (año==2021)//Si el año introducido es 2021, se obtiene por consola lo siguiente
           {
               System.out.println("El año introducido coincide con el actual"); 
               System.out.println("El año pertenece al siglo "+siglo);
           }
           else//Si el año introducido no es igual a 2021, se obtiene por consola las variables de la zona de Procesamiento.
           {
               System.out.println("El año introducido "+momento+" actual. "+dif_text+ "" +dife_año+ " años.");
               System.out.println("El año pertenece al siglo "+siglo);}
        } 
        else//Si el año introducido se sale del intervalo inicial, se obtiene por consola "Año no válido" y finaliza el programa. 
        {
            System.out.println("Año no válido");
        }
       // TODO code application logic here
    }
}
