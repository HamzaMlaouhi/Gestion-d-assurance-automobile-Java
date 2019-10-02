/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure;

import Entities.Reclamation;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class AjouterReclamationController implements Initializable {
       
    @FXML
    private DatePicker date;
    @FXML
    private TextField lieu;
    @FXML
    private TextField objet;
    @FXML
    private TextField commentaire;
    @FXML
    private Button ajouter;
    @FXML
    private ChoiceBox<?> code;
 
    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
         @FXML
    private void back(ActionEvent event) throws IOException {
       Pane newPane = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
         StageManager.vcontent.getChildren().setAll(newPane);
    } 
    
    @FXML
    private void AjouterReclamtion(ActionEvent event) {
        Reclamation r=new Reclamation();
        r.setDate_rec(Date.valueOf(this.date.getValue()));
        r.setLieu_rec(this.lieu.getText());
        r.setObjet_rec(this.objet.getText());
        
     
     

        Assure.ServiceAssure.ReclamationService ex =new Assure.ServiceAssure.ReclamationService();
        ex.AjouterReclamtion(r);
    }
    
}
