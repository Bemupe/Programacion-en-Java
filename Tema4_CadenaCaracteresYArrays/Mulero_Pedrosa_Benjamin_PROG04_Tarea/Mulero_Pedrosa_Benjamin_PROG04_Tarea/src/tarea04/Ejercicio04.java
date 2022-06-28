
package tarea04;

import java.util.Arrays;

/**
 * Ejercicio 4. ¡Línea!
 * @author nombre y apellidos del alumno/a
 */

public class Ejercicio04 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        
        // 1.- Declaración del array que representa las bolas que han salido hasta el momento
        int[]bolas={1, 2, 5, 10, 11, 12, 14, 15, 22, 55, 56, 57, 59, 60, 61, 66, 78, 89, 90};

        // 2.- Declaración del array bidimensional "irregular" de números enteros para representar el cartón
        int[][] carton={{1, 2, 5, 9}, {11, 15}, {22, 29}, {34}, {47, 49}, {55, 59, 60}, {61}, {71, 75}, {88, 90}};
        // Variables de salida
        // 3.- Declaración del array unidimensional que almacenará los resultados
        String[]resultados;

        // Variables auxiliares

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("BUSCADOR DE LÍNEAS EN UN CARTÓN DE BINGO");
        System.out.println("----------------------------------------");

        // 4.- Mostramos por pantalla el contenido del cartón
        System.out.println("Cartón: "+Arrays.deepToString(carton));

        // 5.- Mostramos por pantalla la lista de bolas
        System.out.println("Números que ya han salido: "+Arrays.toString(bolas));
        
        //----------------------------------------------
        //                   Procesamiento 
        //---------------------------------------------- 
        // 6.- Reservamos espacio para el array de resultados (sin usar un literal)
        resultados=new String [carton.length];
        // 7.- Recorremos cada fila del cartón
        
            // 7.1.- Para cada fila, recorremos todos los números que contenga
                // 7.2.- Comprobamos si cada número ha salido o no (habrá que recorrer la lista de bolas que ya han salido)
                //       Si han salido todos, se marcará esa fila como "línea" en el array de resultados
                // 7.3.- Si no han salido todos, se marcará es fila como "no" en el array de resultados
            
            

            //Creo un primer for con otros for anidados para acceder a cada uno 
            //de los valores del array bidimensional "carton" y comparar con las 
            //bolas que han salido (array unidimensional "bolas". Si la comparación 
            //es correcta colocamos el valor 0 a la igualdad.
            for (int i=0;i<bolas.length;i++)
            {
                for (int j=0;j<carton.length;j++)
                {
                    for (int k=0;k<carton[j].length;k++)
                    {
                        if (bolas[i]==carton [j][k])
                        {
                            carton[j][k]=0;
                        }
                    }
                }
            } 
            
            //Una vez tenemos el array "carton" con los valores iguales de las 
            //bolas extraidas en cero, realizamos una suma con todos los valores de cada fila, si la fila 
            //es cero, hay línea, si la suman no es cero, no hay línea.
            int contador=0;
            for (int j=0;j<carton.length;j++)
            {
                int sum=0;
                for (int k=0;k<carton[j].length;k++)
                {
                    sum+= carton [j][k];
                }
                if (sum==0)
                {
                    resultados[j]="línea";
                    contador=1+contador;
                }
                else
                {
                    resultados[j]="no";
                }
            } 

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        
        // 8.- Mostramos por pantalla el array de resultados y cuántas líneas han salido
        System.out.println("Resultados de la búsqueda de líneas en el cartón de bingo:"+"\n"
        +Arrays.toString(resultados));      
        System.out.println("Número de líneas obtenidas: "+contador);
        
    }      
}
