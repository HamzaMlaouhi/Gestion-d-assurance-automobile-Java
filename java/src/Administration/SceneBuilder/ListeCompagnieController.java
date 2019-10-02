/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.CompagnieDAO;
import Compagnie.Services.GCService;
import Entities.Compagnie;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class ListeCompagnieController implements Initializable {
    
     private final ObservableList<Entities.Compagnie> data = FXCollections.observableArrayList();

    @FXML
    private TableView<Entities.Compagnie> table;
    @FXML
    private TableColumn<Entities.Compagnie, Integer> id;
    @FXML
    private TableColumn<Entities.Compagnie, String> nomC;
    @FXML
    private TableColumn<Entities.Compagnie, String> adr;
    @FXML
    private TableColumn<Entities.Compagnie, String> fix;
    @FXML
    private TableColumn<Entities.Compagnie, String> fax;
    @FXML
    private TableColumn<Entities.Compagnie, String> site;
    @FXML
    private Button backBtn;
    @FXML
    private TextField rechercher;
    
    public String recherche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             
             // TODO
             ResultSet compagnie = new AdministrationDAO.CompagnieDAO().selectAll();
             while(compagnie.next()){
                 Entities.Compagnie c = new Compagnie(compagnie.getString("id"),
                         compagnie.getString("nom_compagnie"),
                         compagnie.getString("adresse"),
                         compagnie.getString("Tel"),
                         compagnie.getString("Fax"),
                         compagnie.getString("site"));
                 data.add(c);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ListeCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         this.id.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nomC.setCellValueFactory(new PropertyValueFactory<>("nomCompagnie"));
        this.adr.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        this.fix.setCellValueFactory(new PropertyValueFactory<>("fixe"));
        this.fax.setCellValueFactory(new PropertyValueFactory<>("fax"));
        this.site.setCellValueFactory(new PropertyValueFactory<>("site"));
        table.setItems(data);
        
        backBtn.setOnAction(event ->{
        try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestCompagnie.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
        
         
    }
   

 
    @FXML
    private void search(KeyEvent event) {
         recherche = rechercher.getText();
        CompagnieDAO dao = new CompagnieDAO();
            
        table.setItems( dao.RechercheParAdresse(recherche));
    }
    
    
    
}
