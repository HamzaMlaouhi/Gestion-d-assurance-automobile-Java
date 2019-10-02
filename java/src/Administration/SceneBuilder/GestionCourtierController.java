/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class GestionCourtierController implements Initializable {

    @FXML
    private Button addCourtier;
    @FXML
    private Button ChercheCourtier;
    @FXML
    private Button ListéCourtier;
    @FXML
    private Button backBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addCourtier.setOnAction(event ->{
            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("AjoutCourtier.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        ChercheCourtier.setOnAction(event -> {

            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("ChercherCourtier.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
         ListéCourtier.setOnAction(event -> {

            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("ListeCourtier.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         
    }    

    @FXML
    private void AddCourtier(ActionEvent event) {
    }

    @FXML
    private void ChercherCourtier(ActionEvent event) {
    }

    @FXML
    private void AfficherCourtiers(ActionEvent event) {
    }
    
}
