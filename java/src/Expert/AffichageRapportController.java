/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert;

import Entities.Reclamation;
import Expert.Service.ReclamationDAO;
import Shared.StageManager;
import com.lowagie.text.DocumentException;
import java.io.FileNotFoundException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AffichageRapportController implements Initializable {
    private final ObservableList<Reclamation> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Reclamation, Date> date;
    @FXML
    private TableColumn<Reclamation, String> titre;
    @FXML
    private TableColumn<Reclamation, String> detaille;
    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<?, ?> document;
    @FXML
    private TableColumn action;
    @FXML
    private AnchorPane retourr;
    @FXML
    private Button modifierBtn;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table.setEditable(true);
this.titre.setCellFactory(TextFieldTableCell.forTableColumn());


        String xx = "";
        try {
            // TODO
            ResultSet reclamations = new ReclamationDAO().selectAll("reclamation");
            try {
                while(reclamations.next()){
                    Reclamation r = new Reclamation();
                    r.setDate_rap(reclamations.getDate("date_rap"));
                    r.setTitre_rap(reclamations.getString("titre_rap"));
                    r.setDetaille_rap(reclamations.getString("detaille_rap"));
                     xx = "kkkk"+reclamations.getString("titre_rap")+reclamations.getDate("date_rap").toString();
                    
                    data.add(r);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AffichageReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.date.setCellValueFactory(new PropertyValueFactory<>("date_rap"));
            this.titre.setCellValueFactory(new PropertyValueFactory<>("titre_rap"));
            this.detaille.setCellValueFactory(new PropertyValueFactory<>("detaille_rap"));
            table.setItems(data);
            //Suppression
                 this.action.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Entities.Reclamation, String>, TableCell<Entities.Reclamation, String>> cellFactory =
           (TableColumn<Reclamation, String> param) -> {
               final Button btn = new Button("supprimer");
               final TableCell<Reclamation, String> cell = new TableCell<Reclamation, String>() {
                   
                   
                   public void updateItem(String item, boolean empty) {
                       super.updateItem(item, empty);
                       if (empty) {
                           setGraphic(null);
                           setText(null);
                       } else {
                           btn.setOnAction(event -> {
                                ReclamationDAO r = new ReclamationDAO();
                               Reclamation rec = getTableView().getItems().get(getIndex());
                               
                               r.delete("reclamation", rec);
                              
                               try {
                                        Pane newPane = FXMLLoader.load(getClass().getResource("AffichageRapport.fxml")); 
                                        StageManager.vcontent.getChildren().setAll(newPane);
                                } catch (IOException ex) {
                                        Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            
            //PDF GENERATION
            pdfGeneration pd = new pdfGeneration();
            pd.addpdf(xx);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AffichageRapportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(AffichageRapportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
     @FXML
    private void editBtn(ActionEvent event) throws IOException {
         StageManager.vcontent.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("./EditerRapport.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
        
    }
    
     @FXML
    private void retourBtn(ActionEvent event) throws IOException {
         StageManager.vcontent.getChildren().clear();
        Pane newPane = FXMLLoader.load(getClass().getResource("./AjoutRapport.fxml"));
        StageManager.vcontent.getChildren().setAll(newPane);
        
    }
    @FXML
    private void objetchange(TableColumn.CellEditEvent<Reclamation, String> event) {
        Reclamation rec = table.getSelectionModel().getSelectedItem();
       rec.setTitre_rap(event.getNewValue());
       //rec.setDetaille_rap(event.getNewValue());
       ReclamationDAO r =new ReclamationDAO();
       r.update( rec);
    }
    

  
    
    
    
 
    }    
    

