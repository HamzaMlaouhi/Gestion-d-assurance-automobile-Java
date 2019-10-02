/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure;

import Assure.ServiceAssure.ConstatService;
import Assure.ServiceAssure.ReclamationService;
import Entities.Constat;
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
public class GestionConstatController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TableView<Constat> table;
    private final ObservableList<Constat> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Constat, String> code;
    @FXML
    private TableColumn<Constat, String> croquis;
    @FXML
    private TableColumn<Constat, String>matricule;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                 ResultSet constat = new ConstatService().selectAll("Constat");
        try {
            while(constat.next()){

            Constat r =new Constat(constat.getInt("code_rec"),
                    constat.getString("Croquis"),
                    constat.getString("Matricule_autrui"));
       
                    
            data.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionConstatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.code.setCellValueFactory(new PropertyValueFactory<>("code_rec"));
    this.croquis.setCellValueFactory(new PropertyValueFactory<>("Croquis"));
    this.matricule.setCellValueFactory(new PropertyValueFactory<>("Matricule_autrui"));
        table.setItems(data);
    }    
    
    
     @FXML
    private void ajouteraction(ActionEvent event) throws IOException {
       Pane newPane = FXMLLoader.load(getClass().getResource("AjouterConstat.fxml"));
      StageManager.content.getChildren().setAll(newPane);
    }
    
}
