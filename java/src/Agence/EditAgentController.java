/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence;

import Administration.SceneBuilder.GestCompagnieController;
import AdministrationDAO.CompagnieDAO;
import Agence.Services.AgentDAO;
import Entities.Agent;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class EditAgentController implements Initializable {

    @FXML
    private TextField uname;
    @FXML
    private TextField name;
    @FXML
    private TextField pren;
    @FXML
    private TextField tel;
    @FXML
    private TextField adr;
    @FXML
    private TextField email;
    @FXML
    private Button modif;
    @FXML
    private Button reinit;
    @FXML
    private Button supr;
    @FXML
    private TextField cin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        modif.setOnAction(event ->{
       
            Entities.Agent o  = new Agent();
            AgentDAO agDAO = new AgentDAO();
            o.setAdresse(adr.getText());
            
            o.setEmail(email.getText());
            o.setNom(name.getText());
            o.setPrenom(pren.getText());
            o.setTel(tel.getText());
            o.setUname(uname.getText());
            o.setCin(cin.getText());
            agDAO.ModifierAgent(o);
            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("EditAgent.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        
        
        });
        
            this.supr.setOnAction(event -> {
    String nomC = this.cin.getText();
    AgentDAO AgDAO = new AgentDAO();
    AgDAO.DeleteAction(nomC);
    try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestCompagnie.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
});
    }     
}
