package tarea02;

import java.util.Scanner;

/**
 * Ejercicio 5: construcción de cajas.
 * 
 * @author Nombre alumno/a
 */
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        int filas, columnas, relleno;//Establezco tres variables int, una para establecer el número de filas, 
        //otra para el número de columnas y otra para seleccionar el si la caja estará vacía o rellena.

        // Variables de salida
        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CONSTRUCCIÓN DE CAJAS");
        System.out.println("---------------------");
        do//Utilizo do/while para hacer un bucle, del cual se saldrá cuando se introduzca el número de carateres señalados. 
        {
            System.out.println("Introduzca el número de filas (2-10): ");
            filas = teclado.nextInt();
        } while (filas < 2 || filas > 10);//Mientras la cantidad de filas sea menor de 2 y o mayor que 10 se ejecutará lo establecido entre llaves.

        do//Utilizo do/while para hacer un bucle, del cual se saldrá cuando se introduzca el número de multiplicador señalado. 
        {
            System.out.println("Introduzca el número de columnas (entre 2-10): ");
            columnas = teclado.nextInt();
        } while (columnas < 2 || columnas > 10);//Mientras la cantidad de columnas sea menor de 2 y o mayor que 10 se ejecutará lo establecido entre llaves.
        do {
            System.out.println("¿Caja rellena? (0: vacía, cualquier otro número rellena): ");
            relleno = teclado.nextInt();
        } while (relleno < 0);
        System.out.println("¿Caja rellena? (0: vacía, cualquier otro número rellena): ");
        //----------------------------------------------
        //         Procesamiento y Resultados
        //----------------------------------------------               
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");

        if (relleno == 0)//Informamos por pantalla sobre el tamaño de la caja y sobre si esta vacía o rellena a través de un if. 
        {
            System.out.println("Caja de tamaño " + filas + "x" + columnas + " vacía");
        } else {
            System.out.println("Caja de tamaño " + filas + "x" + columnas + " rellena");
        }

        
        //PRIMERA LÍNEA DE LA CAJA//
        System.out.print("+");//Establezco la esquina superior izquierda de la caja.

        for (int col = 1; col <= columnas - 2; col++)//A través de un for teniendo como referencia el número de columnas, establezco a primera línea de la caja.
        {
            System.out.print("-");
        }
        System.out.print("+");//Establezco la esquina superior derecha de la caja
        System.out.print("\n");//Salto de línea para iniciar el relleno, o no, de la caja.

        
        //FILAS DE LA CAJAS/RELLENO//
        for (int i = 1; i < filas - 1; i++)//Con un primer for plasmamos el número de filas.
        {
            System.out.print("|");//En cada inicio de fila, el primer caracter es "|"
            for (int col = 2; col < columnas; col++)//Con un segundo for, anidado en el anterior, rellenamos, o no, la caja.
            {
                if (relleno == 0)//Hacemos el relleno de la caja con un "if", dependiendo de si el dígito introducido en la variable "relleno", es cero u otro número (no negativo)
                {
                    System.out.print(" ");//Si relleno es igual a cero se imprimirá un espacio.
                } else {
                    System.out.print(i);//Si relleno es distinto de cero, la caja se rellena con el número establecido en la variable "i" del for, en cada iteración.
                }
            }
            System.out.print("| \n");//Finalizamos cada línea con "|" y un salto de línea para iniciar la siguiente.
        }

        
        //ÚLTIMA FILA DE LA CAJA//
        System.out.print("+");//Establezco la esquina inferior izquierda.

        for (int col = 1; col <= columnas - 2; col++)//Elaboro la última línea de la caja con un for. 
        {
            System.out.print("-");
        }

        System.out.print("+");//Establezco la esquina inferior derecha.
    }

}
