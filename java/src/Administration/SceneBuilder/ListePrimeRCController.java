/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import Entities.Compagnie;
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
public class ListePrimeRCController implements Initializable {
    private final ObservableList<Entities.PrimeRC> data = FXCollections.observableArrayList();

    @FXML
    private TableView<PrimeRC> table;
    @FXML
    private TableColumn<PrimeRC, String> id;
    @FXML
    private TableColumn<PrimeRC, String> puiss;
    @FXML
    private TableColumn<PrimeRC, String> prix;
    @FXML
    private Button backBtn;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
             // TODO
             ResultSet prime = new AdministrationDAO.PrimeRC_DAO().selectAll();
             while(prime.next()){
                 Entities.PrimeRC c = new PrimeRC(prime.getString("id"),
                         prime.getString("puissance_fiscale"),
                         prime.getString("prix"));
                 data.add(c);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ListeCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        this.puiss.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.id.setCellValueFactory(new PropertyValueFactory<>("puissance"));
        this.prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        table.setItems(data);
        
        backBtn.setOnAction(event ->{
        try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestPrimeRC.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
    }

    
    
}
