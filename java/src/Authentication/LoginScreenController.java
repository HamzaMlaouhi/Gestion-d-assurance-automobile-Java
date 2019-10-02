package Authentication;

import Shared.StageManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class LoginScreenController implements Initializable {

    @FXML
    private JFXTextField loginField;
    @FXML
    private JFXPasswordField motDePasseField;
    @FXML
    private JFXButton LoginButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        LoginButton.setOnAction(e -> {
            try {
                connect();
            } catch (SQLException ex) {
                Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public String resource;


    public void connect() throws SQLException, NoSuchAlgorithmException {
        Preferences pref = Preferences.userRoot().node("user");
        String uname = loginField.getText();
        String pass = motDePasseField.getText();
        ResultSet type = new DatabaseHandler().CheckLoginUser(uname, pass);
        while (type.next()) {
            pref.put("id", String.valueOf(type.getInt("id")));
            switch (type.getString("type")) {
                case "courtier":
                    resource = "../Courtier/Home.fxml";
                    break;
                case "admin":
                    resource = "../Administration/SceneBuilder/Home.fxml";
                    break;
                case "agent":
                    resource = " ../Agence/Home.fxml";
                    break;
                case "assure":
                    resource = "../Assure/Home.fxml";
                    break;
                case "expert":
                    resource = "../Expert/Home.fxml";
                    break;
                case "compagnie":
                    resource = "../Compagnie/Home.fxml";
                    break;
                default:
                    System.out.println("Username error ");
            }
        }
        //if(type.next)
        try {
            // sending data to databasehandler class to connection data
            Parent root = FXMLLoader.load(getClass().getResource(resource));
            Scene scene = new Scene(root);
            StageManager.primaryStage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
