/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import Entities.Compagnie;
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

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class ChercheCompagnieController implements Initializable {
    
     Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;
    public Entities.Compagnie cp;
    @FXML
    private TextField nomC;
    @FXML
    private Button chercherBtn;
    
        String nomCompagnie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        chercherBtn.setOnAction(event ->{
            try {
                nomCompagnie = this.nomC.getText();
                //System.out.println(nomCompagnie);
                FXMLLoader res = new FXMLLoader(getClass().getResource("ResCompagnie.fxml"));
                Parent root = (Parent)res.load();
                ResCompagnieController controller = res.<ResCompagnieController>getController();
                controller.nc=nomCompagnie;
                // Parent page1 = FXMLLoader.load(getClass().getResource("ResCompagnie.fxml"));
                
                
                StageManager.vcontent.getChildren().setAll(root);
            

            } catch (IOException ex) {
                Logger.getLogger(ChercheCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    

    @FXML
    private void ChercheCompagnieAction(ActionEvent event) {
    }

    public Compagnie getCp() {
        return cp;
    }
    
    
}
