/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie.Police;

import Compagnie.Services.PoliceService;
import Entities.Police;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author BahaEddine
 */
public class GestionPoliceController implements Initializable {
    private ObservableList<Police> data;
    @FXML
    private DatePicker critere;
    @FXML
    private TableView<Police> table;
    @FXML
    private TableColumn<Police, String> assure;
    @FXML
    private TableColumn<Police, String> agence;
    @FXML
    private TableColumn<Police, Integer> classe;
    @FXML
    private TableColumn<Police, Double> coef;
    @FXML
    private TableColumn<Police, String> nature;
    @FXML
    private TableColumn<Police, String> usage;

    private final PoliceService service = new PoliceService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table.setEditable(true);
        this.assure.setCellFactory(TextFieldTableCell.forTableColumn());
        this.agence.setCellFactory(TextFieldTableCell.forTableColumn());
        this.classe.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        this.coef.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        this.nature.setCellFactory(TextFieldTableCell.forTableColumn());
        this.usage.setCellFactory(TextFieldTableCell.forTableColumn());
        refresh();
        /*this.action.setCellValueFactory(new PropertyValueFactory<>("delete"));
        Callback<TableColumn<Police, String>, TableCell<Police, String>> remove
                = (TableColumn<Police, String> param) -> {
                    final Button btn = new Button("-");
                    btn.setStyle("-fx-background-color: tomato;-fx-padding:5px 10px;");
                    final TableCell<Police, String> cell = new TableCell<Police, String>() {

                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btn.setOnAction(event -> {
                            Agence agence = getTableView().getItems().get(getIndex());

                            service.delete("agence", agence);

                            refresh();
                        });
                        setGraphic(btn);
                        setText(null);
                    }
                }
            ;
                    };
               return cell;
                };
        this.action.setCellFactory(remove);*/
    }    

    @FXML
    private void ajouterPolice(ActionEvent event) {
    }

    @FXML
    private void chercher(ActionEvent event) {
        this.data = FXCollections.observableArrayList();
        System.out.println(this.critere.getValue().toString());
        ResultSet agences = this.service.chercher(this.critere.getValue().toString());
        try {
            while (agences.next()) {
                Police p = new Police(agences.getInt("code_assure_id"),
                        agences.getInt("agence_id"),
                        agences.getDate("date_effet_police"),
                        agences.getDate("date_echeance"),
                        agences.getString("nature"));
                
                p.setId(agences.getInt("id"));
                p.setAgence("agence");
                p.setAssure("assure");
                p.setClasse(agences.getInt("classe"));
                p.setCoef(agences.getDouble("coef_classe"));
                p.setUsage_contrat(agences.getString("usage_contrat"));
                data.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionPoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.assure.setCellValueFactory(new PropertyValueFactory<>("assure"));
        this.agence.setCellValueFactory(new PropertyValueFactory<>("agence"));
        this.classe.setCellValueFactory(new PropertyValueFactory<>("classe"));
        this.coef.setCellValueFactory(new PropertyValueFactory<>("coef_classe"));
        this.nature.setCellValueFactory(new PropertyValueFactory<>("nature"));
        this.usage.setCellValueFactory(new PropertyValueFactory<>("usage_contrat"));
        table.setItems(data);
    }

    private void refresh() {
        this.data = FXCollections.observableArrayList();
        ResultSet agences = this.service.selectAll("police");
        try {
            while (agences.next()) {
                Police p = new Police(agences.getInt("code_assure_id"),
                        agences.getInt("agence_id"),
                        agences.getDate("date_effet_police"),
                        agences.getDate("date_echeance"),
                        agences.getString("nature"));
                
                p.setId(agences.getInt("id"));
                p.setAgence("agence");
                p.setAssure("assure");
                p.setClasse(agences.getInt("classe"));
                p.setCoef(agences.getDouble("coef_classe"));
                p.setUsage_contrat(agences.getString("usage_contrat"));
                data.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionPoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.assure.setCellValueFactory(new PropertyValueFactory<>("assure"));
        this.agence.setCellValueFactory(new PropertyValueFactory<>("agence"));
        this.classe.setCellValueFactory(new PropertyValueFactory<>("classe"));
        this.coef.setCellValueFactory(new PropertyValueFactory<>("coef_classe"));
        this.nature.setCellValueFactory(new PropertyValueFactory<>("nature"));
        this.usage.setCellValueFactory(new PropertyValueFactory<>("usage_contrat"));
        table.setItems(data);
    }
@FXML
    private void classeChange(TableColumn.CellEditEvent<Police, Integer> event) {
        Police p = table.getSelectionModel().getSelectedItem();
        p.setClasse(event.getNewValue());
        this.service.update("police", p);
    }
@FXML
    private void coeffChange(TableColumn.CellEditEvent<Police, Double> event) {
        Police p = table.getSelectionModel().getSelectedItem();
        p.setCoef(event.getNewValue());
        this.service.update("police", p);
    }
@FXML
    private void natureChange(TableColumn.CellEditEvent<Police, String> event) {
        Police p = table.getSelectionModel().getSelectedItem();
        p.setNature(event.getNewValue());
        this.service.update("police", p);
    }
@FXML
    private void usageChange(TableColumn.CellEditEvent<Police, String> event) {
        Police p = table.getSelectionModel().getSelectedItem();
        p.setUsage_contrat(event.getNewValue());
        this.service.update("police", p);
    }
    
}
