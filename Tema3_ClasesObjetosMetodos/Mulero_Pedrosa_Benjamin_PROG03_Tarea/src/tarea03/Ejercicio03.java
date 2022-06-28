package tarea03;

// Incluir los imports que se necesiten

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;



/**
 * Ejercicio 3: Horario de clases.
 *
 * @author Profesor
 */
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        boolean boole=false;//Creamos una constante inicial para ir cambiándola para obtener el resultado que deseamos en el uso de captura de excepciones con "try-catch". 
        // Variables de entrada
        int hora=0;//Creamos variables y las iniciamos.
        int minutos=0;
        // Variables de salida
        

        // Variables auxiliares

        // Objeto Scanner para lectura desde teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("HORARIO DE CLASES");
        System.out.println("-----------------");

        // 1. Creación de un objeto de la clase LocalTime con la primera hors de clase (08:00)
        LocalTime inicioClase=LocalTime.of(8,0);//Creamos la hora de inicio.
        
        // 2. Lectura por teclado y comprobación de hora y minuto
        // 2.1. Leer y comprobar la hora (debe estar entre 0 y 23)
        System.out.printf ("Introducción del horario que se desea comprobar: "+"\n");
        do//Creamos un bucle "DO-WHILE" y utilizamas una variable "boolean" para comprobar que lo introducido es correcto.
            //"DO: Anidamos un "TRY-CATCH".
                //"TRY (Anidamos un "do-while", para que se repita hasta introducir los datos correctos (intervalo 0-23))
                //CATCH"(Capturamos la excepción en caso de escribir otro caracter distinto de un número"  
            //WHILE": Utilizamos la variable "booleana" que reiniciará el bucle si no es "true"
        { 
            try
            { 
                do 
                {
                    boole=false;
                    System.out.printf ("Introduzca hora (00-23): ");
                    hora=teclado.nextInt();
                }
                while((hora<0)||(hora>23));
            }
            catch(InputMismatchException e)
            {
                System.err.printf ("Error de lectura: no es un número entero válido."+"\n");
                teclado.nextLine(); 
                boole=true;
            }
        }
        while(boole);    
    
        // 2.2.  Leer y comprobar el minuto (entre 0 y 59)
        do//Mismo mecanismo que el anterior. 
        { 
            try
            { 
                do 
                {
                    boole=false;
                    System.out.printf ("Introduzca minuto(00-59): ");
                    minutos=teclado.nextInt();
                }
                while(minutos<0||minutos>59);
            }
            catch(InputMismatchException e)
            {
                System.err.printf ("Error de lectura: no es un número entero válido."+"\n");
                teclado.nextLine(); 
                boole=true;
            }
        }
        while(boole);    

        // 3. Creación de objeto LocalTime a partir de los datos leídos por teclado
        LocalTime horaIntroducida=LocalTime.of(hora, minutos);//Creamos un LocalTime denominado horaIntroducida, en el cual introducimos las horas y minutos introducidos por teclado.
        System.out.printf ("Introduzca minuto(00-59): Hora introducida %s",horaIntroducida+"\n");
        //----------------------------------------------
        //               Procesamiento 
        //----------------------------------------------
        // 4. Obtener el rango en el que se encuentra la hora a partir de los dos objetos LocalTime
        Long minutosFaltan=ChronoUnit.MINUTES.between(horaIntroducida,inicioClase);
        LocalTime programacion=LocalTime.of(10, 0);
        LocalTime sis_Infor=LocalTime.of(12, 0);
        LocalTime ent_Desa=LocalTime.of(14, 0);
        LocalTime finClase=LocalTime.of(14, 0);
        Long minutosFinalizado=ChronoUnit.MINUTES.between(finClase,horaIntroducida);

        //----------------------------------------------
        //            Salida de resultados 
        //----------------------------------------------
        // 5. Mostrar la hora y introducida y los resultados obtenidos
        //Sacamos por pantalla los resultados, estableciendo unas condiciones con "if" y "else-if" y 
        //utilizando las variables LocalTime creadas anteriormente y los cálculos con ChronoUnit.
        
        if (horaIntroducida.isBefore(inicioClase))
        {
            System.out.printf ("Clase correspondiente: Aún no ha comenzado la jornada. Faltán %s ", minutosFaltan+ " minutos para comenzar."+"\n");
        }
        
        else if ((horaIntroducida.isAfter(inicioClase)||(horaIntroducida==inicioClase))&&(horaIntroducida.isBefore(programacion))) 
        {
            System.out.printf("Clase correspondiente: Programación."+"\n");       
        }
        
        else if ((horaIntroducida.isAfter(programacion)||(horaIntroducida==programacion))&&(horaIntroducida.isBefore(sis_Infor))) 
        {
            System.out.printf("Clase correspondiente: Sistemas informáticos."+"\n");       
        }
        
        else if ((horaIntroducida.isAfter(sis_Infor)||(horaIntroducida==sis_Infor))&&(horaIntroducida.isBefore(ent_Desa)))
        {
            System.out.printf("Clase correspondiente: Entornos de desarrollo."+"\n"); 
        }
        
        else if ((horaIntroducida.isAfter(ent_Desa))||(horaIntroducida.isBefore(ent_Desa))||(horaIntroducida==finClase)) 
        {
            System.out.printf("Clase correspondiente: La jornada ya ha finalizado. Han pasado %s ", minutosFinalizado+ " minutos desde el fin."+"\n");       
        }

    }

}
