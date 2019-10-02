/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.CompagnieDAO;
import AdministrationDAO.CourtierDAO;
import AdministrationDAO.ExpertDAO;
import AdministrationDAO.PrimeRC_DAO;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class IndexController implements Initializable {

    private Button Gcourtier;
    private Button Gcompagnie;
    private Button Gexpert;
    private Button Gprime;
    @FXML
  private StackedBarChart<String,Number> graph;
    @FXML
    private VBox pnl_scroll;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         int x = new ExpertDAO().selectDisabledNumber();
              int y =new CourtierDAO().selectDisabledNumber();
               int w = new CompagnieDAO().selectDisabledNumber();
              int z =new PrimeRC_DAO().selectDisabledNumber();
              
              //Stats Graph :
                           //Defining the y axis 
                        CategoryAxis xAxis = new CategoryAxis();    
                        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList
                        ("Compagnie", "Prime RC", "Expert", "Courtier"))); 
                         xAxis.setLabel("category");  

                            //Defining the y axis 
                         NumberAxis yAxis = new NumberAxis(); 
                        yAxis.setLabel("Nombre dans l'app");
                 
                        graph= new StackedBarChart<>(xAxis,yAxis);
                        graph.setTitle("Stats");
                        XYChart.Series<String, Number> series1 = new XYChart.Series<>(); 
                           series1.setName("Totale "+Integer.toString(x+y+w+z)); 
                           series1.getData().add(new XYChart.Data<>("Compagnie", w)); 
                           series1.getData().add(new XYChart.Data<>("Prime RC", z)); 
                           series1.getData().add(new XYChart.Data<>("Expert", x)); 
                           series1.getData().add(new XYChart.Data<>("Courtier", y)); 

                        graph.getData().addAll(series1);
                        pnl_scroll.getChildren().setAll(graph);
        
    }

}
