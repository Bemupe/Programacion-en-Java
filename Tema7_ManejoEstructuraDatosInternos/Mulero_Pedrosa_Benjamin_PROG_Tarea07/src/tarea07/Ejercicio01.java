package tarea07;

import java.util.HashSet;
import static tarea07.Utilidades.colorAleatorio;

/**
 * Ejercicio 1. Combinando colores.
 * @author Profe
 */
public class Ejercicio01 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        final int CANTIDAD_COLORES = 3;
        HashSet<String> c1=new HashSet<String>();
        HashSet<String> c2=new HashSet<String>();
        HashSet<String> union=new HashSet<String>();
        HashSet<String> interseccion=new HashSet<String>();
        HashSet<String> diferencia=new HashSet<String>();

        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // No hay, pues se usa un número fijo de elementos aleatorios
        System.out.println("CONJUNTOS DE COLORES");
        System.out.println("--------------------");
        
        
        

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        // Rellenamos los conjuntos con aleatorios hasta que haya CANTIDAD_NUMEROS
        
        //Al ser un conjunto, al introducir un nuevo color, si el color aleatorio 
        //coincide con el ya existente en el conjunto, este no se introducirá, dado 
        //que en los conjuntos no se repite los elementos. Para asegurarme que 
        //se introduce el número de elementos requeridos, utilizamos un "While" 
        //y el método "size()". De esta forma, hasta que el tamaño 
        //de la lista no sea de CANTIDAD_COLORES (3), se ingresarán elementos, 
        //siendo estos finalmente distintos.  
        //Para ahorrar código podría intro
        
        while (c1.size()<CANTIDAD_COLORES){
            c1.add(colorAleatorio());
        }
        while (c2.size()<CANTIDAD_COLORES){
           c2.add(colorAleatorio());
        }      
        
        // Cálculo de la Unión de los dos conjuntos 
        
        //Añadimos primero el conjunto C1 al conjunto "union", y posteriormente
        //añadimos el conjunto C2 al conjunto "union", de tal forma que obtenemos
        //un conjunto "union", con todos los elementos de cada conjunto, pero sin 
        //elementos repetidos.
        union.addAll(c1);
        union.addAll(c2);
       
        // Cálculo de la Intersección de los conjuntos
        
        //Primero añadimos todo el conjunto C1 al conjunto "interseccion", y luego
        //hacemos la intersección con los elementos introducidos en el conjunto "intersección"
        // y los elementos del conjunto C2.
        interseccion.addAll(c1);
        interseccion.retainAll(c2);     
        
        // Cálculo de la Diferencia de los conjuntos
        
        //Primero añadimos todo el conjunto C1 al conjunto diferencia, y luego
        //hacemos la diferencia con los elementos introducidos en el conjunto "diferencia"
        // y los elementos del conjunto C2.        
        diferencia.addAll(c1);
        diferencia.removeAll(c2);
        
        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        // Rellenamos los conjuntos
        System.out.println("Conjunto C1: "+c1+"\n"+"Conjunto C2: "+c2);
        // Cálculo de la Unión de los dos conjuntos 
        System.out.println("Unión C1 y C2:"+union);
        // Cálculo de la Intersección de los conjuntos
        System.out.println("Intersección C1 y C2:"+interseccion);
        // Cálculo de la Diferencia de los conjuntos
        System.out.println("Diferencia C1-C2:"+diferencia);
    }
   
}
