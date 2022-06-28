package tarea07;

import java.util.ArrayList;
import java.util.HashMap;
import static tarea07.Utilidades.colorAleatorio;

/** Ejercicio 4. Clasificación de coincidentes
 * @author profe
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        final int CANTIDAD_COLORES = 15;
        ArrayList<String> lista1=new ArrayList<String>();//ArrayList lista 1
        ArrayList<String> lista2=new ArrayList<String>();//ArrayList lista 2
        HashMap<String,ArrayList<Integer>>coincidencia=new HashMap<String,ArrayList<Integer>>();//Map donde la clave es un String (color) y el valor un ArrayList formado por la posición donde coinciden los colores en ambas listas. 


        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("CLASIFICACIÓN DE COINCIDENTES");
        System.out.println("-----------------------------");
        // No hay, pues se usa un número fijo de elementos aleatorios

        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_NUMEROS
        while (lista1.size()<CANTIDAD_COLORES){
            lista1.add(colorAleatorio());
        }
        while (lista2.size()<CANTIDAD_COLORES){
            lista2.add(colorAleatorio());
        }
        System.out.println("Contenido inicial de la lista 1: "+lista1+"\n"
                +"Contenido inicial de la litas 2: "+lista2);
        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------
        //Se analiza si algún elemento en su posición de la lista 1 es igual 
        //al elemento de la misma posción en la lista 2. En el caso afirmativo,
        //si el elemento de la lista además, se encuentra entre las claves del Map, a esa clave
        //se le añade la posición (Número Integer que coincidirá en ambas listas (lista 1 y lista 2)).
        //En caso contrario, se crea un ArrayList, se introduce en el "Map coincidencia" el color coincidente (key) y
        //el ArrayList vacío (valor) y finalmente se introduce en el ArrayList(valor) la posición correspondiente.
        for (int i=0;i<CANTIDAD_COLORES;i++) { 
            if (lista1.get(i).equals(lista2.get(i))) {
                if (coincidencia.containsKey(lista1.get(i))){
                    coincidencia.get(lista1.get(i)).add(i);
                } else {
                    ArrayList<Integer> coincidenciaList = new ArrayList<Integer>();
                    coincidencia.put(lista1.get(i),coincidenciaList);
                    coincidencia.get(lista1.get(i)).add(i); 
                }
            }
        }

        
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        System.out.println("Clasificación de coincidencias: "+coincidencia);
        
        
    
    }
}
       
        


