package tarea04;

import java.util.Arrays;

/**
 * Ejercicio 5. Sopa de letras.
 * @author nombre y apellidos del alumno/a
 */

public class Ejercicio05 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Variables de entrada
        // 1.- Declaración del array unidimensional que contiene la listra de palabras para buscar
        String[]lista={"Hola", "sol", "AMOR", "ARA", "Casa", "dos"};

        // 2.- Declaración del array bidimensional que representa la sopa de letras
        char[][]sopa={{'H','J','S','O','L'},{'O','E','C','A','U'},{'L','Y','K','D','A'},{'A','A','M','O','R'},{'V','C','A','S','A'}};
        // Variables de salida
        // 3.- Declaración del array unidimensional que almacena los resultados
        String[]resultados;

        // Variables auxiliares

        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("BUSCADOR DE PALABRAS EN HORIZONTAL");
        System.out.println("----------------------------------");
        
        // 4.- Mostramos por pantalla el contenido de la sopa de letras en forma de tabla
        for (int i=0;i<sopa.length;i++)
            {
                for (int j=0;j<sopa.length;j++)
                {System.out.print(sopa[i][j]);
                }
                System.out.print("\n");
            }
        // 5.- Mostramos por pantalla la lista de palabras
        System.out.println("Lista de palabras de prueba:"+"\n"
        +Arrays.toString(lista));  

        //----------------------------------------------
        //  Procesamiento (implementado por los alumnos)
        //----------------------------------------------
        // 5.- Reservamos espacio para el array de resultados (sin usar un literal)
        resultados=new String[lista.length];
        // 7.- Exploramos la sopa de letras para buscar horizontalmente cada una de las palabras de la lista 
            // 7.1.- Recorremos la lista de palabras 
            // 7.2.- Para cada palabra, la buscamos horizontalmente (en cada fila de la sopa)
            int contador=0;
            //PREPARACIÓN DE LAS VARIABLES
            for (int i=0;i<lista.length;i++)
            {
                lista[i] = lista[i].toUpperCase();//Preparamos la lista de palabras para hacer la comparación, para lo cual, pasamos todas la palabras a mayúsculas.
                resultados[i]="No";//Pasamos el array de resultados a resultados negativos (no línea), para posteriormente introducir los resultados positivos.
            }
            //PROCESAMIENTO
            for (int fila = 0; fila < sopa.length; fila++)//Entramos en la fila de la sopa de letras.
            {
                StringBuilder  builder_fila= new StringBuilder();//Creamos un StringBuilder (contendrá cada fila de la sopa para encontrar la palabra) que se reiniciará en cada fila.
                
                for (int columna = 0; columna < sopa[fila].length; columna++)//Entramos en cada columna de la sopa de letras.
                {
                    builder_fila.append(sopa[fila][columna]);//Añadimos la columna o la letra de la columna al StringBuilder creado.
                    
                    for (int i=0;i<lista.length;i++)//Entramos en la lista de palabras
                    {
                        if(builder_fila.indexOf(lista[i].toString())!=-1)//Buscamos a través de "indexOf" la posición en la que se encuentra el inicio de la palabra(columna) y si exite la palabra de la lista.
                        {
                            contador=1+contador;
                            resultados[i]="Fila "+fila+" Columna "+builder_fila.indexOf(lista[i].toString());//Almacenamos en "resultados", la fila, que será la variable "int fila", y la columna, que será el resultado de indexOf de la palabra de la lista, si existe.
                        }
                    }
                } 
            }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        
        // 8.- Mostramos por pantalla el array de resultados y cuántas palabras se han encontrado
        System.out.println("Resultado de la búsqueda horizontal: "+Arrays.toString(resultados));
        System.out.println("Número de palabras encontradas: "+contador);
    }
}
