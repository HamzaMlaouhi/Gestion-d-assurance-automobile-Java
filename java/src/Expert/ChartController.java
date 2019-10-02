/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert;

import Expert.Service.CompagnieDAO;
import Shared.StageManager;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ChartController implements Initializable {
  @FXML
    private VBox pnl_scroll;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         StageManager.vcontent = pnl_scroll;
          HBox root=new HBox();
        Scene scene=new Scene(root, 450, 330);
        CategoryAxis xAxis=new CategoryAxis();
        xAxis.setLabel("Date sinistre");
        NumberAxis yAxis=new NumberAxis();
        yAxis.setLabel("Nombre des sinistres");
        LineChart<String,Number> lineChart=new LineChart<String,Number>(xAxis,yAxis);
        lineChart.setTitle("les nombres des sinistres par année");
        XYChart.Series<String, Number> data=new XYChart.Series<>();
        ResultSet stat = new CompagnieDAO().stat();
          try {
              while(stat.next()){
                  data.getData().add(new XYChart.Data<String, Number>(stat.getString("datee"),stat.getInt("nbr")));
                  
              }lineChart.getData().add(data);
        root.getChildren().add(lineChart); } catch (SQLException ex) {
              Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
          }
       
        
        pnl_scroll.getChildren().setAll(scene.getRoot());
    }    
    
}
