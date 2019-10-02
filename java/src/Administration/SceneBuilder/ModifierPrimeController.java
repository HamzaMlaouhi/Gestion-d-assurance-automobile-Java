/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.PrimeRC_DAO;
import Entities.PrimeRC;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class ModifierPrimeController implements Initializable {
    String idP,puis,prix;

    @FXML
    private TextField puiss;
    @FXML
    private TextField price;
    @FXML
    private TextField id;
    @FXML
    private Button addBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Platform.runLater(() -> {
         
         this.id.setText(idP);
         this.price.setText(prix);
         this.puiss.setText(puis);
                    });
         addBtn.setOnAction(event ->{
         if(isString(puiss.getText()) || isString(prix))
             //Boîte du message d'erreur
            JOptionPane.showMessageDialog(null, "tapper un entier", "Erreur", JOptionPane.ERROR_MESSAGE);
        
        else{
            
        Entities.PrimeRC o  = new PrimeRC(puiss.getText(), id.getText(), price.getText());
            AdministrationDAO.PrimeRC_DAO primeDAO = new PrimeRC_DAO();
            primeDAO.ModifierPrimeRC(o);
            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestPrimeRC.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         });
      
       
    }    

    @FXML
    private void save(ActionEvent event) {
                
    }
    
     public  boolean isString(String text) {
        boolean test=false;
        try {
    int x = Integer.parseInt(text);
    }       
        catch (NumberFormatException nfe) 
        {
        test=true;
        }
        return test;
    }
    
}
