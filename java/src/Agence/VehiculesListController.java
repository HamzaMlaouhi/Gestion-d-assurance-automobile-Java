/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence;

import Administration.SceneBuilder.GestCompagnieController;
import Agence.Services.VehiculeDAO;
import Agence.Services.VehiculeDAO;
import Agence.Services.VehiculeDAO;
import Entities.Vehicule;
import Entities.Vehicule;
import Entities.Vehicule;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class VehiculesListController implements Initializable {
    
    private final ObservableList<Vehicule> data = FXCollections.observableArrayList();

    @FXML
    private TableView<Vehicule> veh;
    @FXML
    private TableColumn<Vehicule, String> chas;
    @FXML
    private TableColumn<Vehicule,Date > dtec;
    @FXML
    private TableColumn<Vehicule, Integer> puis;
    @FXML
    private TableColumn<Vehicule, String> carb;
    @FXML
    private TableColumn<Vehicule, Integer> nbrp;
    @FXML
    private TableColumn<Vehicule, Integer> valV;
    @FXML
    private TableColumn<Vehicule, Integer> ref;
    @FXML
    private TableColumn<Vehicule, String> modl;
    @FXML
    private TableColumn action;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.chas.setCellFactory(TextFieldTableCell.forTableColumn());
        this.carb.setCellFactory(TextFieldTableCell.forTableColumn());
        this.nbrp.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        this.modl.setCellFactory(TextFieldTableCell.forTableColumn());
        this.ref.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        this.valV.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter())); 
         
        this.puis.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter())); 

             
             veh.setEditable(true);
         ResultSet vehicule = new VehiculeDAO().selectAll("vehicule");
        try {
            while(vehicule.next()){
                Vehicule v = new Vehicule();
                v.setChassis(vehicule.getString("chassis"));
                v.setModele(vehicule.getString("modele"));
                v.setDate_circule(vehicule.getDate("date_circule"));
                v.setPuissance(vehicule.getInt("puissance"));
                v.setCarburant(vehicule.getString("carburant"));
                v.setNombre_pneu(vehicule.getInt("nombre_pneu"));
                v.setVal_venale(vehicule.getDouble("val_venale"));
                v.setRef_contrat_id(vehicule.getInt("ref_contrat_id"));
               



                data.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculesListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.chas.setCellValueFactory(new PropertyValueFactory<>("chassis"));
        this.dtec.setCellValueFactory(new PropertyValueFactory<>("date_circule"));
        this.puis.setCellValueFactory(new PropertyValueFactory<>("puissance"));
        this.ref.setCellValueFactory(new PropertyValueFactory<>("ref_contrat_id"));
        this.valV.setCellValueFactory(new PropertyValueFactory<>("val_venale"));
        this.nbrp.setCellValueFactory(new PropertyValueFactory<>("nombre_pneu"));
        this.modl.setCellValueFactory(new PropertyValueFactory<>("modele"));
        this.carb.setCellValueFactory(new PropertyValueFactory<>("carburant"));

   Callback<TableColumn<Entities.Vehicule, String>, TableCell<Entities.Vehicule, String>> cellFactory =
           (TableColumn<Vehicule, String> param) -> {
               final Button btn = new Button("supprimer");
               final TableCell<Vehicule, String> cell = new TableCell<Vehicule, String>() {
                   
                   
                   public void updateItem(String item, boolean empty) {
                       super.updateItem(item, empty);
                       if (empty) {
                           setGraphic(null);
                           setText(null);
                       } else {
                           btn.setOnAction(event -> {
                                VehiculeDAO dao = new VehiculeDAO();
                               Vehicule Vehicule = getTableView().getItems().get(getIndex());
                               String chassis =Vehicule.getChassis();
                            
                               //expDao.SetEnabled(cin);
                               dao.DeleteAction(chassis);
                               
//                               try {
//                                        Pane newPane = FXMLLoader.load(getClass().getResource("vehiculesList.fxml")); 
//                                        StageManager.vcontent.getChildren().setAll(newPane);
//                                } catch (IOException ex) {
//                                        Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
//                                    }
                           });
                           setGraphic(btn);
                           setText(null);
                       }
                   };
               };
               
               
               return cell;
        };
        action.setCellFactory(cellFactory);
        veh.setItems(data);
    } 
    @FXML
    private void puissanceChnage(TableColumn.CellEditEvent<Vehicule, Integer> event) {
        Vehicule vehicule = veh.getSelectionModel().getSelectedItem();
        vehicule.setPuissance(event.getNewValue());
        VehiculeDAO dao = new VehiculeDAO();
        dao.ModifierVehicule(vehicule);
    }
    @FXML
    private void modeleChnage(TableColumn.CellEditEvent<Vehicule, String> event) {
        Vehicule vehicule = veh.getSelectionModel().getSelectedItem();
        vehicule.setModele(event.getNewValue());
        VehiculeDAO dao = new VehiculeDAO();
        dao.ModifierVehicule(vehicule);
    }
    @FXML
    private void dateChnage(TableColumn.CellEditEvent<Vehicule, Date> event) {
        Vehicule vehicule = veh.getSelectionModel().getSelectedItem();
        vehicule.setDate_circule(event.getNewValue());
        VehiculeDAO dao = new VehiculeDAO();
        dao.ModifierVehicule(vehicule);
    }
    @FXML
    private void carburantChnage(TableColumn.CellEditEvent<Vehicule, String> event) {
        Vehicule vehicule = veh.getSelectionModel().getSelectedItem();
        vehicule.setCarburant(event.getNewValue());
        VehiculeDAO dao = new VehiculeDAO();
        dao.ModifierVehicule( vehicule);
    }
    @FXML
    private void nombreChnage(TableColumn.CellEditEvent<Vehicule, Integer> event) {
        Vehicule vehicule = veh.getSelectionModel().getSelectedItem();
        vehicule.setNombre_pneu(event.getNewValue());
        VehiculeDAO dao = new VehiculeDAO();
        dao.ModifierVehicule(vehicule);
    }
    @FXML
    private void valvChnage(TableColumn.CellEditEvent<Vehicule, Integer> event) {
        Vehicule vehicule = veh.getSelectionModel().getSelectedItem();
        vehicule.setVal_venale(event.getNewValue());
        VehiculeDAO dao = new VehiculeDAO();
        dao.ModifierVehicule(vehicule);
     
    }
    @FXML
    private void refCChnage(TableColumn.CellEditEvent<Vehicule, Integer> event) {
        Vehicule vehicule = veh.getSelectionModel().getSelectedItem();
        vehicule.setRef_contrat_id(event.getNewValue());
        VehiculeDAO dao = new VehiculeDAO();
        dao.ModifierVehicule(vehicule);
 }
    }    
    

