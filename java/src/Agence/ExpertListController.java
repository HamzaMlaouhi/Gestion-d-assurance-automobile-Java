 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence;


import Agence.Services.ExpertDAO1;
import Entities.Expert;
import java.net.URL;
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
public class ExpertListController implements Initializable {
    
     private final ObservableList<Expert> data = FXCollections.observableArrayList();

    @FXML
    private TableView<Expert> exp;
    @FXML
    private TableColumn<Expert, String> cin;
    @FXML
    private TableColumn<Expert, String> nom;
    @FXML
    private TableColumn<Expert, String> pren;
    @FXML
    private TableColumn<Expert, String> zone;
    @FXML
    private TableColumn<Expert, String> tel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ResultSet expert = new ExpertDAO1().selectAll("user");
        try {
            while(expert.next()){
              
                Expert e = new Expert();
                e.setCin(expert.getString("cin_exp"));
                e.setNom(expert.getString("nom_exp"));
                e.setPrenom(expert.getString("prenom_exp"));
                e.setZone(expert.getString("zone_exp"));
                e.setTel(expert.getString("tel_exp"));
                data.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpertListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        this.nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.pren.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        this.zone.setCellValueFactory(new PropertyValueFactory<>("zone"));
        this.tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        exp.setItems(data);
    }   
        // TODO
    }    
    

