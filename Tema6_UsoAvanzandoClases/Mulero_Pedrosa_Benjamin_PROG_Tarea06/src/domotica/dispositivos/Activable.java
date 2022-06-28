package domotica.dispositivos;
/**
 * Interfaz Activable. 
 * Las clases que implementen esta interfaz representarán objetos que podrán activarse y desactivarse.
 * @author Benmupe
 */
public interface Activable {
    //MÉTODOS DE LA INTERFAZ
    //Todos los métodos de una interfaz serán siempre public y abstract aunque no se indique. El compilador lo considerará así de forma implícita.
    /**
    * Obtiene el estado del elemento. 
    * Si está activado será true. Si no lo está será false.
    * @return Estado actual del elemento
    */
    public abstract boolean getEstado ();
    
    /**
    * Activa el elemento. 
    * @throws IllegalStateException Si el elemento ya estaba activado.
    */
    public abstract void  on ()throws IllegalStateException;
    
    /**
    * Desactiva el elemento.
    @throws IllegalStateException Si el elemento ya estaba desactivado.
    */
    public abstract void off ()throws IllegalStateException; 
       
}
