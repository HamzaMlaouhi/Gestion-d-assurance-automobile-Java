/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie;

import Compagnie.Services.PoliceService;
import Entities.Assure;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {

    private ObservableList<Assure> data;
    @FXML
    private VBox pnl_scroll;
    @FXML
    private TableView<Assure> subscription;
    @FXML
    private TableColumn<Assure, Integer> id;
    @FXML
    private TableColumn<Assure, String> username;
    @FXML
    private TableColumn<Assure, String> email;
    @FXML
    private TableColumn<Assure, String> cin;
    @FXML
    private TableColumn<Assure, String> adr;
    @FXML
    private TableColumn<Assure, Long> tel;
    @FXML
    private TableColumn<Assure, String> gender;
    @FXML
    private TableColumn<Assure, String> prof;
    private final PoliceService service = new PoliceService();
    @FXML
    private TableColumn<Assure, String> accepter;
    @FXML
    private TableColumn<Assure, String> refuser;

    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        StageManager.vcontent = pnl_scroll;
        refresh();
        this.accepter.setCellValueFactory(new PropertyValueFactory<>("accepter"));
        this.refuser.setCellValueFactory(new PropertyValueFactory<>("refuser"));
        Callback<TableColumn<Assure, String>, TableCell<Assure, String>> accept
                = (TableColumn<Assure, String> param) -> {
                    final Button btn = new Button("+");
                    btn.setStyle("-fx-background-color: olivedrab;-fx-padding:5px 20px;");
                    final TableCell<Assure, String> cell = new TableCell<Assure, String>() {

                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btn.setOnAction(event -> {
                            Assure assure = getTableView().getItems().get(getIndex());

                            service.accept(assure);

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

        Callback<TableColumn<Assure, String>, TableCell<Assure, String>> remove
                = (TableColumn<Assure, String> param) -> {
                    final Button btn = new Button("-");
                    btn.setStyle("-fx-background-color: tomato;-fx-padding:5px 20px;-fx-position-shape:middle;");
                    final TableCell<Assure, String> cell = new TableCell<Assure, String>() {

                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btn.setOnAction(event -> {
                            Assure assure = getTableView().getItems().get(getIndex());

                            service.delete("user", assure);
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
        this.accepter.setCellFactory(accept);
        this.refuser.setCellFactory(remove);
    }

    @FXML
    private void policeBtn(ActionEvent event) throws IOException {
        pnl_scroll.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("./Police/gestionPolice.fxml"));
        pnl_scroll.getChildren().setAll(newPane);

    }

    @FXML
    private void congeBtn(ActionEvent event) throws IOException {
        /*pnl_scroll.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("./GarantieComplementaire/gestionGC.fxml"));
        pnl_scroll.getChildren().setAll(newPane);*/
    }

    @FXML
    private void gcBtn(ActionEvent event) throws IOException {
        pnl_scroll.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("./GarantieComplementaire/gestionGC.fxml"));
        pnl_scroll.getChildren().setAll(newPane);
    }

    @FXML
    private void personnelBtn(ActionEvent event) throws IOException {
        /*pnl_scroll.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("./GarantieComplementaire/gestionGC.fxml"));
        pnl_scroll.getChildren().setAll(newPane);*/
    }

    @FXML
    private void agenceBtn(ActionEvent event) throws IOException {
        pnl_scroll.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("./Agence/gestionAgence.fxml"));
        pnl_scroll.getChildren().setAll(newPane);
    }

    @FXML
    private void refresh() {
        this.data = FXCollections.observableArrayList();
        ResultSet assures = this.service.getSubscriptionDemands();
        try {
            while (assures.next()) {
                Assure a = new Assure(assures.getString("username"),
                        assures.getString("email"),
                        assures.getString("cin"),
                        assures.getString("adresse"),
                        assures.getLong("Tel"),
                        assures.getString("gender"),
                        assures.getString("Profession"),
                        assures.getDate("birthdate"),
                        assures.getDate("Date_enreg"));
                a.setId(assures.getInt("id"));
                this.data.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.username.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.email.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        this.adr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        this.tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
        this.gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        this.prof.setCellValueFactory(new PropertyValueFactory<>("Profession"));
        subscription.setItems(this.data);
    }

    @FXML
    private void disconnect(ActionEvent event) throws IOException {
        Preferences pref = Preferences.userRoot().node("user");
        pref.remove("id");
        Parent root = FXMLLoader.load(getClass().getResource("../Authentication/LoginScreen.fxml"));
        Scene scene = new Scene(root);
        StageManager.primaryStage.setScene(scene);
    }
    // Column formatter for date type
    private class ColumnFormatter<S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>> {

        private final DateTimeFormatter format;

        public ColumnFormatter(DateTimeFormatter format) {
            super();
            this.format = format;
        }

        @Override
        public TableCell<S, T> call(TableColumn<S, T> arg0) {
            return new TableCell<S, T>() {
                @Override
                protected void updateItem(T item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        LocalDate ld = (LocalDate) item;
                        String val = ld.format(format);
                        setGraphic(new Label(val));
                    }
                }
            };
        }
    }
}
