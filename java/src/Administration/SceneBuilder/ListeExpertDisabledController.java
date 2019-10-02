/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.ExpertDAO;
import Entities.Expert;

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class ListeExpertDisabledController implements Initializable {
     private final ObservableList<Entities.Expert> data = FXCollections.observableArrayList();

    @FXML
    private TableView<Entities.Expert> table;
    @FXML
    private Button backBtn;
    @FXML
    private TableColumn<Entities.Expert, String> cin;
    @FXML
    private TableColumn<Entities.Expert, String> nom;
    @FXML
    private TableColumn<Entities.Expert, String> prenom;
    @FXML
    private TableColumn<Entities.Expert, String> tel;
    @FXML
    private TableColumn<Entities.Expert, String> zone;
    @FXML
    private TableColumn action;
    @FXML
    private TableColumn<Entities.Expert, String> mail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try {
             // TODO
             ResultSet expert = new AdministrationDAO.ExpertDAO().selectDisabled();
             while(expert.next()){
                 Entities.Expert c = new Expert(expert.getString("cin_exp"),
                         expert.getString("nom_exp"),
                         expert.getString("prenom_exp"),
                         expert.getString("zone_exp"),
                         expert.getString("tel_exp"),
                         expert.getString("email"));
                         
                 data.add(c);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ListeExpertController.class.getName()).log(Level.SEVERE, null, ex);
         }
        this.cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        this.nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        this.zone.setCellValueFactory(new PropertyValueFactory<>("zone"));
        this.tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        this.mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        this.action.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Entities.Expert, String>, TableCell<Entities.Expert, String>> cellFactory =
           (TableColumn<Expert, String> param) -> {
               final Button btn = new Button("Accepter");
               final TableCell<Expert, String> cell = new TableCell<Expert, String>() {
                   
                   
                   public void updateItem(String item, boolean empty) {
                       super.updateItem(item, empty);
                       if (empty) {
                           setGraphic(null);
                           setText(null);
                       } else {
                           btn.setOnAction(event -> {
                                ExpertDAO expDao = new ExpertDAO();
                               Expert expert = getTableView().getItems().get(getIndex());
                               String cin =expert.getCin();
                               String mail = expert.getMail();
                               //expDao.SetEnabled(cin);
                               expDao.SetEnabled(cin, mail);
                               try {
                                    Pane newPane = FXMLLoader.load(getClass().getResource("ListeExpertDisabled.fxml")); 
                                    StageManager.vcontent.getChildren().setAll(newPane);
                                } catch (IOException ex) {
                                    Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                               
                           });
                           setGraphic(btn);
                           setText(null);
                       }
                   };
               };
               
               
               return cell;
        };
        action.setCellFactory(cellFactory);
        table.setItems(data);
        
        backBtn.setOnAction(event ->{
            try {
                Pane newPane = FXMLLoader.load(getClass().getResource("ListeExpert.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
    }    
    
}
