/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie.GarantieComplementaire;

import Compagnie.Services.GCService;
import Entities.GarantieComplementaire;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author BahaEddine
 */
public class GestionGCController implements Initializable {

    @FXML
    private TableView<GarantieComplementaire> table;
    private ObservableList<GarantieComplementaire> data;
    @FXML
    private TableColumn<GarantieComplementaire, String> nom;
    @FXML
    private TableColumn<GarantieComplementaire, Double> tarif;
    @FXML
    private TableColumn<GarantieComplementaire, Double> niveau;
    @FXML
    private TableColumn<GarantieComplementaire, Double> prime;
    @FXML
    private TableColumn<GarantieComplementaire, Double> surprime;
    @FXML
    private TextField critere;
    @FXML
    private TableColumn<GarantieComplementaire, Integer> id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.data = FXCollections.observableArrayList();
        ResultSet garanties = new GCService().selectAll("garantie_complementaire");
        try {
            while (garanties.next()) {
                GarantieComplementaire g = new GarantieComplementaire(garanties.getString("nom"),
                        garanties.getDouble("tarif_de_base"),
                        garanties.getDouble("niv_franchise"),
                        garanties.getDouble("prime_de_base"),
                        garanties.getDouble("surprime"));
                g.setId(garanties.getInt("id"));
                data.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionGCController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.tarif.setCellValueFactory(new PropertyValueFactory<>("tarifDeBase"));
        this.niveau.setCellValueFactory(new PropertyValueFactory<>("nivFranchise"));
        this.prime.setCellValueFactory(new PropertyValueFactory<>("primeDeBase"));
        this.surprime.setCellValueFactory(new PropertyValueFactory<>("surprime"));
        this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.setItems(data);
        table.setRowFactory(tv -> {
            TableRow<GarantieComplementaire> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    GarantieComplementaire rowData = row.getItem();
                }
            });
            return row;
        });
    }

    @FXML
    private void ajouterGC(ActionEvent event) throws IOException {
        StageManager.vcontent.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("newGC.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
    }

    @FXML
    private void chercher(ActionEvent event) {
        this.data = FXCollections.observableArrayList();
        ResultSet garanties = new GCService().chercher(this.critere.getText());
        try {
            while (garanties.next()) {
                GarantieComplementaire g = new GarantieComplementaire(garanties.getString("nom"),
                        garanties.getDouble("tarif_de_base"),
                        garanties.getDouble("niv_franchise"),
                        garanties.getDouble("prime_de_base"),
                        garanties.getDouble("surprime"));
                g.setId(garanties.getInt("id"));
                data.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionGCController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.tarif.setCellValueFactory(new PropertyValueFactory<>("tarifDeBase"));
        this.niveau.setCellValueFactory(new PropertyValueFactory<>("nivFranchise"));
        this.prime.setCellValueFactory(new PropertyValueFactory<>("primeDeBase"));
        this.surprime.setCellValueFactory(new PropertyValueFactory<>("surprime"));
        this.id.setCellValueFactory(new PropertyValueFactory<>("id"));

        table.setItems(data);
        table.setRowFactory(tv -> {
            TableRow<GarantieComplementaire> row = new TableRow<>();
            row.setOnMouseClicked(evt -> {
                if (evt.getClickCount() == 2 && (!row.isEmpty())) {
                    GarantieComplementaire rowData = row.getItem();
                }
            });
            return row;
        });
    }

}
