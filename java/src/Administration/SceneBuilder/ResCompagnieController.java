/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import AdministrationDAO.CompagnieDAO;
import Shared.StageManager;
import static java.awt.PageAttributes.MediaType.C;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mahmoud
 */
public class ResCompagnieController implements Initializable {
    Connection cn = Utils.Database.getInstance().getConnection();
    Statement st;
    PreparedStatement pst;
    public String nc;

    @FXML
    public TextField id;
    @FXML
    public TextField nomCompagnie;
    @FXML
    public TextField adr;
    @FXML
    public TextField fix;
    @FXML
    public TextField fax;
    @FXML
    public TextField site;
    @FXML
    public TextField userName;
    @FXML
    public TextField mail;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button modifierBtn;
//    ChercheCompagnieController  cc = new ChercheCompagnieController();
//    String nomc =cc.nomCompagnie;
//    Entities.Compagnie cpc =cc.getCp();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
    
    System.out.println(this.nomCompagnie.getText());
      try {

String nomC = null;
String site = null; String userName=null; String adr = null;
String mail=null; String nom=null;
String tel = null; String fax=null;
String id = null;
            System.out.println(this.nomCompagnie.getText());
String req = " SELECT * FROM user where nom_compagnie ='"+nc+"'";

st= cn.createStatement();

ResultSet ss = st.executeQuery(req);
while(ss.next()){
    userName=ss.getString("username");
    adr=ss.getString("adresse");
    mail=ss.getString("email");
    site=ss.getString("site");
    tel=Integer.toString(ss.getInt("Tel"));
    fax=Integer.toString(ss.getInt("Fax"));
    nom=ss.getString("nom_compagnie");
    id= Integer.toString(ss.getInt("id"));
}
    if(id != null){
        
    
        this.site.setText(site);
        this.userName.setText(userName);
        this.adr.setText(adr);
        this.mail.setText(mail);
        this.fix.setText(tel);
        this.fax.setText(fax);
        this.id.setText(id);
        this.nomCompagnie.setText(nc);
                }
    else {
         JOptionPane.showMessageDialog(null, "n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
   
            Pane newPane; 
    try {
        newPane = FXMLLoader.load(getClass().getResource("ChercheCompagnie.fxml"));
          StageManager.vcontent.getChildren().setAll(newPane);
    } catch (IOException ex) {
        Logger.getLogger(ResCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
    }
         
            
        }}
catch (SQLException ex) {
            Logger.getLogger(ResCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
        }   
});
      

deleteBtn.setOnAction(event -> {
    String nomC = this.nomCompagnie.getText();
    CompagnieDAO CpDAO = new CompagnieDAO();
    CpDAO.DeleteAction(nomC);
    try {
                Pane newPane = FXMLLoader.load(getClass().getResource("GestCompagnie.fxml")); 
                StageManager.vcontent.getChildren().setAll(newPane);
            } catch (IOException ex) {
                Logger.getLogger(GestCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
});

modifierBtn.setOnAction(event ->{
            try {
                String nomComp = this.nomCompagnie.getText();
                //System.out.println(nomCompagnie);
                FXMLLoader res = new FXMLLoader(getClass().getResource("ModifierCompagnie.fxml"));
                Parent root = (Parent)res.load();
                ModifierCompagnieController controller = res.<ModifierCompagnieController>getController();
                controller.nc=nomComp;
                controller.adrs=this.adr.getText();
                controller.Wsite=this.site.getText();
                controller.num=this.fix.getText();
                controller.faxe=this.fax.getText();
                controller.email=this.mail.getText();
                controller.username=this.userName.getText();
                controller.Id=this.id.getText();
                // Parent page1 = FXMLLoader.load(getClass().getResource("ResCompagnie.fxml"));
               StageManager.vcontent.getChildren().setAll(root);

            } catch (IOException ex) {
                Logger.getLogger(ChercheCompagnieController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
 
    
    }


@FXML
private void deleteAction(ActionEvent event) {    
            String nomC = this.nomCompagnie.getText();
            CompagnieDAO CpDAO = new CompagnieDAO();
            CpDAO.DeleteAction(nomC);
        }

@FXML
private void modifierAction(ActionEvent event) {
        }   
    


}