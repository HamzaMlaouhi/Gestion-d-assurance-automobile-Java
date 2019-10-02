/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.CourtierDAO;
import Entities.Courtier;
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
public class ModifierCourtierController implements Initializable {
    String nomC = null; String lieuC=null;String commissionC=null; String userNameC=null; String mailC=null;String idC=null;
                

    @FXML
    private TextField nom;
    @FXML
    private TextField lieu;
    @FXML
    private TextField commission;
    @FXML
    private TextField username;
    @FXML
    private TextField mail;
    @FXML
    private Button addbtn;
    @FXML
    private TextField id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {
        this.nom.setText(nomC);
        this.lieu.setText(lieuC);
        this.mail.setText(mailC);
        this.username.setText(userNameC);
        this.commission.setText(commissionC);
        this.id.setText(idC);
        
        });
         addbtn.setOnAction(event ->{
           if(isString( this.commission.getText()))
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "verfifier vos champ d'entier", "Erreur", JOptionPane.ERROR_MESSAGE);
        else{
            AdministrationDAO.CourtierDAO CourDAO  = new CourtierDAO();
            Entities.Courtier o = new Courtier(this.nom.getText(), this.lieu.getText(), this.commission.getText(), this.id.getText(), this.mail.getText(), this.username.getText());
            CourDAO.ModifierCourtier(o);
            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestionCourtier.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        
        }
             
         });
         }
        

    @FXML
    private void ModifierCourtier(ActionEvent event) {
         String nomC; String local; String Un; int flouss;String email; String commi;
         String type="courtier";
        nomC=this.nom.getText();
        local=this.lieu.getText();
        email=this.mail.getText();
        Un=this.username.getText();
        commi=this.commission.getText();
        String ID= this.id.getText();
        if(isString(commi))
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "verfifier vos champ d'entier", "Erreur", JOptionPane.ERROR_MESSAGE);
        else{
            AdministrationDAO.CourtierDAO CourDAO  = new CourtierDAO();
            Entities.Courtier o = new Courtier(nomC, local, commi, ID, email, Un);
            CourDAO.ModifierCourtier(o);
           
        
        }
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
