package domotica;

/**
 * Clase DOMOTICA.
 * "Caja de herramientas" que irá conteniendo algunas utilidades (constantes 
 * de configuración, métodos auxiliares, etc.) que podrán servir para el resto 
 * de clases del paquete. 
 * @author Benmupe
 */

public  final class  Domotica {
    /**
    * Representa la mínima ubicación (estancia o habitación) posible en 
    * una vivienda domótica.
    * {@value MIN_UBICACION}
    */
    public static final int MIN_UBICACION=1;
    /**
    * Representa la máxima ubicación posible.
    * {@value MAX_UBICACION}
    */
    public static final int MAX_UBICACION=5;

    /**
    * Constructor por defecto clase Domotica.
    */
    private Domotica () {
    }   
}
