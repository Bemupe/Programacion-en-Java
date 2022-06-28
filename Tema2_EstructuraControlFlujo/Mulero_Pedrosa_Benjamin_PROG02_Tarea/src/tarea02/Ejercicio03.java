package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 3: Valor de un naipe en el juego del tute.
 * 
 * @author Nombre alumno/a
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes

        // Variables de entrada
        int carta, valor;//Establezco dos variables int, una donde se introduce el número da la carta y otra que será el valor de la carta.
        valor=0;//Inicializo la carta valor.
        // Variables de salida
 
        // Variables auxiliares

        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("VALOR DE UN NAIPE EN EL TUTE");
        System.out.println("----------------------------");
        System.out.println("Introduzca número (1-7, 10-12): ");
        carta= teclado.nextInt();//Cargamos variable desde teclado.
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------       
        switch (carta) //Creo el switch "carta", según el número de la carta introducida la variable valor se carga una cantidad.
        {
            case 1:      
                valor = 11;
                break;
            case 3:
                valor = 10;
                break;
            case 12:
                valor = 4;
                break;
            case 11:
                valor = 3;
                break;
            case 10:
                valor = 2;
                break;
            case 2: case 4:  case 5: case 6: case 7:
                valor = 0;
                break;
            default://El resto de cartas o números introducidos en la variable carta, cargará la variable valor con "-1".
                valor = -1;
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("El valor del naipe con ese número es: "+valor);//Obtengo el valor del naipe seleccionado.
    }
}
