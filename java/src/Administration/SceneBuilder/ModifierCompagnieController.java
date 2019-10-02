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
public class ModifierCompagnieController implements Initializable {
    public String nc = null;
    public String nomC; public String adrs; public String Wsite; public String num; public String faxe; public String email;
        public String username; public String Id=null; 
    
    @FXML
    private TextField id;
    @FXML
    private TextField nomCompagnie;
    @FXML
    private TextField adr;
    @FXML
    private TextField fix;
    @FXML
    private TextField fax;
    @FXML
    private TextField site;
    @FXML
    private TextField userName;
    @FXML
    private TextField mail;
    private Button modifier;
    @FXML
    private Button modifierBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {
       // modifier.setOnAction(event ->{
         
        nomC=this.nomCompagnie.getText();
        nomCompagnie.setText(nc);
        adr.setText(adrs);
       site.setText(Wsite);
        id.setText(Id);
        mail.setText(email);
        userName.setText(username);
        fix.setText(num);
        fax.setText(faxe);
        
        modifierBtn.setOnAction(event ->{   
        if(this.fix.getText().length()!=8 || this.fax.getText().length()!=8)
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "taille tel ou fix invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
        else{
            Entities.Compagnie C = new Compagnie(nomCompagnie.getText(),this.id.getText(), this.adr.getText(), this.fix.getText(), this.fax.getText(), this.site.getText(), this.userName.getText(), this.mail.getText());
            CompagnieDAO CpDAO = new CompagnieDAO();
            CpDAO.ModifierCompagnie(C);
            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestCompagnie.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
            
    
                });
        
        
                });
        
        
    }    

    @FXML
    private void saveAction(ActionEvent event) {
//        String nomC; String adr; String Wsite; String num; String faxe; String email;
//        String userName; String type="compagnie";
//        nomC=this.nomCompagnie.getText();
//        adr=this.adr.getText();
//        Wsite=this.site.getText();
//        String ID=this.id.getText();
//        email=this.mail.getText();
//        userName=this.userName.getText();
//        num=this.fix.getText();
//        faxe=this.fax.getText();
//        if(this.fix.getText().length()!=8 || this.fax.getText().length()!=8)
//            //Boîte du message d'erreur
//           JOptionPane.showMessageDialog(null, "taille tel ou fix invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
//        else{
//            Entities.Compagnie C = new Compagnie(nomC, ID, adr, num, faxe, Wsite, userName, email);
//            CompagnieDAO CpDAO = new CompagnieDAO();
//            CpDAO.ModifierCompagnie(C);
//            
//        
//        }
    }
    
}
