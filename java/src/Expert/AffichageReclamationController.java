/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert;

import Entities.GarantieComplementaire;
import Entities.Reclamation;
import Expert.Service.ReclamationDAO;
import Shared.StageManager;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AffichageReclamationController implements Initializable {
    private final ObservableList<Reclamation> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Reclamation, Integer> code;
    @FXML
    private TableColumn<Reclamation, Date> date;
    @FXML
    private TableColumn<Reclamation, String> lieu;
    @FXML
    private TableColumn<Reclamation, String> objet;
    @FXML
    private TableColumn<Reclamation, String> commentaire;
    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TextField rechercher;
    public String recherche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ResultSet reclamations = new ReclamationDAO().selectAll("reclamation");
        try {
            while(reclamations.next()){
                Reclamation r = new Reclamation();
                r.setCode_rec(reclamations.getInt("Code_rec"));
                r.setDate_rec(reclamations.getDate("date_rec"));
                r.setLieu_rec(reclamations.getString("lieu_rec"));
                r.setObjet_rec(reclamations.getString("objet_rec"));
                r.setCommentaire_rec(reclamations.getString("commentaire_rec"));
                data.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AffichageReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.code.setCellValueFactory(new PropertyValueFactory<>("Code_rec"));
        this.date.setCellValueFactory(new PropertyValueFactory<>("date_rec"));
        this.lieu.setCellValueFactory(new PropertyValueFactory<>("lieu_rec"));
        this.objet.setCellValueFactory(new PropertyValueFactory<>("objet_rec"));
        this.commentaire.setCellValueFactory(new PropertyValueFactory<>("commentaire_rec"));
        table.setItems(data);
    } 
    
     @FXML
    private void affecterBtn(ActionEvent event) throws IOException {
         StageManager.vcontent.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("./AjoutRapport.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
        
    }
     @FXML
    private void retourBtn(ActionEvent event) throws IOException {
         StageManager.vcontent.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("./ChercherReclamation.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
        
    }
    @FXML
     private void search(KeyEvent event) {
         recherche = rechercher.getText();
        ReclamationDAO dao = new ReclamationDAO();
            
        table.setItems( dao.RechercheParLieu(recherche));
    }

    
}
    