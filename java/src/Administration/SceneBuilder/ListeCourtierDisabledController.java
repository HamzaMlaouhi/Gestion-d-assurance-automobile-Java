/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.CourtierDAO;

import Entities.Courtier;

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
public class ListeCourtierDisabledController implements Initializable {
      private final ObservableList<Entities.Courtier> data = FXCollections.observableArrayList();

    @FXML
    private TableView<Entities.Courtier> table;
    @FXML
    private TableColumn<Entities.Courtier, String> id;
    @FXML
    private TableColumn<Entities.Courtier, String> nom;
    @FXML
    private TableColumn<Entities.Courtier, String> lieu;
    @FXML
    private TableColumn<Entities.Courtier, String> commi;
    @FXML
    private Button backBtn;
    @FXML
    private TableColumn action;
    @FXML
    private TableColumn<Entities.Courtier, String> mail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
             // TODO
             ResultSet courtier = new AdministrationDAO.CourtierDAO().selectDisabled();
             while(courtier.next()){
                 Entities.Courtier c = new Courtier(courtier.getString("id"),
                         courtier.getString("nom"),
                         courtier.getString("adresse"),
                         courtier.getString("commission"),
                         courtier.getString("email"));
                 data.add(c);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ListeCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        this.commi.setCellValueFactory(new PropertyValueFactory<>("commission"));
        this.mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        this.action.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Entities.Courtier, String>, TableCell<Entities.Courtier, String>> cellFactory =
           (TableColumn<Courtier, String> param) -> {
               final Button btn = new Button("Accepter");
               final TableCell<Courtier, String> cell = new TableCell<Courtier, String>() {
                   
                   
                   public void updateItem(String item, boolean empty) {
                       super.updateItem(item, empty);
                       if (empty) {
                           setGraphic(null);
                           setText(null);
                       } else {
                           btn.setOnAction(event -> {
                                CourtierDAO courtDao = new CourtierDAO();
                               Courtier courtier = getTableView().getItems().get(getIndex());
                               String id =courtier.getId();
                               String mail = courtier.getMail();
                               //System.out.println(mail);
                               //courtDao.SetEnabled(id);
                               // String mail1 = "mahmoud.omrani@esprit.tn";
                               courtDao.SetEnabled(id, mail);  
                               try {
                                        Pane newPane = FXMLLoader.load(getClass().getResource("ListeCourtierDisabled.fxml")); 
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
                Pane newPane = FXMLLoader.load(getClass().getResource("ListeCourtier.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
    }    
    
}
