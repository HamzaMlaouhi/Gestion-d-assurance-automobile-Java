/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.CompagnieDAO;
import Entities.Compagnie;
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
public class AjoutCompagnieController implements Initializable {

    @FXML
    private TextField nomC;
    @FXML
    private TextField adress;
    @FXML
    private TextField fixe;
    @FXML
    private TextField fax;
    @FXML
    private TextField site;
    @FXML
    private TextField Uname;
    @FXML
    private TextField mail;
    @FXML
    private Button addBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addBtn.setOnAction(event ->{
            String nomC; String adr; String Wsite; String num; String faxe; String email;
        String userName;
        nomC=this.nomC.getText();
        adr=this.adress.getText();
        Wsite=this.site.getText();
        num=this.fixe.getText();
        faxe=this.fax.getText();
        email=this.mail.getText();
        userName=this.Uname.getText();
        if(this.fixe.getText().length()!=8 || this.fax.getText().length()!=8){
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "taille tel ou fix invalide", "Erreur", JOptionPane.ERROR_MESSAGE);}
        else if (this.nomC.getText().length()==0 || this.adress.getText().length()==0 ||this.site.getText().length()==0 || this.mail.getText().length()==0 || this.Uname.getText().length()==0){
            JOptionPane.showMessageDialog(null, "taille nom ,adrsse , site, mail ou nom d'utilisateur invalide", "Erreur", JOptionPane.ERROR_MESSAGE);}
            
        
        else{
            Entities.Compagnie C = new Compagnie(nomC,adr, num, faxe, Wsite, userName, email);
            CompagnieDAO CpDAO = new CompagnieDAO();
            CpDAO.AjoutCompagnie(C);
                      try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestCompagnie.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
            
        });
        
    }    

    @FXML
    private void AjoutComp(ActionEvent event) {
         String nomC; String adr; String Wsite; String num; String faxe; String email;
        String userName;
        nomC=this.nomC.getText();
        adr=this.adress.getText();
        Wsite=this.site.getText();
        num=this.fixe.getText();
        faxe=this.fax.getText();
        email=this.mail.getText();
        userName=this.Uname.getText();
        if(this.fixe.getText().length()!=8 || this.fax.getText().length()!=8)
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "taille tel ou fix invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
        else{
            Entities.Compagnie C = new Compagnie(nomC,adr, num, faxe, Wsite, userName, email);
            CompagnieDAO CpDAO = new CompagnieDAO();
            CpDAO.AjoutCompagnie(C);
        
        }
        
    }
    
}
