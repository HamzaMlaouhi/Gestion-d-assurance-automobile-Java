/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure;

import Entities.Constat;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
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
public class AjouterConstatController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private DatePicker date;
    @FXML
    private TextField lieu;
    @FXML
    private TextField objet;
    @FXML
    private TextField comm;
    @FXML
    private TextField croquis;
    @FXML
    private ChoiceBox matricule;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
     @FXML
    private void AjouterConstat(ActionEvent event) {
         Constat r=new Constat();
        r.setMatricule_autrui(this.objet.getText());
        r.setCroquis(this.croquis.getText());
        r.setMatricule_autrui(this.matricule.getId());
        
     

        Assure.ServiceAssure.ConstatService ex =new Assure.ServiceAssure.ConstatService();
        ex.AjouterConstat(r);
    }
     @FXML
    private void retourraction(ActionEvent event) throws IOException {
       Pane newPane = FXMLLoader.load(getClass().getResource("GestionConstat.fxml"));
      StageManager.content.getChildren().setAll(newPane);
    }
}


