package tarea1;

/**
 * Provincias de Andaluc�a.
 * @author Benjamin Mulero Pedrosa
 */
public class Ejercicio01 {
    
    // Definici�n del enum
    public enum provAnd {ALMERIA, CADIZ, CORDOBA, GRANADA, HUELVA, JAEN, MALAGA, SEVILLA};//Definimos una enumeraci�n, estableciendo un conjunto denominado "provAnd", con cada una de las provincias de Andaluc�a.

    
    // Programa principal
    public static void main(String[] args) {
        
        provAnd provincia;
        
        System.out.println ("PROVINCIAS DE ANDALUC�A");
        System.out.println ("-----------------------");
        
        // Vamos mostrando cada uno de los posibles valores del enum
        provincia=provAnd.ALMERIA;
        System.out.println("Provincia: " + provincia);
        
        provincia=provAnd.CADIZ;
        System.out.println("Provincia: " + provincia);
        
        provincia=provAnd.CORDOBA;
        System.out.println("Provincia: " + provincia);
        
        provincia=provAnd.GRANADA;
        System.out.println("Provincia: " + provincia);
        
        provincia=provAnd.HUELVA;
        System.out.println("Provincia: " + provincia);
        
        provincia=provAnd.JAEN;
        System.out.println("Provincia: " + provincia);
        
        provincia=provAnd.MALAGA;
        System.out.println("Provincia: " + provincia);
        
        provincia=provAnd.SEVILLA;
        System.out.println("Provincia: " + provincia);
        
        
        
        // (no hace falta estructurar el programa en entrada/procesamiento/salida)

    }
    
}

