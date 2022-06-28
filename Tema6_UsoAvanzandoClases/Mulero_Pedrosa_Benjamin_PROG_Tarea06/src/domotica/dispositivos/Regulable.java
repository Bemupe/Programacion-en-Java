package domotica.dispositivos;
/**
 * Interfaz Regulable. Las clases que implementen esta interfaz representarán 
 * objetos que permitirán regular su intensidad. 
 * @author Benmupe
 */
public interface Regulable {
    
    /**
    * Obtiene el valor regulable del elemento (intensidad).
    * @return Valor alcanzado tras la operación.
    */
    public abstract int getIntensidad ();
    
    /**
    * Incrementa el valor regulable del elementos (intensidad).
    * @return Valor alcanzado tras la operación.
    */
    public abstract int up () throws IllegalStateException;
    
    /**
    * Decrementa el valor regulable del elemento(intensidad).
    * @return Valor alcanzado tras la operación.
    */
    public abstract int down ()throws IllegalStateException; 
    
    
}
