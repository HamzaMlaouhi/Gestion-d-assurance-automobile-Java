/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence;

import Agence.Services.AgentDAO;
import Agence.Services.ExpertDAO1;
import Agence.Services.PoliceDAO;
import Agence.Services.VehiculeDAO;
import Agence.Services.reclamationDAO;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Skander
 */
public class ChartController implements Initializable {

    @FXML
    private VBox pnl_scroll;
    @FXML
    private StackedBarChart<String,Number> graph;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          //Defining the y axis 
          
         int x = new ExpertDAO1().selectDisabledNumber();
              int y =new PoliceDAO().selectDisabledNumber();
               int w = new VehiculeDAO().selectDisabledNumber();
              int z =new AgentDAO().selectDisabledNumber();
              int r =new reclamationDAO().selectDisabledNumber();
             
                        CategoryAxis xAxis = new CategoryAxis();    
                        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList
                        ("Expert", "Police", "Vehicule", "Agent", "reclamation"))); 
                         xAxis.setLabel("category");  

                            //Defining the y axis 
                         NumberAxis yAxis = new NumberAxis(); 
                        yAxis.setLabel("Nombre dans votre base de donnée");
                 
                        graph= new StackedBarChart<>(xAxis,yAxis);
                        graph.setTitle("Statistiques");
                        XYChart.Series<String, Number> series1 = new XYChart.Series<>(); 
                           series1.setName("Totale "); 
                           series1.getData().add(new XYChart.Data<>("Expert", x*100)); 
                           series1.getData().add(new XYChart.Data<>("Police", y*100)); 
                           series1.getData().add(new XYChart.Data<>("Vehicule", w*100)); 
                           series1.getData().add(new XYChart.Data<>("Agent", z*100)); 
                           series1.getData().add(new XYChart.Data<>("reclamtion", r*100)); 

                        graph.getData().addAll(series1);
                        pnl_scroll.getChildren().setAll(graph);
     
    }    
    
}
