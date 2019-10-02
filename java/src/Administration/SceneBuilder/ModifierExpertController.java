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
public class ModifierExpertController implements Initializable {
    String nomE = null; String zoneE=null;String prenomE=null; String userName=null; String mailE=null;
             String telE=null; String idE=null;
             public String nc;

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
            this.nom.setText(nomE);
       this.prenom.setText(prenomE);
        this.zone.setText(zoneE);
        this.mail.setText(mailE);
        this.username.setText(userName);
        this.tel.setText(telE);
        this.cin.setText(nc);
       this.id.setText(idE);
       
        addBtn.setOnAction(event ->{
        if(isString(this.cin.getText())|| isString(this.tel.getText()))
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "verfifier vos champ d'entier", "Erreur", JOptionPane.ERROR_MESSAGE);
        else if( this.cin.getText().length()!=8)
            JOptionPane.showMessageDialog(null, "verifier taille du CIN ", "Erreur", JOptionPane.ERROR_MESSAGE);
            
        else{
            Entities.Expert o  = new Expert(this.nom.getText(), this.id.getText(), this.prenom.getText(), this.zone.getText(), this.tel.getText(),this.cin.getText(), this.mail.getText(), this.username.getText());
            AdministrationDAO.ExpertDAO ExpDAO = new ExpertDAO();
            ExpDAO.ModifierExpert(o);
            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestExpert.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        
        }
        });
        
        });
        
        
        
        
        addBtn.setOnAction(event ->{
            
            String nomExp; String local; String uname; String prenomExp; String email; String tel;
        String carte;
        String type="expert";
        nomExp=this.nom.getText();
        prenomExp=this.prenom.getText();
        local=this.zone.getText();
        email=this.mail.getText();
        uname=this.username.getText();
        tel=this.tel.getText();
        carte=this.cin.getText();
        String ID=this.id.getText();
        if(isString(carte)|| isString(tel))
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "verfifier vos champ d'entier", "Erreur", JOptionPane.ERROR_MESSAGE);
        else if( carte.length()!=8)
            JOptionPane.showMessageDialog(null, "verifier taille du CIN ", "Erreur", JOptionPane.ERROR_MESSAGE);
            
        else{
            Entities.Expert o  = new Expert(nomExp, ID, prenomExp, local, tel, carte, email, uname);
            AdministrationDAO.ExpertDAO ExpDAO = new ExpertDAO();
            ExpDAO.ModifierExpert(o);
            
            
        
        }
             
         });
    }    

    @FXML
    private void saveAction(ActionEvent event) {
        String nomExp; String local; String uname; String prenomExp; String email; String tel;
        String carte;
        String type="expert";
        nomExp=this.nom.getText();
        prenomExp=this.prenom.getText();
        local=this.zone.getText();
        email=this.mail.getText();
        uname=this.username.getText();
        tel=this.tel.getText();
        carte=this.cin.getText();
        String ID=this.id.getText();
        if(isString(carte)|| isString(tel))
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "verfifier vos champ d'entier", "Erreur", JOptionPane.ERROR_MESSAGE);
        else if( carte.length()!=8)
            JOptionPane.showMessageDialog(null, "verifier taille du CIN ", "Erreur", JOptionPane.ERROR_MESSAGE);
            
        else{
            Entities.Expert o  = new Expert(nomExp, ID, prenomExp, local, tel, carte, email, uname);
            AdministrationDAO.ExpertDAO ExpDAO = new ExpertDAO();
            ExpDAO.ModifierExpert(o);
            
            
        
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
