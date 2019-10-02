/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence;

import Administration.SceneBuilder.GestCompagnieController;
import Agence.Services.AgentDAO;
import Entities.Agent;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class CreationAgentController implements Initializable {

    @FXML
    private TextField tel;
    @FXML
    private TextField adr;
    @FXML
    private TextField pren;
    @FXML
    private TextField nom;
    @FXML
    private TextField cin;
    @FXML
    private Button btn;
    @FXML
    private TextField uname;
    @FXML
    private Button btn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Entities.Agent a = new Agent();
                a.setCin(cin.getText());
                a.setNom(nom.getText());
                a.setPrenom(pren.getText());
                a.setTel(tel.getText());
                a.setAdresse(adr.getText());
                a.setUname(uname.getText());
                
                if(cin.getText().length()!=8 || tel.getText().length()!=8)
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "taille CIN ou Téléphone invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
                
                else {
                        AgentDAO dao = new AgentDAO();
                        dao.AjoutAgent(a);
            }}
        });
    
         btn1.setOnAction((ActionEvent event) ->{
        try {
                Pane newPane = FXMLLoader.load(getClass().getResource("AgentList.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
       
    }   
}
