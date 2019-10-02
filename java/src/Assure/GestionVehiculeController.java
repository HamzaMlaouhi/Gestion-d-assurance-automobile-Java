/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure;

import Assure.ServiceAssure.VehiculeService;
import Entities.Vehicule;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author azizi
 */

  

public class GestionVehiculeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Vehicule> table;
    private final ObservableList<Vehicule> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Vehicule, String> chassis;
    @FXML
    private TableColumn<Vehicule, Date> Datecircule;
    @FXML
    private TableColumn<Vehicule, String> Puissance;
    @FXML
    private TableColumn<Vehicule, String>Nombrepneu;
    @FXML
    private TableColumn<Vehicule,String>Valvenale;
    @FXML
     private TableColumn<Vehicule,String>Carburant;
     @FXML
    private TableColumn<Vehicule,String>Primerc;
        @FXML
    private TextField critere;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
              ResultSet vehicule = new VehiculeService().selectAll("Vehicule");
        try {
            while(vehicule.next()){

            Vehicule r =new Vehicule();
             r.setChassis(vehicule.getString("chassis"));
                    r.setDate_circule(vehicule.getDate("date_circule"));
                    r.setPuissance(Integer.valueOf(vehicule.getString("puissance")));
                    r.setCarburant(vehicule.getString("carburant"));
                    r.setNombre_pneu(Integer.valueOf(vehicule.getString("nombre_pneu")));
                    r.setVal_venale(Integer.valueOf(vehicule.getString("val_venale")));
                    r.setPrime_rc_id(Integer.valueOf(vehicule.getString("prime_rc_id"))); 

            data.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.Carburant.setCellValueFactory(new PropertyValueFactory<>("carburant"));
        this.chassis.setCellValueFactory(new PropertyValueFactory<>("chassis"));
    this.Datecircule.setCellValueFactory(new PropertyValueFactory<>("date_circule"));
    this.Puissance.setCellValueFactory(new PropertyValueFactory<>("puissance"));
        this.Nombrepneu.setCellValueFactory(new PropertyValueFactory<>("nombre_pneu"));
       this.Valvenale.setCellValueFactory(new PropertyValueFactory<>("val_venale"));
        this.Primerc.setCellValueFactory(new PropertyValueFactory<>("prime_rc_id"));
        table.setItems(data);
    }    
    
    
    
    
}
