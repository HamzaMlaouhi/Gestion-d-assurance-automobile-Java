/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence;

import Agence.Services.reclamationDAO;
import Entities.Reclamation;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class ListeReclamationsController implements Initializable {
    
        private final ObservableList<Reclamation> data = FXCollections.observableArrayList();


    @FXML
    private TableView<Reclamation> rec;
    @FXML
    private TableColumn<Reclamation, Date> dte;
    @FXML
    private TableColumn<Reclamation, String> lieu;
    @FXML
    private TableColumn<Reclamation, String> obj;
    @FXML
    private TableColumn<Reclamation, String> cmt;
    @FXML
    private TableColumn<Reclamation, String> crec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ResultSet reclamations = new reclamationDAO().selectAll("reclamation");
        try {
            while(reclamations.next()){
                System.out.println(reclamations.getInt("Code_rec"));
                Reclamation r = new Reclamation();
                r.setCode_rec(reclamations.getInt("Code_rec"));
                r.setDate_rec(reclamations.getDate("date_rec"));
                r.setLieu_rec(reclamations.getString("lieu_rec"));
                r.setObjet_rec(reclamations.getString("objet_rec"));
                r.setCommentaire_rec(reclamations.getString("commentaire_rec"));
                data.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListeReclamationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.crec.setCellValueFactory(new PropertyValueFactory<>("Code_rec"));
        this.dte.setCellValueFactory(new PropertyValueFactory<>("date_rec"));
        this.lieu.setCellValueFactory(new PropertyValueFactory<>("lieu_rec"));
        this.obj.setCellValueFactory(new PropertyValueFactory<>("objet_rec"));
        this.cmt.setCellValueFactory(new PropertyValueFactory<>("commentaire_rec"));
        rec.setItems(data);
    }      
    }    
    

