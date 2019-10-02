/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert;

import Entities.Reclamation;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjoutRapportController implements Initializable {

    @FXML
    private DatePicker date;
    @FXML
    private TextField titre;
    @FXML
    private TextField detail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterRapport(ActionEvent event) {
        Reclamation r=new Reclamation();
        r.setDate_rap(Date.valueOf(this.date.getValue()));
         if (this.titre.getText().length()==0)
            JOptionPane.showMessageDialog(null, "il faut remplir le champ titre", "Erreur", JOptionPane.ERROR_MESSAGE);
        else
        r.setTitre_rap(this.titre.getText());
         if (this.detail.getText().length()==0)
            JOptionPane.showMessageDialog(null, "il faut remplir le champ detaille", "Erreur", JOptionPane.ERROR_MESSAGE);
        else
        r.setDetaille_rap(this.detail.getText());

        Expert.Service.ReclamationDAO ex =new Expert.Service.ReclamationDAO();
        ex.AjoutRapport(r);
    }
       @FXML
    private void affichagerectBtn(ActionEvent event) throws IOException {
         StageManager.vcontent.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("./AffichageRapport.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
        
    }
    
}
