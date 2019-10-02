/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie.GarantieComplementaire;

import Compagnie.Services.GCService;
import Entities.GarantieComplementaire;
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
public class NewGCController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField tarifBase;
    @FXML
    private TextField primeBase;
    @FXML
    private TextField surprime;
    @FXML
    private TextField nivFranchise;

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
        Pane newPane = FXMLLoader.load(getClass().getResource("gestionGC.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
    }

    @FXML
    private void ajouterGC(ActionEvent event) throws IOException {
        GarantieComplementaire gc = new GarantieComplementaire(this.nom.getText(),
                Double.valueOf(this.tarifBase.getText()),
                Double.valueOf(this.nivFranchise.getText()),
                Double.valueOf(this.primeBase.getText()),
                Double.valueOf(this.surprime.getText())
        );
        
        new GCService().ajouter("garantie_complementaire", gc);
        Pane newPane = FXMLLoader.load(getClass().getResource("gestionGC.fxml"));
        StageManager.content.getChildren().setAll(newPane);
    }
    
}
