/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.ExpertDAO;
import Entities.Expert;
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
public class AjoutExpertController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField cin;
    @FXML
    private TextField username;
    @FXML
    private TextField mail;
    @FXML
    private TextField zone;
    @FXML
    private TextField tel;
    @FXML
    private Button addExpertBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        addExpertBtn.setOnAction(event ->{
            String nomExp; String local; String Uname; String prenomExp; String email; String tel;
        String carte;
       
        nomExp=this.nom.getText();
        prenomExp=this.prenom.getText();
        local=this.zone.getText();
        email=this.mail.getText();
        Uname=this.username.getText();
        tel=this.tel.getText();
        carte=this.cin.getText();
        if(isString(carte)|| isString(tel))
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "verfifier vos champ d'entier", "Erreur", JOptionPane.ERROR_MESSAGE);
        else if( carte.length()!=8 || this.tel.getText().length()!=8)
            JOptionPane.showMessageDialog(null, "verifier taille du CIN ou du téléphone ", "Erreur", JOptionPane.ERROR_MESSAGE);
        else if (this.nom.getText().length()==0 || this.prenom.getText().length()==0 ||this.zone.getText().length()==0 || this.mail.getText().length()==0 || this.username.getText().length()==0){
            JOptionPane.showMessageDialog(null, "taille nom ,prenom ,zone, mail ou nom d'utilisateur invalide", "Erreur", JOptionPane.ERROR_MESSAGE);}
            
        else{
            Entities.Expert o = new Expert(nomExp, prenomExp, local, tel, carte, email, Uname);
            AdministrationDAO.ExpertDAO ExpDAO = new ExpertDAO();
            ExpDAO.AjouterExpert(o);
            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestExpert.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
            
        });
        }
        

    @FXML
    private void addAction(ActionEvent event) {
        String nomExp; String local; String Uname; String prenomExp; String email; String tel;
        String carte;
       
        nomExp=this.nom.getText();
        prenomExp=this.prenom.getText();
        local=this.zone.getText();
        email=this.mail.getText();
        Uname=this.username.getText();
        tel=this.tel.getText();
        carte=this.cin.getText();
        if(isString(carte)|| isString(tel))
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "verfifier vos champ d'entier", "Erreur", JOptionPane.ERROR_MESSAGE);
        else if( carte.length()!=8)
            JOptionPane.showMessageDialog(null, "verifier taille du CIN ", "Erreur", JOptionPane.ERROR_MESSAGE);
            
        else{
            Entities.Expert o = new Expert(nomExp, prenomExp, local, tel, carte, email, Uname);
            AdministrationDAO.ExpertDAO ExpDAO = new ExpertDAO();
            ExpDAO.AjouterExpert(o);
        
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
