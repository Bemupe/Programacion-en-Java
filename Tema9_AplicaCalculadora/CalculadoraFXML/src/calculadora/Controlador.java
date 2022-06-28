package calculadora;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;


/**
 * El controlador se encarga de responder a los eventos que causa el usuario
 * invocando las peticiones al modelo cuando se hace alguna solicitud sobre la
 * información (por ejemplo, en este caso cuando el usuario pulse en el botón 
 * de igual para calcular la expresión).
 * 
 * @author 
 */
public class Controlador implements Initializable {
    @FXML private TextField textfield;
    private String cadena;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

	/**
     * Ventanita para mostrar mensajes de error
     * @param error 
     */
    private void mostrarError(String titulo, String error)  {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
        alert.setTitle(titulo);
        
        alert.setContentText(error);
        
        Optional<ButtonType> action = alert.showAndWait();
      
    }

   //Método para copiar en el textfield.
    private void copiarAlTextField(String caracter)  {
       
       textfield.setText(textfield.getText()+caracter);
      
    }    

    
   //ActionEvent de: 
   //   1. Botones, números, operadores y punto: Cada uno de estos botones y a través del método "copiarAlTextField", copiamos en el el "textfield" el botón pulsado.
   //   2. Botón igual: Utiliza el método "evaluar" de la clase "Modelo", que calculará el resultado si la cadena es correcta.
   //   3. Botón raiz cuadrada: Utiliza primero el método "evaluar" y posteriormente, si es correcto el método "raizCuadrada" de la clase "Modelo"
   //   4. Botón suprimir: Suprime el último caracter añadido al textfield
   //   5. Botón borrartodo: Borra toda la cadena.
   @FXML
    private void action_Punto(ActionEvent event) {
        copiarAlTextField(".");
    }

    @FXML
    private void action_Raiz(ActionEvent event) {
        
        Modelo.evaluar(cadena, textfield);
        
        calculadora.Modelo.raizCuadrada(cadena, textfield);
        
    }

    @FXML
    private void action_Cero(ActionEvent event) {

        copiarAlTextField("0");

    }

    @FXML
    private void action_Siete(ActionEvent event) {
      
        copiarAlTextField("7");
    }

    @FXML
    private void action_Cuatro(ActionEvent event) {
      
        copiarAlTextField("4");
    }

    @FXML
    private void action_Uno(ActionEvent event) {
        
        copiarAlTextField("1");
    }

    @FXML
    private void action_Suprimir(ActionEvent event) {
        
        String str = textfield.getText();
        str = str.substring(0, str.length()-1);
        textfield.setText(str);
        
    }

    @FXML
    private void action_Ocho(ActionEvent event) {
    
        copiarAlTextField("8");
    }

    @FXML
    private void action_Cinco(ActionEvent event) {

        copiarAlTextField("5");
    }

    @FXML
    private void action_Dos(ActionEvent event) {

        copiarAlTextField("2");
             
    }

    @FXML
    private void action_BorrarAll(ActionEvent event) {
        
        textfield.setText("");
        
    }

    @FXML
    private void action_Igual(ActionEvent event) {
       
        Modelo.evaluar(cadena, textfield);
    
    }
    
    @FXML
    private void action_Nueve(ActionEvent event) {
        
        copiarAlTextField("9");
         
    }

    @FXML
    private void action_Seis(ActionEvent event) {
       
        copiarAlTextField("7");
    }

    @FXML
    private void action_Tres(ActionEvent event) {

        copiarAlTextField("3");
    }

    @FXML
    private void action_Mas(ActionEvent event) {

        copiarAlTextField("+");
        
    }

    @FXML
    private void action_Menos(ActionEvent event) {

        copiarAlTextField("-");
  
    }

    @FXML
    private void action_Multiplicar(ActionEvent event) {

        copiarAlTextField("*");
    }

    @FXML
    private void action_Dividir(ActionEvent event) {

        copiarAlTextField("/");
    }

}
