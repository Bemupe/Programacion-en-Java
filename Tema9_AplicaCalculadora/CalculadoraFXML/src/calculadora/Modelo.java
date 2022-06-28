package calculadora;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 
 * @author 
 */
public class Modelo {
    //String operationS = textfield.getText();
    
    /**
     * Evaluar la cadena que se pasa como parámetro
     * @param cadena String con la expresión a evaluar
     * @return Una cadena con el resultado o bien null si la cadena recibida
     *         como parámetro no era válida
     */
    public static String evaluar(String cadena, TextField textfield) {
        
        //Introducimos lo escrito en el cuadro de texto en un string y creamos el Pattern y Matcher
        cadena = textfield.getText();
        String aux = cadena.replace(" ", "");
        Pattern pattern = Pattern.compile("[+/*-]?[0-9]+");
        Matcher matcher = pattern.matcher(aux);
        
        //Si hacemos matcher, creamos un objeto ScriptEngine. 
        //Tras lo anterior, en un try-catch, creamos un "Object" y cálculamos las operaciones. 
        //En el caso de error de script, saltará el método "errorExpresion" con el panel de advertencia "Expresión no válida"
        //Finalmente, en el caso de no hacer matcher, también saltará el panel de advertencia "Expresión no válida"
        if (matcher.find()){
            
            while (matcher.find()) {
                
                ScriptEngineManager manager = new ScriptEngineManager();
                
                ScriptEngine engine = manager.getEngineByName("js");
                
                try {
                    
                    Object operation = engine.eval(textfield.getText());
                    
                    textfield.setText("" + operation);
                
                } catch (ScriptException e) {
                    
                    errorExpresion();
                
                }
            
            }
        
        } else {
            
            errorExpresion();
        
        }
        
        return null ; 
        
    }

    /**
     * Evalúa la expresión pasada en text y posteriormente realiza la raíz 
     * cuadrada dicha expresión
     * 
     * @param texto Presunta expresión a calcular la raíz
     * @return Cadena de caracteres con el resultado del cálculo o bien null
     *         si la expresión que se pasó no era válida
     */
    static String raizCuadrada(String text, TextField textfield) {

        text = textfield.getText();
        int numero;
        double resultado=0.0;
        
        //Envolvemos el código del cálculo de la raíz cuadrada en el caso de que se produzca alguna excepción. 
        //Utilizamos un panel de alerta.
        try {
                
                numero = Integer.parseInt (text);
                
                resultado = Math.sqrt(numero);
                
                textfield.setText(String.valueOf(resultado));
        
        }catch (Exception a)
        
        {
            
           Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    
           alerta.setHeaderText("Error");
        
           alerta.setTitle("Error");
           
           Optional<ButtonType> action = alerta.showAndWait();
        
        }
        
        return null ;
    
    }
    
    public static void errorExpresion()  {
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    
        alerta.setHeaderText("Mensaje");
        
        alerta.setTitle("Error en los datos");
        
        alerta.setContentText("Expresión no válida");
        
        Optional<ButtonType> action = alerta.showAndWait();
        
    }
          
   
}
