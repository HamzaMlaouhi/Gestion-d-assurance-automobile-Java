/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert;

import Entities.Reclamation;
import Expert.Service.ReclamationDAO;
import Shared.StageManager;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class EditerRapportController implements Initializable {

    @FXML
    private TextField date;
    @FXML
     TextField titre;
    @FXML
    private TextField detaille;
    @FXML
    private TextField document;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }   
      @FXML
    private void update(ActionEvent event) {
        
  Reclamation r=new Reclamation();
          System.out.println(Date.valueOf(this.date.getText()));
        r.setDate_rap(Date.valueOf(this.date.getText()));
        r.setTitre_rap(this.titre.getText());
        r.setDetaille_rap(this.detaille.getText());

        Expert.Service.ReclamationDAO ex =new Expert.Service.ReclamationDAO();
        ex.update("reclamation",r);
    }
    
}
