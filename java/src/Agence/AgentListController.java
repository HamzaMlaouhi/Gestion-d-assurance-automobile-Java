/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence;

import Administration.SceneBuilder.GestCompagnieController;

import Agence.Services.AgentDAO;

import Entities.Agent;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class AgentListController implements Initializable {
    
      private final ObservableList<Agent> data = FXCollections.observableArrayList();

    @FXML
    private TableView<Agent> agt;
    @FXML
    private TableColumn<Agent, String> cin;
    @FXML
    private TableColumn<Agent,String > nom;
    @FXML
    private TableColumn<Agent, String> pren;
    @FXML
    private TableColumn<Agent, String> tel;
    @FXML
    private TableColumn<Agent, String> adr;
    @FXML
    private TableColumn<Agent, String> email;
    @FXML
    private TableColumn action;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cin.setCellFactory(TextFieldTableCell.forTableColumn());
         this.nom.setCellFactory(TextFieldTableCell.forTableColumn());
          this.pren.setCellFactory(TextFieldTableCell.forTableColumn());
           this.tel.setCellFactory(TextFieldTableCell.forTableColumn());
            this.adr.setCellFactory(TextFieldTableCell.forTableColumn());
             this.email.setCellFactory(TextFieldTableCell.forTableColumn()); 
             
             agt.setEditable(true);
        ResultSet agent = new AgentDAO().selectAll();
        try {
            while(agent.next()){
              
                Agent a = new Agent();
                a.setCin(agent.getString("cin"));
                a.setNom(agent.getString("nom"));
                a.setPrenom(agent.getString("prenom"));
                a.setAdresse(agent.getString("adresse"));
                a.setTel(agent.getString("Tel"));
                a.setEmail(agent.getString("email"));
                data.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgentListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        this.nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.pren.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        this.adr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        this.tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
        this.email.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.action.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Entities.Agent, String>, TableCell<Entities.Agent, String>> cellFactory =
           (TableColumn<Agent, String> param) -> {
               final Button btn = new Button("supprimer");
               final TableCell<Agent, String> cell = new TableCell<Agent, String>() {
                   
                   
                   public void updateItem(String item, boolean empty) {
                       super.updateItem(item, empty);
                       if (empty) {
                           setGraphic(null);
                           setText(null);
                       } else {
                           btn.setOnAction(event -> {
                                AgentDAO dao = new AgentDAO();
                               Agent agent = getTableView().getItems().get(getIndex());
                               String cin =agent.getCin();
                            
                               //expDao.SetEnabled(cin);
                               dao.DeleteAction(cin);
                               try {
                                    Pane newPane = FXMLLoader.load(getClass().getResource("AgentList.fxml")); 
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
        agt.setItems(data);
    }  
      @FXML
    private void mailChnage(TableColumn.CellEditEvent<Agent, String> event) {
        Agent agent = agt.getSelectionModel().getSelectedItem();
        agent.setCin(event.getNewValue());
        AgentDAO dao = new AgentDAO();
        dao.ModifierAgent(agent);
    }
      @FXML
    private void nomChnage(TableColumn.CellEditEvent<Agent, String> event) {
        Agent agent = agt.getSelectionModel().getSelectedItem();
        agent.setNom(event.getNewValue());
        AgentDAO dao = new AgentDAO();
        dao.ModifierAgent(agent);
    }
      @FXML
    private void prenChnage(TableColumn.CellEditEvent<Agent, String> event) {
        Agent agent = agt.getSelectionModel().getSelectedItem();
        agent.setPrenom(event.getNewValue());
        AgentDAO dao = new AgentDAO();
        dao.ModifierAgent(agent);
    }
      @FXML
    private void telChnage(TableColumn.CellEditEvent<Agent, String> event) {
        Agent agent = agt.getSelectionModel().getSelectedItem();
        agent.setTel(event.getNewValue());
        AgentDAO dao = new AgentDAO();
        dao.ModifierAgent( agent);
    }
      @FXML
    private void adrChnage(TableColumn.CellEditEvent<Agent, String> event) {
        Agent agent = agt.getSelectionModel().getSelectedItem();
        agent.setAdresse(event.getNewValue());
        AgentDAO dao = new AgentDAO();
        dao.ModifierAgent(agent);
    }
        // TODO
}
    

