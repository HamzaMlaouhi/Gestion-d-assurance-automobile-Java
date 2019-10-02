/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure;

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
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {
    
    @FXML
    private Label label;
    
      @FXML
    private VBox pnl_scroll;
    
    @FXML
    private void handleButtonAction(MouseEvent event) {        
       refreshNodes();
       
    }
    
       @FXML
    private VBox content;
    @FXML
    private VBox menu;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
          StageManager.vcontent = menu;
     
    }

   @FXML
    private void gsreclamation(ActionEvent event) throws IOException {
        menu.getChildren().clear();
       Pane newPane = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
        menu.getChildren().setAll(newPane);
    }
   
        @FXML
    private void gsconstat(ActionEvent event) throws IOException {
       Pane newPane = FXMLLoader.load(getClass().getResource("GestionConstat.fxml"));
        menu.getChildren().setAll(newPane);
    }
    
            @FXML
    private void ajoutsinsistre(ActionEvent event) throws IOException {
       Pane newPane = FXMLLoader.load(getClass().getResource("AjouterSinistre.fxml"));
        menu.getChildren().setAll(newPane);
    }
    
        
            @FXML
    private void ajoutertemoin(ActionEvent event) throws IOException {
       Pane newPane = FXMLLoader.load(getClass().getResource("AjouterTemoin.fxml"));
        menu.getChildren().setAll(newPane);
    }
    
          
            @FXML
    private void gestionvehicule(ActionEvent event) throws IOException {
       Pane newPane = FXMLLoader.load(getClass().getResource("GestionVehicule.fxml"));
        menu.getChildren().setAll(newPane);
    }
    
            @FXML
    private void statistique(ActionEvent event) throws IOException {
       try {
                      Pane newPane = FXMLLoader.load(getClass().getResource("Statistique.fxml"));
                      menu.getChildren().setAll(newPane);
                  } catch (IOException ex) {
                      Logger.getLogger(Administration.SceneBuilder.HomeController.class.getName()).log(Level.SEVERE, null, ex);
                  }
    }
        
    
    private void refreshNodes()
    {
        pnl_scroll.getChildren().clear();
        
        Node [] nodes = new  Node[15];
        
        for(int i = 0; i<1; i++)
        {
            try {
                nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Index.fxml"));
               pnl_scroll.getChildren().add(nodes[i]);
                
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }  
    }
    
}
