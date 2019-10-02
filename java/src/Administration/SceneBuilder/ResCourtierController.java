/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.CourtierDAO;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class ResCourtierController implements Initializable {
     public String nc;
    Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

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
    private TextField id;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button modifierBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {
            try {
                String nom = null; String lieu=null;String commission=null; String userName=null; String mail=null;String id=null;
                String req = " SELECT * FROM user where cin='"+nc+"' and type ='courtier' ";
                st= cn.createStatement();
                ResultSet ss = st.executeQuery(req);
                while(ss.next()){
                    userName=ss.getString("username");
                    nom=ss.getString("nom");
                    mail=ss.getString("email");
                    lieu=ss.getString("adresse");
                    commission=Integer.toString(ss.getInt("commission"));
                    id = Integer.toString(ss.getInt("id"));
                    
                }
                if(id != null){
                
                this.cin.setText(nc);
                this.commission.setText(commission);
                this.lieu.setText(lieu);
                this.mail.setText(mail);
                this.nom.setText(nom);
                this.username.setText(userName);
                this.id.setText(id);}
                else {
         JOptionPane.showMessageDialog(null, "n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
   
            Pane newPane; 
    try {
        newPane = FXMLLoader.load(getClass().getResource("ChercherCourtier.fxml"));
          StageManager.vcontent.getChildren().setAll(newPane);
    } catch (IOException ex) {
        Logger.getLogger(ResCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
    }
         
            
        }
            } catch (SQLException ex) {
                Logger.getLogger(ResCourtierController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
        deleteBtn.setOnAction(event -> {
            String idC = this.cin.getText();
            System.out.println(idC);
            AdministrationDAO.CourtierDAO CourDAO = new CourtierDAO();
                CourDAO.DeleteCourtier(idC);
                try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestionCourtier.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        modifierBtn.setOnAction(event ->{
            try {
                FXMLLoader res = new FXMLLoader(getClass().getResource("ModifierCourtier.fxml"));
                Parent root = (Parent)res.load();
                ModifierCourtierController controller = res.<ModifierCourtierController>getController();
                controller.nomC=nom.getText();
                controller.userNameC=username.getText();
                controller.commissionC=commission.getText();
                controller.idC=id.getText();
                controller.lieuC=lieu.getText();
                controller.mailC=mail.getText();
                StageManager.vcontent.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(ResCourtierController.class.getName()).log(Level.SEVERE, null, ex);
            }
    });
        
        
    }    

    @FXML
    private void deleteAction(ActionEvent event) {
       
    }

    @FXML
    private void modifierAction(ActionEvent event) {
    }
    
}
