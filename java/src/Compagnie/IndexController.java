/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie;

import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author BahaEddine
 */
public class IndexController implements Initializable {

    @FXML
    private AnchorPane content;
    @FXML
    private AnchorPane menu;
    @FXML
    private SplitPane split;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        StageManager.content = this.content;
    }    

    @FXML
    private void gcAction(ActionEvent event) throws Exception{
        Pane newPane = FXMLLoader.load(getClass().getResource("./GarantieComplementaire/gestionGC.fxml"));
        content.getChildren().setAll(newPane);
    }

    @FXML
    private void agenceAction(ActionEvent event) throws IOException {
        Pane newPane = FXMLLoader.load(getClass().getResource("./Agence/gestionAgence.fxml"));
        content.getChildren().setAll(newPane);
    }

}
