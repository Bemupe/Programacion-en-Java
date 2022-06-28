package tarea05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Clase que representa un CHIP DE BICI.
 * 
 * Esta clase representa el funcionamiento de un chip de implantación a
 * bicicletas, que permitirá realizar una gestión sobre:
 * 
 * - Registro de cada bicicleta: número de serie, fecha de adquisición
 * - Actividad de cada bicicleta: kilómetros recorridos totales por la bicicleta, si está alquilada o no,
 * kilómetros recorridos durante el actual alquiler y el último alquiler, fecha y hora del actual alquiler 
 * y el último alquiler
 * - Datos globales de todas las bicicletas: total de bicicletas, bicicletas alquiladas,
 * kilómetros recorridos por todas las bicicletas.
 *
 * @author Benmupe
 */

public class ChipBici {
  
// ATRIBUTOS DE OBJETO
    // Atributos de objeto inmutables
    private final LocalDate fechaAdquisicionbici;                                               // Fecha en la que se adquiere la bici
    private final String numeroDeserie;                                                         // Número de serie de la bici
    // Atributos de objeto variables (estado)
    private int versionFirmware;                                                                //Versión del 1.0 al 10.0
    private int revisionFirmware;                                                               //Revisón del 0.1 al 0.9
    private double kmRecorridosTotales=0;                                                       //Kilometros recorridos por la bicicleta desde que se tiene
    private boolean alquilada;                                                                  //Si se alguila o no la bici
    //Información sobre el alquiler actual, si está alquilada
    private LocalDateTime fechaHoraInicioActualAlquiler=null;                                   //Si no está alquilada en ese momento el valor será null
    private double kmRecorridosDuranteActualAlquiler=0;                                         //Si no está alguilada en ese momento su valor será cero
    //Información último alquiler, si es que ha sido alquilada y devuleta alguna vez
    private LocalDateTime fechaHoraInicioUltimoAlquiler=null;                                   //Si aún no ha sido alquilada y devuelta al menos una vez, su valor será null;
    private LocalDateTime fechaHoraFinUltimoAlquiler=null;                                      //Si aún no ha sido alquilada y devuelta al menos una vez, su valor será null;
    private double kmRecorridosDuranteUltimoAlquiler=0;                                         //Si aún no ha sido alquilada y devuelta al menos una vez, su valor será cero.  
    
     
// ATRIBUTOS DE CLASE
    // Atributos de clase variables 
    private static int cantidadTotalBici = 0;                                                    //Cantidad de bicis hasta ese momento
    private static int cantidadAlquilada;                                                        //Cantidad de bicis alquiladas hasta ese momento
    private static double kmRecorridosTodasBicis=0;                                              //Cantidad de km recorridos por todas la bicis hastas ese momento
    // Atributos de clase constantes
    /**
    * Distancia máxima permitida en un trayecto.
    * {@value MAX_DISTANCIA_TRAYECTO} Km.
    */
    public static final double MAX_DISTANCIA_TRAYECTO=140;//Km
    /**
    * Versión mínima del Firmware.
    * {@value MIN_VERSION}
    */
    public static final int MIN_VERSION=1;
    /**
    * Versión máxima del Firmware.
    * {@value MAX_VERSION}
    */
    public static final int MAX_VERSION=10;       
    /**
    * Revisión mínima del Firmware.
    * {@value MIN_REVISION}
    */
    public static final int MIN_REVISION=0;
    /**
    * Revisión máxima del Firmware.
    * {@value MAX_REVISION}
    */
    public static final int MAX_REVISION=9;
    /**
    * Versión por defecto del Firmware.
    * {@value DEFAULT_VERSION}
    */
    public static final int DEFAULT_VERSION=1;
    /**
    * Revisión por defecto del Firmware.
    * {@value MIN_VERSION}
    */
    public static final int DEFAULT_REVISION=0; 
    /**
    * Fecha mínima de adquisicón de bicicleta MIN_FECHA_ADQUISICION
    *
    */
    public static final LocalDate MIN_FECHA_ADQUISICION=LocalDate.of(2020, 06, 15);


//CONSTRUCTORES 
    /**
    * Constructor con 3 parámetros que crea un objeto de ChiBici
    * @param fechaAdquisicionbici Define la fecha de adquisición de la bici.
    * @param versionFirmware Versión del firmware (tiene que estar del 1 al 10).
    * @param revisionFirmware Revisión del frimware (tiene que estar del 0 al 9).
    * @throws IllegalArgumentException Si la fecha de adquisición no es la adecuada, o la versión a revisión tampoco lo es.
    */
    public ChipBici (LocalDate fechaAdquisicionbici, int versionFirmware, int revisionFirmware) throws IllegalArgumentException {
        //Formato para la fecha
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        //Excepciones
        if (fechaAdquisicionbici==null)
            throw new IllegalArgumentException ("Fecha incorrecta: null");
        if (fechaAdquisicionbici.isBefore(MIN_FECHA_ADQUISICION))
            throw new IllegalArgumentException ("Fecha incorrecta: "+fechaAdquisicionbici.format(formato));     
        if (fechaAdquisicionbici.isAfter(LocalDate.now()))
            throw new IllegalArgumentException ("Fecha incorrecta: "+fechaAdquisicionbici.format(formato));
        if (versionFirmware<1||versionFirmware>10)
            throw new IllegalArgumentException ("Versión incorrecta: "+versionFirmware);
        if (revisionFirmware<0||revisionFirmware>9)
            throw new IllegalArgumentException ("Revisión incorrecta: "+revisionFirmware);
   
        // Si los parámetros son válidos, iniciamos los atributos con esos valores 
        numeroDeserie=String.valueOf(++ChipBici.cantidadTotalBici);
        this.fechaAdquisicionbici=fechaAdquisicionbici;
        this.versionFirmware=versionFirmware;
        this.revisionFirmware=revisionFirmware;
    
    }
 
    /**
    * Constructor con 2 parámetros que crea un objeto de ChiBici
    * @param versionFirmware Versión del firmware (tiene que estar del 1 al 10).
    * @param revisionFirmware Revisión del frimware (tiene que estar del 0 al 9).
    * @throws IllegalArgumentException Si la versión a revisión no es correcta.
    */
   
    public ChipBici (int versionFirmware, int revisionFirmware) throws IllegalArgumentException {
      //Parámetros
      this.versionFirmware=versionFirmware;
      this.revisionFirmware=revisionFirmware;
      //Excepciones  
      if (versionFirmware<1||versionFirmware>10)
            throw new IllegalArgumentException ("Versión incorrecta: "+versionFirmware);
      if (revisionFirmware<0||revisionFirmware>9)
            throw new IllegalArgumentException ("Revisión incorrecta: "+revisionFirmware);
      //Establecemos número de serie y fecha para el objeto creado
      numeroDeserie=String.valueOf(++ChipBici.cantidadTotalBici);
      fechaAdquisicionbici=LocalDate.now();
   }

    /**
    * Constructor sin parámetros que crea un objeto de ChipBici
    * 
    */
   public ChipBici()  {
      this(ChipBici.DEFAULT_VERSION,ChipBici.DEFAULT_REVISION);
   }


//MÉTODO FÁBRICA
   /**
   * Método fábrica, que devuelve un array del objeto ChipBici, con una cantidad determinada de objetos ChipBici
   * @param cantidadBicis Cantidad de ChipBicis a crear e introducir el en array de objetos 
   * @return Devuelve un array del objeto ChipBici
   * @throws IllegalArgumentException Si la cantidad de objetos no es la adecuada
   * 
   */
   public static ChipBici [] crearArrayChipBici (int cantidadBicis) throws IllegalArgumentException {
       ChipBici[] array=new ChipBici[cantidadBicis];
       if (cantidadBicis<1)
           throw new IllegalArgumentException ("Cantidad no válida: "+cantidadBicis);
       //Dado que da algunas excepciones al "rellenar el array de objetos", ya sea, porque el array es nulo o la 
       //cantidad es nula, establezco un try-catch para el buen funcionamiento de los resultados. 
       try{
           for (int i=0;i<cantidadBicis;i++){array[i]=new ChipBici();}
       }catch(Exception e){};
       
       return array;     
}

   
//MÉTODOS DE CONSULTA
   /**
   * Método de consulta(get), que devuelve el número de serie.
   * @return Devuelve el número de serie de ChipBici.
   */
public String getNumSerie() {

        return numeroDeserie;

   } 
   /**
   * Método de consulta(get), que devuelve la fecha de adqusición de la bicicleta.
   * @return Devuelve fecha de adquisición.
   */
public LocalDate getFechaAdquisicion() {

        return fechaAdquisicionbici;

   }  
   /**
   * Método de consulta(get), que devuelve la versión de Firmware.
   * @return Devuelve versión del Firmware.
   */
public int getVersion() {

        return versionFirmware;

   } 
   /**
   * Método de consulta(get), que devuelve la revisión del Firmware.
   * @return Devuelve la revisión del Firmware.
   */
public int getRevision() {

        return revisionFirmware;

   }
   /**
   * Método de consulta(get), que devuelve el Firmware (versión+revision).
   * @return Devuelve el número del Firmware completo.
   */
public String getVersionRevision() {
    
    String version=String.valueOf(versionFirmware);
    String revision=String.valueOf(revisionFirmware);
    String versionRevison=version+"."+revision;

        return versionRevison;

   }
   /**
   * Método de consulta(get), que devuelve un valor booleano. 
   * @return Devuelve, el si está alquilada (true), o no (false), la bicicleta.
   */
public boolean isAlquilada() {

        return alquilada;

   }
   /**
   * Método de consulta(get), que devuelve el número de kilómetros totales de una bicicleta.
   * @return Devuelve el número de kilómetros totales de una bicicleta.
   */
public double getKilometrosTotales() {
        return kmRecorridosTotales;

   }
   /**
   * Método de consulta(get), que devuelve fecha y hora del inicio del alquiler vigente de una bicicleta.
   * @return Devuelve registro del inicio del alquiler vigente.
   */
public LocalDateTime getRegistroInicioAlquilerActual() {
        return fechaHoraInicioActualAlquiler;

   }
   /**
   * Método de consulta(get), que devuelve los  por una bicicleta en alquiler vigente de una bicicleta.
   * @return Devuelve el número de kilómetros realizados en alquiler vigente.
   */
public double getKilometrosRecorridosAlquilerActual() {
        return kmRecorridosDuranteActualAlquiler;

   }
   /**
   * Método de consulta(get), que devuelve fecha y hora del inicio del último alquiler de una bicicleta.
   * @return Devuelve registro del inicio del último alquiler.
   */
public LocalDateTime getRegistroInicioUltimoAlquiler() {
//Si nunca antes ha sido alquilada y devuelta, debería ser null;
        return fechaHoraInicioUltimoAlquiler;

   }
   /**
   * Método de consulta(get), que devuelve fecha y hora del fin del último alquiler de una bicicleta.
   * @return Devuelve el registro del fin del último alquiler.
   */
public LocalDateTime getRegistroFinUltimoAlquiler()  {

        return fechaHoraFinUltimoAlquiler;

   }
   /**
   * Método de consulta(get), que devuelve, el número de kilómetros recorridos en el último alquiler de una bicicleta.
   * @return Devuelve el número de kilómetros del último alquiler.
   */
public double getKilometrosRecorridosUltimoAlquiler()   {

        return kmRecorridosDuranteUltimoAlquiler;

   }


//MÉTODOS QUE DEVUELVAN INFORMACIÓN SOBRE LOS PARÁMETROS ESTATICOS. INFORMACIÓN SOBRE LA CLASE
   /**
   * Método de consulta(get) de parámetro stático, que devuelve el número total de bicicletas.
   * @return Número total de bicicletas.
   */
public static int getNumBicis()   {

        return cantidadTotalBici;

   }
   /**
   * Método de consulta(get) de parámetro stático, que devuelve el número total de bicicletas alquiladas en ese momento.
   * @return Número total de bicicletas alquiladas.
   */
public static int getNumBicisAlquiladas()   {

        return cantidadAlquilada;

   }
   /**
   * Método de consulta(get) de parámetro stático, que devuelve el número total kilómetros realizados por todas la bicicletas.
   * @return Número total kilómetros realizados por todas la bicicletas.
   */
public static double getKilometrosTodasLasBicis()   {

        return kmRecorridosTodasBicis;

   }


//MÉTODOS ALQUILAR Y DEVOLVER
   /**
   * Método vacío que inicia el proceso de alquiler de una bicicleta determinada.
   * @throws IllegalStateException Si la bici está alquilada.
   */
public void alquilar () throws IllegalStateException{
    if (alquilada==true)
        throw new IllegalStateException ("Bici ya alquilada");
    alquilada=true;
    fechaHoraInicioActualAlquiler=LocalDateTime.now();
    cantidadAlquilada++;
}
   
   /**
   * Método vacío que inicia el proceso de devolución de una bicicleta determinada.
   * @throws IllegalStateException Si la bici no está alquilada.
   */
public void devolver () throws IllegalStateException {
    if (alquilada==false)
        throw new IllegalStateException ("Bici no alquilada");
    //Colocamos la bicicleta como sin alquilar
    alquilada=false;
    //Introducimos el número de km recorridos durante el alquiler en un avariable auxiliar y esta, en los km realizados durante el último alquiler.
    Double varAux2=kmRecorridosDuranteActualAlquiler;
    kmRecorridosDuranteUltimoAlquiler=varAux2;
    //Ponemos el contador de kmo recorridos durante el alquiler a 0
    kmRecorridosDuranteActualAlquiler=0;
    //Introducimos la hora de inicio del alquiler en la hora de inicio del último alquiler
    LocalDateTime varAux=fechaHoraInicioActualAlquiler;
    fechaHoraInicioUltimoAlquiler=varAux;
    //Ponemos nulo la hora de inicio del actual alquiler
    fechaHoraInicioActualAlquiler=null;
    //Ponemos como fecha y hora del ultimo alquiler la hora actual de devolución de la bici.
    fechaHoraFinUltimoAlquiler=LocalDateTime.now();
    //Restamo una bicicleta menos alquilada y actualizamos la cantidad de bicicletas alquiladas.
    cantidadAlquilada--;

}


//MÉTODOS DE RECORRIDOS DE TRAYECTOS
   /**
   * Método con un parámetro, que inicia el proceso de trayecto de una bicicleta determinada.
   * @param kmRecorridos Cantidad de kilómetros recorridos en el trayecto. 
   * @return El número de kilómetros recorridos.
   * @throws IllegalStateException Si la bici no está alquilada.
   * 
   */
 public double recorrerTrayecto (double kmRecorridos) throws IllegalStateException  {
     
     if(this.alquilada==false) 
         throw new IllegalStateException ("Bici no alquilada");
     if(kmRecorridos<0||kmRecorridos>MAX_DISTANCIA_TRAYECTO) 
         throw new IllegalStateException ("Distancia incorrecta: "+kmRecorridos);
    
     kmRecorridosTotales += kmRecorridos;     
     kmRecorridosTodasBicis += kmRecorridos;
     kmRecorridosDuranteActualAlquiler+= kmRecorridos;       
    
     
     return kmRecorridosDuranteActualAlquiler;
   
 }
   /**
   * Método sin parámetros, que inicia el proceso de trayecto, en la cual el trayecto será la máxima distancia (140Km).
   * @return El número de kilómetros recorridos (140Km).
   * 
   */
public double recorrerTrayecto ()throws IllegalStateException {
  double km=MAX_DISTANCIA_TRAYECTO;
  recorrerTrayecto(km);
  return kmRecorridosDuranteActualAlquiler;
}


//MÉTODOS ACTUALIZAR FIRMWARE
   /**
   * Método vacío con 2 parámetros, que inicia el proceso de actualización del Firmware.
   * @param version Número de la versión
   * @param revision Número de la revisión
   * @throws IllegalStateException Si la bici está alquilada.
   * @throws IllegalArgumentException Si versión o revisión no son las adecuadas.
   */
public void actualizarFirmware (int version, int revision) throws IllegalStateException, IllegalArgumentException {
  if(this.alquilada==true) 
         throw new IllegalStateException ("No se puede actualizar el firmware a una bici alquilada");  
  if(version<MIN_VERSION||version>MAX_VERSION) 
         throw new IllegalArgumentException ("Versión incorrecta: "+version);
  if(revision<MIN_REVISION||revision>MAX_REVISION) 
         throw new IllegalArgumentException ("Revisión incorrecta: "+revision);
  if(version<=versionFirmware&&revision<=revisionFirmware) 
         throw new IllegalArgumentException ("Es necesario actualizar a una versión superior a la actual: "+version+"."+revision+" <= "+versionFirmware+"."+revisionFirmware);
  versionFirmware=version;
  revisionFirmware=revision;
}

   /**
   * Método vacío con 1 parámetros, que inicia el proceso de actualización del Firmware, donde la revisión se establece por defecto.
   * @param version Número de la versión
   */
public void actualizarFirmware (int version) throws IllegalStateException, IllegalArgumentException {
  int rev=DEFAULT_REVISION;
  actualizarFirmware (version,rev);
}

   /**
   * Método vacío sin parámetros, que inicia el proceso de actualización del Firmware (sobrecarga).
   * @throws IllegalStateException Si la bici está alquilada.
   */
public void reset () throws IllegalStateException {

    if(this.alquilada==true) 
         throw new IllegalStateException ("No se puede resetear un chip de una bici que esté alquilada");  
    this.versionFirmware=DEFAULT_VERSION;
    this.revisionFirmware=DEFAULT_REVISION;
    this.kmRecorridosTotales=0;
    this.fechaHoraInicioActualAlquiler=null;
    this.kmRecorridosDuranteActualAlquiler=0;
    this.fechaHoraInicioUltimoAlquiler=null;
    this.fechaHoraFinUltimoAlquiler=null;
    this.kmRecorridosDuranteUltimoAlquiler=0;
    
}

//MÉTODO TOSTRING
   /**
   * Método que crea una cadena de caracteres, para obtener por pantalla  una ficha de información de una bicileta determinada. Usamos String.format.
   * 
   */
@Override
 public String toString() {
     //Establecemos el formato para LocalDate
     DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY");
     //Establecemos el formato para LocalDateTime
     DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
     String alquiler=null;
     String horAlquiler=null;
     String ultimoIniAlquiler=null;
     String ultimoFinAlquiler=null;
     //Introducimos en String con el formato señalado por el ejercicio los kmRecorridosTotales, kmRecorridosDuranteActualAlquiler, kmRecorridosDuranteUltimoAlquiler
     String kmTotal = String.format("%,.2f", kmRecorridosTotales);
     String kmActAl = String.format("%,.2f", kmRecorridosDuranteActualAlquiler);
     String kmUltAl = String.format("%,.2f", kmRecorridosDuranteUltimoAlquiler);
     
     //Condicional en el caso de estar alquilada la bicicleta. Introducimos en el String.format, según true o false.
     if (alquilada==true){
         alquiler="alquilada";} 
     else{ 
         alquiler="no alquilada";}
     
     //Condicional en el caso de que la fecha/hora de inicio del alquiler actual sea nula.
     if (fechaHoraInicioActualAlquiler!=null) {
         horAlquiler=fechaHoraInicioActualAlquiler.format(formato2);
     } else {horAlquiler="---";}
     
    //Misma condicional que el anterior pero para el caso de la fecha/hora inicio-último-alquiler.
     if (fechaHoraInicioUltimoAlquiler!=null){
         ultimoIniAlquiler=fechaHoraInicioUltimoAlquiler.format(formato2);
     } else {ultimoIniAlquiler="---";}
     
     //Misma condicional que el anterior, pero para el caso de fecha/hora fin-último-alquiler.
     if (fechaHoraFinUltimoAlquiler!=null){
         ultimoFinAlquiler=fechaHoraFinUltimoAlquiler.format(formato2);
     } else {ultimoFinAlquiler="---";}
   
     //Retorno del String format. 
     return String.format ("{ NS: %s; %s; fw:"+versionFirmware+"."+revisionFirmware+"; "+alquiler+"; "+kmTotal+" Km Totales; Alquiler actual: "+horAlquiler+", "+kmActAl+" Km; Último alquiler: "+ultimoIniAlquiler+", "+ultimoFinAlquiler+", "+kmUltAl+" Km }",
              this.numeroDeserie,
              this.fechaAdquisicionbici.format(formato));
}
                    
 
} 
    
    





