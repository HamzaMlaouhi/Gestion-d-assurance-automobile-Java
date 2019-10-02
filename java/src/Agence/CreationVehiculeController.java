/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence;

import Administration.SceneBuilder.GestCompagnieController;
import Agence.Services.VehiculeDAO;
import Entities.Vehicule;
import Shared.StageManager;
import java.io.IOException;
import java.sql.Date;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class CreationVehiculeController implements Initializable {

    @FXML
    private Button save;
    @FXML
    private TextField ch;
    @FXML
    private TextField ref;
    @FXML
    private TextField carb;
    @FXML
    private TextField nbrp;
    @FXML
    private TextField valv;
    @FXML
    private TextField puis;
    @FXML
    private DatePicker date;
    @FXML
    private ChoiceBox<?> prime;
    @FXML
    private TextField modl;
    @FXML
    private Button btn5;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        save.setOnAction((ActionEvent event) -> {
            
                Entities.Vehicule v = new Vehicule();
                v.setCarburant(carb.getText());
                v.setChassis(ch.getText());
                v.setDate_circule(Date.valueOf(date.getValue()));
                v.setModele(modl.getText());
                v.setNombre_pneu(Integer.valueOf(nbrp.getText()));
               // v.setPrimeRc(Double.valueOf(prime.getValue().toString()));
                v.setPuissance(Integer.valueOf(puis.getText()));
                v.setRef_contrat_id(Integer.valueOf(ref.getText()));
                v.setVal_venale(Integer.valueOf(valv.getText()));
                
                 if(Integer.valueOf(nbrp.getText())!=4 ) {
                     JOptionPane.showMessageDialog(null, "Nombre de pneu doit étre égal à 4 ", "Erreur", JOptionPane.ERROR_MESSAGE);
                 }
                     
                 else if (Integer.valueOf(puis.getText())!=12){
            //Boîte du message d'erreur
           JOptionPane.showMessageDialog(null, "la puissance fiscale ne doit pas dépasser 12 cheveaux", "Erreur", JOptionPane.ERROR_MESSAGE);
                 }
                
                else {
                
                Agence.Services.VehiculeDAO vdao = new VehiculeDAO();
                vdao.AjoutVehicule(v);
            
                 } });
        
          btn5.setOnAction((ActionEvent event) ->{
        try {
                Pane newPane = FXMLLoader.load(getClass().getResource("vehiculeList.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
    }    
    
}

