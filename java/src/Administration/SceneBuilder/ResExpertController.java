/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.ExpertDAO;
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
public class ResExpertController implements Initializable {
    public String nc;
    Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;

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
            String nom = null; String zone=null;String prenom=null; String userName=null; String mail=null;
             String tel=null; String id=null;
             try {
             String req = " SELECT * FROM user where cin_exp ='"+nc+"' and type='expert'";
             st= cn.createStatement();
             ResultSet ss = st.executeQuery(req);
             while(ss.next()){
                 userName=ss.getString("username");
                 nom=ss.getString("nom_exp");
                 mail=ss.getString("email");
                 zone=ss.getString("zone_exp");
                 tel=Integer.toString(ss.getInt("tel_exp"));
                 id=Integer.toString(ss.getInt("id"));
                 prenom=ss.getString("prenom_exp");
                
             }
             if(id != null){
             this.cin.setText(nc);
             this.mail.setText(mail);
             this.nom.setText(nom);
             this.tel.setText(tel);
             this.prenom.setText(prenom);
             this.username.setText(userName);
             this.zone.setText(zone);
             this.id.setText(id);}
             else {
         JOptionPane.showMessageDialog(null, "n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
   
            Pane newPane; 
    try {
        newPane = FXMLLoader.load(getClass().getResource("ChercheExpert.fxml"));
          StageManager.vcontent.getChildren().setAll(newPane);
    } catch (IOException ex) {
        Logger.getLogger(ResCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
    }
         
            
        }
             
         } catch (SQLException ex) {
             Logger.getLogger(ResExpertController.class.getName()).log(Level.SEVERE, null, ex);
         }
             
             });
             
             
             
             
         deleteBtn.setOnAction(event -> {
            String Cin = this.cin.getText();
        AdministrationDAO.ExpertDAO ExpDAO = new ExpertDAO();
            ExpDAO.DeleteExpert(Cin);
           try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestExpert.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        modifierBtn.setOnAction(event ->{
            try {
                //String nomComp = this.nomCompagnie.getText();
                //System.out.println(nomCompagnie);
                FXMLLoader res = new FXMLLoader(getClass().getResource("ModifierExpert.fxml"));
                Parent root = (Parent)res.load();
                ModifierExpertController controller = res.<ModifierExpertController>getController();
                controller.nc=cin.getText();
                controller.idE=id.getText();
                controller.mailE=mail.getText();
                controller.nomE=nom.getText();
                controller.prenomE=prenom.getText();
                controller.telE=tel.getText();
                controller.userName=username.getText();
                controller.zoneE=zone.getText();
                StageManager.vcontent.getChildren().setAll(root);

            } catch (IOException ex) {
                Logger.getLogger(ChercheCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
         });
    }

    @FXML
    private void deleteAction(ActionEvent event) {
        String Cin = this.cin.getText();
        AdministrationDAO.ExpertDAO ExpDAO = new ExpertDAO();
            ExpDAO.DeleteExpert(Cin);
    }

    @FXML
    private void modifiAction(ActionEvent event) {
    }
    
}
