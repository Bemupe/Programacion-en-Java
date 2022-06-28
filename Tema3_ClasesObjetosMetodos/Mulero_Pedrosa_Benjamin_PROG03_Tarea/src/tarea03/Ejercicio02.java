 package tarea03;

// Incluir los imports que se necesiten

import java.util.Random;
import libtarea3.Dado;



/**
 * Ejercicio 2: Lanzando los dados.
 * @author Nombre alumno/a
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada

        // Variables de salida
        // (no hace falta ninguna)
        
        // Variables auxiliares


        System.out.println("LANZANDO LOS DADOS");
        System.out.println("------------------");
        System.out.println();

        //----------------------------------------------
        //               Análisis inicial
        //----------------------------------------------        
        // 1. Consulta de valores iniciales
        System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES");
        System.out.println("---------------------------------------");
    

        // 1.1. Número total de dados creados
        System.out.printf ("Número de total de dados creados hasta el momento: %s\n",Dado.getNumeroDadosCreados());
        
        // 1.2. Número total de lanzamientos
        System.out.printf ("Número de total de lanzamientos llevados acabo hasta el momento: %s\n",Dado.getNumeroLanzamientosGlobal());
        
        // 1.3. Consulta de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar)   
        System.out.printf ("Número de veces que se ha obtenido 1: %s\n",Dado.getNumeroVecesCaraGlobal​(1));
        System.out.printf ("Número de veces que se ha obtenido 2: %s\n",Dado.getNumeroVecesCaraGlobal​(2));
        System.out.printf ("Número de veces que se ha obtenido 3: %s\n",Dado.getNumeroVecesCaraGlobal​(3));
        System.out.printf ("Número de veces que se ha obtenido 4: %s\n",Dado.getNumeroVecesCaraGlobal​(4)+"\n");
        //----------------------------------------------
        //      Creación y lanzamiento de dados
        //----------------------------------------------
        System.out.println();
        System.out.println("2.- CREACIÓN Y LANZAMIENTO DE DADOS");
        System.out.println("-----------------------------------");
        // 2.1. Intentos de creación 
        // Se intentan crear 10 dados que tengan aleatoriamente entre 0 y 8 caras (bucle)
        // Sólo algunas llamadas al constructor funcionarán y en esos casos es cuando se podrá lanzar el dado
        // Otras harán que salte una excepción IllegalArgumentException
        // Habrá que recogerla y mostrar el mensaje de error por pantalla

        for (int i=1;0+i<=10;++i) 
        {
            Random objetoRandom= new Random();
            int a=objetoRandom.nextInt(9);
            
            try
            {   int suma=0;
                Dado diezDados=new Dado(a);
                System.out.printf ("\n"+"Intento %s",i+": Intentando crear dado aleatorio de "+diezDados.getNumeroCaras()+" caras. Correcto. Creado dado de "+a+" caras.\n");
                System.out.printf ("Lo lanzamos %s",a+" veces: " );
                for (int e=1;0+e<=a;++e)
                {
                    System.out.print(diezDados.lanzar());
                    System.out.print (" ");
                }
                System.out.print("\n"+"Suma total del los lanzamientos del dado: "+diezDados.getSumaPuntuacionHistorica()+"\n");
            }
            catch (Exception e)
            {
                System.out.printf ("\n"+"Intento %s",i+": Intentando crear dado aleatorio de "+a+" caras. Error. Número de caras no válido: "+a+"\n");
            }
        }
         
   
        
        //----------------------------------------------
        //         Análisis de resultados finales
        //----------------------------------------------
        // 3. Análisis de resultados una vez realizados todos los lanzamientos
        System.out.println();
        System.out.println("3.-ANÁLISIS DE RESULTADOS FINALES");
        System.out.println("---------------------------------");

        // 3.1. Número total de dados creados
        System.out.printf("Número total de dados creados hasta el momento: %s",Dado.getNumeroDadosCreados()+".");
        
        // 3.2. Número total de lanzamientos
        System.out.printf("\n"+"Número total de lanzamientos llevados acabo hasta el momento: %s",Dado.getNumeroLanzamientosGlobal()+".");
        
        // 3.3. Análisis de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar)   
        System.out.printf ("Número de veces que se ha obtenido 1 entre todos los lanzamientos de todos los dados: %s\n",Dado.getNumeroVecesCaraGlobal​(1));
        System.out.printf ("Número de veces que se ha obtenido 2 entre todos los lanzamientos de todos los dados: %s\n",Dado.getNumeroVecesCaraGlobal​(2));
        System.out.printf ("Número de veces que se ha obtenido 3 entre todos los lanzamientos de todos los dados: %s\n",Dado.getNumeroVecesCaraGlobal​(3));
        System.out.printf ("Número de veces que se ha obtenido 4 entre todos los lanzamientos de todos los dados: %s\n",Dado.getNumeroVecesCaraGlobal​(4)+"\n");

    }
}
