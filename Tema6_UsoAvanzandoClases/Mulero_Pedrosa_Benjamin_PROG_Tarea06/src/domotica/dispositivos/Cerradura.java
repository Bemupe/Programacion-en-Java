package domotica.dispositivos;
/**
 * Clase que representa un mecanismo de cerradura domótica. 
 * Podrá estar abierta (false o "desactivada") o cerrada (true o "activada"). 
 * @author Benmupe
 */
public  final class Cerradura extends Dispositivo implements Activable {
//ATRIBUTOS
    /**
    * Si la cerradura esta en actividad o no(true/false).
    */
    private boolean actividad;
    /**
    * El estado actual en la que se encuentra la bombilla (podra ser, "Encendida" o "Apagada").
    */
    private String estado;
    /**
    * Estado de información abierta/desactivada/false de la bombilla.
    */
    private final String abierta="Abierta";//abierta/desactivada(false)
    /**
    * Estado de información cerrada/activada/true de la bombilla.
    */
    private final String cerrada="Cerrada";//cerrada/activada(true)

//CONSTRUCTORES
    /**
    * Constructor que instancia un objeto Cerradura a partir de una descripción, ubicación y estado inicial.
    * @param descripcion Descripción del dispositivo.
    * @param ubicacion Ubicación (número de habitación) del dispositivo.
    * @param actividad Si el dispositivo, en este caso cerradura, está abierta o cerrada.
    */   
    public Cerradura (String descripcion, int ubicacion, boolean actividad){
        super(descripcion, ubicacion);//Usamos "super()", para atraer los parámetros de su padre "Dispositivos" (extends)  
        this.actividad=actividad;
    } 
    
    /**
    * Constructor que instancia un objeto Cerradura a partir de una descripción y una ubicación. 
    * La actividad inicial de la cerradura será "abierta" o "desactivada" (false).
    * @param descripcion Descripción del dispositivo.
    * @param ubicacion Ubicación (número de habitación) del dispositivo.
    */
    public Cerradura (String descripcion, int ubicacion){
        this(descripcion, ubicacion, false);//Usamos this() para llamar al constructor del mismo nombre (Cerradura), arrastrando los tres parámetros de su padre "Dispositivo" (extends)
    }

//MÉTODOS

//Implementación de los métodos de la interfaz Activable
    
    /**
    * Obtiene el estado actual de la cerradura. El valor true significa que la 
    * cerradura está cerrada. El valor false indica que está abierta. 
    * @return Estado actual de la cerradura.
    */
    @Override
    public boolean getEstado(){
        return actividad;
    
    };
    
    /**
    * Activa la cerradura (cierra)
    * cerradura está cerrada. El valor false indica que está abierta. 
    * @throws IllegalStateException Si la cerradura ya está cerrada (activada).
    */
    @Override
    public void on()throws IllegalStateException{
        if (this.actividad==true) {
            throw new IllegalStateException ("Cerradura ya activada (cerrada)");
        } else {
            this.actividad=true;
        }
    };
   
    /**
    * Desactiva la cerradura (abre). 
    * @throws IllegalStateException Si la cerradura ya está abierta (desactivada).
    */
    @Override
    public void off()throws IllegalStateException{
        if (actividad==false) {
            throw new IllegalStateException ("Cerradura ya desactivada (abierta)");
        } else {
            actividad=false;
        }
    };
    
    /**
    *Devuleve una cadena que representa el estado de la cerradura de forma textual. 
    * @return Cadena que representa el estado de la cerradura de forma textual.
    */
    @Override
    public String toString() {
        if (actividad==false){
            estado=abierta;
        } else { estado=cerrada;}
        String dispositivo;
        dispositivo= super.toString()+" estado:"+this.estado;
        return dispositivo;
    }





}
