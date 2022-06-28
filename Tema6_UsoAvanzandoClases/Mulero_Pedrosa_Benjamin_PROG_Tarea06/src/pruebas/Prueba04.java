package pruebas;

import domotica.CasaDomotica;
import domotica.dispositivos.Bombilla;
import domotica.dispositivos.Cerradura;

/**
 * Programa de pruebas la clase CasaDomotica: método toString
 */
public class Prueba04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //        PRUEBA DE CASA DOMÓTICA: TOSTRING
        //----------------------------------------------
        System.out.println("------------------------------------");
        System.out.println("4. PRUEBA DE CASA DOMÓTICA: TOSTRING");
        System.out.println("------------------------------------");

        // Instanciamos la casa domótica
        System.out.printf("Instanciamos una casa domótica de prueba: \n");
        CasaDomotica casa = new CasaDomotica(
                "Elvis Presley",
                "Casa de un rockero",
                new Bombilla("b1.1", 1),
                new Cerradura("c1.1", 1),
                new Bombilla("b1.2", 1),
                new Bombilla("c3.1", 3),
                new Bombilla("b3.1", 3),
                new Bombilla("b4.1", 4),
                new Cerradura("c4.1", 4)
        );
        System.out.printf("Casa domótica creada.\n");
        System.out.printf("Número de dispositivos totales: %d\n", casa.getNumDispositivos());
        System.out.printf("Número de bombillas: %d\n", casa.getNumBombillas());
        System.out.println();
        System.out.println(casa);

        // Activamos todas las cerraduras
        System.out.printf("Activamos todas las cerraduras de la casa.\n");
        int cerradurasActivadas = casa.cerrarCerraduras();
        System.out.printf("Cerraduras activadas: %d\n", cerradurasActivadas);
        System.out.println();
        System.out.println(casa);

        // Activamos todos los dispositivos que sean activables
        System.out.printf("Activamos todos los dispositivos Activables de la casa.\n");
        int dispositivosActivados = casa.activarDispositivosActivables();
        System.out.printf("Todos los dispositivos activados: %d\n", dispositivosActivados);
        System.out.println();
        System.out.println(casa);

    }

}
