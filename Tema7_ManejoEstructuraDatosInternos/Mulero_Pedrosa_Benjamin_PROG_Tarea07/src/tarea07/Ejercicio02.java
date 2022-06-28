package tarea07;

import java.util.HashSet;
import java.util.LinkedList;
import static tarea07.Utilidades.colorAleatorio;

/** Ejercicio 2. Búsqueda de coincidentes
 * @author profe
 */
public class Ejercicio02 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        final int CANTIDAD_COLORES = 10;
        String posicion=null;
        LinkedList<String> lista1=new LinkedList<String>();
        LinkedList<String> lista2=new LinkedList<String>();
        LinkedList<String> coloresEliminados=new LinkedList<String>();
        LinkedList<String> posicionesEliminadas=new LinkedList<String>();
        HashSet<String> setElim=new HashSet<String>();
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("BÚSQUEDA DE COINCIDENTES");
        System.out.println("------------------------");
        // No hay, pues se usa un número fijo de elementos aleatorios
        while (lista1.size()<CANTIDAD_COLORES){
            lista1.add(colorAleatorio());
        }
        while (lista2.size()<CANTIDAD_COLORES){
            lista2.add(colorAleatorio());
        }
        System.out.println("1. Contenido inicial de la lista 1: "+lista1+"\n"
                +"2. Contenido inicial de la litas 2: "+lista2);
        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_NUMEROS


        
        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------
        
        //Hay que señalar que los digitos de las posiciones que aparece en el 
        //ejercicio, corresponde al intervalo desde 0 a 9, ya que en las listas
        //y arrays, las posiciones se inician por el 0, pero podemos observar 
        //que existen 10 elementos.
        for (int i=0;i<CANTIDAD_COLORES;i++) {
            if (lista1.get(i).equals(lista2.get(i))) {
                coloresEliminados.add(lista1.get(i));
                lista1.remove(i);
                lista2.remove(i);
                lista1.add(i,"---");
                lista2.add(i,"---");
                posicion=String.valueOf(i);
                posicionesEliminadas.add(posicion);
            }
        }
        setElim.addAll(coloresEliminados);

        
        
        
        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.println(
                "Contenido final de la lista 1: "+lista1+"\n"
                +"Contenido final de la lista 2: "+lista2+"\n"
                +"Contenido final de la lista de colores eliminados: "+coloresEliminados+"\n"
                +"Contenido final de la lista de posiciones eliminadas: "+posicionesEliminadas+"\n"
                +"Contenido final del conjunto de colores eliminados: "+setElim+"\n"
                );


        
    }

}
