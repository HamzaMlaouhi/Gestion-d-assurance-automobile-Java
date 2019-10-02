/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure;

import Assure.ServiceAssure.ReclamationService;
import Entities.Reclamation;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class GestionReclamationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private TableView<Reclamation> table;
     private ObservableList<Reclamation> data;
    @FXML
    private TableColumn<Reclamation, Date> date;
    @FXML
    private TableColumn<Reclamation, String> lieu;
    @FXML
    private TableColumn<Reclamation, String> objet;
    @FXML
    private TableColumn<Reclamation, String>comm;
    @FXML
    private TableColumn<Reclamation,String>code;
        @FXML
    private TextField critere;
    
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         this.data = FXCollections.observableArrayList();
         ResultSet reclamation = new ReclamationService().selectAll("Reclamation");
        try {
            while(reclamation.next()){

            Reclamation r =new Reclamation(reclamation.getString("code_sinistre_id"),
                    reclamation.getString("commentaire_rec"),
                    reclamation.getDate("date_rec"),
                    reclamation.getString("lieu_rec"),
                    reclamation.getString("objet_rec"));
            data.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.date.setCellValueFactory(new PropertyValueFactory<>("date_rec"));
    this.lieu.setCellValueFactory(new PropertyValueFactory<>("lieu_rec"));
    this.objet.setCellValueFactory(new PropertyValueFactory<>("objet_rec"));
        this.comm.setCellValueFactory(new PropertyValueFactory<>("commentaire_rec"));
       this.code.setCellValueFactory(new PropertyValueFactory<>("code_sinistre_id"));
        table.setItems(data);
  }
    
            @FXML
    private void ajouteraction(ActionEvent event) throws IOException {
       Pane newPane = FXMLLoader.load(getClass().getResource("AjouterReclamation.fxml"));
      StageManager.vcontent.getChildren().setAll(newPane);
    }

        @FXML
    private void chercher(ActionEvent event) {
        this.data = FXCollections.observableArrayList();
        ResultSet recalamtion = new ReclamationService().chercher(this.critere.getText());
        try {
            while(recalamtion.next()){
                Reclamation rec =new Reclamation(
                        recalamtion.getString("commentaire_rec"),
                        recalamtion.getDate("date_rec"),
                        recalamtion.getString("lieu_rec"),
                        recalamtion.getString("objet_rec"));
                        
//                        garanties.getString("nom"), 
//                        garanties.getDouble("tarif_de_base"), 
//                        garanties.getDouble("niv_franchise"), 
//                        garanties.getDouble("prime_de_base"),
//                        garanties.getDouble("surprime"));
                data.add(rec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.comm.setCellValueFactory(new PropertyValueFactory<>("commentaire_rec"));
        this.date.setCellValueFactory(new PropertyValueFactory<>("date_rec"));
        this.lieu.setCellValueFactory(new PropertyValueFactory<>("lieu_rec"));
        this.objet.setCellValueFactory(new PropertyValueFactory<>("objet_rec"));
        table.setItems(data);
    }
//    
//      @FXML
//    private void btn_ajouter(ActionEvent event) throws IOException {
//        Pane newPane = FXMLLoader.load(getClass().getResource("AjouterReclamation.fxml"));
//        StageManager.content.getChildren().setAll(newPane);
//      
//    }
//    
}
