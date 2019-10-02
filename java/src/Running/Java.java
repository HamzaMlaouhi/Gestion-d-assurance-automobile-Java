/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Running;

import Administration.SceneBuilder.AdminMailer;
import Shared.StageManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author BahaEddine
 */
public class Java extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Authentication/LoginScreen.fxml"));
        StageManager.primaryStage = primaryStage;
        Scene scene = new Scene(root);
        primaryStage.setTitle("Gestion d'assurances");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
