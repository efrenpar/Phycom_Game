/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phycomgame;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import phycomgame.model.Reto;

/**
 *
 * @author Israel
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    ArrayList<Reto> retos = new ArrayList<>();
    Reto retoActual;
    
    @FXML
    private Label enunciado ;
    @FXML
    private Label conteo;
    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;
    @FXML
    private RadioButton rb4;
    @FXML
    final ToggleGroup group = new ToggleGroup();
    @FXML
    private Button responder;
    @FXML
    private Button iniciar;
    @FXML
    private Label admiracion;
    
    
    @FXML
    public void iniciarReto() {
       
        for(int i = 0;i<retos.size();i++){
        
            if(!retos.get(i).isCompletado()){
                
                
                this.enunciado.setText(retos.get(i).getEnunciado());
                this.conteo.setText("0");
                
                this.rb1.setText(retos.get(i).getOpciones().get(0));
                this.rb2.setText(retos.get(i).getOpciones().get(1));
                this.rb3.setText(retos.get(i).getOpciones().get(2));
                this.rb4.setText(retos.get(i).getOpciones().get(3));
                
                this.retoActual = retos.get(i);
                break;
       
                
            }
        }
        
        
    }
    
    @FXML
    public void enviarRespuesta(){
        if(((RadioButton)this.group.getSelectedToggle()).getText().equalsIgnoreCase(this.retoActual.getRespuesta())){
            this.retoActual.setCompletado(true);
            this.admiracion.setText("Has Acertado!");
        }
        else
        this.admiracion.setText("Intentalo de nuevo");
    }
    
    public ArrayList<Reto> hacerPreguntas(){
        
        ArrayList<Reto> retos = new ArrayList<Reto>();
         String enunciado = "Cual es la\nsalida\ndel\nsiguiente\ncodigo";
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("holi");
        opciones.add("hola");
        opciones.add("holita");
        opciones.add("k ase");
        
        Reto reto = new Reto(enunciado,opciones,"hola");
        retos.add(reto);
        
        enunciado = "lalalalalala";
        opciones = new ArrayList<>();
        opciones.add("hey");
        opciones.add("you");
        opciones.add("hey you");
        opciones.add("hey you");
        
        
        reto = new Reto(enunciado,opciones,"you");
        
        
        retos.add(reto);
        
        return retos;
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.retos = this.hacerPreguntas();
       this.admiracion.setText("");
       this.rb1.setToggleGroup(group);
       this.rb2.setToggleGroup(group);
       this.rb3.setToggleGroup(group);
       this.rb4.setToggleGroup(group);
       
      
       
       
       
    }    
    
}
