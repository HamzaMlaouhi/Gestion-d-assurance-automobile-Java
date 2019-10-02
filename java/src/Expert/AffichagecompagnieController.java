/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert;

import Expert.PrivateEntity.RatingEntity;
import Expert.Service.CompagnieDAO;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AffichagecompagnieController implements Initializable {

    @FXML
    private TableColumn<Object, String> nom;
    @FXML
    private TableColumn<Object, Double> avis;
    
    private ObservableList<RatingEntity> data;
    @FXML
    private TableView<RatingEntity> table;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.data = FXCollections.observableArrayList();
        ResultSet agences = new CompagnieDAO().selectAll("agence");
        try {
            while (agences.next()) {
                RatingEntity a = new RatingEntity(agences.getInt("id"),
                        agences.getString("nom_compagnie"),
                        agences.getDouble("rating"));
                this.data.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AffichagecompagnieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.nom.setCellValueFactory(new PropertyValueFactory<>("nom_compagnie"));
        this.avis.setCellValueFactory(new PropertyValueFactory<>("rating"));
        table.setItems(this.data);
    }    

    @FXML
    private void doubleclick(MouseEvent event) throws IOException {
        if(event.getClickCount() == 2){
               
        Pane newPane = FXMLLoader.load(getClass().getResource("./Rating.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
            }
    }
    
    
}
