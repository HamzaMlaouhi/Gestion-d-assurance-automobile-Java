/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assure;

import Assure.ServiceAssure.ReclamationService;
import Assure.ServiceAssure.TemoinService;
import Shared.StageManager;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author azizi
 */
public class StatistiqueController implements Initializable {

    /**
     * Initializes the controller class.
     */
     
    @FXML
    private StackedAreaChart<String, Number> stat;
    @FXML
    private AnchorPane anchor;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
              
//              int z =(int) new TemoinService().selectcount("temoin");
               int x=(int) new TemoinService().selectcount();
               int z=(int) new ReclamationService().selectcountr();  
              
              //Stats Graph :
                           //Defining the y axis 
                        CategoryAxis xAxis = new CategoryAxis();    
                        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList
                        ("temoin","reclamation"))); 
                         xAxis.setLabel("category");  

                            //Defining the y axis 
                         NumberAxis yAxis = new NumberAxis(); 
                        yAxis.setLabel("Nombre dans l'app");
                 
                        stat= new StackedAreaChart<>(xAxis,yAxis);
                        stat.setTitle("Stats");
                        XYChart.Series<String, Number> series1 = new XYChart.Series<>(); 
                           series1.setName("Totale "); 
                           series1.getData().add(new XYChart.Data<>("temoin",x)); 
                           series1.getData().add(new XYChart.Data<>("reclamation", z)); 
//                           series1.getData().add(new XYChart.Data<>("Expert", x)); 
//                           series1.getData().add(new XYChart.Data<>("Courtier", 10)); 

                        stat.getData().addAll(series1);
                        anchor.getChildren().setAll(stat);

              // TODO
             

    
}
}
