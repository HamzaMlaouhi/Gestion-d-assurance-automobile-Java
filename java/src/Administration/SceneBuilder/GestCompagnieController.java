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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class GestCompagnieController implements Initializable {

    @FXML
    private Button addCompagnie;
    @FXML
    private Button ChercheCompagnie;
    @FXML
    private Button ListéCompagnie;
    @FXML
    private Button backBtn;
      @FXML
    private VBox pnl_scroll;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addCompagnie.setOnAction(event -> {
            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("AjoutCompagnie.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        ChercheCompagnie.setOnAction(event -> {

            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("ChercheCompagnie.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        ListéCompagnie.setOnAction(event -> {

            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("ListeCompagnie.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }    

    @FXML
    private void AddCompagnie(ActionEvent event) {
    }

    @FXML
    private void ChercherCompagnie(ActionEvent event) {
    }

    @FXML
    private void AfficherCompagnie(ActionEvent event) {
    }
    
}
