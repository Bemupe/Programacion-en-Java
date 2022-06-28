package tarea07;

import java.util.Collections;
import java.util.LinkedList;

/** Ejercicio 6. Ordenación de citas literarias
 * @author profe
 */
public class Ejercicio06 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        LinkedList<CitaLiteraria> lista=new LinkedList<CitaLiteraria>();//Lista de las citas literarias
        String citas="Soy el mejor en morir en la escena,El mundo acaba hoy,Silba una vez y vendré siempre,Un invitado invita a cien";//String con todas la citas
        String libros="Libro 1,Libro 2,Libro 3,Libro 4,Libro 5";//String con los distintos libros
        int contador=0;

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        //Introducimos en un array de String, las citas y los distintos libros, 
        //utilizando un "split" con el caracter de la "coma", para hacer referencia a la separación.
        String[] citaSeparada = citas.split(",");
        String[] books=libros.split(",");
        
        // Rellenamos la lista con las citas literarias. Usamos un for (4 iteraciones, una por cada línea) con 4 condicinales, 
        //cada uno de los cuales, en cada iteración del bucle, introducirá cada línea de datos que nos pide el ejercicio.
        for (int i=0;i<4;i++){
            String obras []  = null;
              
            if (citaSeparada[i].equals(citaSeparada[0])){ 
                obras = new String[1];
                for (int j=0;j<obras.length;j++){
                obras[j]=books[j];
                }
                lista.add(new CitaLiteraria(citaSeparada[i],obras));
            } 

            if (citaSeparada[i].equals(citaSeparada[1])){
                obras = new String[2];
                for (int j=0;j<obras.length;j++){
                obras[j]=books[j];
                } 
                lista.add(new CitaLiteraria(citaSeparada[i],obras));  
            }
              
            if (citaSeparada[i].equals(citaSeparada[2])){
                obras = new String[3];
                for (int j=0;j<obras.length;j++){
                obras[j]=books[2+j];
                }
                lista.add(new CitaLiteraria(citaSeparada[i],obras));  
            }
     
            if (citaSeparada[i].equals(citaSeparada[3])){
                obras = new String[0];
                lista.add(new CitaLiteraria(citaSeparada[i],obras));  
              
            }      
        }
            
        System.out.println("ORDENACIÓN DE CITAS LITERARIAS");
        System.out.println("------------------------------");
        System.out.println("Contenido inicial de la lista");

        // Mostramos el contenido inicial de la lista. Usamos un for-each
        for (CitaLiteraria cita: lista){
            contador++;
            System.out.println(contador+"."+cita);};
        //----------------------------------------------
        //     Procesamiento + Salida de resultados
        //----------------------------------------------
        //Para hacer cada ordenación, creamos un una clase que implementa el comparador para los objetos "CitasLiterarias". 
        //Dentro de ella, establecemos un método que retornará la posición según el orden que queramos conseguir 
        //(alfabético, cantidad de caracteres, número de obras).
        //Para el uso del comparador creado, usamos "Collections.sort(estuctura de datos,clase comparador)
        //(Ej.Collections.sort(lista, new ComparadorCitasPorTexto()));" 
        //Seguidamente sacamos por consola la estrucutura de datos y obtenemos la ordenación deseada.
        
        //Ordenación de la lista por texto de la cita (alfabético) y la mostramos por pantalla. 
        System.out.println();
        System.out.println();
        System.out.println("Ordenación de la lista por texto de la cita (alfabético):");
        contador=0;
        for (int i=0;i<4;i++){
            contador++;
            Collections.sort(lista, new ComparadorCitasPorTexto());
            System.out.println(contador+"." + lista.get(i));
        }

        // Ordenación de la lista por longitud de la cita y la mostramos por pantalla
        System.out.println();
        System.out.println();
        System.out.println("Ordenación de la lista por longitud de la cita:");
        contador=0;
        for (int i=0;i<4;i++){
            contador++;
            Collections.sort(lista, new ComparadorCitasPorLongitud());
            System.out.println(contador+"." + lista.get(i));
        }
          
        // Ordenación de la lista por número de obras en las que aparece la cita y la mostramos por pantalla
        System.out.println();
        System.out.println();
        System.out.println("Ordenación de la lista por número de obras en las que aparece la cita y la mostramos por pantalla:");
        contador=0;
        for (int i=0;i<4;i++){
            contador++;
            Collections.sort(lista, new ComparadorCitasPorNumObras());
            System.out.println(contador+"." + lista.get(i));
        }

    }

   
            
}

