package tarea07;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;


/** Ejercicio 5. Clasificación de fechas por día de la semana
 * @author profe
 */
public class Ejercicio05 {

    public static void main(String[] args) throws ParseException {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int YEAR_MIN = 1900;
        final int YEAR_MAX = 2100;
        //Variables
        LocalDate fechaFija=null;//LocalDate (fecha 1 de cada mes) desde el cual se inicia el proceso de conseguir los días y se tienen la referencia del mes.
        LocalDate fechaCambia = null;//Se almacena la nueva fecha obtenida  
        LocalDate next=null;
        //Variables de uso para señalar al método donde almacenar las fechas en la estructura de datos.
        DayOfWeek lunes=null;
        DayOfWeek martes=null;
        DayOfWeek miercoles=null;
        DayOfWeek jueves=null; 
        DayOfWeek viernes=null;
        DayOfWeek sabado=null;
        DayOfWeek domingo=null;
        HashMap<Month, HashMap<DayOfWeek, HashSet<LocalDate>>>calendario=new HashMap<Month, HashMap<DayOfWeek, HashSet<LocalDate>>>();//Estructura de datos
        DateTimeFormatter nuevoFormato=DateTimeFormatter.ofPattern("dd/MM/yyyy");//Patrón para dar formato a la fecha a sacarla por pantalla
        int año=0;//Variable que almacena el año introducido por teclado
        boolean binario;//Variable para salir del bucle al introducir el año.
        Scanner teclado = new Scanner(System.in);//Scanner

     
        //Se pide un año del 1900 al 2100 (ambos incluidos), en caso de error se pedirá un número entero dentro del intervalo.
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("CLASIFICACIÓN DE FECHAS DE UN AÑO POR DÍA DE LA SEMANA");
        System.out.println("------------------------------------------------------");
        do{
            try{
               do{
                   binario=false;
                   System.out.printf ("Introduzca un año (1900-2100):  ");
                   año=teclado.nextInt();
               }while((año<YEAR_MIN)||(año>YEAR_MAX));
            }catch(InputMismatchException e){
                System.err.printf ("Error de lectura: no es un número entero válido."+"\n");
                teclado.nextLine(); 
                binario=true;
            }
        }while(binario);
        
        
        
        
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        //Usamos un for con otro anidado para ingresar los meses y los días. Iniciamos los meses y los días(de lunes a domingo) desde 1 (i=1,j=1) ya que los métodos
        //inician el establecimiento de los meses y días desde el número 1. Como límite en los for, añadimos un número de más para encajar las iteraciones.
        //(13 y 8)
        for (int i=1;i<13;i++){
            calendario.put(Month.of(i),new HashMap<>()
            {
                {
                    for (int j=1;j<8;j++)
                    {
                    put(DayOfWeek.of(j),new HashSet<>()
                    {
                        {;
                        }
                    });
                    }
                }
            });
        }
        
        
        //Se introduce a cada variable el día al cual corresponde.
        lunes=lunes.MONDAY;
        martes=martes.TUESDAY;
        miercoles=miercoles.WEDNESDAY;
        jueves=jueves.THURSDAY;
        viernes=viernes.FRIDAY;
        sabado=sabado.SATURDAY;
        domingo=domingo.SUNDAY;
        
        //Un método para almacenar todas las fechas según el día
        introducDias(fechaFija, fechaCambia,  calendario, año, next,lunes);
        introducDias(fechaFija, fechaCambia,  calendario, año, next,martes);
        introducDias(fechaFija, fechaCambia,  calendario, año, next,miercoles);
        introducDias(fechaFija, fechaCambia,  calendario, año, next,jueves);
        introducDias(fechaFija, fechaCambia,  calendario, año, next,viernes);
        introducDias(fechaFija, fechaCambia,  calendario, año, next,sabado);
        introducDias(fechaFija, fechaCambia,  calendario, año, next,domingo);


        //Para obtener los resultados en cada petición:
        //   Primero. Creamos una estrucutra TreeSet, que nos ayudará a ordenar los resultados
        //   Segundo. Utilizamos un primer for-each para añadir las fechas al TreeSet
        //   Tercero. Utilizamos otro for-each para sacar por consola los resultados dando el formato señalado por el ejercicio y en el orden señalado. 
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        System.out.println("MUESTREO DE FECHAS");
        System.out.println("------------------");
        
        System.out.println();
        System.out.printf ("Fechas de febrero que caen en lunes: \n");
        TreeSet<LocalDate> monday = new TreeSet<LocalDate>();
        for (LocalDate fechas: calendario.get(Month.FEBRUARY).get(DayOfWeek.MONDAY)){
            monday.add(fechas);
        };
        for (LocalDate fechas: monday){
            System.out.println((fechas.format(nuevoFormato)));
        };
       
       
  
        System.out.println();
        System.out.printf ("Fechas de marzo que caen en jueves: \n");
        TreeSet<LocalDate> thursday = new TreeSet<LocalDate>();
        for (LocalDate fechas: calendario.get(Month.MARCH).get(DayOfWeek.THURSDAY)){
            thursday.add(fechas);
        };
        for (LocalDate fechas: thursday){
            System.out.println((fechas.format(nuevoFormato)));
        };

        System.out.println();
        System.out.printf ("Fechas de diciembre que caen en domingo: \n");
        TreeSet<LocalDate> sunday = new TreeSet<LocalDate>();
        for (LocalDate fechas: calendario.get(Month.DECEMBER).get(DayOfWeek.SUNDAY)){
            sunday.add(fechas);
        };
        for (LocalDate fechas: sunday){
            System.out.println((fechas.format(nuevoFormato)));
        };
        System.out.println();
        
        
    }

    

//Creamos un método para almacenar en la estructura, en que fechas cae un día 
//determinado de la semana, en un més determinado y en un año determinado.
//Ej. ¿En que fechas del més de febrero del año 2122 caen los lunes?:7, 14, 21 y 28 de febrero.
//Usamos for para entrar en la estructura de datos "calendario". Para añadir las fechas, 
//usamos un bucle "while", en el cual entramos y permaneceremos mientras:
    //1. El número de mes de la "fechaFija" (Día uno de cada més en cada iteración)" 
        //sea igual a la "fechaCambia" (Fecha que cambia en cada bucle del while)
    //2. El día en la interación en la que nos encontramos "mapa.get(Month.of(i)).get(DayOfWeek.of(j))" 
        //sea igual al día que queremos "calendario.get(Month.of(i)).get(DayOfWeek.of(day))" 
//De esta forma conseguimos que todos los días se almacenen en su lugar correcto. 
//Si todo se cumple, se ingresa en el mes y día de la iteración la fecha obtenida. 
//La fecha se consigue con "TemporalAdjusters.next(DayOfWeek.of(j))",que nos devuelve 
//el siguiente día del mes en cuestión que recae en el día establecido. 
//En el caso señalado sería el Lunes. Obtenemos así, todas las fechas
//en las que en un mes elegido el día del mes corresponde con el "Lunes".
public static void  introducDias(LocalDate fechaFija, LocalDate fechaCambia, HashMap<Month, HashMap<DayOfWeek, HashSet<LocalDate>>> mapa, int año, LocalDate next, DayOfWeek day){

    for (int i=1;i<13;i++)
    {
        for (int j=1;j<8;j++)
        {
            fechaFija= LocalDate.of(año, i, 1);
            fechaCambia=fechaFija;//Se igualan las fechas para entrar en el while
            while (
                    fechaFija.getMonthValue()==fechaCambia.getMonthValue()//Mismo mes
                    &&
                    mapa.get(Month.of(i)).get(DayOfWeek.of(j))==mapa.get(Month.of(i)).get(day)//Mismo día
                    )
            {
                mapa.get(Month.of(i)).get(DayOfWeek.of(j)).add(next);
                next = fechaCambia.with(TemporalAdjusters.next(DayOfWeek.of(j)));
                fechaCambia=next;
            }
        }
    }
}
}

    