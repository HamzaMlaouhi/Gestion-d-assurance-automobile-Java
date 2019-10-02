/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie.Agence;

import Compagnie.GarantieComplementaire.GestionGCController;
import Compagnie.Services.AgenceService;
import Entities.Agence;
import Shared.StageManager;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author BahaEddine
 */
public class GestionAgenceController implements Initializable {

    private ObservableList<Agence> data;
    @FXML
    private TextField critere;
    @FXML
    private TableView<Agence> table;
    @FXML
    private TableColumn<Agence, Integer> id;
    @FXML
    private TableColumn<Agence, String> zone;
    @FXML
    private TableColumn<Agence, Integer> tel;
    @FXML
    private TableColumn<Agence, Integer> nbr_employer;
    @FXML
    private TableColumn<Agence, Integer> fax;

    private final AgenceService service = new AgenceService();
    @FXML
    private TableColumn<Agence, String> action;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table.setEditable(true);
        this.zone.setCellFactory(TextFieldTableCell.forTableColumn());
        this.tel.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        this.fax.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        this.nbr_employer.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        refresh();
        this.action.setCellValueFactory(new PropertyValueFactory<>("delete"));
        Callback<TableColumn<Agence, String>, TableCell<Agence, String>> remove
                = (TableColumn<Agence, String> param) -> {
                    final Button btn = new Button("-");
                    btn.setStyle("-fx-background-color: tomato;-fx-padding:5px 10px;");
                    final TableCell<Agence, String> cell = new TableCell<Agence, String>() {

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
        this.action.setCellFactory(remove);
    }

    @FXML
    private void chercher(ActionEvent event) {
        this.data = FXCollections.observableArrayList();
        ResultSet agences = this.service.chercher(this.critere.getText());
        try {
            while (agences.next()) {
                Agence a = new Agence(agences.getString("zone"),
                        agences.getInt("telephone"),
                        agences.getInt("fax"),
                        agences.getInt("nbr_employer"));
                a.setId(agences.getInt("id"));
                data.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionGCController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.zone.setCellValueFactory(new PropertyValueFactory<>("zone"));
        this.tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        this.nbr_employer.setCellValueFactory(new PropertyValueFactory<>("nbr_employer"));
        this.fax.setCellValueFactory(new PropertyValueFactory<>("fax"));
        this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.setItems(data);
    }

    @FXML
    private void ajouterAgence(ActionEvent event) throws IOException {
        StageManager.vcontent.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("newAgence.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
    }

    @FXML
    private void zoneChange(TableColumn.CellEditEvent<Agence, String> event) {
        Agence agence = table.getSelectionModel().getSelectedItem();
        agence.setZone(event.getNewValue());
        this.service.update("agence", agence);
    }

    @FXML
    private void telChange(TableColumn.CellEditEvent<Agence, Integer> event) {
        Agence agence = table.getSelectionModel().getSelectedItem();
        agence.setTel(event.getNewValue());
        this.service.update("agence", agence);
    }

    @FXML
    private void nbrChange(TableColumn.CellEditEvent<Agence, Integer> event) {
        Agence agence = table.getSelectionModel().getSelectedItem();
        agence.setNbrEmp(event.getNewValue());
        this.service.update("agence", agence);
    }

    @FXML
    private void faxChange(TableColumn.CellEditEvent<Agence, Integer> event) {
        Agence agence = table.getSelectionModel().getSelectedItem();
        agence.setFax(event.getNewValue());
        this.service.update("agence", agence);
    }

    public void refresh() {
        this.data = FXCollections.observableArrayList();
        ResultSet agences = this.service.selectAll("agence");
        try {
            while (agences.next()) {
                Agence a = new Agence(agences.getString("zone"),
                        agences.getInt("telephone"),
                        agences.getInt("fax"),
                        agences.getInt("nbr_employer"));
                a.setId(agences.getInt("id"));
                System.out.println(agences.getInt("telephone"));
                data.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionGCController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.zone.setCellValueFactory(new PropertyValueFactory<>("zone"));
        this.tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        this.nbr_employer.setCellValueFactory(new PropertyValueFactory<>("nbr_employer"));
        this.fax.setCellValueFactory(new PropertyValueFactory<>("fax"));
        this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.setItems(data);
    }
}
