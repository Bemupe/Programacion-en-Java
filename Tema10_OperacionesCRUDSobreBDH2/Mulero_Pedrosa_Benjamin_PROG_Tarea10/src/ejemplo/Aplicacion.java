package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import org.h2.tools.Server;
import static java.lang.System.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.stream.Collectors;
import utilidades.ES;


/**
 * Clase principal de inicio del programa. 
 */
public class Aplicacion {

    /**
     * Nombre del archivo de base de datos local.
     */
    private static final String DB_NOMBRE = "proyectobase.h2db";
    /**
     * URL para la conexión a la base de datos.
     */
    private static final String URL_CONEXION = "jdbc:h2:./" + DB_NOMBRE ;
    /**
     * Driver a utilizar para conectarse a la base de datos.
     */
    private static final String DRIVER = "org.h2.Driver";
    /**
     * Opciones de conexión. 
     */
    private static final String PARAMS = ";MODE=MySQL;AUTO_RECONNECT=TRUE";
    
    /**
     * Path al archivo que contiene la estructura de la base de datos.
     */
    public final static String ESTRUCTURA_DB = "/resources/creaBD.sql";  
    
    /**
     * Path al archivo que contiene la estructura de la base de datos.
     */
    public final static String INSERTA_DB = "/resources/cargaBD.sql";  
    
    
    /**
     * Método principal de la aplicación. En él se realiza la preparación
     * del entorno antes de empezar. A destacar:
     * 
     * - Se carga el driver (Class.forName).
     * - Se establece una conexión con la base de datos (DriverManager.getConnection)
     * - Se crean las tablas, si no están creadas, invocando el método createTables.
     * - Se ejecuta una consulta de prueba
     * 
     * @param args 
     */
     public static void main(String[] args)  {        
        boolean driverCargado = false ;
        
        //Carga del driver de la base de datos.
        try {
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            driverCargado=true;
        }
        catch (ClassNotFoundException e)
        {
            err.printf("No se encuentra el driver de la base de datos (%s)\n", DRIVER);
        } catch (InstantiationException | IllegalAccessException ex) {
            err.printf("No se ha podido iniciar el driver de la base de datos (%s)\n", DRIVER);
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        //Si el driver está cargado, aseguramos que podremos conectar.
        if (driverCargado) {
            //Conectamos con la base de datos.
            //El try-with-resources asegura que se cerrará la conexión al salir.
            String[] wsArgs={"-baseDir",System.getProperty("user.dir"),"-browser"};
            try (Connection con = DriverManager.getConnection(URL_CONEXION + PARAMS,"","")) {
                
                // Iniciamos el servidor web interno (consola H2 para depuraciones)
                Server sr = Server.createWebServer(wsArgs);                              
                sr.start();
                
                // Presentamos información inicial por consola
                out.println("¡¡Atención!!");                
                out.println();
                out.println("Mientras tu aplicación se esté ejecutando "
                        + "puedes acceder a la consola de la base de datos \n"
                        + "a través del navegador web.");    
                out.println();
                out.println("Página local: " + sr.getURL());     
                out.println();
                out.println("Datos de acceso");                
                out.println("---------------");
                out.println("Controlador: "+ DRIVER);
                out.println("URL JDBC: " + URL_CONEXION);
                out.println("Usuario: (no indicar nada)");                
                out.println("Password: (no indicar nada)");                
                
                // Creamos las tablas y algunos datos de prueba si no existen
                // y continuamos
                if (crearTablas(con)) {
                    
                    // Insertar los datos en las tablas de la BD
                    insertarDatosTablas (con) ;
                    
                    boolean continuar = true ;
                    
                    do {
                        System.out.println() ;
                        System.out.println() ;
                        System.out.println("---- MENÜ DE LA APLICACIÓN  ----") ;
                        System.out.println("---- ---------------------- ----") ;
                        System.out.println("1 - Consultar personajes") ;
                        System.out.println("2 - Consultar naves") ;
                        System.out.println("3 - Modificar nave") ;
                        System.out.println("4 - Borrar personaje") ;                      
                        System.out.println("0 - Salir") ;
                        System.out.println("---- ---------------------- ----") ;
                        System.out.println("---- ---------------------- ----") ;
                        System.out.println() ;
                        System.out.println() ;
                        
                        // Leer la opción correspondiente a ejecutar.
                        int opcion = ES.leeEntero("Escriba opción: ", 0, 4) ;
                        switch (opcion) {
                            case 0: continuar = false ;
                                    break ;
                            case 1: consultarPersonaje(con) ;
                                    break ;
                            case 2: consultarNave(con) ;
                                    break ;
                            case 3: modificarNave(con) ;
                                    break ;
                            case 4: borrarPersonaje(con) ;
                                    break ;
                        }
                    } while (continuar) ;
                    
                    // Esperar tecla
                    ES.leeCadena("Antes de terminar, puedes acceder a la "
                            + "consola de H2 para ver y modificar la base de "
                            + "datos. Pulsa cualquier tecla para salir.") ;
                    
                } else {
                    System.err.println("Problema creando las tablas.");

                }                                                        
                
                sr.stop();
                sr.shutdown();
                
            } catch (SQLException ex) {
                err.printf("No se pudo conectar a la base de datos (%s)\n", DB_NOMBRE);
            }
        }

    }
    
    /**
     * Dada una conexión válida, lleva a cabo la creación de la estructura
     * de la base de datos, usando como SQL para la creación el contenido 
     * en la constante ESTRUCTURA_DB
     * @param con conexión a la base de datos.
     * @see ESTRUCTURA_DB
     * @return true si se creo la estructura y false en caso contrario. 
     */
    public static boolean crearTablas (Connection con) {
        boolean todoBien = false ;
        
        try (Statement st = con.createStatement()) {
                         
            String sqlScript = loadResourceAsString(ESTRUCTURA_DB);
            if (sqlScript != null) {
                st.execute(sqlScript);                  
                todoBien = true ;
            } else {
                System.out.printf("Problema cargando el archivo: %s \n", ESTRUCTURA_DB);
                System.out.printf("Para ejecutar este proyecto no puede usarse 'Run File'\n");
            }
            
        } catch (SQLException ex) {
            System.err.printf("Problema creando la estructura de la base de datos.\n");
        }
        return todoBien ;        
    }   
    
    
    /**
     * Dada una conexión válida, lleva a cabo la inserción de datos
     * de la base de datos, usando como SQL para la creación el contenido 
     * en la constante INSERTA_DB
     * @param con conexión a la base de datos.
     * @see INSERTA_DB
     * @return true si se creo la estructura y false en caso contrario. 
     */
    private static boolean insertarDatosTablas (Connection con) {
        boolean todoBien = false ;
        
        try (Statement st = con.createStatement()) {
                         
            String sqlScript = loadResourceAsString(INSERTA_DB);
            if (sqlScript != null) {
                st.execute(sqlScript);                  
                todoBien = true ;
            } else {
                System.out.printf("Problema cargando el archivo: %s \n", INSERTA_DB);
                System.out.printf("Para ejecutar este proyecto no puede usarse 'Run File'\n");
            }
            
        } catch (SQLException ex) {
            System.err.printf("Problema insertando datos en la base de datos.\n");
        }
        return todoBien ;        
    }
    
    
    /**
      * Carga un recurso que estará dentro del JAR como cadena de texto.
      * @param resourceName Nombre del recurso dentro del JAR.
      * @return Cadena que contiene el contenido del archivo.
      */
    public static String loadResourceAsString(String resourceName) {
        String resource = null;
        InputStream is = Aplicacion.class.getResourceAsStream(resourceName);
        if (is != null) {
            try ( InputStreamReader isr = new InputStreamReader(is);  BufferedReader br = new BufferedReader(isr);) {
                resource = br.lines().collect(Collectors.joining("\n"));
            } catch (IOException ex) {
                System.err.printf("Problema leyendo el recurso como cadena: %S\n ", resourceName);
            }
        }
        return resource;
    }
    
    
    /**
     * Consultar los personajes de la base de datos
     * @param con Conexión a la BD
     */
    private static void consultarPersonaje(Connection con) {  
        System.out.printf("%-15s %-25s %-15s\n", "Código", "Nombre", "Descripcion");
        System.out.printf("%-15s %-25s %-15s\n", "------" , "-----------------", "-------------------------------------");
         if (con != null) {
            try ( Statement consulta = con.createStatement()) {
                ResultSet resultados = consulta.executeQuery("SELECT codigo,nombre,descripcion FROM PERSONAJE");

                while (resultados.next()) {
                    long codigo = resultados.getLong("codigo");
                    String nombre = resultados.getString("nombre");
                    String descripcion = resultados.getString("descripcion");
                    System.out.printf("%-15d %-25s %-15s\n", codigo, nombre, descripcion);
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.\n");
                System.err.printf("SQLState: %s\n",ex.getSQLState());
                System.err.printf("SQLError: %s\n",ex.getMessage());
            }
        }
        
    }
    
    
    /**
     * Modificar la descripción de la nava cuyo código se introduzca
     * @param con Conexión a la BD
     */
    private static void modificarNave(Connection con) {
        long idnave=0;
        boolean error;
        Scanner pedir = new Scanner(System.in);
        do {
            try {
                do{
                    System.out.println("Escriba el número de nave cuyo nombre se cambiará por HIPOPOTAMO (mayor de 0): ");
                    idnave = pedir.nextLong();}while (idnave<0||idnave==0);
                error=false;} 
            catch (InputMismatchException e) {
                error=true;
                System.out.println("Introduce un número, has introducido letras ");
                pedir.next();
            }
        }while(error);
    
        if (con != null) {

            try ( PreparedStatement actualizar = con.prepareStatement("UPDATE NAVE SET nombre=? WHERE idnave=?;")) {

                actualizar.setString(1,"HIPOPOTAMO");
                actualizar.setLong(2, idnave);

                int registrosAfectados = actualizar.executeUpdate();
                if (registrosAfectados>0)
                {
                    System.out.println("El nombre de la nave se ha modificado. Modificación correcta");
                    
                } else {
                    System.out.println("El nombre de la nave no se ha modificado, número de la nave no encontrado.");
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.\n");
                System.err.printf("SQLState: %s\n",ex.getSQLState());
                System.err.printf("SQLError: %s\n",ex.getMessage());
            }
        }
        
    }
    
    /**
     * Borrar personajes de la BD
     * @param con Conexión a la BD
     */
    private static void borrarPersonaje(Connection con) {  
        long codigo=0;
        boolean error;
        Scanner pedir = new Scanner(System.in);
        do {
            try {
                do{
                    System.out.println("Escriba el código de personaje a borrar(mayor de 0): ");
                    codigo = pedir.nextLong();}while (codigo<0||codigo==0);
                error=false;} 
            catch (InputMismatchException e) {
                error=true;
                System.out.println("Introduce un número, has introducido letras ");
                pedir.next();
            }
        }while(error);
    
        if (con != null) {

            try ( PreparedStatement actualizar = con.prepareStatement("DELETE FROM PERSONAJE WHERE codigo=?;")) {

                
                actualizar.setLong(1, codigo);

                int registrosAfectados = actualizar.executeUpdate();
                if (registrosAfectados>0)
                {
                    System.out.println("Borrado personaje con código "+codigo+" correctamente");
                    
                } else {
                    System.out.println("No se realizó ningún borrado en la base de dato");
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.\n");
                System.err.printf("SQLState: %s\n",ex.getSQLState());
                System.err.printf("SQLError: %s\n",ex.getMessage());
            }
        }
        
                
    }

    /**
     * Consultar las naves de la base de datos
     * @param con Conexión a la BD
     */
    private static void consultarNave(Connection con) {
        System.out.printf("%-15s %-25s %-15s\n", "Código", "Nave", "Motores");
        System.out.printf("%-15s %-25s %-15s\n", "------" , "-----------------", "------------");
         if (con != null) {
            try ( Statement consulta = con.createStatement()) {
                ResultSet resultados = consulta.executeQuery("SELECT idnave,nombre,motores FROM NAVE");

                while (resultados.next()) {
                    long idnave = resultados.getLong("idnave");
                    String nombre = resultados.getString("nombre");
                    int motores = resultados.getInt("motores");
                    System.out.printf("%-15d %-25s %-15s\n", idnave, nombre, motores);
                }

            } catch (SQLException ex) {
                System.err.printf("Se ha producio un error al ejecutar la consulta SQL.\n");
                System.err.printf("SQLState: %s\n",ex.getSQLState());
                System.err.printf("SQLError: %s\n",ex.getMessage());
            }
        }
                
    }
}
