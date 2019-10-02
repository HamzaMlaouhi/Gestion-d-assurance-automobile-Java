package Courtier;

import Courtier.Service.CourtierServiceBD;
import com.jfoenix.controls.JFXButton;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class CrudPoliceController implements Initializable {

    @FXML
    private Label idAgence;
    @FXML
    private TextField idField;
    @FXML
    private TextField codeAssureField;
    @FXML
    private TextField idAgenceField;
    @FXML
    private TextField classeField;
    @FXML
    private TextField montantField;
    @FXML
    private TextField coefficientField;
    @FXML
    private DatePicker dateEffetField;
    @FXML
    private DatePicker dateEcheanceField;
    @FXML
    private TextField statusField;
    @FXML
    private TextField natureField;
    @FXML
    private TextField usageField;
    @FXML
    private TableView<Entities.PoliceEntity> TableView;
    private ObservableList<Entities.PoliceEntity> data;
    @FXML
    private TableColumn<Entities.PoliceEntity, Integer> idColumn;
    @FXML
    private TableColumn<Entities.PoliceEntity, Integer> codeAssureColumn;
    @FXML
    private TableColumn<Entities.PoliceEntity, Integer> idAgenceColumn;
    @FXML
    private TableColumn<Entities.PoliceEntity, Integer> classeColumn;
    @FXML
    private TableColumn<Entities.PoliceEntity, Double> montantColumn;
    @FXML
    private TableColumn<Entities.PoliceEntity, Double> coefficientColumn;
    @FXML
    private TableColumn<Entities.PoliceEntity, Date> dateEffetColumn;
    @FXML
    private TableColumn<Entities.PoliceEntity, Date> dateEcheanceColumn;
    @FXML
    private TableColumn<Entities.PoliceEntity, String> statusColumn;
    @FXML
    private TableColumn<Entities.PoliceEntity, String> natureColumn;
    @FXML
    private TableColumn<Entities.PoliceEntity, String> usageColumn;
    @FXML
    private JFXButton insertButton;
    @FXML
    private JFXButton updateButton;
    @FXML
    private JFXButton deleteButton;
    @FXML
    private JFXButton resetButton;
    private Connection cn = Utils.Database.getInstance().getConnection();
    @FXML
    private AnchorPane mainPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        showPolice();

        updateButton.setOnAction(e -> {
            try {
                System.out.println("update button test");
                int id = Integer.valueOf(idField.getText());
                String req = "SELECT * FROM  police WHERE id='" + id + "'";
                Statement st;
                st = cn.createStatement();
                ResultSet police = st.executeQuery(req);
                while (police.next()) {
                    codeAssureField.setText(Integer.toString(police.getInt("code_assure_id")));
                    idAgenceField.setText(Integer.toString(police.getInt("agence_id")));
                    classeField.setText(Integer.toString(police.getInt("classe")));
                    montantField.setText(Double.toString(police.getDouble("montant")));
                    coefficientField.setText(Double.toString(police.getDouble("coef_classe")));
                    statusField.setText(police.getString("statut"));
                    natureField.setText(police.getString("nature"));
                    usageField.setText(police.getString("usage_contrat"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(CrudPoliceController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        String xx = "";

    }

    @FXML
    private void ajouterPolice(ActionEvent event) {
        PoliceEntity police = new PoliceEntity();
        police.setCode_assure(Integer.valueOf(this.codeAssureField.getText()));
        police.setAgence_id(Integer.valueOf(this.idAgenceField.getText()));
        police.setDate_effet_police(java.sql.Date.valueOf(this.dateEffetField.getValue()));
        police.setDate_echeance(java.sql.Date.valueOf(this.dateEcheanceField.getValue()));
        police.setClasse(Integer.valueOf(this.classeField.getText()));
        police.setMontant(Double.valueOf(this.montantField.getText()));
        police.setClasse(Integer.valueOf(this.classeField.getText()));
        police.setCoef_classe(Integer.valueOf(this.coefficientField.getText()));
        police.setNature_contrat(this.natureField.getText());
        police.setUsage_contrat(this.usageField.getText());
        new CourtierServiceBD().ajouter("police", police);
        showPolice();
        sendMail();
    }

    public void showPolice() {
        this.data = FXCollections.observableArrayList();
        try {
            ResultSet police = new CourtierServiceBD().selectAll("police");
            while (police.next()) {
                Entities.PoliceEntity c = new Entities.PoliceEntity();
                c.setId(police.getInt("id"));
                c.setCode_assure_id(police.getInt("code_assure_id"));
                c.setAgence_id(police.getInt("agence_id"));
                c.setDate_effet_police(police.getDate("date_effet_police"));
                c.setDate_echeance(police.getDate("date_echeance"));
                c.setStatut(police.getString("statut"));
                c.setMontant(police.getDouble("montant"));
                c.setClasse(police.getInt("classe"));
                c.setCoef_classe(police.getDouble("coef_classe"));
                c.setNature_contrat(police.getString("nature"));
                c.setUsage_contrat(police.getString("usage_contrat"));
                this.data.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudPoliceController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.codeAssureColumn.setCellValueFactory(new PropertyValueFactory<>("code_assure_id"));
        this.idAgenceColumn.setCellValueFactory(new PropertyValueFactory<>("agence_id"));
        this.classeColumn.setCellValueFactory(new PropertyValueFactory<>("classe"));
        this.montantColumn.setCellValueFactory(new PropertyValueFactory<>("montant"));
        this.coefficientColumn.setCellValueFactory(new PropertyValueFactory<>("coef_classe"));
        this.dateEffetColumn.setCellValueFactory(new PropertyValueFactory<>("date_effet_police"));
        this.dateEcheanceColumn.setCellValueFactory(new PropertyValueFactory<>("date_echeance"));
        this.statusColumn.setCellValueFactory(new PropertyValueFactory<>("statut"));
        this.natureColumn.setCellValueFactory(new PropertyValueFactory<>("nature"));
        this.usageColumn.setCellValueFactory(new PropertyValueFactory<>("usage_contrat"));

        TableView.setItems(this.data);

    }

    @FXML
    public void clearFields() {
        idField.clear();
        codeAssureField.clear();
        idAgenceField.clear();
        classeField.clear();
        montantField.clear();
        coefficientField.clear();
        statusField.clear();
        natureField.clear();
        usageField.clear();

    }

    @FXML
    public void delete() {
        CourtierServiceBD service = new CourtierServiceBD();
        service.delete2(Integer.valueOf(idField.getText()));
        showPolice();
    }

    @FXML
    public void update() throws SQLException {
        PoliceEntity police = new PoliceEntity();
        police.setId(Integer.valueOf(this.idField.getText()));
        police.setCode_assure(Integer.valueOf(this.codeAssureField.getText()));
        police.setAgence_id(Integer.valueOf(this.idAgenceField.getText()));
        police.setDate_effet_police(java.sql.Date.valueOf(this.dateEffetField.getValue()));
        police.setDate_echeance(java.sql.Date.valueOf(this.dateEcheanceField.getValue()));
        police.setClasse(Integer.valueOf(this.classeField.getText()));
        police.setMontant(Double.valueOf(this.montantField.getText()));
        police.setClasse(Integer.valueOf(this.classeField.getText()));
        police.setCoef_classe(Double.valueOf(this.coefficientField.getText()));
        police.setNature_contrat(this.natureField.getText());
        police.setUsage_contrat(this.usageField.getText());

        new CourtierServiceBD().updatePolice(police);
        showPolice();
    }

    public void sendMail(){
        MailAPI mail = new MailAPI();
        mail.send("mohamedbenabbes6@gmail.com");
    }

}
