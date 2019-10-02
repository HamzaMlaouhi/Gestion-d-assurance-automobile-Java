/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure;

import Entities.Sinistre;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class AjouterSinistreController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private DatePicker date;
    @FXML
    private TextField lieu;
    @FXML
    private TextField dommage;
    @FXML
    private TextField cin;
    @FXML
    private TextField matriel;
    @FXML
    private ChoiceBox contrat;
    @FXML
    private ChoiceBox vehicule;
           
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }    
    
      @FXML
    private void back(ActionEvent event) throws IOException {
       Pane newPane = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
         StageManager.content.getChildren().setAll(newPane);
    } 
    
    @FXML
    private void ajoutersinistre(ActionEvent event) {
        Sinistre r=new Sinistre();
                r.setDate_sinistre(Date.valueOf(this.date.getValue()));
        r.setLieu_sinistre(this.lieu.getText());
        r.setDommage_corps(this.dommage.getText());
        r.setCin_conducteur(this.cin.getText());
        r.setDommage_materiel(this.matriel.getText());
//       r.setContrat_id(this.contrat.getItems());
//       r.setModele_id(this.vehicule.getItems()));
              Assure.ServiceAssure.SinistreService ex =new Assure.ServiceAssure.SinistreService();
        ex.ajoutersinistre(r);  }
}
