/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert;

import Entities.Expert;
import Entities.Reclamation;
import Expert.Service.ExpertDAO;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjoutExpertController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField cin;
    @FXML
    private TextField tel;
    @FXML
    private TextField zone;
    @FXML
    private Button ajouter;
    @FXML
    private TextField Uname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ajouter.setOnAction(event ->{          
        Expert r=new Expert();
          if (this.nom.getText().length()==0)
            JOptionPane.showMessageDialog(null, "il faut remplir le champ nom", "Erreur", JOptionPane.ERROR_MESSAGE);
        else
        r.setNom(this.nom.getText());
           if (this.prenom.getText().length()==0)
            JOptionPane.showMessageDialog(null, "il faut remplir le champ prenom", "Erreur", JOptionPane.ERROR_MESSAGE);
        else
        r.setPrenom(this.prenom.getText());
            if (this.zone.getText().length()==0)
            JOptionPane.showMessageDialog(null, "il faut remplir le champ zone", "Erreur", JOptionPane.ERROR_MESSAGE);
        else
        r.setZone(this.zone.getText());
        if (this.cin.getText().length()!=8)
            JOptionPane.showMessageDialog(null, "taille cin invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
        else
        r.setCin(this.tel.getText());
         if (this.tel.getText().length()!=8)
            JOptionPane.showMessageDialog(null, "taille tel invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
        else
        r.setTel(this.tel.getText());
          if (this.Uname.getText().length()==0)
            JOptionPane.showMessageDialog(null, "il faut remplir le champ uname", "Erreur", JOptionPane.ERROR_MESSAGE);
        else
        r.setUname(this.Uname.getText());
        ExpertDAO ex =new ExpertDAO();
        ex.ajouter(r);
        });
    }    
    
}
