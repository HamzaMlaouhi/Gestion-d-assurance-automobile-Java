/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agence;

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
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {

    @FXML
    private VBox pnl_scroll;
    @FXML
    private JFXButton listReclamationBtn;
    @FXML
    private JFXButton listExpertBtn;
    @FXML
    private JFXButton vehiculeBtn;
    @FXML
    private JFXButton agentBtn;
    private JFXButton demandeSouscirptionBtn;
    @FXML
    private JFXButton acceuilBtn;
    @FXML
    private JFXButton ajoutVehiculeBtn;
    @FXML
    private JFXButton ajoutAgentBtn;

    private void handleButtonAction(MouseEvent event) {
        refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        refreshNodes();
        listReclamationBtn.setOnAction(e -> {
            pnl_scroll.getChildren().clear();

            Node[] nodes = new Node[15];

            for (int i = 0; i < 1; i++) {
                try {
                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("listeReclamations.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);

                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        listExpertBtn.setOnAction(e -> {
            pnl_scroll.getChildren().clear();

            Node[] nodes = new Node[15];

            for (int i = 0; i < 1; i++) {
                try {
                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("expertList.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);

                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        vehiculeBtn.setOnAction(e -> {
            pnl_scroll.getChildren().clear();

            Node[] nodes = new Node[15];

            for (int i = 0; i < 1; i++) {
                try {
                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("vehiculesList.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);

                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        agentBtn.setOnAction(e -> {
            pnl_scroll.getChildren().clear();

            Node[] nodes = new Node[15];

            for (int i = 0; i < 1; i++) {
                try {
                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("AgentList.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);

                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
        acceuilBtn.setOnAction(e -> {
            pnl_scroll.getChildren().clear();

            Node[] nodes = new Node[15];

            for (int i = 0; i < 1; i++) {
                try {
                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("chart.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);

                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        ajoutVehiculeBtn.setOnAction(e -> {
            pnl_scroll.getChildren().clear();

            Node[] nodes = new Node[15];

            for (int i = 0; i < 1; i++) {
                try {
                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("CreationVehicule.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);

                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        ajoutAgentBtn.setOnAction(e -> {
            pnl_scroll.getChildren().clear();

            Node[] nodes = new Node[15];

            for (int i = 0; i < 1; i++) {
                try {
                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("CreationAgent.fxml"));
                    pnl_scroll.getChildren().add(nodes[i]);

                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    private void refreshNodes() {
        pnl_scroll.getChildren().clear();

        Node[] nodes = new Node[15];

        for (int i = 0; i < 1; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("chart.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
