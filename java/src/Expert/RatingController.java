/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expert;

import Shared.StageManager;
import static Shared.StageManager.primaryStage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Rating;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class RatingController implements Initializable {

    @FXML
    private Label msg;
    @FXML
    private Rating rating;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       rating.ratingProperty().addListener(new ChangeListener<Number>(){
          @Override
          public void changed (ObservableValue<? extends Number> args0 ,Number t, Number t1){
              msg.setText("Rating :"+t1.toString());
          }
           
           
       });
    }
    
}

   
    
    

