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
public class AjoutCourtierController implements Initializable {

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
    private TextField cin;
    @FXML
    private Button addbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addbtn.setOnAction(event ->{
            String nomC; String local; String Uname;String email; String commi;
        String carte;
        nomC=this.nom.getText();
        local=this.lieu.getText();
        email=this.mail.getText();
        Uname=this.username.getText();
        commi=this.commission.getText();
        carte=this.cin.getText();
        if(isString(commi)|| isString(carte))
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "verfifier vos champ d'entier", "Erreur", JOptionPane.ERROR_MESSAGE);
        else if( carte.length()!=8)
            JOptionPane.showMessageDialog(null, "verifier taille du CIN ", "Erreur", JOptionPane.ERROR_MESSAGE);
        else if (this.nom.getText().length()==0 || this.lieu.getText().length()==0 ||this.commission.getText().length()==0 || this.username.getText().length()==0 || this.cin.getText().length()==0){
            JOptionPane.showMessageDialog(null, "taille nom ,lieu , commission ou usernme  d'utilisateur invalide", "Erreur", JOptionPane.ERROR_MESSAGE);}
            
        else{
            AdministrationDAO.CourtierDAO CourDAO  = new CourtierDAO();
            Entities.Courtier o = new Courtier(nomC, local, commi, carte, email, Uname);
            CourDAO.AjoutCourtier(o);
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
    private void addCourtierAction(ActionEvent event) {
        
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
