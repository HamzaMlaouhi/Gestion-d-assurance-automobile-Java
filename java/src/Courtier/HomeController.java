package Courtier;

import Shared.StageManager;
import static Shared.StageManager.primaryStage;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Med
 */
public class HomeController implements Initializable {

    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton btnRechercherCompagnie;
    @FXML
    private JFXButton btnModifierProfil;
    @FXML
    private JFXButton btnGestionContrat;

    private void handleButtonAction(MouseEvent event) throws IOException {
        refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            refreshNodes();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        btnModifierProfil.setOnAction(e -> {
//            pnl_scroll.getChildren().clear();
//            Node[] nodes = new Node[15];
//            for (int i = 0; i < 1; i++) {
//                try {
//                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("ModifierProfil.fxml"));
//                    pnl_scroll.getChildren().add(nodes[i]);
//
//                } catch (IOException ex) {
//                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        });
        btnGestionContrat.setOnAction(e -> {
            pnl_scroll.getChildren().clear();
            Node[] nodes = new Node[15];
            for (int i = 0; i < 1; i++) {
                try {
                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("./crudPolice.fxml")); //crudPolice || MainPane
                    pnl_scroll.getChildren().add(nodes[i]);

                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        btnRechercherCompagnie.setOnAction(e -> {
            pnl_scroll.getChildren().clear();
            Node[] nodes = new Node[15];
            for (int i = 0; i < 1; i++) {
                try {
                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("ChercherCompagnie.fxml")); //RechercherCompagnieMetier
                    pnl_scroll.getChildren().add(nodes[i]);

                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
       
    }
    private void refreshNodes() throws IOException {
        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[15];
        Pane newPane = FXMLLoader.load(getClass().getResource("./crudPolice.fxml"));
        pnl_scroll.getChildren().setAll(newPane);
        /*for (int i = 0; i < 1; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("./crudPolice.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }*/
    }

    @FXML
    private void deco(ActionEvent event) {
        System.out.println("ggg");
//        try {
//                Parent root = FXMLLoader.load(getClass().getResource("../Authentication/LoginScreen.fxml"));
//                
//                StageManager.primaryStage = primaryStage;
//                
//                Scene scene = new Scene(root);
//                primaryStage.setTitle("Gestion d'assurances");
//                primaryStage.setScene(scene);
//                primaryStage.show();
//            } catch (IOException ex) {
//                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//            }
      
    

}
}