package domotica;
import domotica.dispositivos.Activable;
import domotica.dispositivos.Dispositivo;
import domotica.dispositivos.Cerradura;

/**
 * Clase que representa una vivienda domótica con un conjunto de dispositivos domóticos de distintos tipos.
 * @author Benmupe
 */
public class CasaDomotica {
    //ATRIBUTOS
    /**
    * Array de objetos Dispositivos.
    */
    private Dispositivo dispositivos[];
    /**
    * Nombre del propietario de la casa.
    */
    private String propietario;
    /**
    * Nombre de la casa.
    */
    private String descripcionVivienda;

//CONSTRUCTORES
    /**
    * Constructor con 3 parámetros para una vivenda domótica.
    * @param propietario Propietario de la vivienda.
    * @param descripcionVivienda Descripción de la vivienda.
    * @param dispositivos Lista variable de dispositivos domóticos integrados en la vivienda.
    */
    public CasaDomotica(String propietario, String descripcionVivienda, Dispositivo...dispositivos){
        this.propietario=propietario;
        this.descripcionVivienda=descripcionVivienda;
        this.dispositivos=dispositivos;
        for (int i=0; i<dispositivos.length; i++) {
            this.dispositivos[i]=dispositivos[i];
        }   
    }

//MÉTODOS
    /**
    * Método que devuelve el nombre del propietario de la casa domótica.
    * @return El nombre del propietario de la casa
    */
    public String getPropietario(){ 
        return propietario;
    }

    /**
    * Método que devuelve el nombre de la casa domótica.
    * @return Nombre de la casa.
    */
    public String getDescripcionVivienda(){  
        return descripcionVivienda;
    }

    /**
    * Obtiene el número de dispositivos integrados en la vivienda.
    * @return Número de dispositivos integrados en la vivienda.
    */
    public int getNumDispositivos(){  
        return dispositivos.length;
    }

    /**
    * Obtiene el número de dispositivos de tipo Bombilla integrados en la vivienda.
    * @return Número de bombillas instaladas en la vivienda
    */
    public int getNumBombillas (){
        int numBombilla=0;
        for (int i=0; i<dispositivos.length; i++) {
            if (dispositivos[i].getClass().getSimpleName().equals("Bombilla")){
                numBombilla++;
            }
        }
        return numBombilla;
    }

    /**
    * Obtiene el número de dispositivos de tipo Cerradura integrados en la vivienda.
    * @return Número de cerraduras instaladas en la vivienda.
    */
    public int getNumCerraduras (){
        int numCerradura=0;
        for (int i=0; i<dispositivos.length; i++) {
            if (dispositivos[i].getClass().getSimpleName().equals("Cerradura")){
                numCerradura++;
            }
        }      
        return numCerradura;   
    }

    /**
    * Cierra todas las cerraduras de la casa que estén aún sin cerrar.
    * @return El número de cerraduras que se han activado (cerrado).
    */
    public int cerrarCerraduras () {
        int cerradurasCerradas=0;
        for (int i=0; i<dispositivos.length; i++) {
            if (dispositivos[i] instanceof Cerradura){
                ((Cerradura)dispositivos[i]).on();
            }
        }
        for (int i=0; i<dispositivos.length; i++) {
            if (dispositivos[i] instanceof Cerradura){
                if (((Cerradura)dispositivos[i]).getEstado()==true){
                cerradurasCerradas++;
                }
            }   
        }
        return cerradurasCerradas;   
    }
   
    /**
    * Activa todos los dispositivos de la casa que estén aún sin activar.
    * @return El número de desipositivos que se han activado.
    */
    public int activarDispositivosActivables () {
        int dispositivosActivados=0;
        for (int i=0; i<dispositivos.length; i++) {
            if (dispositivos[i] instanceof Activable&&((Activable)dispositivos[i]).getEstado()==false){
                ((Activable)dispositivos[i]).on();
                dispositivosActivados++;
            }
        }
        return dispositivosActivados;   
    }
 
    
    @Override
    public String toString() {
        //Creo un StringBuilder por cada estancia
        StringBuilder estancia1=new StringBuilder(100);
        StringBuilder estancia2=new StringBuilder(100);
        StringBuilder estancia3=new StringBuilder(100);
        StringBuilder estancia4=new StringBuilder(100);
        StringBuilder estancia5=new StringBuilder(100);
        
        //Ingreso en cada StringBuilder los dispositivos de cada estancia en con salto de línea (\n)
        for (int i=0; i<dispositivos.length; i++) {
            if (dispositivos[i].getUbicacion()==1){
                estancia1.append(dispositivos[i]+"\n");
            }
            if (dispositivos[i].getUbicacion()==2){
                estancia2.append(dispositivos[i]+"\n");
            } 
            if (dispositivos[i].getUbicacion()==3){
                estancia3.append(dispositivos[i]+"\n");
            } 
            if (dispositivos[i].getUbicacion()==4){
                estancia4.append(dispositivos[i]+"\n");
            } 
            if (dispositivos[i].getUbicacion()==5){
                estancia5.append(dispositivos[i]+"\n");
            }      
        }
        
        //Introduzco las estancias (StringBuilder) y el formato en el String "resultado". Resultado
        //será el retorno del método toString.
        String resultado;
        resultado="\u001B[31m_________________________________________________________________________________"+"\n"
                +"\u001B[31mCASA DOMOTICA"+"\n"
                + "\u001B[31mPropietario:"+propietario+"\n"
                + "\u001B[31mDescripción:"+descripcionVivienda+"\n"
                + "\u001B[31m_________________________________________________________________________________"+"\n"
                +"Estancia:1"+"\n"
                +"**********"+"\n"
                +estancia1
                +"---------------------------------------------------------------------------------"+"\n"
                +"Estancia:2"+"\n"
                +"**********"+"\n"
                +estancia2
                +"---------------------------------------------------------------------------------"+"\n"
                +"Estancia:3"+"\n"
                +"**********"+"\n"
                +estancia3
                +"---------------------------------------------------------------------------------"+"\n"
                +"Estancia:4"+"\n"
                +"**********"+"\n"
                +estancia4
                +"---------------------------------------------------------------------------------"+"\n"
                +"Estancia:5"+"\n"
                +"**********"+"\n"
                +estancia5+"\n"
                +"---------------------------------------------------------------------------------"+"\n";
        
return resultado;
    }
   
}
