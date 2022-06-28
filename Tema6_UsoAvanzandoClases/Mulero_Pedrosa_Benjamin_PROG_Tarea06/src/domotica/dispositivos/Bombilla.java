package domotica.dispositivos;
/**
 * Clase que representa una Bombilla domótica. 
 * Representa una lámpara domótica "inteligente". Permite la regulación de su intensidad.
 * @author Benmupe
 */
public class Bombilla extends Dispositivo implements Activable, Regulable {
//ATRIBUTOS
    /**
    * Si la bombilla esta en actividad o no(true/false).
    */
    private boolean actividad;
    /**
    * El estado actual en la que se encuentra la bombilla (podra ser, "Encendida" o "Apagada").
    */
    private String estado;
    /**
    * Nivel de intensidad en el que se encuentra la bombilla (de 0 a 10).
    */
    private int intensidad;
    /**
    * Número de veces que se manipula la Bombilla.
    */
    private int manipulacionEfectiva;
    /**
    * Estado de información encendida de la bombilla.
    */
    private final String encendido="Encendida";
    /**
    * Estado de información apagada de la bombilla.
    */
    private final String apagado="Apagada";
    /**
    * Mínima intensidad posible para una bombilla.
    * {@value MIN_INTENSIDAD}
    */
    public static final int MIN_INTENSIDAD=0;
    /**
    * Máxima intensidad posible para una bombilla.
    * {@value MAX_INTENSIDAD}
    */
    public static final int MAX_INTENSIDAD=10;
    
//CONSTRUCTORES
    /**
    * Instancia un objeto Bombilla a partir de una descripcón y una ubicación.
    * @param descripcion Descripción del dispositivo.
    * @param ubicacion Ubicación (número de habitación) del dispositivo.
    */
    public Bombilla (String descripcion, int ubicacion){
        super(descripcion, ubicacion);
        this.intensidad=MIN_INTENSIDAD;
    }

//MÉTODOS
//Métodos propio de la clase
    /**
    * Obtiene el número de veces que la bombilla ha sido manipulada.
    * @return Número de veces que la bombilla ha sido manipulada.
    */
    public int getNumVecesManipulada (){
        return manipulacionEfectiva;
    }
    
    
    /**
    * Devuelve una cadena que representa el estado de la bombilla de forma textual.
    * @return Cadena que representa el estado de la bombilla de forma textual.
    */
    @Override
    public String toString() {
        if (actividad==false){
            estado=apagado;
        } else { estado=encendido;}
        String dispositivo;
        dispositivo= super.toString()
                +" estado:"+this.estado
                +" int:"+this.intensidad
                +" NVM:"+this.manipulacionEfectiva;
        return dispositivo;
    }
    
    
//Implementación de los métodos de Activable
    /**
    * Obtiene el estado actual de la bombilla. El valor true significa que la 
    * bombilla está encendida (en cualquier intensidad menos la mínima). 
    * El valor false que está apagada (mínima intensidad posible).
    * @return Estado actual de la bombilla.
    */
    @Override
    public boolean getEstado(){
        return actividad;
    };
    
    /**
    * Enciende la bombilla. Se establece su intensidad al valor máximo.
    * @throws IllegalStateException Si la bombilla ya está encendida.
    */
    @Override
    public void on()throws IllegalStateException{
        if (intensidad>0&&intensidad<=10) {
            throw new IllegalStateException ("Bombilla ya encendida");
        } else {
            manipulacionEfectiva++;
            intensidad=10;
            actividad=true;
        }
    };
    
    /**
    * Apaga la bombilla. Se establece su intensidad al valor mínimo.
    * @throws IllegalStateException Si la bombilla ya está apagada.
    */
    @Override
    public void off()throws IllegalStateException{
        if (intensidad==0) {
            throw new IllegalStateException ("Bombilla ya apagada");
        } else {
            manipulacionEfectiva++;
            intensidad=0;
            actividad=false;
        }
    };

//Implementación de los métodos de Regulables
    /**
    * Obtiene la intensidad actual de la bombilla.
    * @return Intensidad actual de la bombilla.
    */
    @Override
    public int getIntensidad(){
        return intensidad;
    
    };
    
    /**
    * Incrementa en un punto la intensidad lumínica de la bombilla. 
    * Si ya se ha alcanzado la intensidad máxima, se permanece en la 
    * intensidad máxima y no se considera que haya sido manipulada.
    * @throws IllegalStateException Si la bombilla está al máximo de intensidad.
    * @return Intensidad alcanzada tras la operación.
    */
    @Override
    public int up ()throws IllegalStateException{
        if (intensidad>=0&&intensidad<=9) {
            intensidad++;
            manipulacionEfectiva++;
        } 
        if (intensidad==10)  {
            throw new IllegalStateException ("La intensidad de la bombilla está al máximo ("+intensidad+") y no se puede subir más");
        }
        return intensidad;
    }
   
    /**
    * Decrementa en un punto la intensidad lumínica de la bombilla. 
    * Si ya se ha alcanzado la intensidad mínima, se permanece en la intensidad mínima 
    * y no se considera que haya sido manipulada.
    * @throws IllegalStateException Si la bombilla está al mínimo de intensidad.
    * @return Intensidad alcanzada tras la operación.
    */  
    @Override
    public int down ()throws IllegalStateException{
        if (intensidad>=0&&intensidad<=10) {
            intensidad--;  
            manipulacionEfectiva++;
        } 
        if (intensidad==0)  {
            throw new IllegalStateException ("La intensidad de la bombilla está al mínimo ("+intensidad+") y no se pueden bajar más ");
        }
        return intensidad; 
    }
}
