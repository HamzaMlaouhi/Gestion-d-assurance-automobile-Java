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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class ChercherCourtierController implements Initializable {

    @FXML
    private TextField CINCourtier;
    @FXML
    private Button ChercheBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ChercheBtn.setOnAction(event ->{
             try {
                 String CINcourt = this.CINCourtier.getText();
                 FXMLLoader res = new FXMLLoader(getClass().getResource("ResCourtier.fxml"));
                 Parent root = (Parent)res.load();
                 ResCourtierController controller = res.<ResCourtierController>getController();
                 controller.nc=CINcourt;
                 StageManager.vcontent.getChildren().setAll(root);
             } catch (IOException ex) {
                 Logger.getLogger(ChercherCourtierController.class.getName()).log(Level.SEVERE, null, ex);
             }
         
         
         
         
         });
    }    

    @FXML
    private void ChercheCourtierAction(ActionEvent event) {
    }
    
}
