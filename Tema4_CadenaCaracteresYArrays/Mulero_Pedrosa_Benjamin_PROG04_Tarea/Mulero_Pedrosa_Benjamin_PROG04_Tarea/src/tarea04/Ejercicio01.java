package tarea04;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Ejercicio 1. Cálculo de puntuaciones.
 * @author Nombre y apellidos del alumno/a
 */

public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        //Establezco 4 patrones que se irán aplicando a array de objetos para separar las partidas válidas de las invalidas.
        Pattern patron1= Pattern.compile("[XxOo]");
        Pattern patron2= Pattern.compile("[XxOo]-?[XxOo]?");
        Pattern patron3= Pattern.compile("[XxOo]-?[XxOo]-?[XxOo]");
        Pattern patron4= Pattern.compile("[XxOo]-?[XxOo]-?[XxOo]-?[XxOo]?");
        
        // Variables de entrada
        // 1.- Declaramos un array de objetos String (anotaciones) 
        // con el contenido que se nos pide en el enunciado
        String[] anotaciones={
            "a", "a-b", "X-A", "O-O-B", "X--X", "O-X-", 
            "-X-X", "O-X-O-X-O", "o", "O-o", "X", "o-x-o", "x", "x-x", 
            "O-x-X", "X-X-X", "x-X-X-x"};
        // Variables de salida
        String[] anota_invalid={
            "a", "a-b", "X-A", "O-O-B", "X--X", "O-X-", 
            "-X-X", "O-X-O-X-O", "o", "O-o", "X", "o-x-o", "x", "x-x", 
            "O-x-X", "X-X-X", "x-X-X-x"};//Establezco un array de objetos igual que "anotaciones", para obtener las anotaciones inválidas eliminando las válidas.
        String[] anota_vali=new String[17];//Estableco un array vacío para ir introduciendo las anotaciones válidas.
        StringBuilder puntuaciones = new StringBuilder();//StringBuilder para crear la salida de las puntuaciones.
        // Variables auxiliares
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CÁLCULO DE PUNTUACIONES");
        System.out.println("-----------------------");
        // 2.- Mostramos por pantalla el contenido del array de anotaciones
        System.out.println("Anotaciones obtenidas de cada mano del juego:");
        System.out.println(Arrays.toString(anotaciones));
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 3.- Recorremos cada elemento del array
        for (int i=0;i<anotaciones.length;i++)//Aplicamos patrón1 al array "anotaciones" a través de un for.
        {
            Matcher a=patron1.matcher(anotaciones[i]);
            if(a.matches())
            {
                anota_vali[i]=anotaciones[i];//Introducimos el objeto que cumple el patrón en el array de objetos válidos.
                anota_invalid[i] = null;//Anulamos la posición donde se encuentra el objeto que cumple el patrón, obteniendo al final las anotaciones inválidas. 
            }
        }
        for (int i=0;i<anotaciones.length;i++)//Aplicamos patrón2 realizamos la misma operación 
        {
            Matcher a=patron2.matcher(anotaciones[i]);
            if(a.matches())
            {
                anota_vali[i]=anotaciones[i];
                anota_invalid[i] = null;
            }
        }
        for (int i=0;i<anotaciones.length;i++)//Aplicamos patrón3 realizamos la misma operación 
        {
            Matcher a=patron3.matcher(anotaciones[i]);
            if(a.matches())
            {
                anota_vali[i]=anotaciones[i];
                anota_invalid[i] = null;
            }
        }
        for (int i=0;i<anotaciones.length;i++)//Aplicamos patrón realizamos la misma operación 
        {
            Matcher a=patron4.matcher(anotaciones[i]);
            if(a.matches())
            {
                anota_vali[i]=anotaciones[i];
                anota_invalid[i] = null;
            }
        }
            // 3.1.- Si el elemento "encaja" con el patrón (anotación válida), se calcula su puntuación
                // Para ello habrá que descomponer la anotación en cada uno de sus elementos,
                // calcular su valor y sumarlos.
            // 3.2.- Si no "encaja" con el patrón, la anotación será inválida y su puntuación -1
            // 3.3.- Las puntuaciones obtenidas se "acumulan" o "concatenan" separadas por comas en un objeto de tipo StringBuilder
                for (int i=0;i<anota_vali.length;i++)//Usamos for según la cantidad de anota_vali, 
                    //de tal forma que, si es null la puntuación es -1, si no lo es contabilizamos los puntos. Introducimos en StringBuilder.
                {
                    if(anota_vali[i]==null)
                    {
                        puntuaciones.append("-1, "); 
                    }
                    else
                    {
                        int posicion, contadorx = 0;
                        posicion = anota_vali[i].indexOf("x");
                        while (posicion != -1)
                        {
                            contadorx++;
                            posicion = anota_vali[i].indexOf("x", posicion + 1);
                        }
                        posicion = anota_vali[i].indexOf("X");
                        while (posicion != -1) 
                        {
                            contadorx++;
                            posicion = anota_vali[i].indexOf("X", posicion + 1);   
                        }
                        puntuaciones.append(String.valueOf(contadorx)+", ");
                    }
                }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO: PUNTUACIONES CALCULADAS");
        System.out.println("----------------------------------");

        // 4.- Mostramos por pantalla el resultado final
        
        // 4.1.- Lista completa de puntuaciones de cada mano
        puntuaciones.deleteCharAt(puntuaciones.length()- 1);//Eliminamos el caracter "," y el espacio para que sea idéntico a la tarea.
        puntuaciones.deleteCharAt(puntuaciones.length()- 1);     
        System.out.println("Puntuaciones: "+puntuaciones+".");//Imprimimos puntuaciones
        // 4.2.- Número de anotaciones válidas
        int nota_validas=0;
        for (int i=0;i<anota_vali.length;i++)//Contabilizamos el número de notaciones válidas con un for, descartando las nulas, e imprmimos resultados. 
        {
            if (anota_vali[i]!=null)
            {
                nota_validas=1+nota_validas;
            }
        }
        System.out.println("Número de anotaciones válidas: "+nota_validas);  
        // 4.3.- Número de anotaciones no válidas
        int nota_invalidas=0;
        for (int i=0;i<anota_invalid.length;i++)//Contabilizamos el número de notaciones inválidas con un for, descartando las nulas, e imprmimos resultados. 
        {
            if (anota_invalid[i]!=null)
            {
                nota_invalidas=1+nota_invalidas;
            }
        }
        System.out.println("Número de anotaciones inválidas: "+nota_invalidas);
    }

}
