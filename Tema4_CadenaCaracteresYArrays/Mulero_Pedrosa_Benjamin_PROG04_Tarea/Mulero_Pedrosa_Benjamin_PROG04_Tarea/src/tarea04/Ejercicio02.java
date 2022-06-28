package tarea04;

import java.util.Arrays;


/**
 * Ejercicio 2. Reconocimiento de palíndromos.
 * @author Nombre y apellidos del alumno/a
 */

public class Ejercicio02 {
    
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        
        // Variables de entrada
        // 1.- Declaración del array de objetos String de entrada
        // (Textos "Reconocer", "AMANECER", "Esto no es un palindromo",
        //    "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
        //    "A man a plan and a canal, Panama", "No deseo ese don..."
        String[] palindromos={"\"Reconocer\";","\"AMANECER\";","\"Esto no es un palindromo\";",//Establecemos los textos con todo incluido como señala el ejercicio(comas, punto y comas, dos puntos, mayúsculas..)
            "\"Dabale arroz a la zorra el abad.\";","\"A man, a plan, a canal: Panama.\";",
            "\"A man a plan and a canal, Panama.\";","\"No deseo ese don...\"."};
        
        String[] elimi_espa_tabu_retor =new String [palindromos.length];//Array de string donde se alamcenará los posibles palíndromos, sin espacios, sin tabulaciones y sin retornos.
        String[] elimi_puntos=new String [palindromos.length];//Array de string donde se alamcenará los posibles palíndromos sin espacios, sin tabulaciones, sin retornos y sin puntos.
        String[] conver_minuscula=new String [palindromos.length];//Array de string donde se alamcenará los posibles palíndromos sin, espacios, tabulaciones, retornos, ni puntos, y en mayúsculas.
        // Variables de salida
        // 2.- Declaración de un array de boolean para los resultados
        boolean[] resultados;
        // Variables auxiliares

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("RECONOCIMIENTO DE PALÍNDROMOS");
        System.out.println("-----------------------------");

        // 3.- Reservamos espacio para el array de resultados (procura no usar un literal)
        resultados=new boolean[palindromos.length];//Reservamos el espacio sin usar literal
        // 4.- Mostramos el array de textos por pantalla
        int contador=0;
        for (int i=0;i<palindromos.length;i++)
                {
                    contador=1+contador;
                     System.out.println("-Texto "+contador+" : "+palindromos[i].toString());
                }

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 5.- Recorremos de nuevo el array de textos
           // 5.1.- Para cada texto comprobamos si es palíndromo
           // Habrá que "limpiar" los textos de espacios y signos de puntuación
           // 5.2.- Si se trata de un palíndromo, se almacena el valor true en el
           // array de salida. Si no, se almacena false
           //LIMPIAMOS
           for (int i=0;i<palindromos.length;i++)//Con distintos for, eliminamos puntos, retornos, 
               //espacios.. y lo pasamos a letra minúscula. Finalmente lo alamacenamos todo modificado en "conver_minuscula".
           {
               elimi_espa_tabu_retor[i]=palindromos[i].replaceAll("\\s","");
           }
           for (int i=0;i<palindromos.length;i++)
           {
               elimi_puntos[i]= elimi_espa_tabu_retor[i].replaceAll("\\p{Punct}","");
           }
           for (int i=0;i<palindromos.length;i++)
           {
               conver_minuscula[i]=elimi_puntos[i].toLowerCase();
           }
           
           //VEMOS SI ES PALÍDNROMO
           for (int i=0;i<conver_minuscula.length;i++)//Uso un for, que crea, en cada 
               //iteración, un StringBuilder para usar "reverse" y dar la vuelta a la palabra. 
               //De esta forma, comparo con la palabra que se encuentra en el orden correcto (array "conver_minuscula") 
               //y ver sin coinciden.Si coinciden es un palíndromo.
           {
               StringBuilder pala_alreves = new StringBuilder();
               pala_alreves.append(conver_minuscula[i].toString());
               pala_alreves=pala_alreves.reverse();
               if (pala_alreves.toString().equals(conver_minuscula[i].toString()))
               {
                   resultados[i]=true;
               }
               else
               {
                   resultados[i]=false;
               };
           }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADOS OBTENIDOS");
        System.out.println("--------------------");
        
        // 6.- Mostramos por pantalla el array de resultados
        System.out.println("Palíndromos encontrados: "+Arrays.toString(resultados)); 
    }
}