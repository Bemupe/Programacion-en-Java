package domotica.dispositivos;
/**
 * Clase abstracta que representa un dispositivo domótico genérico. 
 * Contendrá información relativa a su identificación única, una descripción y 
 * su ubicación en la vivienda. La identificación única se genera de manera 
 * automática mediante números consecutivos empezando por el 1. 
 * @author Benmupe
 */
public abstract class Dispositivo {
//ATRIBUTOS
    /**
    * Contador id.
    */
    private static int id=1;
    /**
    * Número identificador de cada dispositivo.
    */
    private int identificador;
    /**
    * Tipo de dispositivo
    */
    private String descripcion;
    /**
    *Lugar donde se encuentra el dispositivo, representado por un número que va del 1 al 5.
    */
    private int ubicacion;
    
//CONSTRUCTORES
    
    /**
    * Constructor de un objeto dispositivo domótico a partir de una descripción 
    * y una ubicación.
    * @param descripcion Descripción del dispositivo.
    * @param ubicacion Ubicación (número de habitación) del dispositivo.
    * @throws IllegalArgumentException Si el número de la habitación no es válido.
    */
    public Dispositivo (String descripcion, int ubicacion)throws IllegalArgumentException {
        this.descripcion=descripcion;       
        if (ubicacion<domotica.Domotica.MIN_UBICACION||ubicacion>domotica.Domotica.MAX_UBICACION){            
            throw new IllegalArgumentException ("Ubicación no válida: "+ubicacion);        
        }else{           
            this.ubicacion=ubicacion;        
        }       
        this.identificador=Dispositivo.id++;
    }

//MÉTODOS
    
    /**
    * Obtiene el identificador único del dispositivo.
    * @return Id del dispositivo.
    */
    public int getId() {
        return this.identificador;
    }

    /**
    * Obtiene la descripción del dispositivo.
    * @return Descripción del dispositivo.
    */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
    * Obtiene la ubicación del dispositivo.
    * @return Ubicación del dispositivo.
    */
    public int getUbicacion() {
        return this.ubicacion;
    }
    
    /**
    * Devuleve una cadena que representa el estado de la bombilla de forma textual.
    * @return Cadena que representa el estado de la bombilla de forma textual.
    */
    @Override
    public String toString() {
        String dispositivo;
        dispositivo= "tipo: "+this.getClass().getSimpleName()+" id: "+getId()+" descripción: "+this.getDescripcion()+" ubicación: "+this.getUbicacion();
        return dispositivo;
    }

}
