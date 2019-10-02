/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure;

import Entities.Sinistre;
import Entities.Temoin;
import Entities.Validate;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class AjouterTemoinController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField cint;
    @FXML
    private TextField nomt;
    @FXML
    private TextField prenomt;
    @FXML
    private TextField telt;
    @FXML
    private TextField description;
        @FXML
    private ChoiceBox<Sinistre>sinistre;
    
        
            
            
           
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
       @FXML
    private void back(ActionEvent event) throws IOException {
       Pane newPane = FXMLLoader.load(getClass().getResource("Index.fxml"));
         StageManager.content.getChildren().setAll(newPane);
    } 
    
    @FXML
    private void ajouter(ActionEvent event) throws IOException {
       Temoin t =new Temoin();
       boolean status = Validate.ValidateCin(cint.getText()) && Validate.ValidateTel(telt.getText());
       //                           this.sinistre.getItems().get(1).getCode(),
       if (status){
       t.setCinT(this.cint.getText());
       t.setNomT(this.nomt.getText());
       t.setPrenomT(this.prenomt.getText());
       t.setTelT(this.telt.getText());
       t.setDescription(this.description.getText());
     }
       Assure.ServiceAssure.TemoinService ex =new Assure.ServiceAssure.TemoinService();
       ex.ajouter("temoin", t);
        JOptionPane.showMessageDialog(null,"insertion avec succés");
    
    }
    
}

