/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.PrimeRC_DAO;
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
public class ResPrimeRCController implements Initializable {
    
    public String nc;
Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;
    @FXML
    private TextField puiss;
    @FXML
    private TextField price;
    @FXML
    private Button supprimerBtn;
    @FXML
    private Button modifierBtn;
    @FXML
    private TextField ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        Platform.runLater(() -> {
            try {
                String idP = null;
                String puiss = null;
                String Prix = null;
                String req = " SELECT * FROM primerc where puissance_fiscale ='"+nc+"'";
                st= cn.createStatement();
                ResultSet ss = st.executeQuery(req);
                while(ss.next()){
                    puiss=ss.getString("puissance_fiscale");
                    Prix=ss.getString("prix");
                    idP=Integer.toString(ss.getInt("id"));
                    
                }
                
                if(idP != null){
                
              this.price.setText(Prix);
              this.puiss.setText(puiss);
              this.ID.setText(idP);}
                else {
         JOptionPane.showMessageDialog(null, "n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
   
            Pane newPane; 
    try {
        newPane = FXMLLoader.load(getClass().getResource("ChercherPrime.fxml"));
          StageManager.vcontent.getChildren().setAll(newPane);
    } catch (IOException ex) {
        Logger.getLogger(ResCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
    }
         
            
        }
              
              
            } catch (SQLException ex) {
                Logger.getLogger(ResPrimeRCController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        });

        
        
        
        
        
        supprimerBtn.setOnAction(event -> {
            String pss = this.ID.getText();
            AdministrationDAO.PrimeRC_DAO primeDAO = new PrimeRC_DAO();
            primeDAO.DeletePrimeRC(pss);
                try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestPrimeRC.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        modifierBtn.setOnAction(event ->{
            try {
                String idP = this.ID.getText();
                //System.out.println(nomCompagnie);
                FXMLLoader res = new FXMLLoader(getClass().getResource("ModifierPrime.fxml"));
                Parent root = (Parent)res.load();
                ModifierPrimeController controller = res.<ModifierPrimeController>getController();
                controller.puis=this.puiss.getText();
                controller.prix=this.price.getText();
                controller.idP=this.ID.getText();
               StageManager.vcontent.getChildren().setAll(root);
            } catch (IOException ex) {
                Logger.getLogger(ResPrimeRCController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
    });
    }    

    @FXML
    private void supprimerAction(ActionEvent event) {
        String pss = this.puiss.getText();
            AdministrationDAO.PrimeRC_DAO primeDAO = new PrimeRC_DAO();
            primeDAO.DeletePrimeRC(pss);
    }

    @FXML
    private void modifierAction(ActionEvent event) {
    }
    
}
