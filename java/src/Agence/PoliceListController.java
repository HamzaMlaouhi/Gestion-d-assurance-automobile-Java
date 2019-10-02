/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence;

import Agence.Services.PoliceDAO;
import Agence.Services.reclamationDAO;
import Entities.Police;
import Entities.PoliceEntity;
import Entities.Reclamation;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class PoliceListController implements Initializable {
    
     private final ObservableList<PoliceEntity> data = FXCollections.observableArrayList();

    @FXML
    private TableView<PoliceEntity> pol;
    @FXML
    private TableColumn<PoliceEntity, Date> dte;
    @FXML
    private TableColumn<PoliceEntity, Date> DteE;
    @FXML
    private TableColumn<PoliceEntity, String> stat;
    @FXML
    private TableColumn<PoliceEntity, Double> mnt;
    @FXML
    private TableColumn<PoliceEntity, Integer> classe;
    @FXML
    private TableColumn<PoliceEntity, Integer> asur;
    @FXML
    private TableColumn<PoliceEntity, Integer > agnc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     ResultSet police = new PoliceDAO().selectAll("police");
        try {
            while(police.next()){
             
                PoliceEntity p = new PoliceEntity();
                p.setCode_assure_id(police.getInt("code_assure_id"));
                p.setDate_effet_police(police.getDate("date_effet_police"));
                p.setDate_echeance(police.getDate("date_echeance"));
                p.setStatut(police.getString("statut"));
                p.setAgence_id(police.getInt("agence_id"));
                p.setMontant(police.getDouble("montant"));
                p.setClasse(police.getInt("classe"));
                data.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PoliceListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.asur.setCellValueFactory(new PropertyValueFactory<>("code_assure_id"));
        this.dte.setCellValueFactory(new PropertyValueFactory<>("date_effet_police"));
        this.DteE.setCellValueFactory(new PropertyValueFactory<>("date_echeance"));
        this.stat.setCellValueFactory(new PropertyValueFactory<>("statut"));
        this.agnc.setCellValueFactory(new PropertyValueFactory<>("agence_id"));
        this.mnt.setCellValueFactory(new PropertyValueFactory<>("montant"));
        this.classe.setCellValueFactory(new PropertyValueFactory<>("classe"));

        pol.setItems(data);
    }         
    
}
