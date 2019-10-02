/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import Entities.Courtier;
import Entities.PrimeRC;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class ListeCourtierController implements Initializable {
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
    private Button disabled;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
             // TODO
             ResultSet courtier = new AdministrationDAO.CourtierDAO().selectAll();
             while(courtier.next()){
                 Entities.Courtier c = new Courtier(courtier.getString("id"),
                         courtier.getString("nom"),
                         courtier.getString("adresse"),
                         courtier.getString("commission"));
                 data.add(c);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ListeCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        this.lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        this.commi.setCellValueFactory(new PropertyValueFactory<>("commission"));
        table.setItems(data);
        
        backBtn.setOnAction(event ->{
        try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestionCourtier.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
        disabled.setOnAction(event ->{
        try {
                Pane newPane = FXMLLoader.load(getClass().getResource("ListeCourtierDisabled.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
    }    
    
}
