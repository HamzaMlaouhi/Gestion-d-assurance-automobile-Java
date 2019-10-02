/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.CompagnieDAO;
import AdministrationDAO.CourtierDAO;
import Shared.StageManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import AdministrationDAO.ExpertDAO;

import AdministrationDAO.PrimeRC_DAO;

import com.jfoenix.controls.JFXButton;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {
    
    
      @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton btnListeComp;
    @FXML
    private JFXButton btngestCourtier;
    @FXML
    private JFXButton btnGestExpert;
    @FXML
    private JFXButton btnGestPrime;
    @FXML
    private Label LogName;
    @FXML
    private ImageView LogIcone;
    @FXML
    private Label notifNum;
    @FXML
    private Label notifNum1;
    @FXML
    private StackedBarChart<String,Number> stat;
    @FXML
    private Pane home;
    @FXML
    private ImageView homeI;
    @FXML
    private JFXButton homeBtn;
    @FXML
    private Button deco;
    
    private void handleButtonAction(MouseEvent event) {        
      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                    
                 int x = new ExpertDAO().selectDisabledNumber();
              int y =new CourtierDAO().selectDisabledNumber();
               int w = new CompagnieDAO().selectDisabledNumber();
              int z =new PrimeRC_DAO().selectDisabledNumber();
              if(x!=0 && y!=0){
              JOptionPane.showMessageDialog(null, x+" Experts en attente et "+y+" Courtiers en attente", "Notification", JOptionPane.INFORMATION_MESSAGE);
              }
              else{
                  if(x!=0){
                    JOptionPane.showMessageDialog(null, x+" Experts en attente", "Notification", JOptionPane.INFORMATION_MESSAGE);
                  }
                  if(y!=0){
                    JOptionPane.showMessageDialog(null, y+" Courtiers en attente", "Notification", JOptionPane.INFORMATION_MESSAGE);
                  }
              }
              //Stats Graph :
                           //Defining the y axis 
                        CategoryAxis xAxis = new CategoryAxis();    
                        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList
                        ("Compagnie", "Prime RC", "Expert", "Courtier"))); 
                         xAxis.setLabel("category");  

                            //Defining the y axis 
                         NumberAxis yAxis = new NumberAxis(); 
                        yAxis.setLabel("Nombre dans l'app");
                 
                        stat= new StackedBarChart<>(xAxis,yAxis);
                        stat.setTitle("Stats");
                        XYChart.Series<String, Number> series1 = new XYChart.Series<>(); 
                           series1.setName("Totale "+Integer.toString(x+y+w+z)); 
                           series1.getData().add(new XYChart.Data<>("Compagnie", w)); 
                           series1.getData().add(new XYChart.Data<>("Prime RC", z)); 
                           series1.getData().add(new XYChart.Data<>("Expert", x)); 
                           series1.getData().add(new XYChart.Data<>("Courtier", y)); 

                        stat.getData().addAll(series1);
                        pnl_scroll.getChildren().setAll(stat);

              // TODO
              notifNum.setText(Integer.toString(x));
              notifNum1.setText(Integer.toString(y)); 
              
              StageManager.vcontent = this.pnl_scroll;
              btnListeComp.setOnAction(event ->{
                  try {
                      Pane newPane = FXMLLoader.load(getClass().getResource("GestCompagnie.fxml"));
                      pnl_scroll.getChildren().setAll(newPane);
                  } catch (IOException ex) {
                      Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
              
              btngestCourtier.setOnAction(event ->{
                  try {
                      Pane newPane = FXMLLoader.load(getClass().getResource("GestionCourtier.fxml"));
                      pnl_scroll.getChildren().setAll(newPane);
                  } catch (IOException ex) {
                      Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
              
              btnGestExpert.setOnAction(event ->{
                  try {
                      Pane newPane = FXMLLoader.load(getClass().getResource("GestExpert.fxml"));
                      pnl_scroll.getChildren().setAll(newPane);
                  } catch (IOException ex) {
                      Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
              
              btnGestPrime.setOnAction(event ->{
                  try {
                      Pane newPane = FXMLLoader.load(getClass().getResource("GestPrimeRC.fxml"));
                      pnl_scroll.getChildren().setAll(newPane);
                  } catch (IOException ex) {
                      Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
              
              homeBtn.setOnAction(event ->{
                  try {
                      Pane newPane = FXMLLoader.load(getClass().getResource("Index.fxml"));
                      pnl_scroll.getChildren().setAll(newPane);
                  } catch (IOException ex) {
                      Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
              
              
         
          } 
    
    @FXML
    private void disconnect(ActionEvent event) throws IOException {
//        Preferences pref = Preferences.userRoot().node("user");
//        pref.remove("id");
//        Parent root = FXMLLoader.load(getClass().getResource("../Authentication/LoginScreen.fxml"));
//        Scene scene = new Scene(root);
//        StageManager.primaryStage.setScene(scene);
    }
        
    }
    
    

