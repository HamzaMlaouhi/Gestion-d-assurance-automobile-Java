/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie.Agence;

import Compagnie.Services.AgenceService;
import Entities.Agence;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author BahaEddine
 */
public class NewAgenceController implements Initializable {

    @FXML
    private TextField zone;
    @FXML
    private TextField tel;
    @FXML
    private TextField nbr_employer;
    @FXML
    private TextField fax;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
        StageManager.vcontent.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("gestionAgence.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
    }

    @FXML
    private void ajouterAgence(ActionEvent event) throws IOException {
        Agence a = new Agence(this.zone.getText(),
            Integer.valueOf(this.tel.getText()),
            Integer.valueOf(this.fax.getText()),
            Integer.valueOf(this.nbr_employer.getText()));
        new AgenceService().ajouter("agence",a);
        Pane newPane = FXMLLoader.load(getClass().getResource("gestionAgence.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
    }
    
}
