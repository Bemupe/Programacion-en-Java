package tarea03;



import java.time.LocalDate;
import libtarea3.CuentaBancaria;
// Incluir el resto de los imports que se necesiten
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


/**
 * Ejercicio 1: Uso de cuentas bancarias.
 * @author Benjamin Mulero Pedrosa
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // 1. Declaración de tres variables referencia a objetos instancia de la clase CuentaBancaria
        CuentaBancaria cuentaPrivada, cuentaConjunta, cuentaFamiliar;
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        System.out.println("USANDO CUENTAS BANCARIAS");
        System.out.println("------------------------");
        System.out.printf ("Fecha actual: %s\n", LocalDate.now());
        System.out.println();

        // 2.- Instanciación de tres objetos CuentaBancaria
        //La instanciación de las tres variables, correspondería a lo señalado a lo que se observa
        //seguidamente pero de forma deshabilitada, debido a que su 
        //instanciación y asignación la establezco en los puntos 2.3, 2.4, 2.5, 
        //para que el "ID" sea el mismo, puesto que este se va asignando conforme se crean las cuentas.
        
        //cuentaPrivada = new CuentaBancaria();
        //cuentaConjunta= new CuentaBancaria();
        //cuentaFamiliar= new CuentaBancaria();
        System.out.println("Creación de cuentas (constructores)");
        System.out.println("-----------------------------------");
        
        // 2.1.- Intento de crear una cuenta con fecha no válida (hay gestionar la posible excepción)         
        try
        {
            System.out.printf ("Intentando crear cuenta privada con una fecha válida.\n");
            cuentaPrivada = new CuentaBancaria(0,LocalDate.parse("01/09/2027"));
        }
        catch (Exception a) 
        {
            System.out.printf("Error: La fecha es superior a la fecha actual o el formato no es válido (Correcto aaaa-mm-dd. Ej.2021-11-16)\n");
            //También sería correcto poner "System.err.printf", pero el error saldría al final y en rojo y no saldría como el modelo del ejercicio//
        }

        // 2.2.- Intento de crear una cuenta con saldo no válido (hay gestionar la posible excepción)
        try
        {
            System.out.printf ("\nIntentando crear cuenta privada con un saldo no válido.\n");  
            cuentaPrivada = new CuentaBancaria(-200.00);
        } 
        catch (Exception b)
        {
            System.out.printf("Error:Parámetros de creación de la cuenta inválidos. Saldo inicial: -200,00\n");
        }

        // 2.3.- Creación de una cuenta válida usando el constructor de tres parámetros
        System.out.printf ("\nCreando cuenta privada válida con un constructor con tres parámetros...\n");
        cuentaPrivada = new CuentaBancaria(1000.00,LocalDate.parse("2021-07-01"),-200.00);
        System.out.printf ("Cuenta privada creada: %s\n",cuentaPrivada.toString());
        
        // 2.4.- Creación de una cuenta válida usando el constructor de dos parámetros        
        System.out.printf ("\nCreando cuenta conjunta válida con un constructor con dos parámetros...\n");
        cuentaConjunta = new CuentaBancaria(200.00,LocalDate.parse("2021-07-01"));
        System.out.printf ("Cuenta conjunta creada: %s\n",cuentaConjunta.toString());

        
        // 2.5.- Creación de una cuenta válida usando el constructor sin parámetros        
        System.out.printf ("\nCreando cuenta familiar válida con un constructor con tres parámetros...\n");
        cuentaFamiliar = new CuentaBancaria();
        System.out.printf ("Cuenta familiar creada: %s\n",cuentaFamiliar.toString()+"\n");

                
        
        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        // Dado que se va a ir mostrando información de salida a la vez que 
        // se van realizando operaciones, podemos considerar en este caso
        // que el procesamiento y la salida de resultado van unidos y "mezclados"
        
        // 3.- Obtención de información de la cuenta privada
        System.out.printf ("Prueba de los getters de la cuenta privada:");
        System.out.printf ("\n"+"-------------------------------------------"+"\n");
        System.out.printf ("Id: %s\n",cuentaPrivada.getId());
        System.out.printf ("Fecha de creación: %s\n",cuentaPrivada.getFechaCreacion());
        System.out.printf ("Límite descubierto: % .2f\n",cuentaPrivada.getLimiteDescubierto());
        System.out.printf ("Está embargada: %s\n",cuentaPrivada.isEmbargada());
        System.out.printf ("Está en descubierto: %s\n",cuentaPrivada.isDescubierta());
        System.out.printf ("Número de días que lleva la cuenta abierta: %s\n",cuentaPrivada.getDiasCuenta()+"\n");
        

        
        // 4.- Realización de operaciones sobre las cuentas
        System.out.printf ("Realización de operaciones sobre las cuentas");
        System.out.printf ("\n"+"--------------------------------------------"+"\n");
        System.out.printf ("Ingresamos 100 euros en la cuenta familiar...\n");
        cuentaFamiliar.ingresar​(100);
        System.out.printf ("Extraemos 100 euros de la cuenta conjunta...\n");
        cuentaConjunta.extraer​(100);
        System.out.printf ("Transferimos 1100 euros de la cuenta privada a la familiar...\n");
        cuentaPrivada.transferir(1100,cuentaFamiliar);
        
        
        
        // 5.- Estado final de las cuentas
        System.out.printf ("\n"+"Estado final de las cuentas:");
        System.out.printf ("\n"+"----------------------------"+"\n");
        System.out.printf ("Estado final de las cuenta privada:  %s\n",cuentaPrivada.toString());
        System.out.printf ("Estado final de las cuenta conjunta: %s\n",cuentaConjunta.toString());
        System.out.printf ("Estado final de las cuenta familiar: %s\n",cuentaFamiliar.toString());
        
        
    }
    
}
