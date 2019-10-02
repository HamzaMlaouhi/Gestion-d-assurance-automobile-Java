/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class stat extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
    }

    private void init(Stage primaryStage) {
        HBox root=new HBox();
        Scene scene=new Scene(root, 450, 330);
        CategoryAxis xAxis=new CategoryAxis();
        xAxis.setLabel("Year");
        NumberAxis yAxis=new NumberAxis();
        yAxis.setLabel("Annual salary");
        LineChart<String,Number> lineChart=new LineChart<String,Number>(xAxis,yAxis);
        lineChart.setTitle("Salary");
        XYChart.Series<String, Number> data=new XYChart.Series<>();
        data.getData().add(new XYChart.Data<String, Number>("1995",18000));
        data.getData().add(new XYChart.Data<String, Number>("1999",19000));
        data.getData().add(new XYChart.Data<String, Number>("2003",21500));
        lineChart.getData().add(data);
        root.getChildren().add(lineChart);
        primaryStage.setTitle("LineChart on SSaurel.com");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
