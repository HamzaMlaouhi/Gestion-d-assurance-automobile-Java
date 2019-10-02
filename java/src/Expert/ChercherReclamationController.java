/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert;

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
public class ChercherReclamationController implements Initializable {
private  ObservableList<Reclamation> data;
    @FXML
    private TextField code;
    @FXML
    private TableView<Reclamation> tablee;
    @FXML
    private TableColumn<Reclamation, Integer> coderec;
    @FXML
    private TableColumn<Reclamation, Date> daterec;
    @FXML
    private TableColumn<Reclamation, String> lieurec;
    @FXML
    private TableColumn<Reclamation, String> objetrec;
    @FXML
    private TableColumn<Reclamation, String> commentairerec;
    @FXML
    private TextField rechercher;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }      

    @FXML
    private void chercher(ActionEvent event) {
        // TODO
        data=FXCollections.observableArrayList();
        ResultSet reclamations = new ReclamationDAO().chercher("reclamation",this.code.getText());
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
            Logger.getLogger(ChercherReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.coderec.setCellValueFactory(new PropertyValueFactory<>("Code_rec"));
        this.daterec.setCellValueFactory(new PropertyValueFactory<>("date_rec"));
        this.lieurec.setCellValueFactory(new PropertyValueFactory<>("lieu_rec"));
        this.objetrec.setCellValueFactory(new PropertyValueFactory<>("objet_rec"));
        this.commentairerec.setCellValueFactory(new PropertyValueFactory<>("commentaire_rec"));
        tablee.setItems(data);
    }
     @FXML
    private void affichagerectBtn(ActionEvent event) throws IOException {
         StageManager.vcontent.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("./AffichageReclamation.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
        
    }
   
    }    
    

