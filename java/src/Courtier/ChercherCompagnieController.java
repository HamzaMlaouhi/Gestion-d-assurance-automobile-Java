package Courtier;

import com.jfoenix.controls.JFXTextField;
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
 * @author Mohamed
 */
public class ChercherCompagnieController implements Initializable {

    @FXML
    private TableView<Courtier.GarantieComplementaire> TableView;

    private ObservableList<Courtier.GarantieComplementaire> data;
    @FXML
    private TableColumn<Courtier.GarantieComplementaire, Integer> idColumn;
    @FXML
    private TableColumn<Courtier.GarantieComplementaire, String> nomCompagnieColumn;
    @FXML
    private TableColumn<Courtier.GarantieComplementaire, Double> tarifColumn;
    @FXML
    private TableColumn<Courtier.GarantieComplementaire, Double> primeColumn;
    @FXML
    private TableColumn<Courtier.GarantieComplementaire, String> nomGarantieColumn;
    @FXML
    private JFXTextField volFiltreField;
    @FXML
    private JFXTextField incendieFiltreField;
    @FXML
    private JFXTextField defenceFiltreField;
    @FXML
    private JFXTextField compagnieFiltreField;
    @FXML
    private JFXTextField primerSuperieurValeur;
    @FXML
    private JFXTextField primerInferieurValeur;
    @FXML
    private JFXTextField tarifSuperieurValeur;
    @FXML
    private JFXTextField tarifInferieurValeur;
    @FXML
    private JFXTextField tarifSuperieurValeurPlusFiltre;
    @FXML
    private JFXTextField tarifInferieurValeurPlusFiltre;
    @FXML
    private JFXTextField primerSuperieurValeurPlusFiltre;
    @FXML
    private JFXTextField primerInferieurValeurPlusFiltre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        showGarantieComplementaire();

        chercherParCompagnie();
        chercherParGarantieComplementaire();
    }

    public void showGarantieComplementaire() {

        this.data = FXCollections.observableArrayList();
        try {
            ResultSet garantieComplementaire = new Courtier.Service.SericeComplementaireServiceBD().selectAll("garantie_complementaire");
            while (garantieComplementaire.next()) {
                GarantieComplementaire c = new GarantieComplementaire();
                c.setId(garantieComplementaire.getInt("id"));
                c.setNom_compagnie(garantieComplementaire.getString("nom_compagnie"));
                c.setTarif_de_base(garantieComplementaire.getDouble("tarif_de_base"));
                c.setPrime_de_base(garantieComplementaire.getDouble("prime_de_base"));
                c.setNom_garantie(garantieComplementaire.getString("nom_garantie"));

                this.data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudPoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nomCompagnieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_compagnie"));
        this.tarifColumn.setCellValueFactory(new PropertyValueFactory<>("tarif_de_base"));
        this.primeColumn.setCellValueFactory(new PropertyValueFactory<>("prime_de_base"));
        this.nomGarantieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_garantie"));

        TableView.setItems(this.data);

    }

    @FXML
    public void chercherParGarantieComplementaire() {
        this.data = FXCollections.observableArrayList();
        try {
            ResultSet garantieComplementaire = new Courtier.Service.SericeComplementaireServiceBD().chercherParUnCritere("garantie_complementaire", volFiltreField.getText()); //volFiltreField.getText()
            while (garantieComplementaire.next()) {
                GarantieComplementaire c = new GarantieComplementaire();
                c.setId(garantieComplementaire.getInt("id"));
                c.setNom_compagnie(garantieComplementaire.getString("nom_compagnie"));
                c.setTarif_de_base(garantieComplementaire.getDouble("tarif_de_base"));
                c.setPrime_de_base(garantieComplementaire.getDouble("prime_de_base"));
                c.setNom_garantie(garantieComplementaire.getString("nom_garantie"));

                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudPoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nomCompagnieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_compagnie"));
        this.tarifColumn.setCellValueFactory(new PropertyValueFactory<>("tarif_de_base"));
        this.primeColumn.setCellValueFactory(new PropertyValueFactory<>("prime_de_base"));
        this.nomGarantieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_garantie"));

        TableView.setItems(data);

    }

    @FXML
    public void chercherParCompagnie() {
        this.data = FXCollections.observableArrayList();
        try {
            ResultSet garantieComplementaire = new Courtier.Service.SericeComplementaireServiceBD().chercherParNomCompagnie("garantie_complementaire", compagnieFiltreField.getText()); //volFiltreField.getText()
            while (garantieComplementaire.next()) {
                GarantieComplementaire c = new GarantieComplementaire();
                c.setId(garantieComplementaire.getInt("id"));
                c.setNom_compagnie(garantieComplementaire.getString("nom_compagnie"));
                c.setTarif_de_base(garantieComplementaire.getDouble("tarif_de_base"));
                c.setPrime_de_base(garantieComplementaire.getDouble("prime_de_base"));
                c.setNom_garantie(garantieComplementaire.getString("nom_garantie"));

                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudPoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nomCompagnieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_compagnie"));
        this.tarifColumn.setCellValueFactory(new PropertyValueFactory<>("tarif_de_base"));
        this.primeColumn.setCellValueFactory(new PropertyValueFactory<>("prime_de_base"));
        this.nomGarantieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_garantie"));

        TableView.setItems(data);
    }

    @FXML
    public void chercherParDeuxCritere() {
        this.data = FXCollections.observableArrayList();
        try {
            ResultSet garantieComplementaire = new Courtier.Service.SericeComplementaireServiceBD().chercherParDeuxCritere("garantie_complementaire", volFiltreField.getText(), incendieFiltreField.getText()); //volFiltreField.getText()
            while (garantieComplementaire.next()) {
                GarantieComplementaire c = new GarantieComplementaire();
                c.setId(garantieComplementaire.getInt("id"));
                c.setNom_compagnie(garantieComplementaire.getString("nom_compagnie"));
                c.setTarif_de_base(garantieComplementaire.getDouble("tarif_de_base"));
                c.setPrime_de_base(garantieComplementaire.getDouble("prime_de_base"));
                c.setNom_garantie(garantieComplementaire.getString("nom_garantie"));

                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudPoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nomCompagnieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_compagnie"));
        this.tarifColumn.setCellValueFactory(new PropertyValueFactory<>("tarif_de_base"));
        this.primeColumn.setCellValueFactory(new PropertyValueFactory<>("prime_de_base"));
        this.nomGarantieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_garantie"));

        TableView.setItems(data);
    }

    @FXML
    public void chercherParTroisCritere() {
        this.data = FXCollections.observableArrayList();
        try {
            ResultSet garantieComplementaire = new Courtier.Service.SericeComplementaireServiceBD().chercherParTroisCritere("garantie_complementaire", volFiltreField.getText(), incendieFiltreField.getText(), defenceFiltreField.getText()); //volFiltreField.getText()
            while (garantieComplementaire.next()) {
                GarantieComplementaire c = new GarantieComplementaire();
                c.setId(garantieComplementaire.getInt("id"));
                c.setNom_compagnie(garantieComplementaire.getString("nom_compagnie"));
                c.setTarif_de_base(garantieComplementaire.getDouble("tarif_de_base"));
                c.setPrime_de_base(garantieComplementaire.getDouble("prime_de_base"));
                c.setNom_garantie(garantieComplementaire.getString("nom_garantie"));

                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudPoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nomCompagnieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_compagnie"));
        this.tarifColumn.setCellValueFactory(new PropertyValueFactory<>("tarif_de_base"));
        this.primeColumn.setCellValueFactory(new PropertyValueFactory<>("prime_de_base"));
        this.nomGarantieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_garantie"));

        TableView.setItems(data);
    }

    @FXML
    public void chercherParPrimeSuperieurA() {
        this.data = FXCollections.observableArrayList();
        try {
            ResultSet garantieComplementaire = new Courtier.Service.SericeComplementaireServiceBD().chercherParPrimeSuperieurA("garantie_complementaire", Integer.valueOf(primerSuperieurValeur.getText())); //volFiltreField.getText()
            while (garantieComplementaire.next()) {
                GarantieComplementaire c = new GarantieComplementaire();
                c.setId(garantieComplementaire.getInt("id"));
                c.setNom_compagnie(garantieComplementaire.getString("nom_compagnie"));
                c.setTarif_de_base(garantieComplementaire.getDouble("tarif_de_base"));
                c.setPrime_de_base(garantieComplementaire.getDouble("prime_de_base"));
                c.setNom_garantie(garantieComplementaire.getString("nom_garantie"));

                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudPoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nomCompagnieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_compagnie"));
        this.tarifColumn.setCellValueFactory(new PropertyValueFactory<>("tarif_de_base"));
        this.primeColumn.setCellValueFactory(new PropertyValueFactory<>("prime_de_base"));
        this.nomGarantieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_garantie"));

        TableView.setItems(data);

    }

    public void chercherParPrimeInferieurA() {
        this.data = FXCollections.observableArrayList();
        try {
            ResultSet garantieComplementaire = new Courtier.Service.SericeComplementaireServiceBD().chercherParPrimeInferieurA("garantie_complementaire", Integer.valueOf(primerInferieurValeur.getText())); //volFiltreField.getText()
            while (garantieComplementaire.next()) {
                GarantieComplementaire c = new GarantieComplementaire();
                c.setId(garantieComplementaire.getInt("id"));
                c.setNom_compagnie(garantieComplementaire.getString("nom_compagnie"));
                c.setTarif_de_base(garantieComplementaire.getDouble("tarif_de_base"));
                c.setPrime_de_base(garantieComplementaire.getDouble("prime_de_base"));
                c.setNom_garantie(garantieComplementaire.getString("nom_garantie"));

                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudPoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nomCompagnieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_compagnie"));
        this.tarifColumn.setCellValueFactory(new PropertyValueFactory<>("tarif_de_base"));
        this.primeColumn.setCellValueFactory(new PropertyValueFactory<>("prime_de_base"));
        this.nomGarantieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_garantie"));

        TableView.setItems(data);

    }
    
    public void chercherParTarifSuperieurA(){
        this.data = FXCollections.observableArrayList();
        try {
            ResultSet garantieComplementaire = new Courtier.Service.SericeComplementaireServiceBD().chercherParTarifSuperieurA("garantie_complementaire", Integer.valueOf(tarifSuperieurValeur.getText())); //volFiltreField.getText()
            while (garantieComplementaire.next()) {
                GarantieComplementaire c = new GarantieComplementaire();
                c.setId(garantieComplementaire.getInt("id"));
                c.setNom_compagnie(garantieComplementaire.getString("nom_compagnie"));
                c.setTarif_de_base(garantieComplementaire.getDouble("tarif_de_base"));
                c.setPrime_de_base(garantieComplementaire.getDouble("prime_de_base"));
                c.setNom_garantie(garantieComplementaire.getString("nom_garantie"));

                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudPoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nomCompagnieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_compagnie"));
        this.tarifColumn.setCellValueFactory(new PropertyValueFactory<>("tarif_de_base"));
        this.primeColumn.setCellValueFactory(new PropertyValueFactory<>("prime_de_base"));
        this.nomGarantieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_garantie"));

        TableView.setItems(data);
    }
    
    public void chercherParTarifInferieurA(){
        this.data = FXCollections.observableArrayList();
        try {
            ResultSet garantieComplementaire = new Courtier.Service.SericeComplementaireServiceBD().chercherParTarifInferieurA("garantie_complementaire", Integer.valueOf(tarifInferieurValeur.getText())); //volFiltreField.getText()
            while (garantieComplementaire.next()) {
                GarantieComplementaire c = new GarantieComplementaire();
                c.setId(garantieComplementaire.getInt("id"));
                c.setNom_compagnie(garantieComplementaire.getString("nom_compagnie"));
                c.setTarif_de_base(garantieComplementaire.getDouble("tarif_de_base"));
                c.setPrime_de_base(garantieComplementaire.getDouble("prime_de_base"));
                c.setNom_garantie(garantieComplementaire.getString("nom_garantie"));

                data.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudPoliceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nomCompagnieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_compagnie"));
        this.tarifColumn.setCellValueFactory(new PropertyValueFactory<>("tarif_de_base"));
        this.primeColumn.setCellValueFactory(new PropertyValueFactory<>("prime_de_base"));
        this.nomGarantieColumn.setCellValueFactory(new PropertyValueFactory<>("nom_garantie"));

        TableView.setItems(data);
    }

}
