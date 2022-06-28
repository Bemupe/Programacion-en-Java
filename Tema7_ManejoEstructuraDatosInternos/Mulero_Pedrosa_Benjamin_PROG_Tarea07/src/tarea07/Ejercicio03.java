package tarea07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.TreeMap;
import static tarea07.Utilidades.colorAleatorio;

/** Ejercicio 3. Un color por día
 * @author profe
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        final int NUM_DIAS=5;
        HashMap<LocalDate,String> colorFecha=new HashMap<LocalDate,String>();//Podríamos haber utilizado TreeMap desde el principio para hacer la ordenación final.
        TreeMap<LocalDate,String> ordenar=new TreeMap<LocalDate,String>();//Utilizamos un TreeMap para ordenar. Hay otros métodos pero este parece el más facil.
        DateTimeFormatter nuevoFormato=DateTimeFormatter.ofPattern("dd/MM/yyyy");//Formato de fecha según ejercicio

        //LocalDate con la fecha indicada en el ejercicio. Se podría haber establecido 
        //como fecha 2022-02-28, iniciando desde ese momento el incremento de días pero 
        //entonces si se quisiera reutilizar el programa y fuera año bisiesto 
        //(febrero 29) daría error, por eso resto primero un día y luego 
        //le sumo e inicio la cuenta, salvando así el escollo.       
        //LocalDate fecha=LocalDate.parse("2022-03-01");
        LocalDate fecha=LocalDate.parse("2022-03-01");
        
        //LocalDate fecha3 = nuevoFormato.parse("31/12/2020");
        
        String color=null;//Color aleatorio que introducimos en el Hashmap.
        //String fechaString=null;
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("ASIGNACIÓN DE COLORES: UN COLOR DIFERENTE POR CADA FECHA");
        System.out.println("--------------------------------------------------------");
        // No hay entrada de datos pues la estructura se rellena elementos aleatorios

        

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        fecha= fecha.minusDays(1);//Reducimos un día la fecha establecida en el parámetro "fecha", para de esta forma añadir los días a las fechas desde el día 1.
        while (colorFecha.size()<NUM_DIAS){//Bucle para llenar el "HashMap"  
            fecha= fecha.plusDays(1);//Añadimos un día por cada iteración. Iterando hasta NUM_DIAS (5)
            color=colorAleatorio();//Introduzco el color 
            while (colorFecha.containsValue(color)==true) {//Hago que los colores a ingresar no coincidan. En el caso de no coincidir se sale del bucle y se ingresa en "HashMap".   
            color=colorAleatorio();
            };
            
           colorFecha.put(fecha,color);//Ingresamos clave valor en el HashMap.      
        }
        ordenar.putAll(colorFecha);//Introducimos los elementos e un TreeMap para ordenarlos
        
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        System.out.printf( "Contenido final del mapa de colores organizado por fechas:\n");
        
        for (LocalDate date: ordenar.keySet()){//Sacamos por pantalla con un for-each
            System.out.println(date.format(nuevoFormato)+ " = " + ordenar.get(date));
		
        };
 
    }

}
